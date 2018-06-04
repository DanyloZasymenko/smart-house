package com.smarthouse.smarthouse.controller;

import com.smarthouse.smarthouse.dto.UserDataShortDto;
import com.smarthouse.smarthouse.model.UserData;
import com.smarthouse.smarthouse.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

import static com.smarthouse.smarthouse.dto.utils.builder.Builder.map;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/user-data")
public class UserDataController {

    @Autowired
    private UserDataService userDataService;

    @PostMapping("/save-for-climate-config")
    private ResponseEntity<UserData> saveForClimateConfig(@RequestParam Long deviceId,
                                                          @RequestParam Long climateConfigId,
                                                          Principal principal) {
        return ResponseEntity.ok(userDataService.saveForClimateConfig(deviceId, climateConfigId, principal));
    }

    @PostMapping("/save-for-light-config")
    private ResponseEntity<UserData> saveForLightConfig(@RequestParam Long deviceId,
                                                        @RequestParam Long lightConfigId,
                                                        Principal principal) {
        return ResponseEntity.ok(userDataService.saveForLightConfig(deviceId, lightConfigId, principal));
    }

    @GetMapping("/find-one/{id}")
    private ResponseEntity<UserDataShortDto> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(map(userDataService.findOne(id), UserDataShortDto.class));
    }

    @GetMapping("/find-all")
    private ResponseEntity<List<UserDataShortDto>> findAll() {
        return ResponseEntity.ok(userDataService.findAll().stream().map(userData ->
                map(userData, UserDataShortDto.class)).collect(toList()));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(userDataService.delete(id));
    }

    @GetMapping("/find-all-by-user-id/{userId}")
    private ResponseEntity<List<UserDataShortDto>> findAllByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(userDataService.findAllByUserId(userId).stream().map(userData ->
                map(userData, UserDataShortDto.class)).collect(toList()));
    }

    @GetMapping("/find-all-by-device-id/{deviceId}")
    private ResponseEntity<List<UserDataShortDto>> findAllByDeviceId(@PathVariable Long deviceId) {
        return ResponseEntity.ok(userDataService.findAllByDeviceId(deviceId).stream().map(userData ->
                map(userData, UserDataShortDto.class)).collect(toList()));
    }

}
