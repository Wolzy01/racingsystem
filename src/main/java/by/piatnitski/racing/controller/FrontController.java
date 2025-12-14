package by.piatnitski.racing.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import by.piatnitski.racing.service.command.Command;
import by.piatnitski.racing.service.command.CommandFactory;

import java.io.IOException;

public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String commandName = request.getParameter("command");
        Command command = CommandFactory.getInstance().getCommand(commandName);

        try {
            String page = command.execute(request, response);
            request.getRequestDispatcher(page).forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Ошибка при выполнении команды: " + commandName, e);
        }
    }
}