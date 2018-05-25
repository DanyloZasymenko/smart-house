package com.smarthouse.smarthouse.controller;

import com.smarthouse.smarthouse.dto.UserFullDto;
import com.smarthouse.smarthouse.dto.UserShortDto;
import com.smarthouse.smarthouse.model.User;
import com.smarthouse.smarthouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.smarthouse.smarthouse.dto.utils.builder.Builder.map;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    private ResponseEntity<UserFullDto> save(@RequestBody UserFullDto userFullDto) {
        return ResponseEntity.ok(map(userService.save(map(userFullDto, User.class)), UserFullDto.class));
    }

    @PostMapping("/update")
    private ResponseEntity<UserFullDto> update(@RequestBody UserFullDto userFullDto) {
        return ResponseEntity.ok(map(userService.update(map(userFullDto, User.class)), UserFullDto.class));
    }

    @GetMapping("/find-one/{id}")
    private ResponseEntity<UserFullDto> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(map(userService.findOne(id), UserFullDto.class));
    }

    @GetMapping("/find-all")
    private ResponseEntity<List<UserShortDto>> findAll() {
        return ResponseEntity.ok(userService.findAll().stream()
                .map(device -> map(device, UserShortDto.class)).collect(toList()));
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(userService.delete(id));
    }

    @GetMapping("/find-by-username/{username}")
    private ResponseEntity<UserFullDto> findByUsername(@PathVariable String username) {
        return ResponseEntity.ok(map(userService.findByUsername(username), UserFullDto.class));
    }

    @GetMapping("/find-all-by-house-id/{id}")
    private ResponseEntity<List<UserShortDto>> findAllByHouseId(Long id) {
        return ResponseEntity.ok(userService.findAllByHouseId(id).stream()
                .map(user -> map(user, UserShortDto.class)).collect(toList()));
    }
}
