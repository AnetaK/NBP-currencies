package pl.parser.nbp.service;

import pl.parser.nbp.model.RequestParams;
import pl.parser.nbp.model.ReturnedCoursesData;

public class CheckDatesRange {
    public ReturnedCoursesData check(RequestParams params) {
        AquireDataFromNBP dataFromNBP = new AquireDataFromNBP();
        ParseJsonString parsejsonString = new ParseJsonString();
        ReturnedCoursesData jsonDataFromNBP = parsejsonString.parse(dataFromNBP.acuire(params));
        return jsonDataFromNBP;
    }
}
