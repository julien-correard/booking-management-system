package com.julien.booking.controller;

import com.julien.booking.model.CalendarConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public String post(Model model) {

        return "admin/calendar";
    }
}
