package pl.parser.nbp.model;

public class RequestParams {
    private String currency;
    private String startDate;
    private String endDate;
    private String table;

    public RequestParams() {
    }

    private RequestParams(String currency, String startDate, String endDate, String table) {
        this.currency = currency;
        this.startDate = startDate;
        this.endDate = endDate;
        this.table = table;
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

    public RequestParams withTable(String table){
        this.table = table;
        return this;
    }

    public RequestParams build() {
        return new RequestParams(currency, startDate, endDate, table);
    }

    @Override
    public String toString() {
        return "RequestParams{" +
                "currency='" + currency + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", table=" + table +
                '}';
    }
}
