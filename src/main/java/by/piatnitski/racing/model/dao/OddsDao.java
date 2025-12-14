package by.piatnitski.racing.model.dao;

import by.piatnitski.racing.model.entity.Odds;
import java.sql.SQLException;
import java.util.List;

public interface OddsDao {
    Odds findById(long id) throws SQLException;
    List<Odds> findByRace(long raceId) throws SQLException;
    void save(Odds odds) throws SQLException;
    void update(Odds odds) throws SQLException;
    void delete(long id) throws SQLException;
}