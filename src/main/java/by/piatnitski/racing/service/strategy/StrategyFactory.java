package by.piatnitski.racing.service.strategy;

import by.piatnitski.racing.model.entity.BetType;

public class StrategyFactory {
    public static PayoutStrategy getStrategy(BetType type) {
        switch (type) {
            case WIN: return new WinnerStrategy();
            case PLACE: return new PlaceStrategy();
            case EXACTA: return new ExactaStrategy();
            default: throw new IllegalArgumentException("Unknown bet type");
        }
    }
}