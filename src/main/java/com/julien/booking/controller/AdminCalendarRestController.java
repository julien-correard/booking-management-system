package com.julien.booking.controller;

import com.julien.booking.model.CalendarConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping("/admin/calendar")
@RequiredArgsConstructor

public class AdminCalendarRestController {
    @GetMapping("/config")
    public CalendarConfig config() {
        return new CalendarConfig(
                LocalTime.of(8, 0),
                LocalTime.of(18, 0),
                15
        );
    }
}
