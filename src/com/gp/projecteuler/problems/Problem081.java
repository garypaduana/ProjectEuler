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

public class Problem081 {

	/**
	 * @param args
	 * @throws IOException 
	 */
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
		
		System.out.println(elements.get(elements.size() - 1).get(elements.get(elements.size() - 1).size() -1));
		System.out.println(System.currentTimeMillis() - start);
	}
	

}
