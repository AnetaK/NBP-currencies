package pl.parser.nbp.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.parser.nbp.exception.WrongInputParametersException;
import pl.parser.nbp.model.RequestParams;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.containsString;

public class InputValidationTest {
    InputValidation validation = new InputValidation();

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void should_throw_exception_for_currency() throws Exception, WrongInputParametersException {

        RequestParams params = new RequestParams()
                .withCurrency("pln")
                .withStartDate("2016-08-01")
                .withEndDate("2016-08-06")
                .build();

        expectedEx.expect(WrongInputParametersException.class);
        expectedEx.expectMessage(containsString("Allowed currencies: "));
        validation.validate(params);
    }

    @Test
    public void should_throw_exception_for_startDate() throws Exception, WrongInputParametersException {

        RequestParams params = new RequestParams()
                .withCurrency("usd")
                .withStartDate("2016-15-01")
                .withEndDate("2016-08-06")
                .build();

        expectedEx.expect(WrongInputParametersException.class);
        expectedEx.expectMessage("Date should be in format: \"YYYY-MM-DD\"");
        validation.validate(params);
    }

    @Test
    public void should_throw_exception_for_endDate() throws Exception, WrongInputParametersException {

        RequestParams params = new RequestParams()
                .withCurrency("usd")
                .withStartDate("2016-08-01")
                .withEndDate("2016-15-06")
                .build();

        expectedEx.expect(WrongInputParametersException.class);
        expectedEx.expectMessage("Date should be in format: \"YYYY-MM-DD\"");
        validation.validate(params);
    }

    @Test
    public void should_throw_exception_for_wrong_order() throws Exception, WrongInputParametersException {

        RequestParams params = new RequestParams()
                .withCurrency("usd")
                .withStartDate("2016-08-06")
                .withEndDate("2016-08-01")
                .build();

        expectedEx.expect(WrongInputParametersException.class);
        expectedEx.expectMessage("Start date should be given first");
        validation.validate(params);

    }

    @Test
    public void should_throw_exception_for_future_date() throws Exception, WrongInputParametersException {

        RequestParams params = new RequestParams()
                .withCurrency("usd")
                .withStartDate("2016-08-06")
                .withEndDate(LocalDate.now().plusDays(1).toString())
                .build();

        expectedEx.expect(WrongInputParametersException.class);
        expectedEx.expectMessage("Date shouldn't be from the future");
        validation.validate(params);
    }

    @Test
    public void should_not_throw_error() throws Exception, WrongInputParametersException {
        //given
        RequestParams params = new RequestParams()
                .withCurrency("usd")
                .withStartDate("2016-08-01")
                .withEndDate("2016-08-06")
                .build();

        //when
        validation.validate(params);
    }

}