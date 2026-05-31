package com.julien.booking.controller;

import com.julien.booking.model.Address;
import com.julien.booking.model.Client;
import com.julien.booking.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/clients")
@RequiredArgsConstructor

public class AdminClientController {

    private final ClientService clientService;

    @GetMapping
    public String index(Model model) {

        model.addAttribute("clients", clientService.getAllClients());

        return "admin/clients/index";
    }


    @GetMapping("/nouveau")
    public String create(Model model) {

        Client client = new Client();
        client.setAddress(new Address());

        model.addAttribute("client", client);

        return "admin/clients/form";
    }

    @GetMapping("{id}/modifier")
    public String modify(@PathVariable Long id, Model model) {

        Client client = clientService.getClientById(id);

        if (client.getAddress() == null) {
            client.setAddress(new Address());
        }

        model.addAttribute("client", client);

        return "admin/clients/form";
    }

    @PostMapping("{id}/supprimer")
    public String delete(@PathVariable Long id) {
        clientService.deleteClientById(id);
        return "redirect:/admin/clients";
    }

    @PostMapping
    public String store(@ModelAttribute Client client) {
        clientService.save(client);
        return "redirect:/admin/clients";
    }
}
