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
import java.util.Set;
import java.util.TreeSet;

import com.gp.projecteuler.CommonMath;

/**
	It is possible to write ten as the sum of primes in exactly five 
	different ways:
	
	7 + 3
	5 + 5
	5 + 3 + 2
	3 + 3 + 2 + 2
	2 + 2 + 2 + 2 + 2
	
	What is the first value which can be written as the sum of primes in 
	over five thousand different ways?
 */
public class Problem077 {

	public static void main(String[] args) {
		
		Set<Long> primes = new TreeSet<Long>(CommonMath.findPrimesUnder(100000));
		
		List<List<Long>> partitions = new ArrayList<List<Long>>();
		long i = 0;
		long primeOnlyPartitions = 0;
		while(primeOnlyPartitions <= 5000){
			i++;
			partitions.clear();
			partitions.addAll(CommonMath.partitionVerboseWithRecursion(i));
			
			
			if(partitions.size() < 5000){
				continue;
			}
			primeOnlyPartitions = 0;
			
			listLoop:
			for(List<Long> list : partitions){
				for(long n : list){
					if(!primes.contains(n)){
						continue listLoop;
					}
				}
				primeOnlyPartitions++;
			}
		}
		System.out.println("Answer: " + i + ", prime only partitions: " + 
			primeOnlyPartitions);
	}
}
