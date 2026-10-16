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


    //correct toString to print String Instrument information (adding the numString, numFrets, isBowed)
    @Override
    public String toString() {
        String out = " ";
        return out;
    }
}
