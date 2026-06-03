package com.julien.booking.service;

import com.julien.booking.dto.CalendarEventDto;
import com.julien.booking.dto.CreateAppointmentRequest;
import com.julien.booking.model.Appointment;
import com.julien.booking.model.Client;
import com.julien.booking.repository.AppointmentRepository;
import com.julien.booking.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor

public class AppointmentService {

    private final ClientRepository clientRepository;
    private final AppointmentRepository appointmentRepository;

    public List<Appointment> findAllAppointments()
    {
        return appointmentRepository.findAll();
    }

    public List<CalendarEventDto> findAllEvents() {
        return appointmentRepository.findAll().stream()
                .map(a->new CalendarEventDto(

                        a.getId(),
                        a.getClient().getLastName(),
                        a.getStartTime(),
                        a.getEndTime()
                )).toList();

    }

    public Appointment findAppointmentById(Long id)
        {
        return appointmentRepository.findById(id).orElse(null);
        }

    public CalendarEventDto createAppointment(CreateAppointmentRequest request) {

        Client client = clientRepository.findById(request.clientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Appointment appointment = new Appointment();
        appointment.setStartTime(request.startTime());
        appointment.setEndTime(request.endTime());
        appointment.setClient(client);

        appointmentRepository.save(appointment);

        return new CalendarEventDto(
                appointment.getId(),
                client.getLastName(),
                appointment.getStartTime(),
                appointment.getEndTime()
        );

    }

}
