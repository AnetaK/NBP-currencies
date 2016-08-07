package pl.parser.nbp.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.parser.nbp.exception.WrongHttpResponceException;
import pl.parser.nbp.model.RequestParams;
import pl.parser.nbp.model.ReturnedCoursesData;
import pl.parser.nbp.model.ReturnedRates;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReturnRatesForRange {
    private static final Logger LOGGER = LogManager.getLogger();
    private ParseJsonString parsejsonString = new ParseJsonString();
    private List<ReturnedRates> outputData = new ArrayList<>();

    public List<ReturnedRates> returnRates(RequestParams params) throws WrongHttpResponceException {

        LocalDate startDate = LocalDate.parse(params.getStartDate());
        LocalDate endDate = LocalDate.parse(params.getEndDate());

        Integer differenceInDays = endDate.getDayOfYear() - startDate.getDayOfYear();
        LOGGER.debug("Entire number of days for calculation = {}", differenceInDays + 1);

        if (differenceInDays == 0) {
            return outputData = parsejsonString.parse(new AquireDataFromNBP().acuireForSingleDay(params.getCurrency(), startDate)).getRates();
        } else {

            int iterCount = differenceInDays % 93 == 0 ? differenceInDays / 93 : differenceInDays / 93 + 1;
            LOGGER.debug("Due to API limitations (it can send data for no more than 93 days at once) " +
                    "request will be divided to {} parts", iterCount);

            for (int i = 0; i < iterCount; i++) {
                LocalDate tmpStartDate = i == 0 ? startDate.plusDays(93 * i) : startDate.plusDays(93 * i + 1);
                LocalDate tmpEndDate = differenceInDays % 93 == 0 || i < iterCount - 1 ? startDate.plusDays(93 * (i + 1)) : endDate;

                LOGGER.trace("Start date = {} for part {}", tmpStartDate, i + 1);
                LOGGER.trace("End date = {} for part {}", tmpEndDate, i + 1);

                RequestParams tmpRequestParams = params.withStartDate(tmpStartDate.toString()).withEndDate(tmpEndDate.toString()).build();
                ReturnedCoursesData jsonDataFromNBP = parsejsonString
                        .parse(new AquireDataFromNBP().acuireForRange(tmpRequestParams));
                LOGGER.trace("Number od currency rates acquired from API = {} in part {}", jsonDataFromNBP.getRates().size(), i + 1);
                outputData.addAll(jsonDataFromNBP.getRates());
            }

            LOGGER.debug("Number of currency rates acquired for entire range = " + outputData.size());
            return outputData;
        }
    }
}
