package pl.parser.nbp.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.parser.nbp.model.ReturnedCoursesData;

public class ParseJsonString {
    private static final Logger LOGGER = LogManager.getLogger();

    public ReturnedCoursesData parse (String jsonString){
        LOGGER.debug("Input string from NBP API parsing ...");
        Gson gson = new GsonBuilder().create();
        ReturnedCoursesData currencyData = gson.fromJson(jsonString, ReturnedCoursesData.class);
        LOGGER.debug("Input string parsed, there is {} currency rates", currencyData.getRates().size());

        return currencyData;
    }
}
