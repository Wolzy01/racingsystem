package by.piatnitski.racing.model.dao;

import by.piatnitski.racing.model.entity.Bet;

import java.sql.SQLException;
import java.util.List;

public interface BetDao {
    Bet findById(long id) throws SQLException;
    List<Bet> findByUser(long userId) throws SQLException;
    List<Bet> findByRace(long raceId) throws SQLException;
    void save(Bet bet) throws SQLException;
    void update(Bet bet) throws SQLException;
    void delete(long id) throws SQLException;
}