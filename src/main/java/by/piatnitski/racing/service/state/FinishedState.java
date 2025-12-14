// FinishedState.java
package by.piatnitski.racing.service.state;

import by.piatnitski.racing.model.entity.Race;

public class FinishedState implements RaceState {
    @Override
    public void next(Race race) {
        // Завершённый забег не меняет статус
    }

    @Override
    public String getStatus() {
        return "FINISHED";
    }
}