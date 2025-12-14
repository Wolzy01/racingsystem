package by.piatnitski.racing.model.dao;

import by.piatnitski.racing.model.entity.Race;

import java.sql.SQLException;
import java.util.List;

public interface RaceDao {
    Race findById(long id) throws SQLException;
    List<Race> findAll() throws SQLException;
    void save(Race race) throws SQLException;
    void update(Race race) throws SQLException;
    void delete(long id) throws SQLException;
}