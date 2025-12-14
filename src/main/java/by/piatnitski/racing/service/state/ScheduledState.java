// ScheduledState.java
package by.piatnitski.racing.service.state;

import by.piatnitski.racing.model.entity.Race;

public class ScheduledState implements RaceState {
    @Override
    public void next(Race race) {
        race.setStatus(by.piatnitski.racing.model.entity.RaceStatus.ONGOING);
    }

    @Override
    public String getStatus() {
        return "SCHEDULED";
    }
}