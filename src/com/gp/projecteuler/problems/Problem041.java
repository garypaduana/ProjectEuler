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

import com.gp.projecteuler.CommonMath;

/**
	We shall say that an n-digit number is pandigital if it makes use of
	all the digits 1 to n exactly once. For example, 2143 is a 4-digit
	pandigital and is also prime.
	
	What is the largest n-digit pandigital prime that exists?
 */
public class Problem041 {

	public static void main(String[] args) {
			
		List<String> perms = CommonMath.permutation("1234567");
		List<Integer> nums = new ArrayList<Integer>();
		
		for(String s : perms){
			nums.add(Integer.valueOf(s));
		}
		
		Collections.sort(nums);
		for(int i = nums.size() - 1; i >= 0; i--){
			if(CommonMath.isPrime(nums.get(i))){
				System.out.println("Answer: " + nums.get(i));
				break;
			}
		}
		
	}

}
