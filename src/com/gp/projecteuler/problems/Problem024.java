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

import java.util.Collections;
import java.util.List;

import com.gp.projecteuler.CommonMath;

public class Problem024 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		List<Integer> permutationList = new ArrayList<Integer>();
//		String exp = "0123";	
//		
//		int swapPos = exp.length() - 1;
//		
//		while(!permutationList.contains(Integer.valueOf(exp))){
//				
//			permutationList.add(Integer.valueOf(exp));
//			
//			if(swapPos == 0 ){
//				char temp = exp.charAt(swapPos);
//				exp = exp.replace(exp.charAt(swapPos), exp.charAt(exp.length() - 1));
//				exp = exp.substring(0, exp.length() - 1) + temp;
//				swapPos = exp.length() - 1;
//				continue;
//			}
//			else{
//				char temp = exp.charAt(swapPos - 1);
//				exp = exp.replace(exp.charAt(swapPos - 1), exp.charAt(swapPos));
//				exp = exp.substring(0, swapPos) + temp + exp.substring(swapPos + 1, exp.length());
//			}
//			
//			swapPos--;			
//		}
//				
//		Collections.sort(permutationList);
//		System.out.println(permutationList);
//		System.out.println(permutationList.size());
		
		List<String> permutationList = CommonMath.permutation("0123456789");
		
		Collections.sort(permutationList);
		
		System.out.println(permutationList.get(999999));
		
	}
	
	
}
