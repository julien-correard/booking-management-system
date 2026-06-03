package com.julien.booking.dto;

import java.time.LocalDateTime;

public record CreateAppointmentRequest (
        Long clientId,
        LocalDateTime startTime,
        LocalDateTime endTime
) {}
