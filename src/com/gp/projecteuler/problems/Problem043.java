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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gp.projecteuler.CommonMath;

/**
	The number, 1406357289, is a 0 to 9 pandigital number because it is made 
	up of each of the digits 0 to 9 in some order, but it also has a rather 
	interesting sub-string divisibility property.
	
	Let d(1) be the 1st digit, d(2) be the 2nd digit, and so on. 
	In this way, we note the following:
	
	d(2)d(3)d(4) = 406 is divisible by 2
	d(3)d(4)d(5) = 063 is divisible by 3
	d(4)d(5)d(6) = 635 is divisible by 5
	d(5)d(6)d(7) = 357 is divisible by 7
	d(6)d(7)d(8) = 572 is divisible by 11
	d(7)d(8)d(9) = 728 is divisible by 13
	d(8)d(9)d(10) = 289 is divisible by 17
	Find the sum of all 0 to 9 pandigital numbers with this property.
 */
public class Problem043 {

	// TODO: This is very inefficient, find a new approach.
	public static void main(String[] args) {
		
		Map<List<Integer>, Integer> subGroups = new HashMap<List<Integer>, Integer>();
		
		subGroups.put(Arrays.asList(new Integer[] {2, 3, 4}), 2);
		subGroups.put(Arrays.asList(new Integer[] {3, 4, 5}), 3);
		subGroups.put(Arrays.asList(new Integer[] {4, 5, 6}), 5);
		subGroups.put(Arrays.asList(new Integer[] {5, 6, 7}), 7);
		subGroups.put(Arrays.asList(new Integer[] {6, 7, 8}), 11);
		subGroups.put(Arrays.asList(new Integer[] {7, 8, 9}), 13);
		subGroups.put(Arrays.asList(new Integer[] {8, 9, 10}), 17);
		
		long sum = 0;
		
		List<String> perms = CommonMath.permutation("0123456789");

		outer:
		for(String s : perms){
			
			if(s.substring(0, 1).equals("0")){
				continue;
			}
			
			for(List<Integer> list : subGroups.keySet()){
				if(!(subNum(Long.valueOf(s), list) % subGroups.get(list) == 0)){
					continue outer;
				}
			}
			
			sum += Long.valueOf(s);
		}
		
		System.out.println("Answer: " + sum);
	}
	
	public static int subNum(long num, List<Integer> positions){
		String numStr = Long.toString(num);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i : positions){
			try{
				sb.append(String.valueOf(numStr.charAt(i - 1)));
			}
			catch(Exception e){
				System.out.println(num + ", " + positions);
			}
		}
		return Integer.valueOf(sb.toString());
	}

}
