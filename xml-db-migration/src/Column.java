public class Column {
    String name;
    String type;
    boolean primaryKey;
    public Column(String name, String type, boolean primaryKey) {
        this.name = name;
        this.type = type;
        this.primaryKey = primaryKey;
    }
}