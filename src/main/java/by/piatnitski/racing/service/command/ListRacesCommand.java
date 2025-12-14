package by.piatnitski.racing.service.command;

import by.piatnitski.racing.model.dao.jdbc.JdbcRaceDao;
import by.piatnitski.racing.model.pool.ConnectionPool;
import by.piatnitski.racing.model.entity.Race;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.List;

public class ListRacesCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try (Connection conn = ConnectionPool.getConnection()) {
            JdbcRaceDao raceDao = new JdbcRaceDao(conn);
            List<Race> races = raceDao.findAll();
            request.setAttribute("races", races);
        }

        // 👉 Вставляем listRaces.jsp внутрь layout.jsp
        request.setAttribute("pageTitle", "Забеги");
        request.setAttribute("content", "/WEB-INF/jsp/listRaces.jsp");
        return "/WEB-INF/jsp/layout.jsp";
    }
}
