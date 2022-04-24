/**
 * 
 * @(#)HernandezSkinner002PA3.java
 * @authors Rafael Hernandez and Sarah Skinner
 * @version 1.00 2022/04/20 10:57 PM
 *
 * PROGRAM PURPOSE: To process a homeowner's insurance claim(s) for earthquake 
 * damage to a property. 
 */

import java.io.IOException; //imports IOException

public class HernandezSkinner002PA3
{
  public static void main(String[] args) throws IOException
  {
    InsuranceSystem anEarthquake = new InsuranceSystem();
    
    anEarthquake.start();
    System.exit(0);
  }
}