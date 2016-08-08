package pl.parser.nbp;

import pl.parser.nbp.exception.NoDataReturnedFromAPIException;
import pl.parser.nbp.exception.WrongHttpResponceException;
import pl.parser.nbp.exception.WrongInputParametersException;
import pl.parser.nbp.model.RequestParams;
import pl.parser.nbp.model.ReturnedRates;
import pl.parser.nbp.service.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) throws NoDataReturnedFromAPIException, WrongHttpResponceException, WrongInputParametersException {
        RequestParams requestParams = new RequestParams();
        InputValidation validation = new InputValidation();

        if (args.length <= 2) {
            throw new WrongInputParametersException("Wrong number of parameters - should be 3 (currency code, start date, end date)");
        }
        requestParams.withCurrency(args[0])
                .withStartDate(args[1])
                .withEndDate(args[2])
                .build();
        validation.validate(requestParams);

        CalculateAverageBidCourse avg = new CalculateAverageBidCourse();
        CalculateAskCourseDeviation dev = new CalculateAskCourseDeviation();
        ReturnRatesForRange check = new ReturnRatesForRange();
        List<ReturnedRates> jsonDataFromNBP = check.returnRates(requestParams);

        List<BigDecimal> asks = jsonDataFromNBP.stream().filter(s -> s != null)
                .map(ReturnedRates::getAsk).collect(Collectors.toList());
        List<BigDecimal> bids = jsonDataFromNBP.stream().filter(s -> s != null)
                .map(ReturnedRates::getBid).collect(Collectors.toList());

        BigDecimal averageBids = avg.calculate(bids);
        System.out.println(averageBids);

        BigDecimal asksStandardDeviation = dev.calculate(asks);
        System.out.println(asksStandardDeviation);
    }

}
