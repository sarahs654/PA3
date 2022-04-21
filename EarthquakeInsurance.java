/**
 * WARNING:  THE CODE IN THIS PROGRAM "CANNOT" BE ALTERED.
 * NO POSTING OF THIS CODE IS ALLOWED ANY WHERE AS IT
 * IS THE INTELLECTUAL PROPERTY OF THE AUTHOR.
 * 
 * @(#)EarthquakeInsurance.java
 * @author Linda Shepherd
 * @version 1.00 2022/04/07 10:57 PM
 *
 * PROGRAM PURPOSE: Program that tells an insured how much will be paid out if there is an earthquake.
 * The payout will be based off of the richter scale and insured value of the home. 
 */
import java.util.Scanner;   //Import the Scanner class

public class EarthquakeInsurance
{    
  //Class fields
  private String insured;  //Stores the insured's name
  private String coverage; //Stores the string format for the final output of payout for earthquake dmg
  private String message; //Stores the damage assessment message for each Richter value
  private double homeInsVal; //Stores the insured value of the home
  private double richter; //Stores the richter scale value of the earthquake
  private double payout; //Stores the calculated insurance payout 
  private double deductible; //Stores the calculated insurance deductible
  private Scanner input = new Scanner(System.in); //Scanner object to read user input
  private boolean repeat; //Stores loop test variable
  private char correct; //Stores user's input on whether the data is correct
  
  /**
   * No-arg default constructor
   */
  public EarthquakeInsurance()
  {
  }//END Default Constructor
  
  /**
   * Overloaded Constructor which takes three arguments: 
   * String containing the name of the insured 
   * Double containing the insured value of the home 
   * Double containing the richter scale value of the earthquake 
   * Arguments are used to set the values of the related variables. 
   */
  public EarthquakeInsurance(String insured, double homeInsVal, double richter)
  {
    setInsured(insured);
    setHomeInsVal(homeInsVal);
    setRichter(richter);
  }//END EarthquakeInsurance(String, double, double)
  
  /**
   * Copy method uses the values for insured, homeInsVal, and richter stored by
   * the existing EarthquakInsurance object to make a copy with reference variable insuranceObj
   * The insuranceObj is returned
   */
  
  public EarthquakeInsurance copy() 
  {
    EarthquakeInsurance insuranceObj = new EarthquakeInsurance(insured, homeInsVal, richter);
    return insuranceObj; 
  }
  
  /**
   * The equals method accepts another EarthquakeInsurance object and compares it to the calling object. 
   * If the values stored in insured, homeInsVal, and richter are the same on both obejcts, the method returns true 
   * If the listed values are not the same, the method returns false. 
   */
  
  public boolean equals(EarthquakeInsurance object2)
  {
    boolean isEqual = false; 
    
    if(insured.equals(object2.insured) && homeInsVal == 
       object2.homeInsVal && richter == object2.richter)
      isEqual = true;
    
    return isEqual;
  }
  
  /**
   * the setInsured method accepts the insured's name as a string. 
   * It uses this argument to set the value of the insured class field.
   */
  public final void setInsured(String insured)
  {
    this.insured = insured;
    
  }//END setInsured(String):  final void
  
  /**
   * the setHomeInsVal method accepts the insured value of the home as a double. 
   * It uses this argument to set the value of the homeInsVal class field. 
   */
  public final void setHomeInsVal(double homeInsVal)
  {
    this.homeInsVal = homeInsVal;
  }//END setHomeInsVal(double):  final void  
  
  /**
   * The setRichter method accepts the richter scale value of an earthquake as a double. 
   * It uses this argument to set the value of the richter class field. 
   */
  public final void setRichter(double richter)
  {
    this.richter = richter;
  }//END setRichter(double):  final void
  
  /**
   * The overloaded setInsured method accepts no arguments. 
   * It prompts the user to enter their name, validates the input, and 
   * stores it in the insured class field. 
   * It also capitalizes the first letter of each name.
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
   * The overloaded setHomeInsVal method accepts no arguments. 
   * It prompts the user to enter the insured value of their home, validates it, and
   * stores it in the homeInsVal class field. 
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
   * The overloaded setRichter method accepts no arguments. 
   * It prompts the user to enter the richter scale value, validates it, and
   * stores it in the richter class field. 
   * Calls the testRichter() method. 
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
   * Based on the values of richter and homeInsVal: 
   * the payout and deductible are calculated and stored in their respective class fields. 
   * the damage assessment message is stored in the message class field.
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
   * The getInsured method returns the value of the insured class field.
   */
  public String getInsured()
  {
    return insured;
  }//END getInsured():  int
  
  /**
   * The getHomeInsVal method returns the value of the homeInsVal class field.
   */
  public double getHomeInsVal()
  {
    return homeInsVal;
  }//END getHomeInsVal():  double
  
  /**
   * The getRichter method returns the value of the richter class field.
   */
  public double getRichter()
  {
    return richter;
  }//END getRichter():  double
  
  /**
   * The getPayout method returns the value of the payout class field.
   */
  public double getPayout()
  {
    return payout;
  }//END getPayout():  double
  
  /**
   * The getDeductible method returns the value of the deductible class field.
   */
  public double getDeductible()
  {
    return deductible;
  }//END getDeductible():  double  
  
  /**
   * The getMessage method returns the value of the message class field.
   */
  public String getMessage()
  {
    return message;
  }//END getMessage():  String
  
  /**
   * the validateNumber method validates integers and double entered by the user.
   * If the input is non-numeric, a warning is printed. 
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
