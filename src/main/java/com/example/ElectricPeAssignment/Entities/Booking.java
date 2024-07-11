package com.example.ElectricPeAssignment.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
public class Booking{
    private long bookingId;
    private int userId;
    private int stationId;
    private LocalDateTime startTime;

    @Override
    public boolean equals(Object o){
        Booking book = (Booking) o;
        if(this.userId == book.getUserId() && this.stationId == book.getStationId() && this.startTime == book.getStartTime()){
            return true;
        }
        return false;
    }
}
