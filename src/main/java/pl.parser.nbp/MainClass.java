package pl.parser.nbp;

import pl.parser.nbp.exception.NoDataReturnedFromAPI;
import pl.parser.nbp.model.RequestParams;
import pl.parser.nbp.model.ReturnedCoursesData;
import pl.parser.nbp.model.ReturnedRates;
import pl.parser.nbp.service.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass
{
    private static final String TABLE = "c";
    private RequestParams requestParams = new RequestParams();

    public MainClass(String currency, String startDate, String endDate ) {
        requestParams.withCurrency(currency)
                .withStartDate(startDate)
                .withEndDate(endDate)
                .withTable(TABLE)
                .build();
    }

    public void calculateAverangeAndDeviation() throws NoDataReturnedFromAPI {

        CalculateAverageBidCourse avg = new CalculateAverageBidCourse();
        CalculateAskCourseDeviation dev = new CalculateAskCourseDeviation();
        CheckDatesRange check = new CheckDatesRange();
        ReturnedCoursesData jsonDataFromNBP = check.check(requestParams);


        List<BigDecimal> asks = jsonDataFromNBP.getRates().stream().filter(s -> s != null)
                .map(ReturnedRates::getAsk).collect(Collectors.toList());
        List<BigDecimal> bids = jsonDataFromNBP.getRates().stream().filter(s -> s != null)
                .map(ReturnedRates::getBid).collect(Collectors.toList());

        BigDecimal averageBids = avg.calculate(bids);
        System.out.println(averageBids);

        BigDecimal asksStandardDeviation = dev.calculate(asks);
        System.out.println(asksStandardDeviation);
    }

}
