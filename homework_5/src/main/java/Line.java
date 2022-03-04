public class Line {
    private final String name;
    private final String number;

    public Line(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
