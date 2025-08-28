import java.io.PrintWriter;
class StringInstrument extends Instrument {
    private int numStrings;
    private int numFrets;
    private boolean isBowed;

    //complete overloaded constructor 
    public StringInstrument(String type, String name, String manufacturer,
                            int year, int cost, int strings, int frets, boolean bowed) {

    }

    //complete getters
    public int getNumStrings() { return numStrings; }


    //complete setters
    public void setNumStrings(int strings) { this.numStrings = strings; }


    //create the @Override function for printInstrument
    @Override
    public void printInstrument(PrintWriter writer) {

    }
}
