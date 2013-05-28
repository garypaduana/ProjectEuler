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

import java.util.ArrayList;
import java.util.List;

/**
	In England the currency is made up of pound, £, and pence, p, and there
	are eight coins in general circulation:
	
	1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
	It is possible to make £2 in the following way:
	
	1£1 + 150p + 220p + 15p + 12p + 31p
	How many different ways can £2 be made using any number of coins?
 */
public class Problem031 {

	/**
	 * TODO: Solve! Currently incomplete.
	 */
	public static void main(String[] args) {
		//CommonMath.partitionVerboseWithRecursion(n);
	}
	
	/**
	 * Creates a List of List of Long that contains all of the different ways positive whole numbers
	 * can be summed to the number n.
	 * @param n
	 * @return
	 */
//	public static List<List<Long>> partitionVerboseWithRecursion(long n){
//		return partitionVerboseWithRecursion(n, n, "");
//	}
	
	/**
	 * Creates a List of List of Long that contains all of the different ways positive whole numbers
	 * can be summed to the number n.
	 * @param n
	 * @param max
	 * @param prefix
	 * @return
	 */
	public static List<List<Long>> partitionVerboseWithRecursion(long n, long max, String prefix,
		List<Long> increments){
		
		List<List<Long>> masterList = new ArrayList<List<Long>>();
		if(n == 0){
			String[] pieces = prefix.split(" ");
			List<Long> list = new ArrayList<Long>();
			
			for(String s : pieces){
				if(s.length() == 0) continue;
				list.add(Long.valueOf(s));
			}
			masterList.add(list);
			
			return masterList;
		}
		
		for(long i = Math.min(max, n); i >= 1; i--){
			//masterList.addAll(partitionVerboseWithRecursion(n-i, i, prefix + " " + i));
		}
		
		return masterList;
	}

}
