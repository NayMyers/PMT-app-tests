package com.example.testapiinteraction;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Price {

    @SerializedName("AUDUSD")
    @Expose
    private Double aUDUSD;
    @SerializedName("EURUSD")
    @Expose
    private Double eURUSD;
    @SerializedName("GBPUSD")
    @Expose
    private Double gBPUSD;
    @SerializedName("USDJPY")
    @Expose
    private Double uSDJPY;

    public Double getAUDUSD() {
        return aUDUSD;
    }

    public void setAUDUSD(Double aUDUSD) {
        this.aUDUSD = aUDUSD;
    }

    public Double getEURUSD() {
        return eURUSD;
    }

    public void setEURUSD(Double eURUSD) {
        this.eURUSD = eURUSD;
    }

    public Double getGBPUSD() {
        return gBPUSD;
    }

    public void setGBPUSD(Double gBPUSD) {
        this.gBPUSD = gBPUSD;
    }

    public Double getUSDJPY() {
        return uSDJPY;
    }

    public void setUSDJPY(Double uSDJPY) {
        this.uSDJPY = uSDJPY;
    }

}