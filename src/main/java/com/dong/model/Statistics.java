package com.dong.model;

/**
 * Created by DONG on 9/27/2017.
 */
public class Statistics {
    private String time;
    private String lastSeen;
    private String reportedHashrate;
    private String averageHashrate;
    private String currentHashrate;
    private String validShares;
    private String invalidShares;
    private String staleShares;
    private String activeWorkers;
    private String unpaid;
    private String unconfirmed;
    private String coinsPerMin;
    private String usdPerMin;
    private String btcPerMin;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getReportedHashrate() {
        return reportedHashrate;
    }

    public void setReportedHashrate(String reportedHashrate) {
        this.reportedHashrate = reportedHashrate;
    }

    public String getAverageHashrate() {
        return averageHashrate;
    }

    public void setAverageHashrate(String averageHashrate) {
        this.averageHashrate = averageHashrate;
    }

    public String getCurrentHashrate() {
        return currentHashrate;
    }

    public void setCurrentHashrate(String currentHashrate) {
        this.currentHashrate = currentHashrate;
    }

    public String getValidShares() {
        return validShares;
    }

    public void setValidShares(String validShares) {
        this.validShares = validShares;
    }

    public String getInvalidShares() {
        return invalidShares;
    }

    public void setInvalidShares(String invalidShares) {
        this.invalidShares = invalidShares;
    }

    public String getStaleShares() {
        return staleShares;
    }

    public void setStaleShares(String staleShares) {
        this.staleShares = staleShares;
    }

    public String getActiveWorkers() {
        return activeWorkers;
    }

    public void setActiveWorkers(String activeWorkers) {
        this.activeWorkers = activeWorkers;
    }

    public String getUnpaid() {
        return unpaid;
    }

    public void setUnpaid(String unpaid) {
        this.unpaid = unpaid;
    }

    public String getUnconfirmed() {
        return unconfirmed;
    }

    public void setUnconfirmed(String unconfirmed) {
        this.unconfirmed = unconfirmed;
    }

    public String getCoinsPerMin() {
        return coinsPerMin;
    }

    public void setCoinsPerMin(String coinsPerMin) {
        this.coinsPerMin = coinsPerMin;
    }

    public String getUsdPerMin() {
        return usdPerMin;
    }

    public void setUsdPerMin(String usdPerMin) {
        this.usdPerMin = usdPerMin;
    }

    public String getBtcPerMin() {
        return btcPerMin;
    }

    public void setBtcPerMin(String btcPerMin) {
        this.btcPerMin = btcPerMin;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "time='" + time + '\'' +
                ", lastSeen='" + lastSeen + '\'' +
                ", reportedHashrate='" + reportedHashrate + '\'' +
                ", averageHashrate='" + averageHashrate + '\'' +
                ", currentHashrate='" + currentHashrate + '\'' +
                ", validShares='" + validShares + '\'' +
                ", invalidShares='" + invalidShares + '\'' +
                ", staleShares='" + staleShares + '\'' +
                ", activeWorkers='" + activeWorkers + '\'' +
                ", unpaid='" + unpaid + '\'' +
                ", unconfirmed='" + unconfirmed + '\'' +
                ", coinsPerMin='" + coinsPerMin + '\'' +
                ", usdPerMin='" + usdPerMin + '\'' +
                ", btcPerMin='" + btcPerMin + '\'' +
                '}';
    }
}
