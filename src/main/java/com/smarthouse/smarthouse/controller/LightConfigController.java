package com.smarthouse.smarthouse.controller;

import com.smarthouse.smarthouse.model.LightConfig;
import com.smarthouse.smarthouse.service.LightConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@RestController
@RequestMapping("/light-config")
public class LightConfigController {

    @Autowired
    private LightConfigService lightConfigService;

    @PostMapping("/save")
    private ResponseEntity<LightConfig> save(@RequestParam Time startTime,
                                             @RequestParam Time endTime,
                                             @RequestParam Boolean active) {
        return ResponseEntity.ok(lightConfigService.save(startTime, endTime, active));
    }

    @PostMapping("/update")
    private ResponseEntity<LightConfig> update(@RequestParam Long id,
                                               @RequestParam Time startTime,
                                               @RequestParam Time endTime,
                                               @RequestParam Boolean active) {
        return ResponseEntity.ok(lightConfigService.update(id, startTime, endTime, active));
    }

    @GetMapping("/find-one/{id}")
    private ResponseEntity<LightConfig> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(lightConfigService.findOne(id));
    }

    @GetMapping("/find-all")
    private ResponseEntity<List<LightConfig>> findAll() {
        return ResponseEntity.ok(lightConfigService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(lightConfigService.delete(id));
    }
}
