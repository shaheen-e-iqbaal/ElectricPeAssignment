package com.example.ElectricPeAssignment.Service;

import com.example.ElectricPeAssignment.Entities.ChargingStation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ChargingStationService {


    List<ChargingStation> chargingStations = new ArrayList<>();
    static int stationId = 0;

    //Method to create Station
    public String createStation(ChargingStation newChargingStation){
        boolean isAlreadyPresent = false;
        for(ChargingStation chargingStation : chargingStations){
            if(chargingStation.equals(newChargingStation)){
                isAlreadyPresent = true;
                break;
            }
        }
        if(isAlreadyPresent)return "This Station is already Present";
        else{
            newChargingStation.setStationId(stationId++);
            chargingStations.add(newChargingStation);
            return "Station created SUCCESFULLY with stationId = " + newChargingStation.getStationId();
        }
    }

    //Method to get station using stationId
    public ChargingStation getStationByStationId(int stationId){
        for(ChargingStation chargingStation : chargingStations){
            if(chargingStation.getStationId() == stationId){
                return chargingStation;
            }
        }
        return null;
    }

    //Method to get charging stations at max distance = redius
    public List<ChargingStation> getNearbyStation(double currentLetitude, double currentLongitude, double redius){
        List<ChargingStation> ans = new ArrayList<>();

        for(ChargingStation chargingStation : chargingStations){
            double distance = 0;
            double longitude = chargingStation.getLongitude();
            double letitude = chargingStation.getLetitude();
            distance = Math.pow(currentLetitude - letitude, 2) + Math.pow(currentLongitude - longitude,2);
            distance = Math.sqrt(distance);
            if(distance <= redius)ans.add(chargingStation);
        }
        return ans;
    }


}
