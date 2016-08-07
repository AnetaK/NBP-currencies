package pl.parser.nbp.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import pl.parser.nbp.MainClass;
import pl.parser.nbp.model.RequestParams;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckDatesRangeTest {
//
@Mock
AquireDataFromNBP aquireDataFromNBP = new AquireDataFromNBP();

    @Test
    public void should_connect_to_API_3_times() throws Exception {

        CheckDatesRange checkDatesRange = new CheckDatesRange();
        RequestParams requestParams = new RequestParams()
                .withCurrency("EUR")
                .withStartDate("2016-01-01")
                .withEndDate("2016-08-06")
                .withTable("c")
                .build();

        AquireDataFromNBP aquireDataFromNBP =  new AquireDataFromNBP();
//        Mockito.when(mock(aquireDataFromNBP.acuire(requestParams))).thenReturn("abc");

        checkDatesRange.check(requestParams);
//        when(aquireDataFromNBP.acuire(requestParams)).thenReturn("abc");
        checkDatesRange.check(requestParams);
//
//        assertThat("wrong number of API calls", );
    }

}