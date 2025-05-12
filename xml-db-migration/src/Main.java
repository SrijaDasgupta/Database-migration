public class Main {
    public static void main(String[] args) {
        try {
            DatabaseSchema schema = XMLParser.parseSchema("resources/schema.xml");
            List<Employee> employees = XMLParser.parseData("resources/data.xml");
            MigrationService service = new MigrationService();
            service.migrate(schema, employees);
            System.out.println("Migration completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}