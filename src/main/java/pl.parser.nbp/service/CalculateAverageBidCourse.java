package pl.parser.nbp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.parser.nbp.exception.NoDataReturnedFromAPI;

import java.math.BigDecimal;
import java.util.List;

public class CalculateAverageBidCourse {
    private static final Logger LOGGER = LoggerFactory.getLogger(AquireDataFromNBP.class);

    public BigDecimal calculate(List<BigDecimal> bids) throws NoDataReturnedFromAPI {
        LOGGER.debug("Calculating bids average ...");
        if(bids.size() != 0) {
            BigDecimal divisor = BigDecimal.valueOf(bids.size());
            LOGGER.trace("Divisor = " + divisor);

            BigDecimal sum = bids.stream()
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            LOGGER.trace("Calculated sum = " + sum);
            BigDecimal calculationResult = sum.divide(divisor,4,BigDecimal.ROUND_HALF_UP);
            LOGGER.debug("Bids average = " + calculationResult);

            return calculationResult;
        }else{
            throw new NoDataReturnedFromAPI();
        }
    }
}
