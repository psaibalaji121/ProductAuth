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
public class TestSiteProcessor implements UrlProcessor {

    @Override
    public boolean canProcess(String url) {
        return url.contains("webscraper.io");
    }

    @Override
    public UrlResponse process(String url) {
        UrlResponse response = new UrlResponse();
        try {
            Document doc = Jsoup.connect(url).get();

            Element titleElement = doc.selectFirst("div.thumbnail h4.title");
            if (titleElement != null) {
                response.setTitle(titleElement.text());
            }

            Element priceElement = doc.selectFirst("div.thumbnail h4.price");
            if (priceElement != null) {
                String priceText = priceElement.text().replace("$", "");
                response.setPrice(Double.parseDouble(priceText));
            }

            Element descriptionElement = doc.selectFirst("div.thumbnail p.description");
            if (descriptionElement != null) {
                response.setDescription(descriptionElement.text());
            }

            Elements imageElements = doc.select("div.thumbnail img.img-responsive");
            List<String> imageUrls = new ArrayList<>();
            for (Element imageElement : imageElements) {
                String imageUrl = imageElement.absUrl("src");
                imageUrls.add(imageUrl);
            }
            response.setImages(imageUrls);

            response.setResult("Fake Product");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}
