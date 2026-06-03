package com.julien.booking.controller;

import com.julien.booking.dto.CalendarEventDto;
import com.julien.booking.dto.CreateAppointmentRequest;
import com.julien.booking.model.Appointment;
import com.julien.booking.model.CalendarConfig;
import com.julien.booking.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/admin/calendar")
@RequiredArgsConstructor

public class AdminCalendarRestController {

    private final AppointmentService appointmentService;

    @GetMapping("/config")
    public CalendarConfig config() {
        return new CalendarConfig(
                LocalTime.of(8, 0),
                LocalTime.of(18, 0),
                15
        );
    }

    @GetMapping("/events")
    public List<CalendarEventDto> events() {
        return appointmentService.findAllEvents();
    }

    @PostMapping
    public ResponseEntity<CalendarEventDto> create(@RequestBody CreateAppointmentRequest request) {

        CalendarEventDto dto = appointmentService.createAppointment(request);

        return ResponseEntity.ok(dto);
    }
}
