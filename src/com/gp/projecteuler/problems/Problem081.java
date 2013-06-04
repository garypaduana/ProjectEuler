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
import java.util.ArrayList;
import java.util.List;

import com.gp.projecteuler.FileUtil;

/**
	In the 5 by 5 matrix below, the minimal path sum from the top left to
	the bottom right, by only moving to the right and down, is indicated
	in bold red and is equal to 2427.
	
	
	131	673	234	103	18
	201	96	342	965	150
	630	803	746	422	111
	537	699	497	121	956
	805	732	524	37	331
	
	(131, 201, 96, 342, 746, 422, 121, 37, 331)
	
	Find the minimal path sum, in matrix.txt (right click and 
	'Save Link/Target As...'), a 31K text file containing a 80 by 80 
	matrix, from the top left to the bottom right by only moving right 
	and down.
 */
public class Problem081 {

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		
		List<String> sample = FileUtil.getTextFromFile("./resources/Problem081.txt");
		
		List<List<Long>> elements = new ArrayList<List<Long>>();
		
		for(String s : sample){
			String[] pieces = s.split(",");
			List<Long> row = new ArrayList<Long>();
			for(String piece : pieces){
				row.add(Long.valueOf(piece));
			}
			elements.add(row);
		}
		
		for(int col = 0; col < elements.get(0).size(); col++){
			for(int row = 0; row < elements.size(); row++){
				if(col == 0 && row == 0) continue;
				long previous = Long.MAX_VALUE;
				long adjacent = Long.MAX_VALUE;
				long current = elements.get(row).get(col);
				
				elements.get(row).set(col, previous + current);
				
				if(row != 0){
					previous = elements.get(row - 1).get(col);
				}
				if(col != 0){
					adjacent = elements.get(row).get(col - 1);
				}
								
				elements.get(row).set(col, (previous > adjacent ? adjacent : previous) + current);
			}
		}
		
		System.out.println("Answer: " + elements.get(elements.size() - 1)
				.get(elements.get(elements.size() - 1).size() -1));
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}
	

}
