/* Author(s) Asalan Andany
 * Description: This class exists to make reading, writing, overwriting and printing (to standard output) files easier
 */

package com.chess_game;

import java.io.*;
import java.util.*;

public class File
{
  //read a file
  public static String[] read(String file_name)
  {
    try
    {
      FileReader f = new FileReader(file_name);
      BufferedReader br = new BufferedReader(f);
      
      ArrayList<String> list = new ArrayList<String>();
      
      String line = br.readLine();
      while (line != null)
      {
        list.add(line);
        line = br.readLine();
      }
      
      br.close();
      String[] s = list.toArray(new String[0]);
      return s;
    }
    catch (Exception e)
    {
      System.out.println("\nFile Not Found\n");
      String [] failed = new String[1];
      failed [0] = String.valueOf(e);
      return failed;
    }
   }
  
  //print the file to standard output
  public static void print(String[] file)
  {
    for (int i = 0; i < file.length; i++)
    {
      System.out.print(file[i]);
    }
  }
  
  //print the file to standard output
  public static void println(String[] file)
  {
    for (int i = 0; i < file.length; i++)
    {
      System.out.println(file[i]);
    }
  }
  
  //overwrite to file
  public static void overwrite(String file_name)
  {
    try
    {
      PrintWriter out = new PrintWriter(new FileWriter(file_name));
      //out.println();
      out.close();
    }
    catch (Exception e)
    {
      System.out.println("\nSomething went wrong :(\n");
      System.out.println(e);
    }
  }
  
  //write to a file
  public static void write(String file_name, String[] to_write)
  {
    try
    {
      PrintWriter out = new PrintWriter(new FileWriter(file_name, true));
      for (int i =0; i < to_write.length; i++)
        out.print(to_write[i]);
      out.close();
    }
    catch (Exception e)
    {
      System.out.println("\nSomething went wrong :(\n");
      System.out.println(e);
    }
  }
  
  //write to a file
  public static void write(String file_name, String to_write)
  {
    try
    {
      PrintWriter out = new PrintWriter(new FileWriter(file_name, true));
      out.print(to_write);
      out.close();
    }
    catch (Exception e)
    {
      System.out.println("\nSomething went wrong :(\n");
      System.out.println(e);
    }
  }
  
  //write to a file
  public static void writeln(String file_name, String[] to_write)
  {
    try
    {
      PrintWriter out = new PrintWriter(new FileWriter(file_name, true));
      for (int i =0; i < to_write.length; i++)
      {
        out.println(to_write[i]);
      }
      out.close();
    }
    catch (Exception e)
    {
      System.out.println("\nSomething went wrong :(\n");
      System.out.println(e);
    }
  }
  
  //write to a file
  public static void writeln(String file_name, String to_write)
  {
    try
    {
      PrintWriter out = new PrintWriter(new FileWriter(file_name, true));
      out.println(to_write);
      out.close();
    }
    catch (Exception e)
    {
      System.out.println("\nSomething went wrong :(\n");
      System.out.println(e);
    }
  }
}