package pl.parser.nbp.service;

import org.junit.Test;
import pl.parser.nbp.model.ReturnedData;
import pl.parser.nbp.model.ReturnedRates;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ParseJsonFileTest {

    @Test
    public void should_return_list_of_json_elements() {
        //given
        String jsonString = "{\"table\":\"A\"," +
                "\"currency\":\"dolar amerykański\"," +
                "\"code\":\"USD\"," +
                "\"rates\":" +
                "[{\"no\":\"147/A/NBP/2016\"," +
                "\"effectiveDate\":\"2016-08-01\"," +
                "\"bid\":3.9040" +
                ",\"ask\":3.9500}," +
                "{\"no\":\"148/A/NBP/2016\"," +
                "\"effectiveDate\":\"2016-08-02\"," +
                "\"bid\":3.8820," +
                "\"ask\":3.9474}]}";

        //when
        ParseJsonFile parseJsonFile = new ParseJsonFile();
        ReturnedData returnedJson = parseJsonFile.parse(jsonString);
        List<ReturnedRates> returnedRates = returnedJson.getRates();
        Double mid1 = returnedRates.get(0).getBid();
        Double mid2 = returnedRates.get(1).getBid();

        //then
        assertThat("Size of json list in not corrrect", returnedJson.getRates().size(), is(equalTo(2)));
        assertThat("'mid' value has wrong content in first iteration", mid1, is(equalTo(3.9040)));
        assertThat("'mid' value has wrong content in second iteration", mid2, is(equalTo(3.8820)));
    }

}