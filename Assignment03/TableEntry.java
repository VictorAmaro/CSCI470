//package hw3;

public class TableEntry {
    private int freqCount;
    private int numerologicalVal;
    private char alphaLetter;
    
    /***************
     Default constructor 
     Sets class members to passed in values 
     * 
     * @param newCount
     * @param newAlphaLetter
     * @param newNumerologicalVal 
     **************/
    TableEntry(int newCount, char newAlphaLetter, int newNumerologicalVal) {
        this.freqCount = newCount;
        this.alphaLetter = newAlphaLetter;
        this.numerologicalVal = newNumerologicalVal;
    }
    
    /************************************
     getTableValue
     Returns the numerological value for the corresponding letter 
     * 
     * @return this.numerologicalVal
     **********************************/
    public int getTableValue(){
        return this.numerologicalVal;
    }
    
    /**********************************
     bumpCount
     Adds one to the frequency counter for the corresponding letter 
     *********************************/
    public void bumpCount() {
        this.freqCount++;
    }
    
    /*********************************
     getTableCount()
     Returns the frequency counter for the corresponding letter
     * 
     * @return this.freqCount 
     ********************************/
    public int getTableCount() {
        return this.freqCount;
    }
    
    /*******************************
     resetTableCount()
     Resets the frequency counter for the corresponding letter 
     ******************************/
    public void resetTableCount() {
        this.freqCount = 0;
    }
    
    /**************************
     getLetter()
     Returns the corresponding letter 
     * 
     * @return this.alphaLetter
     *************************/
    public char getLetter() {
        return this.alphaLetter;
    }  
}
