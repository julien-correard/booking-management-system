package com.julien.booking.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/calendar")
@RequiredArgsConstructor

public class AdminCalendarController {


    @GetMapping
    public String index(Model model) {

        return "admin/calendar/index";
    }
}
