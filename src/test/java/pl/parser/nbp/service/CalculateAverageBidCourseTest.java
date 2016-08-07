package pl.parser.nbp.service;

import org.junit.Test;
import pl.parser.nbp.exception.NoDataReturnedFromAPIException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculateAverageBidCourseTest {

    @Test
    public void should_calculate_bid_avg() throws NoDataReturnedFromAPIException {
        List<BigDecimal> bids = new ArrayList<>();
        bids.add(new BigDecimal(1));
        bids.add(new BigDecimal(2));
        bids.add(new BigDecimal(0.9));
        bids.add(new BigDecimal(0.9));
        bids.add(new BigDecimal(0.9));
        bids.add(new BigDecimal(0.2));
        bids.add(new BigDecimal(0.2));
        bids.add(new BigDecimal(0));
        bids.add(new BigDecimal(0));
        bids.add(new BigDecimal(0));

        CalculateAverageBidCourse calculateAvg = new CalculateAverageBidCourse();
        BigDecimal calculatedValue = calculateAvg.calculate(bids);

        assertThat("wrong avg calculated",calculatedValue,is(equalTo(new BigDecimal(0.6100).setScale(4,BigDecimal.ROUND_HALF_UP))));
    }

}