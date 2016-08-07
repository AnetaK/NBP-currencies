package pl.parser.nbp.service;

import org.junit.Test;
import pl.parser.nbp.exception.NoDataReturnedFromAPI;
import pl.parser.nbp.model.ReturnedRates;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CalculateAskCourseDeviationTest {
    @Test
    public void calculate() throws Exception, NoDataReturnedFromAPI {
        List<BigDecimal> asks = new ArrayList<>();
        asks.add(new BigDecimal(1));
        asks.add(new BigDecimal(2));
        asks.add(new BigDecimal(0.9));
        asks.add(new BigDecimal(0.9));
        asks.add(new BigDecimal(0.9));
        asks.add(new BigDecimal(0.2));
        asks.add(new BigDecimal(0.2));
        asks.add(new BigDecimal(0));
        asks.add(new BigDecimal(0));
        asks.add(new BigDecimal(0));

        CalculateAskCourseDeviation calculateDev = new CalculateAskCourseDeviation();
        BigDecimal calculatedValue = calculateDev.calculate(asks);

        assertThat("wrong avg calculated",calculatedValue,is(equalTo(new BigDecimal(0.6155).setScale(4,BigDecimal.ROUND_HALF_UP))));
    }

}