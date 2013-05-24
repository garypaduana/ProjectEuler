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

import com.gp.projecteuler.CommonMath;

public class Problem074 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		int sixtyCount = 0;
		List<Long> chain = new ArrayList<Long>();
		long num = 0;
		for(long i = 0; i < 1000000; i++){
			if(i % 10000 == 0){
				System.out.println(i + ", " + sixtyCount);
				
			}
			num = i;
			while(!chain.contains(num)){
				chain.add(num);
				num = factorialSumOfDigits(num);
			}
			
			if(chain.size() == 60){
				sixtyCount++;
			}
			chain.clear();
		}
		
		System.out.println(sixtyCount);
		System.out.println(System.currentTimeMillis() - start);
	}
	
	public static long factorialSumOfDigits(long num){
		long sum = 0;
		String s = Long.toString(num);
		
		for(char c : s.toCharArray()){
			sum += CommonMath.factorial(Long.valueOf(String.valueOf(c)));
		}
		return sum;
	}

}
