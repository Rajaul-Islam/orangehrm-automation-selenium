package Utils;

import config.EmployeeModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

public class Utils {

    public static void saveUser(EmployeeModel model) throws IOException, ParseException {
        String location = "./src/test/resources/employes.json";
        JSONParser parser = new JSONParser();
        JSONArray employArray = (JSONArray) parser.parse(new FileReader(location));

        JSONObject empObj = new JSONObject();
        empObj.put("firstName", model.getFirstName());
        empObj.put("lastName", model.getLastName());
        empObj.put("userName", model.getUserName());
        empObj.put("password", model.getPassword());
        employArray.add(empObj);
        FileWriter writer = new FileWriter(location);
        writer.write(employArray.toJSONString());
        writer.flush();
        writer.close();


    }

    public static JSONObject readUser() throws IOException, ParseException {
        String location = "./src/test/resources/employes.json";
        JSONParser parser = new JSONParser();
        JSONArray employArray = (JSONArray) parser.parse(new FileReader(location));

        JSONObject empObj = (JSONObject) employArray.get(employArray.size() - 1);
        return empObj;
    }

    public static void updateJSONFileObjectProperty(int index, String propertyname, String updatedvalue) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/test/resources/employes.json"));
        JSONArray jsonArray = (JSONArray) obj;
        int arraySize = jsonArray.size();
        int arrayIn = arraySize - index;
        // Get the JSON object at the specific index
        JSONObject jsonObject = (JSONObject) jsonArray.get(arrayIn);


        // Update the property value of the object
        jsonObject.put(propertyname, updatedvalue);
        // Convert the JSON array back to a JSON string

        String updatedJsonString = jsonArray.toJSONString();
        // Write the updated JSON string back to the original JSON file
        try (FileWriter fileWriter = new FileWriter("./src/test/resources/employes.json")) {
            fileWriter.write(updatedJsonString);
        }
    }

    public static int randomNumber() {
        return (int) Math.round(Math.random() * 5000);
    }

    public static void doScroll(WebDriver driver, int scrollvalue) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + scrollvalue + ")");
    }

    public static void waitForElement(WebDriver driver, WebElement element){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}
