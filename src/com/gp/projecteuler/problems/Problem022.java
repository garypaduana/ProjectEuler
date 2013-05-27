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
import java.util.Collections;
import java.util.List;

import com.gp.projecteuler.CommonMath;
import com.gp.projecteuler.FileUtil;

/**
	Using names.txt (right click and 'Save Link/Target As...'), a 46K text file
	containing over five-thousand first names, begin by sorting it into 
	alphabetical order. Then working out the alphabetical value for each name, 
	multiply this value by its alphabetical position in the list to obtain a
	name score. For example, when the list is sorted into alphabetical order,
	COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the
	list. So, COLIN would obtain a score of 938  53 = 49714.  What is the total
	of all the name scores in the file?
 */
public class Problem022 {

	public static void main(String[] args) throws IOException {
		
		List<String> names = new ArrayList<String>();
		List<String> text = FileUtil.getTextFromFile("./resources/Problem022.txt");
		
		for(String line : text){
			String[] pieces = line.split(",");
			for(String piece : pieces){
				names.add(piece.replaceAll("\"", ""));
			}
		}
		
		Collections.sort(names);
		long sum = 0;
		for(int i = 0; i < names.size(); i++){
			sum += CommonMath.sumListOfNumber(
				CommonMath.charArrayToAlphaPositionList(names.get(i))) * (i + 1);
		}
		
		System.out.println("Answer: " + sum);
	}
}
