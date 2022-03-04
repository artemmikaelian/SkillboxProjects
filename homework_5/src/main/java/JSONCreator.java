import lombok.SneakyThrows;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.util.*;

public class JSONCreator {
    private static JSONObject generalObject = new JSONObject();
    private static List<Line> linesList = new ArrayList<>();
    private static List<Station> stationList = new ArrayList<>();
    private static final String STRING_URL = "https://skillbox-java.github.io/";
    private static final String STRING_FIREWATER_PATH = "src/main/resources/data.json";

    @SneakyThrows
    public static void jsoupParser() {
        Document doc = Jsoup.connect(STRING_URL).maxBodySize(0).get();

        Element metrodata = doc.getElementById("metrodata");
        Elements lineElements = metrodata.getElementsByClass("js-metro-line");
        Elements stationsElements = metrodata.getElementsByClass("js-metro-stations");
        linesParser(lineElements);
        stationsParser(stationsElements);
    }

    @SneakyThrows
    private static void linesParser(Elements lineElements) {

        JSONArray array = new JSONArray();

        lineElements.forEach(line ->
                linesList.add(new Line(line.attr("data-line"),
                        line.text().replaceAll("[0-9]+\\.", "")))
        );
        for (Line line : linesList) {
            JSONObject object = new JSONObject();
            object.put("number", line.getNumber());
            object.put("name", line.getName());
            array.add(object);
        }
        generalObject.put("lines", array);
        fileWritingMethod(STRING_FIREWATER_PATH, generalObject.toJSONString());
    }


    private static void stationsParser(Elements stationElements) {
        JSONObject object = new JSONObject();
        stationElements.forEach(station ->
                stationList.add(new Station(station.text().replaceFirst("[0-9][0-9]?\\.\\s", "")
                        .replaceAll("\\s[0-9][0-9]?\\.\\s", ","), station.attr("data-line"))));

        for (Station station : stationList) {
            JSONArray array = new JSONArray();
            String[] stationArray = station.getName().split(",");
            array.addAll(Arrays.asList(stationArray));
            object.put(station.getLine(), array);
        }
        generalObject.put("stations", object);
        fileWritingMethod(STRING_FIREWATER_PATH, generalObject.toJSONString());
    }

    @SneakyThrows
    private static void fileWritingMethod(String sourcePath, String object) {
        FileWriter writer = new FileWriter(sourcePath);
        writer.write(generalObject.toJSONString());
        writer.flush();
        writer.close();
    }
}
