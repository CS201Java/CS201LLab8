import java.io.*;
import java.util.*;

public class InventoryManager {

    public static void readFile(String inputPath, String errorPath, List<Instrument> inventory) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter errorWriter = new BufferedWriter(new FileWriter(errorPath))) {

            String line = reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                try {
                    if (tokens.length < 5) throw new IllegalArgumentException("Incomplete record");

                    String type = tokens[0].trim();
                    String name = tokens[1].trim();
                    String manufacturer = tokens[2].trim();
                    int year = Integer.parseInt(tokens[3].trim());
                    int cost = Integer.parseInt(tokens[4].trim());
                    System.out.println (name + "/" + year + "/" + cost + "/");

                    if (tokens.length == 5 ) {
                        inventory.add(new Instrument(type, name, manufacturer, year, cost));
                    }
                    else {
                        int strings = Integer.parseInt(tokens[5].trim());
                        int frets = Integer.parseInt(tokens[6].trim());
                        boolean bowed = tokens[7].trim().equals("1");
                        inventory.add(new StringInstrument(type, name, manufacturer, year, cost, strings, frets, bowed));
                    }
                } catch (Exception e) {
                    errorWriter.write("Error: " + e.getMessage() + " — " + line + "\n");
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void listInstruments(List<Instrument> inventory, PrintWriter writer){
        writer.write("\n\nFULL INVENTORY LIST\n");
        writer.write(String.format("%-20s%-20s%-20s%10s%10s%15s\n","TYPE","NAME","MANUFACTURER","YEAR","COST $","STRING INFO"));
        for (Instrument i : inventory) {
            i.printInstrument(writer);
            writer.write("\n");
        }

    }

    public static void findInstruments(List<Instrument> inventory, String typeQuery, PrintWriter writer) {
        boolean found = false;
        writer.write("\n\nINVENTORY OF TYPE: " + typeQuery + "\n");
        writer.write(String.format("%-20s%-20s%-20s%10s%10s%15s\n","TYPE","NAME","MANUFACTURER","YEAR","COST $","STRING INFO"));
        for (Instrument i : inventory) {
                if (i.getType().toLowerCase().contains(typeQuery.toLowerCase())) {
                    i.printInstrument(writer);
                    writer.write("\n");
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No instruments of type \"" + typeQuery + "\" found.");
                writer.write("No instruments of type \"" + typeQuery + "\" found.\n");
            }
        
    }

    public static void listManufacturers(List<Instrument> inventory, String maker, PrintWriter writer) {
        boolean found = false;
        writer.write("\n\nINVENTORY FROM MAKER: " + maker + "\n");
        writer.write(String.format("%-20s%-20s%-20s%10s%10s%15s\n","TYPE","NAME","MANUFACTURER","YEAR","COST $","STRING INFO"));
            for (Instrument i : inventory) {
                if (i.getManufacturer().toLowerCase().contains(maker.toLowerCase())) {
                    i.printInstrument(writer);  
                    writer.write("\n");
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No instruments by \"" + maker + "\" found.");
                writer.write("No instruments by \"" + maker + "\" found.\n");
            }
    }
}
