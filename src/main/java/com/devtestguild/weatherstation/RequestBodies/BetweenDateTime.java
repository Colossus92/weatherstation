package com.devtestguild.weatherstation.RequestBodies;

import java.time.ZonedDateTime;

public class BetweenDateTime {

    private ZonedDateTime from;
    private ZonedDateTime toInclusive;

    public BetweenDateTime(ZonedDateTime from, ZonedDateTime toInclusive) {
        this.from = from;
        this.toInclusive = toInclusive;
    }

    public ZonedDateTime getFrom() {
        return from;
    }

    public ZonedDateTime getToInclusive() {
        return toInclusive;
    }
}
