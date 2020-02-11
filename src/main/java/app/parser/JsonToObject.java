package app.parser;

import app.Issue.IssueList;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JsonToObject {
    public static IssueList parseObject() throws IOException {
        ObjectMapper Is = new ObjectMapper();

        //String json = readFile();
        //String
        //IssueList is = Is.readValue(json, IssueList.class);

        //file
        IssueList iss = Is.readValue(new File(ObjectToJson.fileName), IssueList.class);

        /*URL
        IssueList is = Is.readValue(new URL("file:src/test/resources/json_car.json"), IssueList.class);
         */
        return iss;
    }

    /*
    public static String readFile() throws IOException {
        String json = "";
        FileUtils.readFileToString(new File(ObjectToJson.fileName), StandardCharsets.UTF_8);
        return json;
    }
     */
}
