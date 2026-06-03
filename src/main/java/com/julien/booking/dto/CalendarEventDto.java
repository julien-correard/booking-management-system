package com.julien.booking.dto;

import java.time.LocalDateTime;

public record CalendarEventDto(
        Long id,
        String title,
        LocalDateTime start,
        LocalDateTime end
) {}