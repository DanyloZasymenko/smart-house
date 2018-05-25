package com.smarthouse.smarthouse.controller;

import com.smarthouse.smarthouse.dto.DeviceFullDto;
import com.smarthouse.smarthouse.service.AndroidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.smarthouse.smarthouse.dto.utils.builder.Builder.map;

@RestController
@RequestMapping("/android")
public class AndroidController {

    @Autowired
    private AndroidService androidService;

    @PostMapping("/change-active/{id}/{active}")
    private ResponseEntity<DeviceFullDto> changeActive(@PathVariable Long id, @PathVariable Boolean active) {
        return ResponseEntity.ok(map(androidService.changeActive(id, active), DeviceFullDto.class));
    }
}
