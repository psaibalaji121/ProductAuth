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
public class EtsyProcessor implements UrlProcessor {

    @Override
    public boolean canProcess(String url) {
        return url.contains("etsy.com");
    }

    @Override
    public UrlResponse process(String url) {
        UrlResponse response = new UrlResponse();
        try {
            // Fetch the HTML content of the page
            Document doc = Jsoup.connect(url)
                                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
                                .header("Accept-Language", "en-US,en;q=0.9")
                                .header("Accept-Encoding", "gzip, deflate, br")
                                .header("Connection", "keep-alive")
                                .timeout(10000) // 10 seconds timeout
                                .get();

            String title = doc.select("h1[data-buy-box-listing-title='true']").text();
            response.setTitle(title);

            String priceText = doc.select("div[data-selector='price-only']>p").text().replaceAll("Price: ₹","").replaceAll(",","");
            double price = parsePrice(priceText);
            response.setPrice(price);

            String description = doc.select("div[data-id='description-text']").text();
            response.setDescription(description);

            String sellerName = doc.select("p.wt-text-heading-small").text();
            response.setSellerName(sellerName);

            Elements shop = doc.select("span.wt-text-title-small>a");
            String sellerUrl = shop.attr("href");
            String shopName = shop.text();
            response.setSellerUrl(sellerUrl);
            response.setShopName(shopName);



            Elements imageElements = doc.select("div[id='photos']>div>div>ul>li>img");
            List<String> imageUrls = new ArrayList<>();
            for (Element img : imageElements) {
                imageUrls.add(img.attr("src"));
            }
            response.setImages(imageUrls);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private double parsePrice(String priceText) {
        if(priceText.contains("Original"))
        {
            priceText = priceText.replaceAll("Original  \\d+","");
        }
        String cleanPrice = priceText.replaceAll("[^\\d.]", "");
        try {
            return Double.parseDouble(cleanPrice);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
