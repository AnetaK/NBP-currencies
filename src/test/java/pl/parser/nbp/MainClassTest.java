package pl.parser.nbp;

import org.junit.Test;
import pl.parser.nbp.exception.NoDataReturnedFromAPIException;
import pl.parser.nbp.exception.WrongHttpResponceException;

public class MainClassTest {

    @Test
    public void should_return_average_course() throws NoDataReturnedFromAPIException, WrongHttpResponceException {
        //given
        MainClass mainClass = new MainClass("EUR", "2016-01-01", "2016-08-06");

        //when
        mainClass.calculateAverangeAndDeviation();

        //then


    }

    @Test(expected = WrongHttpResponceException.class)
    public void should_return_exception() throws NoDataReturnedFromAPIException, WrongHttpResponceException {
        //given
        MainClass mainClass = new MainClass("EUR", "2016-08-06", "2016-08-06");

        //when
        mainClass.calculateAverangeAndDeviation();

    }

}