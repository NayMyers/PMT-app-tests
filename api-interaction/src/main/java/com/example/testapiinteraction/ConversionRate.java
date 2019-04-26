package com.example.testapiinteraction;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConversionRate {

    @SerializedName("price")
    @Expose
    private Price price;
    @SerializedName("timestamp")
    @Expose
    private Integer timestamp;

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

}