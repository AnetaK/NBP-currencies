package pl.parser.nbp.service;

import org.junit.Test;
import pl.parser.nbp.exception.NoDataReturnedFromAPI;
import pl.parser.nbp.model.ReturnedRates;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculateAverageBidCourseTest {

    @Test
    public void should_calculate_bid_avg() throws NoDataReturnedFromAPI {
        List<ReturnedRates> returnedRates = new ArrayList<>();
        returnedRates.add(new ReturnedRates().withBid(new BigDecimal(1)).build());
        returnedRates.add(new ReturnedRates().withBid(new BigDecimal(2)).build());
        returnedRates.add(new ReturnedRates().withBid(new BigDecimal(0.9)).build());
        returnedRates.add(new ReturnedRates().withBid(new BigDecimal(0.9)).build());
        returnedRates.add(new ReturnedRates().withBid(new BigDecimal(0.9)).build());
        returnedRates.add(new ReturnedRates().withBid(new BigDecimal(0.2)).build());
        returnedRates.add(new ReturnedRates().withBid(new BigDecimal(0.2)).build());
        returnedRates.add(new ReturnedRates().withBid(new BigDecimal(0)).build());
        returnedRates.add(new ReturnedRates().withBid(new BigDecimal(0)).build());
        returnedRates.add(new ReturnedRates().withBid(new BigDecimal(0)).build());

        CalculateAverageBidCourse calculateAvg = new CalculateAverageBidCourse();
        BigDecimal calculatedValue = calculateAvg.calculate(returnedRates);

        assertThat("wrong avg calculated",calculatedValue,is(equalTo(new BigDecimal(0.6100).setScale(4,BigDecimal.ROUND_HALF_UP))));
    }

}