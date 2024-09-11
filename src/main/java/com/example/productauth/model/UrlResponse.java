package com.example.productauth.model;

import java.util.List;

public class UrlResponse {
    private String title;
    private double price;

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


    public UrlResponse() {
    }


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

    public UrlResponse(String title, double price, String description, List<String> images, String sellerName, String shopName, String sellerUrl) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.images = images;
        this.sellerName = sellerName;
        this.shopName = shopName;
        this.sellerUrl = sellerUrl;
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
