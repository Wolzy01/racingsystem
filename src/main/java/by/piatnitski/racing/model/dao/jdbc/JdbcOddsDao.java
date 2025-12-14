package by.piatnitski.racing.model.dao.jdbc;

import by.piatnitski.racing.model.dao.OddsDao;
import by.piatnitski.racing.model.entity.Odds;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcOddsDao implements OddsDao {
    private final Connection connection;

    public JdbcOddsDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Odds findById(long id) throws SQLException {
        String sql = "SELECT id, race_id, participant_id, value FROM odds WHERE id = ?";
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
    public List<Odds> findByRace(long raceId) throws SQLException {
        String sql = "SELECT id, race_id, participant_id, value FROM odds WHERE race_id = ?";
        List<Odds> oddsList = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, raceId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    oddsList.add(mapRow(rs));
                }
            }
        }
        return oddsList;
    }

    @Override
    public void save(Odds odds) throws SQLException {
        String sql = "INSERT INTO odds (race_id, participant_id, value) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, odds.getRaceId());
            stmt.setLong(2, odds.getParticipantId());
            stmt.setBigDecimal(3, odds.getValue());
            stmt.executeUpdate();
        }
    }

    @Override
    public void update(Odds odds) throws SQLException {
        String sql = "UPDATE odds SET value = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setBigDecimal(1, odds.getValue());
            stmt.setLong(2, odds.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(long id) throws SQLException {
        String sql = "DELETE FROM odds WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private Odds mapRow(ResultSet rs) throws SQLException {
        Odds odds = new Odds();
        odds.setId(rs.getLong("id"));
        odds.setRaceId(rs.getLong("race_id"));
        odds.setParticipantId(rs.getLong("participant_id"));
        odds.setValue(rs.getBigDecimal("value"));
        return odds;
    }
}