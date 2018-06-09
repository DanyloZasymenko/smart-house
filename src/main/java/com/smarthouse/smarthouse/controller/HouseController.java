package com.smarthouse.smarthouse.controller;

import com.smarthouse.smarthouse.dto.HouseFullDto;
import com.smarthouse.smarthouse.dto.HouseShortDto;
import com.smarthouse.smarthouse.service.HouseService;
import com.smarthouse.smarthouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

import static com.smarthouse.smarthouse.dto.utils.builder.Builder.map;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    private ResponseEntity<HouseFullDto> save(@RequestParam String name,
                                              @RequestParam String serial) {
        return ResponseEntity.ok(map(houseService.save(name, serial), HouseFullDto.class));
    }

    @PostMapping("/update")
    private ResponseEntity<HouseFullDto> update(@RequestParam Long id,
                                                @RequestParam String name,
                                                @RequestParam String serial,
                                                @RequestParam Float temperature,
                                                @RequestParam Float humidity) {
        return ResponseEntity.ok(map(houseService.update(id, name, serial, temperature, humidity), HouseFullDto.class));
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

    @GetMapping("/find-by-serial/{serial}")
    private ResponseEntity<HouseFullDto> findBySerial(@PathVariable String serial) {
        return ResponseEntity.ok(map(houseService.findBySerial(serial), HouseFullDto.class));
    }

    @GetMapping("/create-or-find-by-serial/{serial}")
    private ResponseEntity<HouseFullDto> createOrFindBySerial(@PathVariable String serial, Principal principal) {
        return ResponseEntity.ok(map(houseService.createOrFindBySerial(serial, principal), HouseFullDto.class));
    }

    @GetMapping("/online")
    private ResponseEntity<Boolean> status(Principal principal) {
        return ResponseEntity.ok(userService.findByEmail(principal.getName()).getHouse().getOnline());
    }
}
