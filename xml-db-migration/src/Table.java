import java.util.*;

public class Table {
    String name;
    List<Column> columns;
    public Table(String name) {
        this.name = name;
        this.columns = new ArrayList<>();
    }
}