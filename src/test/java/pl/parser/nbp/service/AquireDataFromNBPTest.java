package pl.parser.nbp.service;

import org.junit.Test;
import pl.parser.nbp.model.RequestParams;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class AquireDataFromNBPTest {

    @Test
    public void should_return_json_with_courses_for_USD() throws Exception {
        //given
        String currencyCode = "usd";
        String startDate = "2016-08-01";
        String endDate = "2016-08-06";
        String table ="c";

        //when
        AquireDataFromNBP dataFromNBP = new AquireDataFromNBP();
        String json = dataFromNBP.acuire(new RequestParams()
                .withTable(table)
                .withCurrency(currencyCode)
                .withStartDate(startDate)
                .withEndDate(endDate)
                .build());

        //then
        assertThat("returned data is empty",json.length(),is(not(0)));

    }

}