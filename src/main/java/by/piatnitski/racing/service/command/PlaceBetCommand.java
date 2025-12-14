package by.piatnitski.racing.service.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import by.piatnitski.racing.model.dao.jdbc.JdbcBetDao;
import by.piatnitski.racing.model.entity.Bet;
import by.piatnitski.racing.model.entity.BetType;
import by.piatnitski.racing.model.entity.User;
import by.piatnitski.racing.model.pool.ConnectionPool;

import java.math.BigDecimal;
import java.sql.Connection;

public class PlaceBetCommand implements Command {
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

        long raceId = Long.parseLong(request.getParameter("raceId"));
        long participantId = Long.parseLong(request.getParameter("participantId"));
        BetType type = BetType.valueOf(request.getParameter("type"));
        BigDecimal amount = new BigDecimal(request.getParameter("amount"));

        Bet bet = new Bet();
        bet.setUserId(user.getId());
        bet.setRaceId(raceId);
        bet.setParticipantId(participantId);
        bet.setType(type);
        bet.setAmount(amount);

        try (Connection conn = ConnectionPool.getConnection()) {
            JdbcBetDao betDao = new JdbcBetDao(conn);
            betDao.save(bet);
        }

        request.setAttribute("message", "Ставка успешно размещена");
        request.setAttribute("pageTitle", "Главная");
        request.setAttribute("activeTab", "home");
        request.setAttribute("content", "/WEB-INF/jsp/home.jsp");
        return "/WEB-INF/jsp/layout.jsp";
    }
}