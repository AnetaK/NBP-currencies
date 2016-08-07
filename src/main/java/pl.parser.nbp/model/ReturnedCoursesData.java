package pl.parser.nbp.model;

import java.util.List;

public class ReturnedCoursesData {

    String table;
    String currency;
    String code;
    List<ReturnedRates> rates;

    public String getTable() {
        return table;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public List<ReturnedRates> getRates() {
        return rates;
    }

    @Override
    public String toString() {
        return "ReturnedCoursesData{" +
                "table='" + table + '\'' +
                ", currency='" + currency + '\'' +
                ", code='" + code + '\'' +
                ", rates=" + rates +
                '}';
    }
}










