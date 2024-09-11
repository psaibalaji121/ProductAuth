package com.example.productauth.processors;

import com.example.productauth.model.UrlResponse;
import org.springframework.stereotype.Service;

@Service
public class AmazonProcessor implements UrlProcessor {

    @Override
    public boolean canProcess(String url) {
        return url.contains("amazon.in");
    }

    @Override
    public UrlResponse process(String url) {
        UrlResponse response = new UrlResponse();
        response.setTitle("Amazon Product Title");
        response.setPrice(1499.99);
        return response;
    }
}
