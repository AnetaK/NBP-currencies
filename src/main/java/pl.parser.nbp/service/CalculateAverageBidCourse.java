package pl.parser.nbp.service;

import pl.parser.nbp.model.ReturnedCoursesData;
import pl.parser.nbp.model.ReturnedRates;

import java.util.List;

public class CalculateAverageBidCourse {
    public Double calculate(ReturnedCoursesData coursesData){

        List<ReturnedRates> rates = coursesData.getRates();

        rates.stream()
                .mapToDouble(ReturnedRates::getBid)
                .average()
                .getAsDouble();

        return null;
    }
}
