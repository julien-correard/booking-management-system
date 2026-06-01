package com.julien.booking.model;

import java.time.LocalTime;

public class CalendarConfig {

    private LocalTime startTime;
    private LocalTime endTime;
    private int slotStepMinutes;

    public CalendarConfig() {}

    public CalendarConfig(LocalTime startTime, LocalTime endTime, int slotStepMinutes) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.slotStepMinutes = slotStepMinutes;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getSlotStepMinutes() {
        return slotStepMinutes;
    }
}
