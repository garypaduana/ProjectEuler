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

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.gp.projecteuler.CommonMath;

public class Problem051 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<Long> primes = new TreeSet<Long>();
		for(long i = 1; i < 1000000; i++){
			if(CommonMath.isPrime(i)){
				primes.add(i);
			}
		}
		long start = System.currentTimeMillis();
		outer:
		for(int starCount = 1; starCount <= 5; starCount++){
			System.out.println(starCount);
			for(int i = 0; i < 1000; i++){
				String numStr = Integer.toString(i) + getSymbol("*", starCount);
				List<String> perms = CommonMath.permutation(numStr);
				
				for(String perm : perms){
					int primeCount = 0;
					for(int p = 0; p <= 9; p++){
						if((perm.indexOf("*") == 0 && p == 0) || perm.indexOf("0") == 0 ){
							continue;
						}
						int candidate = Integer.valueOf(perm.replaceAll("\\*", Integer.toString(p)));
						if(primes.contains((long)candidate)){
							primeCount++;
						}
						if(primeCount == 8){
							System.out.println(perm);
							break outer;
						}
					}
				}			
			}
		}
		System.out.println((System.currentTimeMillis() - start) + "ms");
	}
	
	public static String getSymbol(String symbol, int count){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < count; i++){
			sb.append(symbol);
		}
		return sb.toString();
	}

}
