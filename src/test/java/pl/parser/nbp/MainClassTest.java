package pl.parser.nbp;

import org.junit.Test;
import pl.parser.nbp.exception.NoDataReturnedFromAPI;

public class MainClassTest {

    @Test
    public void should_return_average_course () throws NoDataReturnedFromAPI {
        //given
        MainClass mainClass = new MainClass("EUR","2016-01-01","2016-08-06");

        //when
        mainClass.calculateAverangeAndDeviation();

        //then



    }

}