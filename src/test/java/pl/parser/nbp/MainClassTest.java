package pl.parser.nbp;

import org.junit.Before;
import org.junit.Test;
import pl.parser.nbp.model.RequestParams;
import pl.parser.nbp.model.Table;

import static org.junit.Assert.*;

public class MainClassTest {

//    @Before
//    public void set_Request_Params(){
//        RequestParams requestParams = new RequestParams()
//                .withCurrency("EUR")
//                .withStartDate("2016-01-01")
//                .withEndDate("2016-08-06")
//                .withTable(Table.a)
//                .build();
//    }

    @Test
    public void should_return_average_course () {
        //given
        MainClass mainClass = new MainClass("EUR","2016-01-01","2016-08-06");

        //when
//        mainClass.

        //then


    }

}