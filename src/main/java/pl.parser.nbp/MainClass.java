package pl.parser.nbp;

import pl.parser.nbp.model.RequestParams;

public class MainClass
{
    private static final String TABLE = "c";
    private RequestParams requestParams = new RequestParams();

    public MainClass(String currency, String startDate, String endDate ) {
        requestParams.withCurrency(currency)
                .withStartDate(startDate)
                .withEndDate(endDate)
                .withTable(TABLE)
                .build();
    }

    private void main(){
        getCurrenciesFromAPI();
        calculateAverateExchangeDate();
        calculateStandardDeviation();
    }

    private void getCurrenciesFromAPI(){
        //http://api.nbp.pl/api/exchangerates/rates/{table}/{code}/{startDate}/{endDate}/


    }

    private Double calculateAverateExchangeDate(){


        return 0d;
    }

    private void calculateStandardDeviation() {

    }


}
