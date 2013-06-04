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

import com.gp.projecteuler.CommonMath;

/**
	Let p(n) represent the number of different ways in which n coins can be
	separated into piles. For example, five coins can separated into piles
	in exactly seven different ways, so p(5)=7.
	
	OOOOO
	OOOO   O
	OOO   OO
	OOO   O   O
	OO   OO   O
	OO   O   O   O
	O   O   O   O   O
	Find the least value of n for which p(n) is divisible by one million.
 */
public class Problem078 {

	public static void main(String[] args) {
		CommonMath cm = new CommonMath();
				
		for(int i = 1; i < 100000; i++){
			BigInteger value = cm.partitionsFinite(i);
			if(value.remainder(CommonMath.ONE_MILLION).equals(new BigInteger("0"))){
				System.out.println("Answer: " + i);
				break;
			}
		}
	}
}
