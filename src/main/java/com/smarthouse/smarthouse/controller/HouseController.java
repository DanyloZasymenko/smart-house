package com.smarthouse.smarthouse.controller;

import com.smarthouse.smarthouse.dto.HouseFullDto;
import com.smarthouse.smarthouse.dto.HouseShortDto;
import com.smarthouse.smarthouse.model.House;
import com.smarthouse.smarthouse.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.smarthouse.smarthouse.dto.utils.builder.Builder.map;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @PostMapping("/save")
    private ResponseEntity<HouseFullDto> save(@RequestBody HouseFullDto houseFullDto) {
        return ResponseEntity.ok(map(houseService.save(map(houseFullDto, House.class)), HouseFullDto.class));
    }

    @PostMapping("/update")
    private ResponseEntity<HouseFullDto> update(@RequestBody HouseFullDto houseFullDto) {
        return ResponseEntity.ok(map(houseService.update(map(houseFullDto, House.class)), HouseFullDto.class));
    }

    @GetMapping("/find-one/{id}")
    private ResponseEntity<HouseFullDto> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(map(houseService.findOne(id), HouseFullDto.class));
    }

    @GetMapping("/find-all")
    private ResponseEntity<List<HouseShortDto>> findAll() {
        return ResponseEntity.ok(houseService.findAll().stream()
                .map(device -> map(device, HouseShortDto.class)).collect(toList()));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(houseService.delete(id));
    }
}