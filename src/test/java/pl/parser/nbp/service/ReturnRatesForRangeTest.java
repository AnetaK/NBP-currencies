package pl.parser.nbp.service;

import org.junit.Test;
import pl.parser.nbp.model.RequestParams;
import pl.parser.nbp.model.ReturnedRates;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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

        List<ReturnedRates> returnedRates = returnRatesForRange.returnRates(requestParams);

        assertThat("wrong number of elements returned",returnedRates.size(),is(equalTo(151)));
    }
    @Test
    public void should_return_1_element_for_range() throws Exception {

        ReturnRatesForRange returnRatesForRange = new ReturnRatesForRange();
        RequestParams requestParams = new RequestParams()
                .withCurrency("EUR")
                .withStartDate("2016-08-05")
                .withEndDate("2016-08-05")
                .withTable("c")
                .build();

        List<ReturnedRates> returnedRates = returnRatesForRange.returnRates(requestParams);

        assertThat("wrong number of elements returned",returnedRates.size(),is(equalTo(1)));
    }

}