import java.io.PrintWriter;
class StringInstrument extends Instrument {
    private int numStrings;
    private int numFrets;
    private boolean isBowed;

    public StringInstrument(String type, String name, String manufacturer,
                            int year, int cost, int strings, int frets, boolean bowed) {
        super(type, name, manufacturer, year, cost);
        this.numStrings = strings;
        this.numFrets = frets;
        this.isBowed = bowed;
    }

    public int getNumStrings() { return numStrings; }
    public int getNumFrets() { return numFrets; }
    public boolean isBowed() { return isBowed; }

    public void setNumStrings(int strings) { this.numStrings = strings; }
    public void setNumFrets(int frets) { this.numFrets = frets; }
    public void setBowed(boolean bowed) { this.isBowed = bowed; }

    @Override
    public void printInstrument(PrintWriter writer) {
        super.printInstrument(writer);
        String bow = "Bowed";
        if (!isBowed)
            bow = "Not Bowed";
        writer.write(String.format("%5d%5d%10s", numStrings, numFrets, bow));
    }
}
