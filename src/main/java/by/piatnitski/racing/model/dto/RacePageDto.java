package by.piatnitski.racing.model.dto;

import by.piatnitski.racing.model.entity.Race;
import by.piatnitski.racing.model.entity.Participant;
import by.piatnitski.racing.model.entity.Odds;

import java.util.List;

public class RacePageDto {
    private Race race;
    private List<Participant> participants;
    private List<Odds> odds;

    public RacePageDto() {}

    public RacePageDto(Race race, List<Participant> participants, List<Odds> odds) {
        this.race = race;
        this.participants = participants;
        this.odds = odds;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<Odds> getOdds() {
        return odds;
    }

    public void setOdds(List<Odds> odds) {
        this.odds = odds;
    }
}