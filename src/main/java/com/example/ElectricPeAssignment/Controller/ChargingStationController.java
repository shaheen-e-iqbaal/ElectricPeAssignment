package com.example.ElectricPeAssignment.Controller;

import com.example.ElectricPeAssignment.Entities.ChargingStation;
import com.example.ElectricPeAssignment.Service.ChargingStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/station")
public class ChargingStationController {


    ChargingStationService chargingStationService;

    @Autowired
    ChargingStationController(ChargingStationService chargingStationService){
        this.chargingStationService = chargingStationService;
    }


    @PostMapping(path = "/create")
    public String createStation(@RequestBody ChargingStation chargingStation){
        return chargingStationService.createStation(chargingStation);
    }

    @GetMapping(path = "/getstation")
    public ChargingStation getStationByStationId(@RequestParam int stationId){
        return chargingStationService.getStationByStationId(stationId);
    }

    @GetMapping(path = "/nearby")
    public List<ChargingStation> getNearbyStation(@RequestParam double latitude,
                                                  @RequestParam double longitude,
                                                  @RequestParam double radius){
        return chargingStationService.getNearbyStation(latitude,longitude,radius);
    }

}
