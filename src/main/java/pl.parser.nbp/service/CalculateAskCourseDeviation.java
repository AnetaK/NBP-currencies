package pl.parser.nbp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.parser.nbp.exception.NoDataReturnedFromAPI;

import java.math.BigDecimal;
import java.util.List;

public class CalculateAskCourseDeviation {

    private static final Logger LOGGER = LoggerFactory.getLogger(AquireDataFromNBP.class);

    public BigDecimal calculate(List<BigDecimal> asks) throws NoDataReturnedFromAPI {
        LOGGER.debug("Calculating asks standard deviation ...");
        if (asks.size() != 0) {
            BigDecimal divisor = BigDecimal.valueOf(asks.size());
            LOGGER.debug("Number of ask elements = " + divisor);

            BigDecimal sum = asks.stream()
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal avg = sum.divide(divisor, 10, BigDecimal.ROUND_HALF_UP);
            LOGGER.debug("Asks average = " + avg);

            BigDecimal squareSum = new BigDecimal(0);

            for (BigDecimal ask :
                    asks) {
                squareSum = (ask.subtract(avg)).pow(2).add(squareSum);
            }

            BigDecimal deviation = new BigDecimal(Math.sqrt(squareSum.divide(divisor, 10, BigDecimal.ROUND_HALF_UP).doubleValue()));
            deviation = deviation.setScale(4, BigDecimal.ROUND_HALF_UP);
            LOGGER.debug("Calculated standard deviation = " + deviation);

            return deviation;

        } else {
            throw new NoDataReturnedFromAPI();
        }
    }
}
