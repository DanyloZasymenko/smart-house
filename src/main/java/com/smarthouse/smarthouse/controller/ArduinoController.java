package com.smarthouse.smarthouse.controller;

import com.smarthouse.smarthouse.dto.DeviceToArduinoDto;
import com.smarthouse.smarthouse.service.ArduinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.smarthouse.smarthouse.dto.utils.builder.Builder.map;

@RestController
@RequestMapping("/arduino")
public class ArduinoController {

    @Autowired
    private ArduinoService arduinoService;

    @GetMapping("/check")
    private ResponseEntity<DeviceToArduinoDto> check() {
        return ResponseEntity.ok(map(arduinoService.check(), DeviceToArduinoDto.class));
    }

    @GetMapping("/confirm-activity/{serial}")
    private ResponseEntity<Boolean> confirm(@PathVariable String serial) {
        return ResponseEntity.ok(arduinoService.confirmActivity(serial));
    }

    @GetMapping("/send-temperature/{h}/{t}/{f}/{hic}/{hif}")
    private ResponseEntity sendTemperature(@PathVariable Float h,
                                   @PathVariable Float t,
                                   @PathVariable Float f,
                                   @PathVariable Float hic,
                                   @PathVariable Float hif) {
//        System.err.println("IN SEND TEMPERATURE");
        arduinoService.getDataFromSensor(h, t, f, hic, hif);
        return ResponseEntity.ok().build();
    }
}
