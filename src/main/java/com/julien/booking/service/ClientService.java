package com.julien.booking.service;

import com.julien.booking.repository.ClientRepository;
import com.julien.booking.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getAllClients()
    {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id)
    {
        return clientRepository.findById(id).orElse(null);
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClientById(Long id) {clientRepository.deleteById(id);}
}
