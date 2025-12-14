package by.piatnitski.racing.service.strategy;

import by.piatnitski.racing.model.entity.Bet;
import java.math.BigDecimal;

public class WinnerStrategy implements PayoutStrategy {
    @Override
    public BigDecimal calculate(Bet bet, boolean isWinner) {
        return isWinner ? bet.getAmount().multiply(BigDecimal.valueOf(2.0)) : BigDecimal.ZERO;
    }
}