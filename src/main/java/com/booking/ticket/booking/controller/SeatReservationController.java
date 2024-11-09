package com.booking.ticket.booking.controller;

import com.booking.ticket.booking.model.Seat;
import com.booking.ticket.booking.service.SeatReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@RequiredArgsConstructor
public class SeatReservationController {
    private final SeatReservationService seatReservationService;

    @PostMapping("/reserve")
    public List<Seat> reserveSeats(@RequestParam int count) {
        return seatReservationService.reserveSeats(count);
    }

    @GetMapping
    public List<Seat> getAllSeats() {
        return seatReservationService.getAllSeats();
    }
}
