package com.smarthouse.smarthouse.controller;

import com.smarthouse.smarthouse.model.LightConfig;
import com.smarthouse.smarthouse.service.LightConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/light-config")
public class LightConfigController {

    @Autowired
    private LightConfigService lightConfigService;

    @PostMapping("/save")
    private ResponseEntity<LightConfig> save(@RequestBody LightConfig lightConfig){
        return ResponseEntity.ok(lightConfigService.save(lightConfig));
    }

    @PostMapping("/update")
    private ResponseEntity<LightConfig> update(@RequestBody LightConfig lightConfig){
        return ResponseEntity.ok(lightConfigService.update(lightConfig));
    }

    @GetMapping("/find-one/{id}")
    private ResponseEntity<LightConfig> findOne(@PathVariable Long id){
        return ResponseEntity.ok(lightConfigService.findOne(id));
    }

    @GetMapping("/find-all")
    private ResponseEntity<List<LightConfig>> findAll(){
        return ResponseEntity.ok(lightConfigService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable Long id){
        return ResponseEntity.ok(lightConfigService.delete(id));
    }
}
