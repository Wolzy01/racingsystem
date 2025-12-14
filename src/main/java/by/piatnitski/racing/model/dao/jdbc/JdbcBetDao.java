package by.piatnitski.racing.model.dao.jdbc;

import by.piatnitski.racing.model.dao.BetDao;
import by.piatnitski.racing.model.entity.Bet;
import by.piatnitski.racing.model.entity.BetType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcBetDao implements BetDao {
    private final Connection connection;

    public JdbcBetDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Bet findById(long id) throws SQLException {
        String sql = "SELECT id, user_id, race_id, participant_id, type, amount FROM bets WHERE id = ?";
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
    public List<Bet> findByUser(long userId) throws SQLException {
        String sql = "SELECT id, user_id, race_id, participant_id, type, amount FROM bets WHERE user_id = ?";
        List<Bet> bets = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    bets.add(mapRow(rs));
                }
            }
        }
        return bets;
    }

    @Override
    public List<Bet> findByRace(long raceId) throws SQLException {
        String sql = "SELECT id, user_id, race_id, participant_id, type, amount FROM bets WHERE race_id = ?";
        List<Bet> bets = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, raceId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    bets.add(mapRow(rs));
                }
            }
        }
        return bets;
    }

    @Override
    public void save(Bet bet) throws SQLException {
        String sql = "INSERT INTO bets (user_id, race_id, participant_id, type, amount) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, bet.getUserId());
            stmt.setLong(2, bet.getRaceId());
            stmt.setLong(3, bet.getParticipantId());
            stmt.setString(4, bet.getType().name());
            stmt.setBigDecimal(5, bet.getAmount());
            stmt.executeUpdate();
        }
    }

    @Override
    public void update(Bet bet) throws SQLException {
        String sql = "UPDATE bets SET type = ?, amount = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, bet.getType().name());
            stmt.setBigDecimal(2, bet.getAmount());
            stmt.setLong(3, bet.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(long id) throws SQLException {
        String sql = "DELETE FROM bets WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private Bet mapRow(ResultSet rs) throws SQLException {
        Bet bet = new Bet();
        bet.setId(rs.getLong("id"));
        bet.setUserId(rs.getLong("user_id"));
        bet.setRaceId(rs.getLong("race_id"));
        bet.setParticipantId(rs.getLong("participant_id"));
        bet.setType(BetType.valueOf(rs.getString("type")));
        bet.setAmount(rs.getBigDecimal("amount"));
        return bet;
    }
}