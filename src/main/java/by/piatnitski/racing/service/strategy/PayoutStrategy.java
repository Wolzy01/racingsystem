package by.piatnitski.racing.service.strategy;

import by.piatnitski.racing.model.entity.Bet;
import java.math.BigDecimal;

public interface PayoutStrategy {
    BigDecimal calculate(Bet bet, boolean isWinner);
}