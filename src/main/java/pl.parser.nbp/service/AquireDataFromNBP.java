package pl.parser.nbp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.parser.nbp.model.RequestParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AquireDataFromNBP {

    private static final Logger LOGGER = LoggerFactory.getLogger(AquireDataFromNBP.class);

    private static final String HTTP_API = "http://api.nbp.pl/api/exchangerates/rates/";

    public String acuire(RequestParams requestParams) {

        try {

            URL url = new URL(HTTP_API + requestParams.getTable() + "/" + requestParams.getCurrency() +
                    "/" + requestParams.getStartDate() + "/" + requestParams.getEndDate() + "/");
            LOGGER.debug("Getting data from URL: {}",url.toString());
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Accept", "application/json");

            if (urlConnection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + urlConnection.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (urlConnection.getInputStream())));

            String output;
            String entireJson = "";
            LOGGER.debug("Output from Server ... ");
            while ((output = br.readLine()) != null) {
                entireJson = entireJson + output;
            }
            LOGGER.debug("Returned json size = " + entireJson.length());
            LOGGER.trace("Returned json = " + entireJson.toString());
            urlConnection.disconnect();

            return entireJson;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";

    }
}
