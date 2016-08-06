package pl.parser.nbp.model;

import java.math.BigDecimal;

public class ReturnedRates {
    String no;
    String effectiveDate;
    BigDecimal bid;
    BigDecimal ask;

    public String getNo() {
        return no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public ReturnedRates() {
    }

    private ReturnedRates(String no, String effectiveDate, BigDecimal bid, BigDecimal ask) {
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.bid = bid;
        this.ask = ask;
    }

    @Override
    public String toString() {
        return "ReturnedRates{" +
                "no='" + no + '\'' +
                ", effectiveDate='" + effectiveDate + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                '}';
    }

    public ReturnedRates withNo(String no) {
        this.no = no;
        return this;
    }

    public ReturnedRates withEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
        return this;
    }

    public ReturnedRates withBid(BigDecimal bid) {
        this.bid = bid;
        return this;
    }

    public ReturnedRates withAsk(BigDecimal ask) {
        this.ask = ask;
        return this;
    }

    public ReturnedRates build() {
        return new ReturnedRates(no, effectiveDate, bid, ask);
    }
}
