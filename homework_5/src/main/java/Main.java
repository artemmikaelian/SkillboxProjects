import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        JSONCreator.jsoupParser();
        JSONParserClass.stationsCount("src/main/resources/data.json");
    }
}
