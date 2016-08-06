package pl.parser.nbp;

import pl.parser.nbp.exception.NoDataReturnedFromAPI;
import pl.parser.nbp.model.RequestParams;
import pl.parser.nbp.model.ReturnedCoursesData;
import pl.parser.nbp.service.AquireDataFromNBP;
import pl.parser.nbp.service.CalculateAverageBidCourse;
import pl.parser.nbp.service.ParseJsonFile;

import java.math.BigDecimal;

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

        ReturnedCoursesData jsonDataFromNBP = parse.parse(dataFromNBP.acuire(requestParams));
        BigDecimal averageBids = avg.calculate(jsonDataFromNBP.getRates());
        System.out.println("averageBids = " + averageBids);
        calculateAverateExchangeDate();
        calculateStandardDeviation();
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
