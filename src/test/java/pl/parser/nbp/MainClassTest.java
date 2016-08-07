package pl.parser.nbp;

import org.junit.Test;
import org.junit.runner.RunWith;
import pl.parser.nbp.exception.NoDataReturnedFromAPI;
import pl.parser.nbp.exception.WrongHttpResponce;
import pl.parser.nbp.service.AquireDataFromNBP;

public class MainClassTest {

    @Test
    public void should_return_average_course() throws NoDataReturnedFromAPI, WrongHttpResponce {
        //given
        MainClass mainClass = new MainClass("EUR", "2016-01-01", "2016-08-06");

        //when
        mainClass.calculateAverangeAndDeviation();

        //then


    }

    @Test(expected = WrongHttpResponce.class)
    public void should_return_exception() throws NoDataReturnedFromAPI, WrongHttpResponce {
        //given
        MainClass mainClass = new MainClass("EUR", "2016-08-06", "2016-08-06");

        //when
        mainClass.calculateAverangeAndDeviation();

    }

}