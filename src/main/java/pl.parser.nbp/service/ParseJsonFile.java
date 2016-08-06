package pl.parser.nbp.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.parser.nbp.model.ReturnedCoursesData;

public class ParseJsonFile {
    private static final Logger LOGGER = LoggerFactory.getLogger(AquireDataFromNBP.class);

    public ReturnedCoursesData parse (String jsonString){
        LOGGER.debug("Input string from NBP API parsing ...");
        Gson gson = new GsonBuilder().create();
        ReturnedCoursesData currencyData = gson.fromJson(jsonString, ReturnedCoursesData.class);
        LOGGER.debug("Input string parsed, there is {} currency rates", currencyData.getRates().size());

        return currencyData;
    }
}
