package by.piatnitski.racing.model.entity;

import java.time.LocalDateTime;

public class Race {
    private long id;
    private String name;
    private LocalDateTime startTime;
    private RaceStatus status;

    // Для отображения в JSP (уже отформатированная дата)
    private String startTimeFormatted;

    public Race() {}

    public Race(long id, String name, LocalDateTime startTime, RaceStatus status) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public RaceStatus getStatus() {
        return status;
    }

    public void setStatus(RaceStatus status) {
        this.status = status;
    }

    public String getStartTimeFormatted() {
        return startTimeFormatted;
    }

    public void setStartTimeFormatted(String startTimeFormatted) {
        this.startTimeFormatted = startTimeFormatted;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                ", status=" + status +
                ", startTimeFormatted='" + startTimeFormatted + '\'' +
                '}';
    }
}