package pl.parser.nbp.service;

import pl.parser.nbp.model.RequestParams;
import pl.parser.nbp.model.ReturnedCoursesData;

public class CheckDatesRange {
    ParseJsonString parsejsonString = new ParseJsonString();
    AquireDataFromNBP dataFromNBP = new AquireDataFromNBP();

    public ReturnedCoursesData check(RequestParams params) {

        dataFromNBP.acuire(params);


        ReturnedCoursesData jsonDataFromNBP = parsejsonString
                .parse(dataFromNBP.acuire(params));
        return jsonDataFromNBP;
    }
}
