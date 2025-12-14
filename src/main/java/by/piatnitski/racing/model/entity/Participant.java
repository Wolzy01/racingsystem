package by.piatnitski.racing.model.entity;

public class Participant {
    private long id;
    private String name;
    private long raceId;

    public Participant() {}

    public Participant(long id, String name, long raceId) {
        this.id = id;
        this.name = name;
        this.raceId = raceId;
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

    public long getRaceId() {
        return raceId;
    }

    public void setRaceId(long raceId) {
        this.raceId = raceId;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", raceId=" + raceId +
                '}';
    }
}