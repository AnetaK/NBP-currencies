package pl.parser.nbp.service;

import org.junit.Test;
import pl.parser.nbp.exception.WrongInputParametersException;
import pl.parser.nbp.model.RequestParams;

public class InputValidationTest {
    InputValidation validation = new InputValidation();

    @Test(expected = WrongInputParametersException.class)
    public void should_throw_exception_for_currency() throws Exception {
        //given
        RequestParams params = new RequestParams()
                .withCurrency("EUR")
                .withStartDate("201-08-01")
                .withEndDate("2016-08-06")
                .build();

        //when
        validation.validate(params);
    }

    @Test(expected = WrongInputParametersException.class)
    public void should_throw_exception_for_startDate() throws Exception {
        //given
        RequestParams params = new RequestParams()
                .withCurrency("usd")
                .withStartDate("2016-08-01")
                .withEndDate("2016-15-06")
                .build();

        //when
        validation.validate(params);
    }

    @Test(expected = WrongInputParametersException.class)
    public void should_throw_exception_for_endDate() throws Exception {
        //given
        RequestParams params = new RequestParams()
                .withCurrency("pln")
                .withStartDate("2016-08-01")
                .withEndDate("2016-08-06")
                .build();

        //when
        validation.validate(params);
    }


}