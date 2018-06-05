package com.smarthouse.smarthouse.controller;

import com.smarthouse.smarthouse.dto.DeviceFullDto;
import com.smarthouse.smarthouse.service.AndroidService;
import com.smarthouse.smarthouse.service.utils.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.smarthouse.smarthouse.dto.utils.builder.Builder.map;

@RestController
@RequestMapping("/android")
public class AndroidController {

    @Autowired
    private AndroidService androidService;

    @PostMapping("/change-active/{id}/{active}")
    private ResponseEntity<DeviceFullDto> changeActive(@PathVariable Long id, @PathVariable Boolean active) {
        System.err.println("______________________________");
        System.err.println(id + " " + active);
        System.err.println("______________________________");
        return ResponseEntity.ok(map(androidService.changeActive(id, active), DeviceFullDto.class));
    }

    @GetMapping("/get-temperature")
    private ResponseEntity<Temperature> getTemperature() {
        System.err.println(Temperature.getInstance());
        return ResponseEntity.ok(Temperature.getInstance());
    }
}
