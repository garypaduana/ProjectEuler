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
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.gp.projecteuler.CommonMath;

/**
	By replacing the 1st digit of the 2-digit number *3, it turns out that
	six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.
	
	By replacing the 3rd and 4th digits of 56**3 with the same digit, this
	5-digit number is the first example having seven primes among the ten 
	generated numbers, yielding the family: 56003, 56113, 56333, 56443, 
	56663, 56773, and 56993. Consequently 56003, being the first member 
	of this family, is the smallest prime with this property.
	
	Find the smallest prime which, by replacing part of the number 
	(not necessarily adjacent digits) with the same digit, is part of 
	an eight prime value family.
 */
public class Problem051 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		Set<Long> primes = new TreeSet<Long>();
		for(long i = 1; i < 1000000; i++){
			if(CommonMath.isPrime(i)){
				primes.add(i);
			}
		}
		
		outer:
		for(int starCount = 1; starCount <= 5; starCount++){
			List<Long> validPrimes = new ArrayList<Long>();
			
			for(int i = 0; i < 1000; i++){
				String numStr = Integer.toString(i) + getSymbol("*", starCount);
				List<String> perms = CommonMath.permutation(numStr);
				
				for(String perm : perms){
					validPrimes.clear();
					for(int p = 0; p <= 9; p++){
						
						// Skip over numbers that start with leading 0
						if((perm.indexOf("*") == 0 && p == 0) ||
								perm.indexOf("0") == 0 ){
							continue;
						}
						
						int candidate = Integer.valueOf(
								perm.replaceAll("\\*", Integer.toString(p)));
						if(primes.contains((long)candidate)){
							validPrimes.add((long)candidate);
						}
						if(validPrimes.size() == 8){
							Collections.sort(validPrimes);
							System.out.println("Answer: " + validPrimes.get(0));
							break outer;
						}
					}
				}			
			}
		}
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}
	
	public static String getSymbol(String symbol, int count){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < count; i++){
			sb.append(symbol);
		}
		return sb.toString();
	}

}
