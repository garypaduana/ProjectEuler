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

import java.util.HashMap;
import java.util.Map;

import com.gp.projecteuler.CommonMath;
import com.gp.projecteuler.Pair;

public class Problem027 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(CommonMath.findFactors(1681));
		Map<Pair, Integer> primeCountMap = new HashMap<Pair, Integer>(); 
		for(int a = -999; a < 1000; a++){
			System.out.println(a);
			for(int b = -999; b < 1000; b++){
				primeCountMap.put(new Pair(a,b), evaluateValues(a, b));
			}
		}
		
		int max = 0;
		for(Pair p : primeCountMap.keySet()){
			if(primeCountMap.get(p) > max){
				max = primeCountMap.get(p);
				System.out.println("count: " + max + ", pair: " + p.toString() + ", product: " + p.getA() * p.getB());
			}
		}
	}
	
	public static int evaluateValues(int a, int b){
		
		int n = 0;
		while(true){
			
			int product = (n * n) + (a * n) + b;
			if(CommonMath.isPrime(product)){
				n++;
			}
			else{
				return n;
			}
		}
	}

	
}
