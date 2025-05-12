import java.util.*;

public class DatabaseSchema {
    String name;
    List<Table> tables;
    public DatabaseSchema(String name) {
        this.name = name;
        this.tables = new ArrayList<>();
    }
}