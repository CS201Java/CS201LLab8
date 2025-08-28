import java.io.*;
import java.util.*;

public class InventoryManager {

    //PRE:  accept the strings for the input file, error file, and empty Instrument list
    //POST: verify that the input files are good (using try/catch)
    //      read the input file & create instrement objects to add to the ArrayList

    public static void readFile(String inputPath, String errorPath, ArrayList<Instrument> inventory) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter errorWriter = new BufferedWriter(new FileWriter(errorPath))) {

            String line = reader.readLine(); // skip header

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                //set up the fields for the instrument
                try {
                    if (tokens.length < 5) throw new IllegalArgumentException("Incomplete record");


                    //add instrument
                    if (tokens.length == 5 ) {
 
                    }
                    //add string instrument
                    else {
 
                    }
                } catch (Exception e) {
                    errorWriter.write("Error: " + e.getMessage() + " — " + line + "\n");
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    //PRE:  accept the instrument arraylist and PrintWriter type (report output file) 
    //POST: print the inventory to the report file
    public static void listInstruments(ArrayList<Instrument> inventory, PrintWriter writer){
        writer.write("\n\nFULL INVENTORY LIST\n");
        writer.write(String.format("%-20s%-20s%-20s%10s%10s%15s\n","TYPE","NAME","MANUFACTURER","YEAR","COST $","STRING INFO"));
        for (Instrument i : inventory) {
            i.printInstrument(writer);
            writer.write("\n");
        }

    }

    //PRE:  accept the Array list of instruments, the string to find, and the PrintWriter report output file
    //POST: print the records that contain typeQuery
    public static void findInstruments(ArrayList<Instrument> inventory, String typeQuery, PrintWriter writer) {
        boolean found = false;
        writer.write("\n\nINVENTORY OF TYPE: " + typeQuery + "\n");
        writer.write(String.format("%-20s%-20s%-20s%10s%10s%15s\n","TYPE","NAME","MANUFACTURER","YEAR","COST $","STRING INFO"));
        
        
        
    }

    //PRE:  accept the Array list of instruments, the string to find, and the PrintWriter report output file
    //POST: print the inventory that was made by the 'maker'
    public static void listManufacturers(List<Instrument> inventory, String maker, PrintWriter writer) {
        boolean found = false;
        writer.write("\n\nINVENTORY FROM MAKER: " + maker + "\n");
        writer.write(String.format("%-20s%-20s%-20s%10s%10s%15s\n","TYPE","NAME","MANUFACTURER","YEAR","COST $","STRING INFO"));

    }
}
