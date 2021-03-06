package pl.parser.nbp.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.parser.nbp.exception.WrongHttpResponceException;
import pl.parser.nbp.model.RequestParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

public class AquireDataFromNBP {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String HTTP_API = "http://api.nbp.pl/api/exchangerates/rates/";
    private static final String TABLE = "c";

    private String getDataFromURL(URL url) throws WrongHttpResponceException {
        try {
            LOGGER.debug("Getting data from URL: {}", url.toString());
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Accept", "application/json");

            if (urlConnection.getResponseCode() != 200) {
                throw new WrongHttpResponceException("Failed : HTTP error code : "
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
            urlConnection.disconnect();

            return entireJson;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String acuireForSingleDay(String currencyCode, LocalDate date) throws WrongHttpResponceException {
        try {
            URL url = new URL(HTTP_API + TABLE + "/" + currencyCode + "/" + date + "/");
            return getDataFromURL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return "";
    }


    public String acuireForRange(RequestParams requestParams) throws WrongHttpResponceException {
        try {
            URL url = new URL(HTTP_API + TABLE + "/" + requestParams.getCurrency() +
                    "/" + requestParams.getStartDate() + "/" + requestParams.getEndDate() + "/");
            return getDataFromURL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return "";
    }
}
