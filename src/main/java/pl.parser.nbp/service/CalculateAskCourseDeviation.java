package pl.parser.nbp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.parser.nbp.exception.NoDataReturnedFromAPI;
import pl.parser.nbp.model.ReturnedCoursesData;
import pl.parser.nbp.model.ReturnedRates;

import java.math.BigDecimal;
import java.util.List;

public class CalculateAskCourseDeviation {

    private static final Logger LOGGER = LoggerFactory.getLogger(AquireDataFromNBP.class);

    public BigDecimal calculate(List<BigDecimal> asks) throws NoDataReturnedFromAPI {
        LOGGER.debug("Calculating asks average ...");
        if(asks.size() != 0) {
            BigDecimal divisor = BigDecimal.valueOf(asks.size());
            LOGGER.trace("Divisor = " + divisor);

            BigDecimal sum = asks.stream()
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            LOGGER.trace("Calculated sum = " + sum);
            BigDecimal avg = sum.divide(divisor,10,BigDecimal.ROUND_HALF_UP);
            LOGGER.debug("Asks average = " + avg);

            BigDecimal squareSum = new BigDecimal(0);

            for (BigDecimal ask :
                    asks) {
                squareSum = (ask.subtract(avg)).pow(2).add(squareSum);
            }

            BigDecimal deviation = new BigDecimal(Math.sqrt(squareSum.divide(divisor,10,BigDecimal.ROUND_HALF_UP).doubleValue()));
            deviation = deviation.setScale(4,BigDecimal.ROUND_HALF_UP);


            return deviation;
        }else{
            throw new NoDataReturnedFromAPI();
        }
    }
}
