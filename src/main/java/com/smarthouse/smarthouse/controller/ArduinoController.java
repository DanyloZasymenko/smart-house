package com.smarthouse.smarthouse.controller;

import com.smarthouse.smarthouse.service.ArduinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/arduino")
public class ArduinoController {

    @Autowired
    private ArduinoService arduinoService;

    @GetMapping("/check")
    private ResponseEntity<String> check() {
        return ResponseEntity.ok(arduinoService.check());
    }
}
