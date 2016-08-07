package pl.parser.nbp.model;

public class RequestParams {
    private String currency;
    private String startDate;
    private String endDate;

    public RequestParams() {
    }

    private RequestParams(String currency, String startDate, String endDate) {
        this.currency = currency;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public RequestParams withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public RequestParams withStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public RequestParams withEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public RequestParams build() {
        return new RequestParams(currency, startDate, endDate);
    }

    public String getCurrency() {
        return currency;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "RequestParams{" +
                "currency='" + currency + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }

}
