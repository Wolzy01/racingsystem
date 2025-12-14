package by.piatnitski.racing.service.strategy;

import by.piatnitski.racing.model.entity.Bet;
import java.math.BigDecimal;

public class ExactaStrategy implements PayoutStrategy {
    @Override
    public BigDecimal calculate(Bet bet, boolean isWinner) {
        // ставка "Exacta" возвращает 5x при точном угадывании
        return isWinner ? bet.getAmount().multiply(BigDecimal.valueOf(5.0)) : BigDecimal.ZERO;
    }
}