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

public class Problem007 {

	/**
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that
	 * the 6th prime is 13.
	 * What is the 10 001st prime number?
	 */
	public static void main(String[] args) {
		
		List<Integer> primeList = new ArrayList<Integer>();
		int num = 2;
		while(primeList.size() < 10001){
			if(CommonMath.isPrime(num)){
				primeList.add(num);
			}
			num++;
		}
		System.out.println(primeList.get(primeList.size() - 1));
	}

}
