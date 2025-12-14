package by.piatnitski.racing.model.entity;

import java.math.BigDecimal;

public class Bet {
    private long id;
    private long userId;
    private long raceId;
    private long participantId;
    private BetType type;
    private BigDecimal amount;

    public Bet() {}

    public Bet(long id, long userId, long raceId, long participantId, BetType type, BigDecimal amount) {
        this.id = id;
        this.userId = userId;
        this.raceId = raceId;
        this.participantId = participantId;
        this.type = type;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public BetType getType() {
        return type;
    }

    public void setType(BetType type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "id=" + id +
                ", userId=" + userId +
                ", raceId=" + raceId +
                ", participantId=" + participantId +
                ", type=" + type +
                ", amount=" + amount +
                '}';
    }
}