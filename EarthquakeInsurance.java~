/**
 * WARNING:  THE CODE IN THIS PROGRAM "CANNOT" BE ALTERED.
 * NO POSTING OF THIS CODE IS ALLOWED ANY WHERE AS IT
 * IS THE INTELLECTUAL PROPERTY OF THE AUTHOR.
 * 
 * @(#)EarthquakeInsurance.java
 * @author Linda Shepherd
 * @version 1.00 2022/04/07 10:57 PM
 *
 * PROGRAM PURPOSE:  Student Inserts
 */
import java.util.Scanner;   //STUDENTS INSERT LINE COMMENTS FOR EACH IMPORT STMT.

public class EarthquakeInsurance
{    
  //STUDENTS INSERT LINE COMMENTS DESCRIPTIVE OF THE PURPOSE OF EACH VARIABLE.
  private String insured;  
  private String coverage;
  private String message;
  private double homeInsVal;
  private double richter;
  private double payout;
  private double deductible;   
  private Scanner input = new Scanner(System.in);  
  private boolean repeat;
  private char correct;
  
  /**
   * STUDENTS ARE TO DESCRIBE WHAT'S GOING ON WITH THE CODE IN METHOD BOXES.
   */
  public EarthquakeInsurance()
  {
  }//END Default Constructor
  
  /**
   * STUDENTS ARE TO DESCRIBE WHAT'S GOING ON WITH THE CODE IN METHOD BOXES.
   */
  public EarthquakeInsurance(String insured, double homeInsVal, double richter)
  {
    setInsured(insured);
    setHomeInsVal(homeInsVal);
    setRichter(richter);
  }//END EarthquakeInsurance(String, double, double)
  
  /**
   * STUDENTS CODE copy() AND PROVIDE METHOD BOX COMMENTS.
   */
  
  
  
  /**
   * STUDENTS CODE equals AND PROVIDE METHOD BOX COMMENTS.
   */
  
  
  
  /**
   * STUDENTS ARE TO DESCRIBE WHAT'S GOING ON WITH THE CODE IN METHOD BOXES.
   */
  public final void setInsured(String insured)
  {
    this.insured = insured;
    
  }//END setInsured(String):  final void
  
  /**
   * STUDENTS ARE TO DESCRIBE WHAT'S GOING ON WITH THE CODE IN METHOD BOXES.
   */
  public final void setHomeInsVal(double homeInsVal)
  {
    this.homeInsVal = homeInsVal;
  }//END setHomeInsVal(double):  final void  
  
  /**
   * STUDENTS ARE TO DESCRIBE WHAT'S GOING ON WITH THE CODE IN METHOD BOXES.
   */
  public final void setRichter(double richter)
  {
    this.richter = richter;
  }//END setRichter(double):  final void
  
  /**
   * STUDENTS ARE TO DESCRIBE WHAT'S GOING ON WITH THE CODE IN METHOD BOXES.
   */
  public void setInsured()  
  { 
    String insuredCopy = null, first = null, last = null;
    int indexOfSpace = 0;
    
    do
    {
      System.out.printf("%nMUTUALLY ACCIDENTAL, INC."
                          + "%nEarthquake Coverage Analyzer"
                          + "%n%nPlease enter your name:  ");
      
      insured =  input.nextLine();   
      
      insuredCopy = new String(insured).replace(" ", "");
      
      while(!isAlpha(insuredCopy))
      {
        System.out.printf("%nInvalid name!  Please re-enter:  ");
        insured = input.nextLine();
        insuredCopy = new String(insured).replace(" ", "");
      }//while insured's name is NOT alphabetic
      
      System.out.printf("%nYour Name:  %s"                            
                          + "%n%nIs this name correct?  \'Y\' or \'N\':  ",
                        insured);        
      correct = input.nextLine().toLowerCase().charAt(0);
      
      repeat = correct == 'y' ? false : true;  
    }while(repeat);  //do-while insured name is not correct
    
    indexOfSpace = insured.indexOf(" ");  //Locate where the space is in insured.      
    
    if(indexOfSpace > 0)
    {
      first = Character.toUpperCase(insured.charAt(0)) 
        + insured.substring(1, indexOfSpace).toLowerCase();
      
      last = Character.toUpperCase(insured.charAt(indexOfSpace + 1))
        + insured.substring(indexOfSpace + 2, insured.length()).toLowerCase();    
      
      insured = first + " " + last;
    }//if there is more than one name, capitalize the first letter in each
    else
    {
      insured = Character.toUpperCase(insured.charAt(0)) 
        + insured.substring(1, insured.length()).toLowerCase();
    }//else capitalize first letter of a single name
    
    
  }//END setInsured():  void
  
  /**
   * STUDENTS ARE TO DESCRIBE WHAT'S GOING ON WITH THE CODE IN METHOD BOXES.
   */
  public void setHomeInsVal()
  {
    do
    {
      do
      {
        System.out.printf("%nPlease enter the insured value of your home:  ");
        repeat = !input.hasNextDouble();
        
        validateNumber();
        
      }while(repeat);  //END do-while repeats when homeInsVal is invalid
      
      homeInsVal = input.nextDouble();    
      
      if(homeInsVal < 0)
      {
        System.out.printf("%nThe insured value of your home cannot be less than or equal to 0.%n");  
        repeat = true;
        
      }//END if homeInsVal less than zero then prompt again
      else
      {
        System.out.printf("%nHome\'s Insured Value:  $%,.0f"                          
                            + "%n%nIs this insured value correct?  \'Y\' or \'N\':  ",
                          homeInsVal);
        correct = input.next().toLowerCase().charAt(0);
        
        repeat = correct == 'y' ? false : true;
      }//END else validate the correctness of insured value
      
    }while(repeat);  //END do-while repeats when homeInsVal is not correct
    
  }//END setHomeInsVal():  final void  
  
  /**
   * STUDENTS ARE TO DESCRIBE WHAT'S GOING ON WITH THE CODE IN METHOD BOXES.
   */ 
  public void setRichter()
  {
    do
    {
      do
      {
        System.out.printf("%nRichter Scale     Damage Assessment"
                            + "%n     9.0+         Total destruction."
                            + "%n     8.0          Most structures fell."
                            + "%n     7.0          Many buildings destroyed."
                            + "%n     6.0          Many buildings considerably damaged, some collapsed."
                            + "%n     4.5          Damage to poorly constructed buildings."
                            + "%n     3.5          Felt by many people, no destruction."
                            + "%n     0            Generally not felt by people."
                            + "%n%nPlease enter the Richter scale value for the earthquake:  ");
        
        repeat = !input.hasNextDouble();
        
        validateNumber();  
        
      }while(repeat);  //END do-while repeats when richter is invalid
      
      richter = input.nextDouble();    
      
      if(richter < 0)
      {
        System.out.printf("%nInvalid!  Richter cannot be negative.  Please re-enter.%n");  
        repeat = true;
        
      }//END if richter less than zero then prompt again
      else
      {      
        System.out.printf("%nRichter Scale:  %.2f"
                            + "%n%nIs this richter value correct?  \'Y\' or \'N\':  ",
                          richter);
        correct = input.next().toLowerCase().charAt(0);
        
        input.nextLine();        
        
        repeat = correct == 'y' ? false : true;
      }//END else validate the correctness of richter
      
    }while(repeat);  //END do-while repeats when homeInsVal is not correct          
    
    testRichter();
  }//END setRichter():  void 
  
  /**
   * STUDENTS ARE TO DESCRIBE WHAT'S GOING ON WITH THE CODE IN METHOD BOXES.
   */  
  private void testRichter()
  {
    if(richter >= 9.0)
    {
      payout = homeInsVal * .90;
      deductible = homeInsVal * .10;
      message = "Total destruction.";
    }//END if richter >= 9.0 else richter < 9.0
    else if(richter >= 8.0)
    {
      payout = homeInsVal * .80;
      deductible = homeInsVal * .20;
      message = "Most structures fell.";
    }//END if richter >= 8.0 else richter < 8.0
    else if(richter >= 7.0)
    {
      payout = homeInsVal * .70;
      deductible = homeInsVal * .30;
      message = "Many buildings destroyed.";
    }//END if richter >= 7.0 else richter < 7.0
    else if(richter >= 6.0)
    {
      payout = homeInsVal * .60;
      deductible = homeInsVal * .40;
      message = "Many buildings considerably damaged, some collapsed.";
    }//END if richter >= 6.0 else richter < 6.0
    else if(richter >= 4.5)
    {
      payout = homeInsVal * .50;
      deductible = homeInsVal * .50;
      message = "Damage to poorly constructed buildings.";
    }//END if richter >= 4.5 else richter < 4.5
    else if(richter >= 3.5)
    {
      payout = 0;
      deductible = 0;
      message = "Felt by many people, no destruction.";
    }//END if richter >= 3.5 else richter < 3.5
    else if(richter >= 0)
    {
      payout = 0;
      deductible = 0;
      message = "Generally not felt by people.";
    }//END if richter >= 0 else richter < 0  
    
  }//END testRichter():  void  
  
  /**
   * STUDENTS ARE TO DESCRIBE WHAT'S GOING ON WITH THE CODE IN METHOD BOXES.
   */
  public String getInsured()
  {
    return insured;
  }//END getInsured():  int
  
  /**
   * STUDENTS ARE TO DESCRIBE WHAT'S GOING ON WITH THE CODE IN METHOD BOXES.
   */
  public double getHomeInsVal()
  {
    return homeInsVal;
  }//END getHomeInsVal():  double
  
  /**
   * STUDENTS ARE TO DESCRIBE WHAT'S GOING ON WITH THE CODE IN METHOD BOXES.
   */
  public double getRichter()
  {
    return richter;
  }//END getRichter():  double
  
  /**
   * STUDENTS ARE TO DESCRIBE WHAT'S GOING ON WITH THE CODE IN METHOD BOXES.
   */
  public double getPayout()
  {
    return payout;
  }//END getPayout():  double
  
  /**
   * STUDENTS ARE TO DESCRIBE WHAT'S GOING ON WITH THE CODE IN METHOD BOXES.
   */
  public double getDeductible()
  {
    return deductible;
  }//END getDeductible():  double  
  
  /**
   * STUDENTS ARE TO DESCRIBE WHAT'S GOING ON WITH THE CODE IN METHOD BOXES.
   */
  public String getMessage()
  {
    return message;
  }//END getMessage():  String
  
  /**
   * STUDENTS ARE TO DESCRIBE WHAT'S GOING ON WITH THE CODE IN METHOD BOXES.
   */
  public void validateNumber()
  {
    if(repeat) //AS LONG AS THE INPUT IS "NOT" AN INTEGER OR DOUBLE
    { 
      input.next(); //CONSUME NON-NUMERIC VALUE.
      System.out.printf("%nWarning:  You entered an invalid integer or "
                          + "floating-point value.%n");  //RE-PROMPT     
    }//END if repeat when a number is an invalid type
    
  }//END validateNumber(boolean):  void
  
  /**
   * chars() returns the integer values of the characters in word.  
   * 
   * allMatch determines whether the integer values for each character 
   * matches the predicate (criterion) that each character is a letter.  
   * 
   * The :: is a method reference operator for calling isLetter from
   * the Character class.
   * 
   * @param word is the incoming String value to test.
   * @return is true when the word is not empty and is alphabetic 
   *  or false when it isn't.
   */
  public final boolean isAlpha(String word)
  {    
    /* Test to see if the word is not empty AND if each letter
     * in a word is an alphabetic character.  
     */
    return word != null && word.chars().allMatch(Character :: isLetter);
    
  }//END isAlpha(String):  final boolean  
  
}//END CLASS EarthquakeInsurance
