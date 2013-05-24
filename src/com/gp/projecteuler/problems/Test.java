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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.gp.projecteuler.CommonMath;

public class Test {

//	/**
//	 * @param args
//	 * @throws IOException 
//	 */
//	public static void main(String[] args) throws IOException {
//
//		BufferedWriter bw = null;
//		try{
//			bw = new BufferedWriter(new FileWriter(new File("./resources/primeFactors.txt"), true));
//			Set<Long> primes = new TreeSet<Long>(CommonMath.findPrimesUnder(1000001));
//			for(int i = 1000000; i <= 1000000; i++){
//				StringBuilder sb = new StringBuilder();
//				Set<Long> factors = CommonMath.findDistinctPrimeFactors(i, primes);
//				for(long factor : factors){
//					sb.append(factor + ",");
//				}
//				if(sb.length() > 0){
//					sb.delete(sb.length() - 1, sb.length());
//				}
//				
//				bw.append(i + ";" + sb.toString() + "\r\n");
//				sb.setLength(0);
//			}
//		}
//		finally{
//			if(bw != null){
//				bw.close();
//			}
//		}
//	}
	
	public static void main(String[] args) {
		System.out.println("blah");
		for(int i = 0; i < 100; i++){
			System.out.println(fibonacci(i));
		}
	}

	public static long fibonacci(int n){
		List<Long> values = new ArrayList<Long>();
		values.add(0L);
		values.add(1L);
		long sum = 0;
		
		for(int i = 2; i <= n; i++){
			long val = values.get(i - 1) + values.get(i - 2);	
			values.add(val);
			sum += val;
		}
		return sum;
	}

}
