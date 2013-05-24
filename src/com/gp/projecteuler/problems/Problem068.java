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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gp.projecteuler.CommonMath;

public class Problem068 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		List<String> perms = new ArrayList<String>();
		List<String> solutions = new ArrayList<String>();
		List<Integer> order = Arrays.asList(0,1,2,3,2,4,5,4,6,7,6,8,9,8,1);
		
		Map<String, Integer> numMap = new HashMap<String, Integer>();
		numMap.put("a", 1);
		numMap.put("b", 2);
		numMap.put("c", 3);
		numMap.put("d", 4);
		numMap.put("e", 5);
		numMap.put("f", 6);
		numMap.put("g", 7);
		numMap.put("h", 8);
		numMap.put("i", 9);
		numMap.put("j", 10);
		
		perms.addAll(CommonMath.permutation("abcdefghij"));
		for(String perm : perms){
			List<Integer> values = convertStringToIntegerListWithMap(numMap, perm);
			int thisSum = values.get(0) + values.get(1) + values.get(2);
			//if(!validSums.contains(thisSum)) continue outer;
			if(values.get(0) + values.get(1) + values.get(2) == thisSum){
				if(values.get(3) + values.get(2) + values.get(4) == thisSum){
					if(values.get(5) + values.get(4) + values.get(6) == thisSum){
						if(values.get(7) + values.get(6) + values.get(8) == thisSum){
							if(values.get(9) + values.get(8) + values.get(1) == thisSum){
								
								int min = 12;
								int minLocation = -1;
								
								for(int i : Arrays.asList(0,3,5,7,9)){
									if(values.get(i) < min){
										min = values.get(i);
										minLocation = i;
									}
								}
								
								StringBuffer sb = new StringBuffer();
								for(int i = order.indexOf(minLocation); i < order.size(); i++){
									sb.append(Integer.toString(values.get(order.get(i))));
								}
								for(int i = 0; i < order.indexOf(minLocation); i++){
									sb.append(Integer.toString(values.get(order.get(i))));
								}
								solutions.add(sb.toString());
							}
						}
					}
				}
			}
		}
		
		long max16 = 0;
		for(String solution : solutions){
			//System.out.println(solution);
			if(solution.length() == 16){
				long val = Long.valueOf(solution);
				if(val > max16) max16 = val;
			}
		}
		
		System.out.println(max16);
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}

	public static List<Integer> convertStringToIntegerListWithMap(Map<String, Integer> map, String s){
		List<Integer> numbers = new ArrayList<Integer>();
		
		for(char c : s.toCharArray()){
			numbers.add(map.get(String.valueOf(c)));
		}
		
		return numbers;
	}
}
