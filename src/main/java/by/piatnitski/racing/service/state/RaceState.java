// RaceState.java
package by.piatnitski.racing.service.state;

import by.piatnitski.racing.model.entity.Race;

public interface RaceState {
    void next(Race race);
    String getStatus();
}