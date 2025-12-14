package by.piatnitski.racing.service.strategy;

import by.piatnitski.racing.model.entity.Bet;
import java.math.BigDecimal;

public class PlaceStrategy implements PayoutStrategy {
    @Override
    public BigDecimal calculate(Bet bet, boolean isWinner) {
        // ставка "Place" возвращает 1.5x при попадании в призы
        return isWinner ? bet.getAmount().multiply(BigDecimal.valueOf(1.5)) : BigDecimal.ZERO;
    }
}