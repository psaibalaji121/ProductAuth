package com.example.productauth.processors;
import com.example.productauth.model.UrlResponse;
import org.springframework.stereotype.Service;

@Service
public class FlipkartProcessor implements UrlProcessor {

    @Override
    public boolean canProcess(String url) {
        return url.contains("flipkart.com");
    }

    @Override
    public UrlResponse process(String url) {
        UrlResponse response = new UrlResponse();
        response.setTitle("Flipkart Product Title");
        response.setPrice(999.99);
        return response;
    }
}
