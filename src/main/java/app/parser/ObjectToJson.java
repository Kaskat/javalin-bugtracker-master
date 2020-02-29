package app.parser;

import app.Entities.Issue.IssueList;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ObjectToJson {

    static String fileName = "src/main/resources/json/main.json";

    public static String parser(IssueList issues) {
        // Creating Object of ObjectMapper define in Jackson Api

        ObjectMapper Is = new ObjectMapper();
        String jsonStr = "";
        try {
            // get Issue object as a json string
            jsonStr = Is.writeValueAsString(issues);
        } catch (IOException e) {
            System.out.println("Input/Output error occurred: " + e.getMessage());
        }

        return jsonStr;
    }

    public static void toFile(String jsonStr) throws IOException {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(jsonStr);

            writer.close();
        }
}
