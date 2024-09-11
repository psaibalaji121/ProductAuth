package com.example.productauth.processors;

import com.example.productauth.model.UrlResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyStoreProcessor implements UrlProcessor {

    @Override
    public boolean canProcess(String url) {
        return url.contains("mystore.com");
    }

    @Override
    public UrlResponse process(String url) {
        UrlResponse response = new UrlResponse();
        try {
            Document doc = Jsoup.connect(url).get();

            String title = doc.select("h1.page-title").text();
            response.setTitle(title);

            String priceText =  doc.select("span.price").first().text();
            double price = parsePrice(priceText);
            response.setPrice(price);

            String description = doc.select("div.text").text();
            response.setDescription(description);

            Elements imageElements =doc.select("img.gallery-placeholder__image"); // Adjust selector as needed
            List<String> imageUrls = new ArrayList<>();
            for (Element img : imageElements) {
                String src = img.attr("src");
                if (src.startsWith("http")) {
                    imageUrls.add(src);
                }
            }
            response.setImages(imageUrls);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private double parsePrice(String priceText) {
        String cleanPrice = priceText.replaceAll("[^\\d.]", "");
        try {
            return Double.parseDouble(cleanPrice);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
