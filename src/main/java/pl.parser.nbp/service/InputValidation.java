package pl.parser.nbp.service;

import pl.parser.nbp.exception.WrongInputParametersException;
import pl.parser.nbp.model.AllowedCurrencies;
import pl.parser.nbp.model.RequestParams;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputValidation {
    public void validate(RequestParams inputParams) throws WrongInputParametersException {
        String currencyToCheck = inputParams.getCurrency().toUpperCase();
        checkCurrency(currencyToCheck);
        checkDateFormat(inputParams.getStartDate());
        checkDateFormat(inputParams.getEndDate());
        checkDatesOrder(inputParams.getStartDate(), inputParams.getEndDate());
    }

    private void checkCurrency(String currencyToCheck) throws WrongInputParametersException {
        boolean currencyCheck = Arrays.stream(AllowedCurrencies.values()).noneMatch(e -> e.name().equals(currencyToCheck));
        if(currencyCheck){
            throw new WrongInputParametersException("Allowed currencies: " +
                    Arrays.stream(AllowedCurrencies.values())
                            .filter(a -> a.equals(a))
                            .collect(Collectors.toList())
                            .toString());
        }
    }

    private void checkDateFormat(String date) throws WrongInputParametersException {
        try {
            LocalDate parsedDate = LocalDate.parse(date);
            if(parsedDate.isAfter(LocalDate.now())){
                throw new WrongInputParametersException("Date shouldn't be from the future");
            }
        }catch(DateTimeParseException e){
            throw new WrongInputParametersException("Date should be in format: \"YYYY-MM-DD\"");
        }
    }

    private void checkDatesOrder(String inputStartDate, String inputEndDate) throws WrongInputParametersException {
        LocalDate startDate = LocalDate.parse(inputStartDate);
        LocalDate endDate = LocalDate.parse(inputEndDate);
        if(endDate.getDayOfYear()-startDate.getDayOfYear()<0){
            throw new WrongInputParametersException("Start date should be given first");
        }
    }
}
