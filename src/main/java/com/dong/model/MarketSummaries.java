package com.dong.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by DONG on 10/5/2017.
 */
public class MarketSummaries {
    @JsonProperty("MarketName")
    private String marketName;

    @JsonProperty("High")
    private String high;

    @JsonProperty("Low")
    private String low;

    @JsonProperty("Volume")
    private String volume;

    @JsonProperty("Last")
    private String last;

    @JsonProperty("BaseVolume")
    private String baseVolume;

    @JsonProperty("TimeStamp")
    private String timeStamp;

    @JsonProperty("Bid")
    private String bid;

    @JsonProperty("Ask")
    private String ask;

    @JsonProperty("OpenBuyOrders")
    private String openBuyOrders;

    @JsonProperty("OpenSellOrders")
    private String openSellOrders;

    @JsonProperty("PrevDay")
    private String prevDay;

    @JsonProperty("Created")
    private String created;

    @JsonProperty("DisplayMarketName")
    private String displayMarketName;

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getBaseVolume() {
        return baseVolume;
    }

    public void setBaseVolume(String baseVolume) {
        this.baseVolume = baseVolume;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getOpenBuyOrders() {
        return openBuyOrders;
    }

    public void setOpenBuyOrders(String openBuyOrders) {
        this.openBuyOrders = openBuyOrders;
    }

    public String getOpenSellOrders() {
        return openSellOrders;
    }

    public void setOpenSellOrders(String openSellOrders) {
        this.openSellOrders = openSellOrders;
    }

    public String getPrevDay() {
        return prevDay;
    }

    public void setPrevDay(String prevDay) {
        this.prevDay = prevDay;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDisplayMarketName() {
        return displayMarketName;
    }

    public void setDisplayMarketName(String displayMarketName) {
        this.displayMarketName = displayMarketName;
    }
}
