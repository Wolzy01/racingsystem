// RunningState.java
package by.piatnitski.racing.service.state;

import by.piatnitski.racing.model.entity.Race;

public class RunningState implements RaceState {
    @Override
    public void next(Race race) {
        race.setStatus(by.piatnitski.racing.model.entity.RaceStatus.FINISHED);
    }

    @Override
    public String getStatus() {
        return "ONGOING";
    }
}