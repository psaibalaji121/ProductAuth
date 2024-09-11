package com.example.productauth.processors;


import com.example.productauth.model.UrlResponse;

public interface UrlProcessor {
    boolean canProcess(String url);
    UrlResponse process(String url);
}
