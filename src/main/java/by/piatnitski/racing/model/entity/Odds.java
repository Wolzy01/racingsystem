package by.piatnitski.racing.model.entity;

import java.math.BigDecimal;

public class Odds {
    private long id;
    private long raceId;
    private long participantId;
    private BigDecimal value;

    public Odds() {}

    public Odds(long id, long raceId, long participantId, BigDecimal value) {
        this.id = id;
        this.raceId = raceId;
        this.participantId = participantId;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRaceId() {
        return raceId;
    }

    public void setRaceId(long raceId) {
        this.raceId = raceId;
    }

    public long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(long participantId) {
        this.participantId = participantId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Odds{" +
                "id=" + id +
                ", raceId=" + raceId +
                ", participantId=" + participantId +
                ", value=" + value +
                '}';
    }
}