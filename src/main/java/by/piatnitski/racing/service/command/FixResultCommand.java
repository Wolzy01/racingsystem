package by.piatnitski.racing.service.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import by.piatnitski.racing.service.observer.ResultPublisher;
import by.piatnitski.racing.service.observer.RaceResultEvent;

public class FixResultCommand implements Command {
    private final ResultPublisher publisher;

    public FixResultCommand(ResultPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String raceIdParam = request.getParameter("raceId");
        Long raceId = Long.parseLong(raceIdParam);

        RaceResultEvent event = new RaceResultEvent(raceId);
        publisher.publish(event);

        request.setAttribute("pageTitle", "Результат зафиксирован");
        request.setAttribute("content", "/WEB-INF/jsp/fixResult.jsp");
        return "/WEB-INF/jsp/layout.jsp";
    }
}