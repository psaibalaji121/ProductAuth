package com.example.productauth.controller;

import com.example.productauth.model.UrlRequest;
import com.example.productauth.model.UrlResponse;
import com.example.productauth.service.UrlProcessorSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UrlController {
    private final UrlProcessorSelector processorSelector;

    @Autowired
    public UrlController(UrlProcessorSelector processorSelector) {
        this.processorSelector = processorSelector;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/process-url")
    public ResponseEntity<UrlResponse> processUrl(@RequestBody UrlRequest urlRequest) {
        String url = urlRequest.getUrl();
        UrlResponse response = processorSelector.processUrl(url);
        return ResponseEntity.ok(response);
    }
}
