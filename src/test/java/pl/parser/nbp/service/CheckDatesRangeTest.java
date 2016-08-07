package pl.parser.nbp.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import pl.parser.nbp.MainClass;
import pl.parser.nbp.model.RequestParams;
import pl.parser.nbp.model.ReturnedCoursesData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CheckDatesRangeTest {

    @Mock
    private AquireDataFromNBP aquireDataFromNBP;

    @Mock
    private ParseJsonString parseJsonString;

    @InjectMocks
    private CheckDatesRange checkDatesRange;

    @Test
    public void should_connect_to_API_3_times() throws Exception {

        CheckDatesRange checkDatesRange = new CheckDatesRange();
        RequestParams requestParams = new RequestParams()
                .withCurrency("EUR")
                .withStartDate("2016-01-01")
                .withEndDate("2016-08-06")
                .withTable("c")
                .build();
        String jsonOut = "response,";
//TODO napraw ten test
        when(aquireDataFromNBP.acuire(requestParams)).thenReturn(jsonOut);
//        when(parseJsonString.parse(jsonOut)).thenReturn();
//
        checkDatesRange.check(requestParams);
//
//        ReturnedCoursesData check = checkDatesRange.check(requestParams);
//
//        assertThat("NBP API was not connected 3 times", check, is(equalTo("response,response,response,")) );

//
//        CheckDatesRange spy = spy(CheckDatesRange.class);
//        AquireDataFromNBP spyAquire = spy(AquireDataFromNBP.class);
//
//        doReturn(jsonOut).when(spyAquire).acuire(requestParams);    // Mock implementation
////        doReturn(200).when(spy).getQuantity();
//        ReturnedCoursesData returnedCoursesData = checkDatesRange.check(requestParams);
//        System.out.println("returnedCoursesData = " + returnedCoursesData);

    }

}