package pl.parser.nbp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.parser.nbp.exception.NoDataReturnedFromAPI;
import pl.parser.nbp.model.ReturnedRates;

import java.math.BigDecimal;
import java.util.List;

public class CalculateAverageBidCourse {
    private static final Logger LOGGER = LoggerFactory.getLogger(AquireDataFromNBP.class);

    public BigDecimal calculate(List<ReturnedRates> returnedRates) throws NoDataReturnedFromAPI {
        LOGGER.debug("Calculating bids average ...");
        if(returnedRates.size() != 0) {
            BigDecimal divisor = BigDecimal.valueOf(returnedRates.size());

            BigDecimal sum = returnedRates.stream()
                    .filter(s -> s != null)
                    .map(ReturnedRates::getBid)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            LOGGER.trace("Calculated sum = " + sum);
            LOGGER.trace("Divisor = " + divisor);
            BigDecimal calculationResult = sum.divide(divisor,4,BigDecimal.ROUND_HALF_UP);
            LOGGER.debug("Bids average = " + calculationResult);

            return calculationResult;
        }else{
            throw new NoDataReturnedFromAPI();
        }
    }
}
