package pl.parser.nbp.service;

import pl.parser.nbp.model.ReturnedCoursesData;
import pl.parser.nbp.model.ReturnedRates;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class CalculateAverageBidCourse {
    public BigDecimal calculate(List<ReturnedRates> returnedRates){

        BigDecimal divisor = BigDecimal.valueOf(returnedRates.size());

        BigDecimal sum = returnedRates.stream()
                .filter(s -> s != null)
                .map(ReturnedRates::getBid)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
//                .collect(Collectors.toList());
//        bids.stream().filter(b -> b != null).
        BigDecimal calculationResult = sum.divide(divisor).setScale(4,BigDecimal.ROUND_HALF_UP);
        System.out.println("calculationResult = " + calculationResult);

        return calculationResult;
    }
}
