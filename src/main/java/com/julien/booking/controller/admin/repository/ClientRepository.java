package com.julien.booking.controller.admin.repository;

import com.julien.booking.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
