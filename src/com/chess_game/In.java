/* Reads/takes in Standard Input 
 */

package com.chess_game;

import java.io.*;
import java.text.*;

public class In
{
  static InputStreamReader r = new InputStreamReader(System.in);
  static BufferedReader br = new BufferedReader(r);

  // Read a String from standard system input
  public static String getString(String... s)
  {
    for (int i = 0; i < s.length; i++)
    {
      System.out.print(s[i]);
    }
    
    try
    {
      return br.readLine();
    }
    catch (Exception e)
    {
      return "";
    }
  }

  // Read a Number as a String from standard system input
  // Return the Number
  public static Number getNumber(String... s)
  {
    String numberString = getString(s);
    try
    {
      numberString = numberString.trim().toUpperCase();
      return NumberFormat.getInstance().parse(numberString );
    }
    catch (Exception e)
    {
      // If any exception occurs, just return null
      return new Integer(null);
    }
  }

  // Read an int from standard system input
  public static int getInt (String... s)
  {
    return getNumber(s).intValue();
  }

  // Read a long from standard system input
  public static long getLong (String... s)
  {
    return getNumber(s).longValue();
  }

  // Read a float from standard system input
  public static float getFloat (String... s)
  {
    return getNumber(s).floatValue();
  }

  // Read a double from standard system input
  public static double getDouble (String... s)
  {
    return getNumber(s).doubleValue();
  }

  // Read a char from standard system input
  public static char getChar (String... s)
  {
    String str = getString(s);
    if (str.length() >= 1)
      return str.charAt(0);
    else
      return '\n';
  }
  
  // Reget input overloaded method
  
  public static String getString(int msg, String... s)
  {
    for (int i = 0; i < s.length; i++)
    {
      System.out.print(s[i]);
    }
    
    try
    {
      return br.readLine();
    }
    catch (Exception e)
    {
      return "";
    }
  }

  // Read a Number as a String from standard system input
  // Return the Number
  public static Number getNumber(int msg, String... s)
  {
    String numberString = getString(msg, s);
    try
    {
      numberString = numberString.trim().toUpperCase();
      return NumberFormat.getInstance().parse(numberString );
    }
    catch (Exception e)
    {
      // If any exception occurs, just return zero
      return new Integer(null);
    }
  }

  // Read an int from standard system input
  public static int getInt (int msg, String... s)
  {
    try
    {
      return getNumber(msg, s).intValue();
    }
    catch (NumberFormatException e)
    {
      errorMessage();
      return getInt(msg, s);
    }
  }

  // Read a long from standard system input
  public static long getLong (int msg, String... s)
  {
    try
    {
      return getNumber(msg, s).longValue();
    }
    catch (NumberFormatException e)
    {
      errorMessage();
      return getLong(msg, s);
    }
  }

  // Read a float from standard system input
  public static float getFloat (int msg, String... s)
  {
    try
    {
      return getNumber(msg, s).floatValue();
    }
    catch (NumberFormatException e)
    {
      errorMessage();
      return getFloat(msg, s);
    }
  }

  // Read a double from standard system input
  public static double getDouble (int msg, String... s)
  {
    try
    {
      return getNumber(msg, s).doubleValue();
    }
    catch (NumberFormatException e)
    {
      errorMessage();
      return getDouble(msg, s);
    }
  }

  // Read a char from standard system input
  public static char getChar (int msg, String... s)
  {
    String str = getString(msg, s);
    if (str.length() >= 1)
      return str.charAt(0);
    else
      return '\n';
  }
  
  public static void errorMessage()
  {
    System.out.println("\nInvalid input. Please try again.\n");
  }
}
