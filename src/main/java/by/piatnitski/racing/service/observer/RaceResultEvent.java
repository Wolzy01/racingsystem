package by.piatnitski.racing.service.observer;

public class RaceResultEvent {
    private final Long raceId;

    public RaceResultEvent(Long raceId) {
        this.raceId = raceId;
    }

    public Long getRaceId() {
        return raceId;
    }
}