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
import java.util.Set;
import java.util.TreeSet;

import com.gp.projecteuler.CommonMath;

public class Problem029 {

	public static void main(String[] args) {
		Set<BigInteger> set = new TreeSet<BigInteger>();
		
		for(int a = 2; a <= 100; a++){
			for(int b = 2; b <= 100; b++){
				set.add(CommonMath.pow(BigInteger.valueOf(a), BigInteger.valueOf(b)));
			}
		}
		
		System.out.println(set.size());
	}
	
	
}