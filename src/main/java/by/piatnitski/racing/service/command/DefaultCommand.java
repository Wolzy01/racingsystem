package by.piatnitski.racing.service.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DefaultCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("pageTitle", "Главная");
        request.setAttribute("activeTab", "home");
        request.setAttribute("content", "/WEB-INF/jsp/home.jsp");
        return "/WEB-INF/jsp/layout.jsp";
    }
}