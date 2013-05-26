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

/**
	If the numbers 1 to 5 are written out in words: one, two, three, four,
	five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
	If all the numbers from 1 to 1000 (one thousand) inclusive were written out
	in words, how many letters would be used?
	NOTE: Do not count spaces or hyphens. For example, 
	342 (three hundred and forty-two) contains 23 letters and 115 
	(one hundred and fifteen) contains 20 letters. The use of "and" when writing
	out numbers is in compliance with British usage.
 */
public class Problem017 {

	public static void main(String[] args) {
		int total = 0;
		for(int i = 1; i <= 1000; i++){
			total += findLetterCount(i);
		}
		System.out.println(total);
	}
	
	public static int findLetterCount(int num){
		StringBuilder sb = new StringBuilder();
		
		if(num == 1000){
			sb.append("one thousand");
			System.out.println(num + ", " + sb.toString());
			return sb.toString().replace(" ", "").length();
		}
		
		if(num / 100 > 0){
			sb.append(findOnes(num / 100));
			sb.append(" hundred ");
			
			if(num % 100 != 0){
				sb.append("and ");
			}
		}
		
		switch((num % 100) / 10){
		case 1:
			switch(num % 10){
				case 0:
					sb.append("ten");
					break;
				case 1:
					sb.append("eleven");
					break;
				case 2:
					sb.append("twelve");
					break;
				case 3:
					sb.append("thirteen");
					break;
				case 4:
					sb.append("fourteen");
					break;
				case 5:
					sb.append("fifteen");
					break;
				case 6:
					sb.append("sixteen");
					break;
				case 7:
					sb.append("seventeen");
					break;
				case 8:
					sb.append("eighteen");
					break;
				case 9:
					sb.append("nineteen");
					break;
				default:
					break;				
			}
			break;
			case 2:
				sb.append("twenty");
				break;
			case 3:
				sb.append("thirty");
				break;
			case 4:
				sb.append("forty");
				break;
			case 5:
				sb.append("fifty");
				break;
			case 6:
				sb.append("sixty");
				break;
			case 7:
				sb.append("seventy");
				break;
			case 8:
				sb.append("eighty");
				break;
			case 9:
				sb.append("ninety");
				break;
			default:
				break;
		}
		
		if((num % 100) / 10 != 1){
			int ones = num % 10;
			
			sb.append(findOnes(ones));
		}
		
		System.out.println(num + ", " + sb.toString());
		return sb.toString().replaceAll(" ", "").length();
	}
	
	public static String findOnes(int num){
		switch(num){
			case 1:
				return "one";
			case 2:
				return "two";
			case 3:
				return "three";
			case 4:
				return "four";
			case 5:
				return "five";
			case 6:
				return "six";
			case 7:
				return "seven";
			case 8:
				return "eight";
			case 9: 
				return "nine";
		}
		return "";
	}

}
