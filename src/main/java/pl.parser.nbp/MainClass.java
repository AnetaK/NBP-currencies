package pl.parser.nbp;

import pl.parser.nbp.exception.NoDataReturnedFromAPIException;
import pl.parser.nbp.exception.WrongHttpResponceException;
import pl.parser.nbp.model.RequestParams;
import pl.parser.nbp.model.ReturnedRates;
import pl.parser.nbp.service.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass
{
    private RequestParams requestParams = new RequestParams();
    private InputValidation validation = new InputValidation();

    public MainClass(String currency, String startDate, String endDate ) {
        requestParams.withCurrency(currency)
                .withStartDate(startDate)
                .withEndDate(endDate)
                .build();
        validation.validate(requestParams);
}

    public void calculateAverangeAndDeviation() throws NoDataReturnedFromAPIException, WrongHttpResponceException {

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
