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

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.gp.projecteuler.FileUtil;

public class Problem073 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		long start = System.currentTimeMillis();
		
		List<String> primeFactors = FileUtil.getTextFromFile("./resources/primeFactors.txt");
		Set<Double> datSet = new TreeSet<Double>();
		for(String s : primeFactors){
			
			if(s.contains("12001;"))break;
			
			String[] pieces = s.split(";");
			long num = Long.valueOf(pieces[0]);
			if(num % 100 == 0){
				System.out.println(num);
			}
			//List<Long> factors = CommonMath.convertList(Arrays.asList(pieces[1].split(",")));
			
			for(int n = (int)((double)num * 1.0/3.0); ((double)n / (double)num) < 1.0/2.0; n++){
				
				double val = (double)n / (double)num;
				
				if(val < 1.0/2.0 && val > 1.0/3.0){
					datSet.add(val);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(double d : datSet){
			sb.append(Double.toString(d));
			sb.append("\r\n");
			
			if(sb.length() > 100000){
				FileUtil.writeTextToFile("./resources/problem073.txt", sb.toString(), true);
				sb.setLength(0);
			}
			
		}
		FileUtil.writeTextToFile("./resources/problem073.txt", sb.toString(), true);
		
		System.out.println(datSet.size());
		System.out.println((System.currentTimeMillis() - start) + " ms");
	}

}
