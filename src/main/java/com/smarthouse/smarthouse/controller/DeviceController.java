package com.smarthouse.smarthouse.controller;

import com.smarthouse.smarthouse.dto.DeviceFullDto;
import com.smarthouse.smarthouse.dto.DeviceShortDto;
import com.smarthouse.smarthouse.model.Device;
import com.smarthouse.smarthouse.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.smarthouse.smarthouse.dto.utils.builder.Builder.map;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @PostMapping("/save")
    private ResponseEntity<DeviceFullDto> save(@RequestBody DeviceFullDto deviceFullDto) {
        return ResponseEntity.ok(map(deviceService.save(map(deviceFullDto, Device.class)), DeviceFullDto.class));
    }

    @PostMapping("/update")
    private ResponseEntity<DeviceFullDto> update(@RequestBody DeviceFullDto deviceFullDto) {
        return ResponseEntity.ok(map(deviceService.update(map(deviceFullDto, Device.class)), DeviceFullDto.class));
    }

    @GetMapping("/find-one/{id}")
    private ResponseEntity<DeviceFullDto> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(map(deviceService.findOne(id), DeviceFullDto.class));
    }

    @GetMapping("/find-all")
    private ResponseEntity<List<DeviceShortDto>> findAll() {
        return ResponseEntity.ok(deviceService.findAll().stream()
                .map(device -> map(device, DeviceShortDto.class)).collect(toList()));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(deviceService.delete(id));
    }

    @GetMapping("/find-by-name-and-house-id/{name}/{id}")
    private ResponseEntity<DeviceFullDto> findByNameAndHouseId(@PathVariable String name, @PathVariable Long id) {
        return ResponseEntity.ok(map(deviceService.findByNameAndHouseId(name, id), DeviceFullDto.class));
    }

    @GetMapping("/find-all-by-house-id/{id}")
    private ResponseEntity<List<DeviceShortDto>> findAllByHouseId(@PathVariable Long id) {
        return ResponseEntity.ok(deviceService.findAllByHouseId(id).stream()
                .map(device -> map(device, DeviceShortDto.class)).collect(toList()));
    }

    @GetMapping("/find-all-by-active-and-house-id/{active}/{id}")
    private ResponseEntity<List<DeviceShortDto>> findAllByActiveAndHouseId(@PathVariable Boolean active,
                                                                           @PathVariable Long id) {
        return ResponseEntity.ok(deviceService.findAllByActiveAndHouseId(active, id).stream()
                .map(device -> map(device, DeviceShortDto.class)).collect(toList()));
    }
}
