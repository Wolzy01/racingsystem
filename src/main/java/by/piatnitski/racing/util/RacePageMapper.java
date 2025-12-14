package by.piatnitski.racing.util;

import by.piatnitski.racing.model.dto.RacePageDto;
import by.piatnitski.racing.model.entity.Race;
import by.piatnitski.racing.model.entity.Participant;
import by.piatnitski.racing.model.entity.Odds;

import java.util.List;

public class RacePageMapper {
    public static RacePageDto toDto(Race race, List<Participant> participants, List<Odds> odds) {
        return new RacePageDto(race, participants, odds);
    }
}