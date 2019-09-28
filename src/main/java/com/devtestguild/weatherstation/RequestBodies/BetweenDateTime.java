package com.devtestguild.weatherstation.RequestBodies;

import java.time.LocalDateTime;

public class BetweenDateTime {

    private LocalDateTime from;
    private LocalDateTime toInclusive;

    public BetweenDateTime(LocalDateTime from, LocalDateTime toInclusive) {
        this.from = from;
        this.toInclusive = toInclusive;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getToInclusive() {
        return toInclusive;
    }
}
