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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gp.projecteuler.CommonMath;

public class Problem043 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Map<List<Integer>, Integer> subGroups = new HashMap<List<Integer>, Integer>();
		
		subGroups.put(Arrays.asList(new Integer[] {2, 3, 4}), 2);
		subGroups.put(Arrays.asList(new Integer[] {3, 4, 5}), 3);
		subGroups.put(Arrays.asList(new Integer[] {4, 5, 6}), 5);
		subGroups.put(Arrays.asList(new Integer[] {5, 6, 7}), 7);
		subGroups.put(Arrays.asList(new Integer[] {6, 7, 8}), 11);
		subGroups.put(Arrays.asList(new Integer[] {7, 8, 9}), 13);
		subGroups.put(Arrays.asList(new Integer[] {8, 9, 10}), 17);
		
		long sum = 0;
		long start = System.currentTimeMillis();
		outer:
		for(long i = 1234567890; i <= 9876543210L; i++){
			
			if(i % 100000000 == 0){
				System.out.println(i + ": " + (System.currentTimeMillis() - start));
				start = System.currentTimeMillis();
			}
			
			if(i == 1406357289){
				System.out.println("1406357289 isPandigital? " + CommonMath.isPandigital(Arrays.asList(new Long[]{i}), 0, 9));
			}
			
//			if((i % 10000000 / 1000000 % 2 != 0)){
//				continue outer;
//			}
			if(!(i % 100000 / 10000 == 0 || i % 100000 / 10000 == 5)){
				continue outer;
			}
			
			for(List<Integer> list : subGroups.keySet()){
				if(!(subNum(i, list) % subGroups.get(list) == 0)){
					continue outer;
				}
			}
			
			if(!CommonMath.isPandigital(Arrays.asList(new Long[]{i}), 0, 9)){
				continue outer;
			}
			
			System.out.println(i);
			sum += i;
		}
		
		System.out.println(sum);
	}
	
	public static int subNum(long num, List<Integer> positions){
		String numStr = Long.toString(num);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i : positions){
			sb.append(String.valueOf(numStr.charAt(i - 1)));
		}
		return Integer.valueOf(sb.toString());
	}

}
