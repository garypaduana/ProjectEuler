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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem025 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<BigInteger> fibList = new ArrayList<BigInteger>();
		
		fibList.add(BigInteger.valueOf(1));
		
		for(int i = 0; i < 6000; i++){
			if(i > 0){
				fibList.add(fibList.get(i).add(fibList.get(i - 1)));
			}
			else{
				fibList.add(BigInteger.valueOf(1));
			}
		}
		
		for(int i = 0; i < fibList.size(); i++){
			if(fibList.get(i).toString().length() == 1000){
				System.out.println((i + 1) + ", " + fibList.get(i).toString().length() + ", " + fibList.get(i).toString());
			}
			
		}
	}

}
