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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gp.projecteuler.CommonMath;

public class Problem061 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		List<List<Integer>> numbers = new ArrayList<List<Integer>>();
		
		List<Integer> triangle = new ArrayList<Integer>();
		List<Integer> square = new ArrayList<Integer>();
		List<Integer> pentagonal = new ArrayList<Integer>();
		List<Integer> hexagonal = new ArrayList<Integer>();
		List<Integer> heptagonal = new ArrayList<Integer>();
		List<Integer> octagonal = new ArrayList<Integer>();
		
		for(int i = 0; i < 1000; i++){
			int tri = i * (i + 1) / 2;
			int sq = i * i;
			int pent = i * (3 * i - 1) / 2;
			int hex = i * (2 * i - 1);
			int hept = i * (i * 5 - 3) / 2;
			int oct = i * (3 * i - 2);
			
			if(tri >= 1000 && tri <= 9999) triangle.add(tri);
			if(sq >= 1000 && sq <= 9999) square.add(sq);
			if(pent >= 1000 && pent <= 9999) pentagonal.add(pent);
			if(hex >= 1000 && hex <= 9999) hexagonal.add(hex);
			if(hept >= 1000 && hept <= 9999) heptagonal.add(hept);
			if(oct >= 1000 && oct <= 9999) octagonal.add(oct);
		}
		
		numbers.add(triangle);
		numbers.add(square);
		numbers.add(pentagonal);
		numbers.add(hexagonal);
		numbers.add(heptagonal);
		numbers.add(octagonal);
		
		Map<String, List<Integer>> abbList = new HashMap<String, List<Integer>>();
		abbList.put("t", triangle);
		abbList.put("s", square);
		abbList.put("p", pentagonal);
		abbList.put("x", hexagonal);
		abbList.put("h", heptagonal);
		abbList.put("o", octagonal);
		
		List<String> perms = CommonMath.permutation("tspxho");
		
		outer:
		for(String perm : perms){
			for(int a : abbList.get(String.valueOf(perm.charAt(0)))){
				for(int b : abbList.get(String.valueOf(perm.charAt(1)))){
					if(!(a % 100 == b / 100)) continue;					
					for(int c : abbList.get(String.valueOf(perm.charAt(2)))){
						if(!(b % 100 == c / 100)) continue;
						for(int d : abbList.get(String.valueOf(perm.charAt(3)))){
							if(!(c % 100 == d / 100)) continue;
							for(int e : abbList.get(String.valueOf(perm.charAt(4)))){
								if(!(d % 100 == e / 100)) continue;
								for(int f : abbList.get(String.valueOf(perm.charAt(5)))){
									if(!(e % 100 == f / 100)) continue;
									if(!(f % 100 == a / 100)) continue;
									System.out.println(a + " + " + b + " + " + c + " + " + d + " + " + e + " + " + f + " = " + (a + b + c + d + e + f));
									break outer;
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(System.currentTimeMillis() - start);
	}
}
