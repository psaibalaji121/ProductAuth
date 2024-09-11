package com.example.productauth.service;

import com.example.productauth.model.UrlResponse;
import com.example.productauth.processors.UrlProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlProcessorSelector {

    private final List<UrlProcessor> processors;

    @Autowired
    public UrlProcessorSelector(List<UrlProcessor> processors) {
        this.processors = processors;
    }

    public UrlResponse processUrl(String url) {
        for (UrlProcessor processor : processors) {
            if (processor.canProcess(url)) {
                return processor.process(url);
            }
        }
        throw new IllegalArgumentException("No processor found for URL: " + url);
    }
}
