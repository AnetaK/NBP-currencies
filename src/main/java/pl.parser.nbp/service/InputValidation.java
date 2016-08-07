package pl.parser.nbp.service;

import pl.parser.nbp.model.AllowedCurrencies;
import pl.parser.nbp.model.RequestParams;

public class InputValidation {
    public void validate(RequestParams inputParams){
        String currencyToCheck = inputParams.getCurrency().toUpperCase();

        System.out.println(AllowedCurrencies.);
//        if(AllowedCurrencies.values())
    }
}
