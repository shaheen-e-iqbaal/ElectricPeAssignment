package com.example.ElectricPeAssignment.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
public class ChargingStation{
    private int stationId;
    private String stationName;
    private double longitude;
    private double letitude;
    private double costPerMinute;

    ChargingStation(String stationName, double longitude, double letitude, double costPerMinute){
        this.stationName = stationName;
        this.longitude = longitude;
        this.letitude = letitude;
        this.costPerMinute = costPerMinute;
    }

    @Override
    public boolean equals(Object o){
        ChargingStation chargingStation = (ChargingStation) o;
        if(this.getLongitude() == chargingStation.longitude && this.getLetitude() == chargingStation.letitude){
            return true;
        }
        return false;
    }
}
