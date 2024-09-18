package com.example.productauth.model;

import java.util.List;

public class UrlResponse {
    private String title;
    private double price;

    public UrlResponse() {
    }


    private String Result;

    public UrlResponse(String title, double price, String result, String description, List<String> images, String sellerName, String shopName, String sellerUrl) {
        this.title = title;
        this.price = price;
        Result = result;
        this.description = description;
        this.images = images;
        this.sellerName = sellerName;
        this.shopName = shopName;
        this.sellerUrl = sellerUrl;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;
    private List<String> images;
    private  String sellerName;

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getSellerUrl() {
        return sellerUrl;
    }

    public void setSellerUrl(String sellerUrl) {
        this.sellerUrl = sellerUrl;
    }

    private String shopName;
    private String sellerUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }



    @Override
    public String toString() {
        return "UrlResponse{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", images=" + images +
                ", sellerName='" + sellerName + '\'' +
                ", shopName='" + shopName + '\'' +
                ", sellerUrl='" + sellerUrl + '\'' +
                '}';
    }
}
