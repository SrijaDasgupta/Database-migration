import java.sql.*;
import java.util.*;

public class MigrationService {
    public void migrate(DatabaseSchema schema, List<Employee> data) throws SQLException {
        Connection conn = DBConnector.getConnection();
        for (Table table : schema.tables) {
            StringBuilder createSQL = new StringBuilder("CREATE TABLE IF NOT EXISTS " + table.name + " (");
            List<String> colDefs = new ArrayList<>();
            for (Column col : table.columns) {
                colDefs.add(col.name + " " + col.type + (col.primaryKey ? " PRIMARY KEY" : ""));
            }
            createSQL.append(String.join(", ", colDefs)).append(")");
            conn.createStatement().execute(createSQL.toString());
        }

        for (Employee emp : data) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO employee VALUES (?, ?, ?)");
            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());
            ps.setString(3, emp.getEmail());
            ps.executeUpdate();
        }
    }
}