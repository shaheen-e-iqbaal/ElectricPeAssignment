package com.example.ElectricPeAssignment.Service;


import com.example.ElectricPeAssignment.Entities.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;




@Service
public class BookSlotService {

    ChargingStationService chargingStationService;


    @Autowired
    BookSlotService(ChargingStationService chargingStationService){
        this.chargingStationService = chargingStationService;
    }



    private List<Booking> bookings = new ArrayList<>();
    static long bookingId = 0;


    //Method to check availability of a charging station.
    public boolean checkAvailibility (int stationId, LocalDateTime startTime){

        for(Booking booking : bookings){
            if(booking.getStationId() == stationId && !(startTime.compareTo(booking.getStartTime()) == 0)){
                return true;
            }
        }
        return false;
    }

    //Method to book time slot at station with stationId
    public String bookStation(Booking bookSlot){
        boolean isAvailable = checkAvailibility(bookSlot.getStationId(), bookSlot.getStartTime());
        if(isAvailable){
            bookSlot.setBookingId(bookingId++);
            bookings.add(bookSlot);
            return "Slot Booked SUCCESSFULLY";
        }
        return "Please choose different time";
    }

    //Method to start Charging
    public String startCharging(Booking availabelBooking){
        boolean isBooked = false;
        for(Booking booking : bookings){
            if(booking.equals(availabelBooking)){
                return "Charging Started Successfully";
            }
        }
        return "Couldn't found Booking";
    }

    //Method to end Charging and get Amount to pay
    public double endChargingAndGetAmount(Booking booking){
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime startingTime = booking.getStartTime();
        double totalMinutes = (double) (ChronoUnit.SECONDS.between(currentTime, startingTime) / 60d);
        double costPerMinutes = chargingStationService.getStationByStationId(booking.getStationId()).getCostPerMinute();
        return totalMinutes * costPerMinutes;
    }


}
