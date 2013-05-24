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

public class Problem077 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Set<Long> primes = new TreeSet<Long>(CommonMath.findPrimesUnder(100000));
		
		for(long i = 0; i < 100; i++){
			List<List<Long>> partitions = CommonMath.partitionVerboseWithRecursion(i);
			
			if(partitions.size() < 5000) continue;
			
			long primeOnlyPartitions = 0;
			listLoop:
			for(List<Long> list : partitions){
				for(long n : list){
					if(!primes.contains(n)){
						continue listLoop;
					}
				}
				primeOnlyPartitions++;
			}
			System.out.println(i + ": " + primeOnlyPartitions + " / " + partitions.size());
		}
	}
	
	
	public static void partition(int n) {
        partition(n, n, "");
    }
    public static void partition(int n, int max, String prefix) {
    	if (n == 0) {
            System.out.println(prefix);
            return;
        }
  
        for (int i = Math.min(max, n); i >= 1; i--) {
            partition(n-i, i, prefix + " " + i);
        }
    }

}
