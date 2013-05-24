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

public class Problem087 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Long> primes = CommonMath.findPrimesUnder(7100);
		Set<Long> products = new TreeSet<Long>();
		long upper = 50000000;

		iLoop:
		for(int i = 0; i < primes.size(); i++){
			
			jLoop:
			for(int j = 0; j < primes.size(); j++){
				if(pow(j, 3) > upper) continue iLoop;

				for(int k = 0; k < primes.size(); k++){
					if(pow(k, 4) > upper) continue jLoop;
					
					long product = pow(primes.get(i), 2) + pow(primes.get(j), 3) + pow(primes.get(k), 4);
					
					if(product <= upper){
						products.add(product);
					}
				}
			}
		}
		
		System.out.println(products.size());
	}

	public static long pow(long num, long power){
		if(power < 0){
			throw new IllegalArgumentException("Power is less than zero!");
		}
		long product = 1;
		for(int i = 0; i < power; i++){
			product *= num;
		}
		return product;
	}
}
