package com.dev.product.Coffee.controller;

import com.dev.product.Coffee.entity.SubscribeEntity;
import com.dev.product.Coffee.service.SubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/s1")
public class SubscribeController {
    
    @Autowired
    private final SubscribeService service;
    
    @PostMapping("/subscribe")
    public ResponseEntity<SubscribeEntity> createSubscribe(@RequestBody SubscribeEntity subscribeEntity) {
        return ResponseEntity.ok(service.insert(subscribeEntity));
    }
    
    @GetMapping("/subscribe")
    public ResponseEntity<List<SubscribeEntity>> getAllSubscribe() {
        return ResponseEntity.ok(service.selectAll());
    }
    
    @DeleteMapping("/subscribe/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteSubscribe(@PathVariable Long id) {
        boolean deleted = false;
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", deleted);
        return ResponseEntity.ok(response);
    }
}
