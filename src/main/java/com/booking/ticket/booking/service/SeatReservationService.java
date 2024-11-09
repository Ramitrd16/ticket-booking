package com.booking.ticket.booking.service;

import com.booking.ticket.booking.model.Seat;
import com.booking.ticket.booking.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatReservationService {
    private final SeatRepository seatRepository;

    @Transactional
    public List<Seat> reserveSeats(int seatCount) {
        List<Seat> availableSeats = seatRepository.findByReservedFalse();
        List<Seat> reservedSeats = new ArrayList<>();

        int reservedCount = 0;
        for (Seat seat : availableSeats) {
            if (reservedCount < seatCount) {
                seat.setReserved(true);
                reservedSeats.add(seat);
                reservedCount++;
            } else {
                break;
            }
        }
        seatRepository.saveAll(reservedSeats);
        return reservedSeats;
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }
}
