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
  private EarthquakeInsurance[] claims; //MAY NOT WORK (maybe will work)
  private Scanner input = new Scanner(System.in); //Scanner object to read user input
  private Calendar dateTime = Calendar.getInstance(); //Calendar object to reference data and time
  private ArrayList<String> claimsReport= new ArrayList<String>();
  private String filename; //Stores name of output file
  private char cont; //Stores loop test variable
  private char correct; //Stores user's input on whether the data is correct
  
  public InsuranceSystem()
  {
    
  }//END InsuranceSystem()
  
  public void start() throws IOException
  {
    //begin prompt 1 
    System.out.printf("%nMUTUALLY ACCIDENTAL, INC."); 
    System.out.printf("%n%nDo you want an analysis of earthquake coverage"
                        + " for your property? Enter 'Y' or 'N':  ");
    cont = input.next().charAt(0); //END PROMPT 1
    
    if(Character.toUpperCase(cont) == 'Y')
    {
      processClaims();
      writeClaimsRecords();
      checkInputFile();
      printThankYou();
    }//END if cont == 'Y' 
    
    printThankYou();
      
   }//END start()
  
  public void processClaims() throws IOException
  {
    int size; //declaring int size variable
    int j;    //declaring int j variable
    int k;    //declaring int k variable
    
    String suffix;  //declaring string suffix variable
    String aClaim;  //declaring string aClaim variable
    
    System.out.printf("%nHow many claims will be filed? "); //prompt for asking how many claims will be filed
    size = input.nextInt();
    
    while(size <= 0)  //here we will "validate the user entry with a while validation loop"
    {
      System.out.printf("%nInvalid integer! Re-enter the number of claims to be filed!");
      size = input.nextInt();
    }//END while size <=0
    
    claims = new EarthquakeInsurance[size]; //then after the while we will use the validated size to create an array for "claims"
    
    for(int i = 0; i < size; i++)
    {
      j = (i + 1) % 10;
      k = (i + 1) % 100;
      suffix = j == 1 && k != 11 ? "st" :
        j == 2 && k != 12 ? "nd" :
        j == 3 && k != 13 ? "rd" : "th";
      
      claims[i] = new EarthquakeInsurance();
      
      if(i > 0)
      {
        System.out.printf("%nIs this %i%s claim for the same property owner? ('Y' or 'N': ",
                          i, suffix);
        
        cont = Character.toLowerCase(input.next().charAt(0));
        
        if(cont == 'n')
        {
          claims[i].setInsured();
        }
        else 
        {
          claims[i].setInsured(claims[i-1].getInsured);       
        }//END if cont == 'n'
        
      }
      else
      {
        claims[i].setInsured();

      }//END if i > 0
      
      claims[i].setHomeInsVal();
      claims[i].setRichter();
      input.next();
      
      aClaim = //please copy this i dont have firefox
      claimsReport.add(aClaim);
      
      for(String eachClaim : claimsReport)
      {
        System.out.println(eachClaim);
      } //END enhanced for
    }//END for
    
  }//END processClaims
  
  public void writeClaimsRecords() 
  {
    String record; 
    PrintWriter outputFile = null; 
    //??
    System.out.printf("%nEnter the file name for claims' records." 
                        + "(WARNING: This will erase a pre-existing file!):  ");
    File Claims.txt = new File(input.next());
    
    
    
  }//END writeClaimsRecords()
  
  public void checkInputFile() 
  {
    String fileName = "";
    File file = new File(fileName);
    Scanner inputFile = new Scanner(System.in);
    String fileRecord; 
    
    
  }//END checkInputFile()
  
  public void printThankYou()
  {
    System.out.printf("%nThank you for using the Earthquake Coverage Analyzer.");
  }//END printThankYou
  
}//END application class InsuranceSystem