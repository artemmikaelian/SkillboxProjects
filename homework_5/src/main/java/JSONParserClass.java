import lombok.SneakyThrows;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class JSONParserClass {
    @SneakyThrows
    public static void  stationsCount (String pathToJSON) {
        JSONParser parser = new JSONParser();
        JSONObject parsingObject = (JSONObject) parser.parse(new FileReader(pathToJSON));
        JSONObject stations = (JSONObject) parsingObject.get("stations");
        Set<String> lineSet = stations.keySet();
        for (String line : lineSet){

            JSONArray array = (JSONArray) stations.get(line);
            System.out.println("Количество станций на линии "+ line +": \n"+array.size());
        }




    }
}
