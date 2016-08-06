package pl.parser.nbp.service;

import pl.parser.nbp.model.ReturnedData;
import pl.parser.nbp.model.ReturnedRates;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ParseJsonFile {
    public ReturnedData parse (String jsonString){
        Gson gson = new GsonBuilder().create();
        ReturnedData currencyData = gson.fromJson(jsonString, ReturnedData.class);

        return currencyData;
    }
}
