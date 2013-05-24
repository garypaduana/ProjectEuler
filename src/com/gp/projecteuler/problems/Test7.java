/*
    Project Euler Solutions
    Copyright (C) 2012-2013, Gary Paduana, gary.paduana@gmail.com
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.gp.projecteuler.problems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test7 {

	public static void main (String args []){
        String ssnum;
        Scanner sc = new Scanner(System.in);
        while(true){
             System.out.print("Please enter your Social Security number, type quit or stop to exit \r\n");
             ssnum = sc.nextLine();
             if (ssnum.equalsIgnoreCase("quit") || ssnum.equalsIgnoreCase("stop")) break;

             char c;

             if (! (11 == ssnum.length())){
               System.err.println( " invalid amount of digit");
               continue;
             }
             int digitCount = 0;
             int dashCount = 0;
             for(int i = 0; i < ssnum.length(); i++){
                 c = ssnum.charAt(i);

                 if(!Character.isDigit(c)){
                     System.err.println( c + " is not a digit");
                 }
                 else{
                	 digitCount++;
                 }
                 
                 if(c != '-'){
                     System.err.println( c + " is not a dash");
                 }
                 else{
                	 dashCount++;
                 }
             }
             
             if(digitCount != 9 && dashCount != 2){
            	 System.err.println("invalid amount of numbers and dashes");
             }
       } 
  }
}
