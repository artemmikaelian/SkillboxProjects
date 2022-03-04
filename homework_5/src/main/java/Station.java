public class Station {
   private final String name;
   private final String line;
    public Station(String name, String line){
        this.line=line;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLine() {
        return line;
    }
}
