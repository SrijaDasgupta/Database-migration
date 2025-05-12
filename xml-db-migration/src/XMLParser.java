import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.*;

public class XMLParser {
    public static DatabaseSchema parseSchema(String filePath) throws Exception {
        File file = new File(filePath);
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        doc.getDocumentElement().normalize();
        
        Element root = doc.getDocumentElement();
        String dbName = root.getAttribute("name");
        NodeList tables = root.getElementsByTagName("table");

        DatabaseSchema schema = new DatabaseSchema(dbName);

        for (int i = 0; i < tables.getLength(); i++) {
            Element tableElement = (Element) tables.item(i);
            String tableName = tableElement.getAttribute("name");
            Table table = new Table(tableName);

            NodeList columns = tableElement.getElementsByTagName("column");
            for (int j = 0; j < columns.getLength(); j++) {
                Element colElement = (Element) columns.item(j);
                String name = colElement.getAttribute("name");
                String type = colElement.getAttribute("type");
                boolean primaryKey = Boolean.parseBoolean(colElement.getAttribute("primaryKey"));
                table.columns.add(new Column(name, type, primaryKey));
            }
            schema.tables.add(table);
        }
        return schema;
    }

    public static List<Employee> parseData(String filePath) throws Exception {
        List<Employee> employees = new ArrayList<>();
        File file = new File(filePath);
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        doc.getDocumentElement().normalize();

        NodeList nodes = doc.getElementsByTagName("employee");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element e = (Element) nodes.item(i);
            int id = Integer.parseInt(e.getElementsByTagName("id").item(0).getTextContent());
            String name = e.getElementsByTagName("name").item(0).getTextContent();
            String email = e.getElementsByTagName("email").item(0).getTextContent();
            employees.add(new Employee(id, name, email));
        }
        return employees;
    }
}