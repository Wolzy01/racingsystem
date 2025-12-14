package by.piatnitski.racing.service.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import by.piatnitski.racing.model.dao.jdbc.JdbcUserDao;
import by.piatnitski.racing.model.pool.ConnectionPool;
import by.piatnitski.racing.model.entity.User;

import java.sql.Connection;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (Connection conn = ConnectionPool.getConnection()) {
            JdbcUserDao userDao = new JdbcUserDao(conn);
            User user = userDao.findByUsername(username);

            if (user != null && user.getPassword().equals(password)) {
                // ✅ сохраняем пользователя в сессии
                request.getSession().setAttribute("user", user);

                // ✅ делаем редирект на главную, чтобы браузер сохранил JSESSIONID
                response.sendRedirect(request.getContextPath() + "/controller?command=home");
                return null;
            } else {
                // ❌ неверный логин или пароль — остаёмся на странице входа
                request.setAttribute("error", "Неверные логин или пароль");
                request.setAttribute("pageTitle", "Вход");
                request.setAttribute("activeTab", "login");
                request.setAttribute("content", "/WEB-INF/jsp/login.jsp");
                return "/WEB-INF/jsp/layout.jsp";
            }
        }
    }
}