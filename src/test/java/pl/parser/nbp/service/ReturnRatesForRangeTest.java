package pl.parser.nbp.service;

import org.junit.Test;
import pl.parser.nbp.model.RequestParams;

public class ReturnRatesForRangeTest {

    @Test
    public void should_return_151_elements_for_range() throws Exception {

        ReturnRatesForRange returnRatesForRange = new ReturnRatesForRange();
        RequestParams requestParams = new RequestParams()
                .withCurrency("EUR")
                .withStartDate("2016-01-01")
                .withEndDate("2016-08-06")
                .withTable("c")
                .build();

        returnRatesForRange.returnRates(requestParams);
    }

}