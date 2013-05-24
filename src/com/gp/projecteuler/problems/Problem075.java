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
import java.util.Map;
import java.util.TreeMap;

import com.gp.projecteuler.PythagoreanTriple;

public class Problem075 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		Map<Integer, Integer> lengthToCountMap = new TreeMap<Integer, Integer>();
		
		PythagoreanTriple pt = new PythagoreanTriple(3, 4, 5, 2000000);
		
		List<List<Integer>> tree = traversePythagoreanTripleTree(pt);
		
		for(List<Integer> branch : tree){
			int sum = 0;
			for(int i : branch){
				sum += i;
			}
				
			int i = 1;
			int multiple = 1;
			while(multiple <= 1500000){
				multiple = sum * i;
				
				if(lengthToCountMap.containsKey(multiple)){
					lengthToCountMap.put(multiple, lengthToCountMap.get(multiple) + 1);
				}
				else{
					lengthToCountMap.put(multiple, 1);
				}
				i++;
			}
		}
		
		int singleCount = 0;
		
		for(int key : lengthToCountMap.keySet()){
			if(key <= 1500000){
				if(lengthToCountMap.get(key) == 1){
					singleCount++;
				}
			}
		}
		System.out.println(singleCount + " wires have exactly one sum of pythagorean triples.");
		System.out.println(System.currentTimeMillis() - start);
	}

	public static List<List<Integer>> traversePythagoreanTripleTree(PythagoreanTriple pt){
		List<List<Integer>> allValues = new ArrayList<List<Integer>>();
		List<Integer> values = new ArrayList<Integer>();
		values.add(pt.getA());
		values.add(pt.getB());
		values.add(pt.getC());
		
		allValues.add(values);
		
		for(PythagoreanTriple child : pt.getChildren()){
			allValues.addAll(traversePythagoreanTripleTree(child));
		}
		
		return allValues;
	}
		
}

