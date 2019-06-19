package com.anhtam.tikihome.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {
    @SerializedName("badges")
    @Expose
    private List<Badge> badges = null;
    @SerializedName("rating_average")
    @Expose
    private Double ratingAverage;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("review_count")
    @Expose
    private Integer reviewCount;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("thumbnail_url")
    @Expose
    private String thumbnailUrl;
    @SerializedName("discount_rate")
    @Expose
    private Integer discountRate;

    public List<Badge> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }

    public Double getRatingAverage() {
        return ratingAverage;
    }

    public void setRatingAverage(Double ratingAverage) {
        this.ratingAverage = ratingAverage;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name != null ? name : "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl != null ? thumbnailUrl : "";
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Integer getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Integer discountRate) {
        this.discountRate = discountRate;
    }

    public boolean hasTikiNow (){
        for (Badge badge : getBadges()) {
            if (badge.isHasTikiNow())
                return true;
        }
        return false;
    }

    public boolean hasFastDelivery (){
        for (Badge badge : getBadges()) {
            if (badge.isHasFastDelivery())
                return true;
        }
        return false;
    }

    public boolean hasOptionColor (){
        for (Badge badge : getBadges()) {
            if (badge.isHasOptionColor())
                return true;
        }
        return false;
    }

    public boolean hasDiscount (){
        return getDiscountRate() > 0;
    }

    public String getTextFastDelivery (){
        for (Badge badge : getBadges()) {
            if (badge.getDeliveryText() != null)
                return badge.getDeliveryText();
        }
        return "";
    }

    public String getNumberFastDelivery (){
        for (Badge badge : getBadges()){
            if (badge.getDeliveryNumber() != null)
                return badge.getDeliveryNumber();
        }
        return "";
    }
}
