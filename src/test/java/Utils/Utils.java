package Utils;

import config.EmployeeModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {

    public static void saveUser(EmployeeModel model) throws IOException, ParseException {
        String location  = "./src/test/resources/employes.json";
        JSONParser parser = new JSONParser();
        JSONArray employArray= (JSONArray) parser.parse(new FileReader(location));

        JSONObject empObj = new JSONObject();
        empObj.put("firstName",model.getFirstName());
        empObj.put("lastName",model.getLastName());
        empObj.put("userName",model.getUserName());
        empObj.put("password",model.getPassword());
        employArray.add(empObj);
        FileWriter writer = new FileWriter(location);
        writer.write(employArray.toJSONString());
        writer.flush();
        writer.close();


    }
    public static JSONObject readUser() throws IOException, ParseException {
        String location  = "./src/test/resources/employes.json";
        JSONParser parser = new JSONParser();
        JSONArray employArray= (JSONArray) parser.parse(new FileReader(location));

        JSONObject empObj= (JSONObject) employArray.get(employArray.size()-1);
        return empObj;
    }


}
