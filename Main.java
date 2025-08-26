import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;


class Main {
    public static void main(String[] args) {
        List<Instrument> inventory = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String inputFile = "instrument.csv";
        String errorFile = "error.txt";
        String reportFile = "report.txt";

        InventoryManager.readFile(inputFile, errorFile, inventory);
        System.out.println("Inventory loaded: " + inventory.size() + " items.\n");

        try (PrintWriter writer = new PrintWriter(new FileWriter(reportFile))) {
            int choice;
            do {
                System.out.println("\n===== Instrument Inventory Menu =====");
                System.out.println("1. List all instruments");
                System.out.println("2. Find instruments by type");
                System.out.println("3. List instruments by manufacturer");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        InventoryManager.listInstruments(inventory, writer);
                        break;
                    case 2:
                        System.out.print("Enter instrument type to search: ");
                        String type = scanner.nextLine();
                        InventoryManager.findInstruments(inventory, type, writer);
                        break;
                    case 3:
                        System.out.print("Enter manufacturer to search: ");
                        String maker = scanner.nextLine();
                        InventoryManager.listManufacturers(inventory, maker, writer);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } while (choice != 4);

            scanner.close();
        
        } catch (IOException e) {
            System.err.println("Could not write report: " + e.getMessage());
        }
    }
}
