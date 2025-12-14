package by.piatnitski.racing.model.dao.jdbc;

import by.piatnitski.racing.model.dao.RaceDao;
import by.piatnitski.racing.model.entity.Race;
import by.piatnitski.racing.model.entity.RaceStatus;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class JdbcRaceDao implements RaceDao {
    private final Connection connection;

    public JdbcRaceDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Race findById(long id) throws SQLException {
        String sql = "SELECT id, name, start_time, status FROM races WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Race> findAll() throws SQLException {
        String sql = "SELECT id, name, start_time, status FROM races";
        List<Race> races = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                races.add(mapRow(rs));
            }
        }
        return races;
    }

    @Override
    public void save(Race race) throws SQLException {
        String sql = "INSERT INTO races (name, start_time, status) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, race.getName());
            stmt.setTimestamp(2, Timestamp.valueOf(race.getStartTime()));
            stmt.setString(3, race.getStatus().name());
            stmt.executeUpdate();
        }
    }

    @Override
    public void update(Race race) throws SQLException {
        String sql = "UPDATE races SET name = ?, start_time = ?, status = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, race.getName());
            stmt.setTimestamp(2, Timestamp.valueOf(race.getStartTime()));
            stmt.setString(3, race.getStatus().name());
            stmt.setLong(4, race.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(long id) throws SQLException {
        String sql = "DELETE FROM races WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private Race mapRow(ResultSet rs) throws SQLException {
        Race race = new Race();
        race.setId(rs.getLong("id"));
        race.setName(rs.getString("name"));

        // Получаем дату и форматируем
        LocalDateTime startTime = rs.getTimestamp("start_time").toLocalDateTime();
        race.setStartTime(startTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String formatted = startTime.format(formatter);
        race.setStartTimeFormatted(formatted); // 👈 это новое поле

        // Статус
        race.setStatus(RaceStatus.valueOf(rs.getString("status")));

        return race;
    }
}