package pl.parser.nbp;

import pl.parser.nbp.exception.NoDataReturnedFromAPI;
import pl.parser.nbp.model.RequestParams;
import pl.parser.nbp.model.ReturnedCoursesData;
import pl.parser.nbp.model.ReturnedRates;
import pl.parser.nbp.service.AquireDataFromNBP;
import pl.parser.nbp.service.CalculateAskCourseDeviation;
import pl.parser.nbp.service.CalculateAverageBidCourse;
import pl.parser.nbp.service.ParseJsonFile;

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
        AquireDataFromNBP dataFromNBP = new AquireDataFromNBP();
        ParseJsonFile parse = new ParseJsonFile();
        CalculateAverageBidCourse avg = new CalculateAverageBidCourse();
        CalculateAskCourseDeviation dev = new CalculateAskCourseDeviation();

        ReturnedCoursesData jsonDataFromNBP = parse.parse(dataFromNBP.acuire(requestParams));
        List<BigDecimal> asks = jsonDataFromNBP.getRates().stream().filter(s -> s != null)
                .map(ReturnedRates::getAsk).collect(Collectors.toList());
        List<BigDecimal> bids = jsonDataFromNBP.getRates().stream().filter(s -> s != null)
                .map(ReturnedRates::getBid).collect(Collectors.toList());

        BigDecimal averageBids = avg.calculate(bids);
        System.out.println("averageBids = " + averageBids);

        BigDecimal asksStandardDeviation = dev.calculate(asks);
        System.out.println("asksStandardDeviation = " + asksStandardDeviation);
    }

    private void getCurrenciesFromAPI(){
        //http://api.nbp.pl/api/exchangerates/rates/{table}/{code}/{startDate}/{endDate}/


    }

    private Double calculateAverateExchangeDate(){


        return 0d;
    }

    private void calculateStandardDeviation() {

    }


}
