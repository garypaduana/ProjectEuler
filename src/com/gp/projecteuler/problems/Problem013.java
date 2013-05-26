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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
	Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.

	(numbers stored in ./resources/Problem013.txt)
*/
public class Problem013 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(new File("./resources/Problem013.txt")));
		List<BigDecimal> bdList = new ArrayList<BigDecimal>();
		
		String line = null;
		while((line = br.readLine()) != null){
		
			bdList.add(new BigDecimal(line));
		}
		
		BigDecimal sum = new BigDecimal(0);
		
		for(BigDecimal bd : bdList){
			sum = sum.add(bd);
		}
		
		System.out.println("Total sum: " + sum.toString());
		System.out.println("Answer: " + sum.toString().substring(0, 10));
	}

}
