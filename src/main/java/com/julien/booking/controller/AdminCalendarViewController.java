package com.julien.booking.controller;

import com.julien.booking.model.CalendarConfig;
import com.julien.booking.model.Client;
import com.julien.booking.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/admin/calendar")
@RequiredArgsConstructor

public class AdminCalendarViewController {

    private final ClientService clientService;

    @GetMapping
    public String index(Model model) {

        List<Client> clients = clientService.getAllClients();

        model.addAttribute("clients", clients);

        return "admin/calendar/index";
    }



}
