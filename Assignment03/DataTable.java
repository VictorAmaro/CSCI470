//package hw3;

public class DataTable {
    private TableEntry[] innerTable;
    private String usingString;
    private int runningTotal = 0;
    
    DataTable( ) {
        innerTable = new TableEntry[26];

        innerTable[0] = new TableEntry(0, 'a', 1);  
        innerTable[1] = new TableEntry(0, 'b', 2);
        innerTable[2] = new TableEntry(0, 'c', 3);
        innerTable[3] = new TableEntry(0, 'd', 4);
        innerTable[4] = new TableEntry(0, 'e', 5);
        innerTable[5] = new TableEntry(0, 'f', 6);
        innerTable[6] = new TableEntry(0, 'g', 7);
        innerTable[7] = new TableEntry(0, 'h', 8);
        innerTable[8] = new TableEntry(0, 'i', 9);
        innerTable[9] = new TableEntry(0, 'j', 0);
        innerTable[10] = new TableEntry(0, 'k', 10);
        innerTable[11] = new TableEntry(0, 'l', 20);
        innerTable[12] = new TableEntry(0, 'm', 30);
        innerTable[13] = new TableEntry(0, 'n', 40);
        innerTable[14] = new TableEntry(0, 'o', 50);
        innerTable[15] = new TableEntry(0, 'p', 60);
        innerTable[16] = new TableEntry(0, 'q', 70);
        innerTable[17] = new TableEntry(0, 'r', 80);
        innerTable[18] = new TableEntry(0, 's', 90);
        innerTable[19] = new TableEntry(0, 't', 100);
        innerTable[20] = new TableEntry(0, 'u', 110);
        innerTable[21] = new TableEntry(0, 'v', 120);
        innerTable[22] = new TableEntry(0, 'w', 130);
        innerTable[23] = new TableEntry(0, 'x', 140);
        innerTable[24] = new TableEntry(0, 'y', 150);
        innerTable[25] = new TableEntry(0, 'z', 160);
    }
    
    /****************
     setString(String ) 
     Brings in the string to manipulate it
     * 
     * @param newString 
     ***************/
    public void setString(String newString) {
        this.usingString = newString;
    }
    
    /*******************
     getString()
     Returns the string we are using 
     * 
     * @return usingString
     ******************/
    public String getString() {
        return this.usingString;
    }
    
    /*****************
     addToTotal(int )
     Adds to the running total value of the string 
     * 
     * @param toBeAdded 
     ****************/
    public void addToTotal(int toBeAdded) {
        this.runningTotal += toBeAdded;
    }
    
    /*******************
     getTotal()
     Returns the running total value of the string 
     * 
     * @return runningTotal
     ******************/
    public int getTotal() {
        return this.runningTotal;
    }
    
    /******************
     processLength()
     Returns the amount of letters (ignoring non letters) there are in the string 
     * 
     * @return temp.length
     *****************/
    public int processLength() {
        return this.getString().length();
    }
    
    /****************
     processLetters() 
     Counts only alphabet numbers  
     * @return totalLetters
     ****************/
    public int processLetters() {
        int totalLetters = 0;
        String temp = this.getString();
        
        for(int i = 0; i < temp.length(); i++) {
            char stringChar = temp.charAt(i);
            if(Character.isLetter(stringChar) ) {
                totalLetters++;
            }
        }
        
        return totalLetters;
    }
    
    /*********************
     processTotal() 
     Converts the string into a char array, removing non letters
     Loops in the char array
       Compares the letter of nth spot in inner table to nth spot in the char array
       Once correct match is found, adds one to the frequency counter for that letter
       And adds the numerological value of that letter to the total points for that char array
     Resets the frequency counter for all spots in the innerTable array
     Returns the total points for the char array 
     * 
     * @return totalPoints
     ********************/
    public int processTotal() {
        int totalPoints = 0;
        int charArCnt = 0;
        char[] charUsingString = this.getString().toLowerCase().replaceAll("\\s+","").toCharArray();  
        
        while(charArCnt < charUsingString.length) {
            for(int innerTableCnt = 0; innerTableCnt < innerTable.length; innerTableCnt++) {
                if(charUsingString[charArCnt] == innerTable[innerTableCnt].getLetter()) {
                    innerTable[innerTableCnt].bumpCount();
                    totalPoints += innerTable[innerTableCnt].getTableValue();
                }  
            }
            charArCnt++;
        }

        return totalPoints;
    }  

    /*************
     printLetterTotals()
     Prints out the alphabet going from a to z in rows
     Prints out the frequency of each letter from innerTable 
     * 
     ************/
    public void printLetterTotals() {
        int j = 0;
        
        for(int i = 0; i < innerTable.length; i++) {
            System.out.printf("%s%s%-3s", (char)(i+97), "->" ,innerTable[i].getTableCount());
                    
            if(j % 5 == 0 && j != 0) {
                System.out.println();
            }
            
            j++;
        }  
    }
    
}
