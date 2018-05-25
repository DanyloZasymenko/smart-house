package com.smarthouse.smarthouse.controller;

import com.smarthouse.smarthouse.model.ClimateConfig;
import com.smarthouse.smarthouse.service.ClimateConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/climate-config")
public class ClimateConfigController {

    @Autowired
    private ClimateConfigService climateConfigService;

    @PostMapping("/save")
    private ResponseEntity<ClimateConfig> save(@RequestBody ClimateConfig climateConfig){
        return ResponseEntity.ok(climateConfigService.save(climateConfig));
    }

    @PostMapping("/update")
    private ResponseEntity<ClimateConfig> update(@RequestBody ClimateConfig climateConfig){
        return ResponseEntity.ok(climateConfigService.update(climateConfig));
    }

    @GetMapping("/find-one/{id}")
    private ResponseEntity<ClimateConfig> findOne(@PathVariable Long id){
        return ResponseEntity.ok(climateConfigService.findOne(id));
    }

    @GetMapping("/find-all")
    private ResponseEntity<List<ClimateConfig>> findAll(){
        return ResponseEntity.ok(climateConfigService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Boolean> delete(@PathVariable Long id){
        return ResponseEntity.ok(climateConfigService.delete(id));
    }
}
