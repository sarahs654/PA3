/**
 * 
 * @(#)InsuranceSystem.java
 * @authors Rafael Hernandez and Sarah Skinner
 * @version 1.00 2022/04/20 10:57 PM
 *
 * PROGRAM PURPOSE: Handles the insurance claims created in the EarthquakeInsurance class 
 * and creates a record of the claims in an output file. 
 */

//imports
import java.util.Scanner;   //imports the scanner class for capturing user input
import java.util.Calendar;  //imports the Calendar class for displaying current date/time
import java.util.ArrayList; //imports the arraylist class 
import java.io.File;           //imports the file class
import java.io.PrintWriter;    //imports the printwriter class 
import java.io.IOException;    //imports the IOException class

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
          claims[i].setInsured(claims[i-1].getInsured());
          
          
        }//END if cont == 'n'
        
      }
      else
      {
        claims[i].setInsured();

      }//END if i > 0
      
      claims[i].setHomeInsVal();
      claims[i].setRichter();
      input.next();
      
      aClaim = String.format("%n%nPAYOUT FOR EARTHQUAKE DAMAGE"
                               + "%n%nHomeowner: %S"
                               + "%n%nDate: %tD"
                               + "%nTime: %tr%n"
                               + "%n%-52s %4s $%,20.2f"
                               + "%nDeductible %47s %,20.2f"
                               + "%n%46s TOTAL %4s $%,20.2f%n",
                             claims[i].getInsured(), dateTime, dateTime,
                             claims[i].getMessage(), " ",
                             claims[i].getPayout(), " ",
                             claims[i].getDeductible(), " ",
                             " ", claims[i].getPayout() +
                             claims[i].getDeductible());//please copy this i dont have firefox
      claimsReport.add(aClaim);
      
      for(String eachClaim : claimsReport)
      {
        System.out.printf("%n%s", eachClaim);
      } //END enhanced for
    }//END for
    
  }//END processClaims
  
  public void writeClaimsRecords() throws IOException
  {
    String record; 
    PrintWriter outputFile;
    
    System.out.printf("%nEnter the file name for claims' records." 
                    + "(WARNING: This will erase a pre-existing file!):  ");
    outputFile = new PrintWriter(input.next());  
       
    for(int i = 0; i < claims.length; i++)
    {
      record = String.format("%s, %f, %f%n", claims[i].getInsured(), claims[i].getHomeInsVal(),
                             claims[i].getRichter());
      outputFile.printf("%n%s", record);
    }//END for
      
    outputFile.close();
    System.out.printf("%nData written to the %s file.", outputFile);
    
  }//END writeClaimsRecords()
  
  public void checkInputFile() throws IOException
  {
    String fileName;
    File file;
    String fileRecord; 
    
    System.out.printf("%nEnter the name for the claims' file:  "); 
    fileName = input.next();
    file = new File(input.next());
    
    Scanner inputFile = new Scanner(file); 
    
    while(inputFile.hasNext())
    {
      fileRecord = inputFile.nextLine();
      System.out.printf("%n%s", fileRecord);
    } //END while iput.hasNext()
    
    System.out.println();
    inputFile.close();
    
  }//END checkInputFile()
  
  public void printThankYou()
  {
    System.out.printf("%nThank you for using the Earthquake Coverage Analyzer.");
  }//END printThankYou
  
}//END application class InsuranceSystem