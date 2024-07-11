package com.example.ElectricPeAssignment.Controller;

import com.example.ElectricPeAssignment.Entities.Booking;
import com.example.ElectricPeAssignment.Service.BookSlotService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/booking")
public class BookingController {

    BookSlotService bookSlotService;

    BookingController(BookSlotService bookSlotService){
        this.bookSlotService = bookSlotService;
    }


    @PostMapping(path = "/book")
    public String bookSlot(@RequestBody Booking bookSlot){
        return bookSlotService.bookStation(bookSlot);
    }

    @PostMapping(path = "/startcharging")
    public String startCharging(@RequestBody Booking availabelBooking){
        return bookSlotService.startCharging(availabelBooking);
    }

    @GetMapping(path = "/terminateandgetcost")
    public double endChargingAndGetAmount(@RequestBody Booking booking){
        return bookSlotService.endChargingAndGetAmount(booking);
    }

}
