import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;


class Main {
    public static void main(String[] args) {
        
        //create an arraylist of instrument objects
        ArrayList<Instrument> inventory = new ArrayList<>();

        //set input for menu choices
        Scanner scanner = new Scanner(System.in);
        String inputFile = "instrument.csv";
        String errorFile = "error.txt";
        String reportFile = "report.txt";

        //readFile will open & close error file
        InventoryManager.readFile(inputFile, errorFile, inventory);
        System.out.println("Inventory loaded: " + inventory.size() + " items.\n");

        //try to open the output file for the report 
        try (PrintWriter writer = new PrintWriter(new FileWriter(reportFile))) {
            int choice;
            //print the menu & stay in loop until '4' is chosen
            //add logic (switch?) to choose which function to do based on input
  

            scanner.close();
        
        } catch (IOException e) {
            System.err.println("Could not write report: " + e.getMessage());
        }
    }
}
