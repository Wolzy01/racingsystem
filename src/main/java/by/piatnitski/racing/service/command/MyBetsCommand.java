package by.piatnitski.racing.service.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import by.piatnitski.racing.model.dao.jdbc.JdbcBetDao;
import by.piatnitski.racing.model.entity.Bet;
import by.piatnitski.racing.model.entity.User;
import by.piatnitski.racing.model.pool.ConnectionPool;

import java.sql.Connection;
import java.util.List;

public class MyBetsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            request.setAttribute("error", "Сначала войдите в систему");
            request.setAttribute("pageTitle", "Вход");
            request.setAttribute("activeTab", "login");
            request.setAttribute("content", "/WEB-INF/jsp/login.jsp");
            return "/WEB-INF/jsp/layout.jsp";
        }

        try (Connection conn = ConnectionPool.getConnection()) {
            JdbcBetDao betDao = new JdbcBetDao(conn);
            List<Bet> bets = betDao.findByUser(user.getId());
            request.setAttribute("bets", bets);
        }

        request.setAttribute("pageTitle", "Мои ставки");
        request.setAttribute("activeTab", "bets");
        request.setAttribute("content", "/WEB-INF/jsp/myBets.jsp");
        return "/WEB-INF/jsp/layout.jsp";
    }
}