/**
 * 
 * @(#)InsuranceSystem.java
 * @authors Rafael Hernandez and Sarah Skinner
 * @version 1.00 2022/04/20 10:57 PM
 *
 * PROGRAM PURPOSE: Handles the insurance claims created in the EarthquakeInsurance class 
 * and creates a record of the claims in an output file. 
 */

import java.util.Scanner;   //imports the scanner class for capturing user input
import java.util.Calendar;  //imports the Calendar class for displaying current date/time
import java.util.ArrayList; //imports the arraylist class 
import java.io.*;           //imports all classes under java.io for IO exceptions, file, and printwriter
//import calendar, arraylist, file, printwriter, ioexception

public class InsuranceSystem
{
  //class data members
  private EarthquakeInsurance claims = new EarthquakeInsurance(); //MAY NOT WORK
  private Scanner input = new Scanner(System.in); //Scanner object to read user input
  private Calendar dateTime = Calendar.getInstance(); //Calendar object to reference data and time
  private ArrayList<String> claimsReport= new ArrayList<String>();
  private String filename; //Stores name of output file
  private char cont; //Stores loop test variable
  private char correct; //Stores user's input on whether the data is correct
  
  public InsuranceSystem()
  {
  }
  
  public void start(String[] args)
  {
    //begin prompt 1 
    System.out.printf("%nMUTUALLY ACCIDENTAL, INC."); 
    System.out.printf("%n%nDo you want an analysis of earthquake coverage"
                        + " for your property? Enter 'Y' or 'N':  ");
    cont = input.next().charAt(0); //END PROMPT 1
    
    if(Character.toUpperCase(cont) == 'Y')
    {
      //processClaims();
      //writeClaimsRecords();
      //checkInputFile();
    } 
    else {
      printThankYou();
    }                          
   }
  
  public void processClaims()
  {
    int size;
    int j;
    int k;
    
    String suffix;
    String aClaim;
    
    processClaims();
    String record;
    PrintWriter outputFile = new PrintWriter("File");
    
    outputFile.close();
    
    //checkInputFile();
    
    
  }
  
  public void writeClaimsRecords(String[] args) 
  {
    String record; 
    PrintWriter outputFile = null; 
    
    
    
  }
  
  public void checkInputFile(String[] args) 
  {
    //File file ??
    Scanner inputFile = new Scanner();
    String fileRecord; 
    
    
  }
  
  public void printThankYou()
  {
    System.out.printf("%nThank you for using the Earthquake Coverage Analyzer.");
  }
  
}