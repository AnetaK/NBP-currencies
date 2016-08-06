package pl.parser.nbp.model;

public class ReturnedRates {
    String no;
    String effectiveDate;
    Double mid;

    public String getNo() {
        return no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public Double getMid() {
        return mid;
    }

    @Override
    public String toString() {
        return "ReturnedRates{" +
                "no='" + no + '\'' +
                ", effectiveDate='" + effectiveDate + '\'' +
                ", mid=" + mid +
                '}';
    }
}
