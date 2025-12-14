package by.piatnitski.racing.util;

import java.math.BigDecimal;

public class Validator {

    public static boolean isValidUsername(String username) {
        return username != null && username.length() >= 3 && username.length() <= 20;
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }

    public static boolean isValidBetAmount(BigDecimal amount) {
        return amount != null && amount.compareTo(BigDecimal.ZERO) > 0;
    }

    public static boolean isValidRaceId(long raceId) {
        return raceId > 0;
    }

    public static boolean isValidParticipantId(long participantId) {
        return participantId > 0;
    }
}