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
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.gp.projecteuler.CommonMath;
import com.gp.projecteuler.FileUtil;

/**
	The nth term of the sequence of triangle numbers is given by, 
	t(n) = ½n(n+1); so the first ten triangle numbers are:
	
	1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
	
	By converting each letter in a word to a number corresponding to its 
	alphabetical position and adding these values we form a word value. 
	For example, the word value for SKY is 19 + 11 + 25 = 55 = t(10). If the
	word value is a triangle number then we shall call the word a triangle word.
	
	Using words.txt (right click and 'Save Link/Target As...'), a 16K text 
	file containing nearly two-thousand common English words, how many are
	triangle words?
 */
public class Problem042 {

	public static void main(String[] args) throws IOException {
				
		List<String> words = Arrays.asList(FileUtil.getTextFromFile(
			"./resources/Problem042.txt").get(0).split(","));
		
		Set<Long> triangleSet = new TreeSet<Long>();
		int count = 0;
		
		for(int i = 0; i < 1000; i++){
			triangleSet.add((long)(0.5 * i * (i + 1)));
		}
		
		for(String word : words){
			word = word.replace("\"", "");
			
			long wordValue = CommonMath.sumListOfNumber(
				CommonMath.charArrayToAlphaPositionList(word));
			
			if(triangleSet.contains(wordValue)){
				count++;
			}
		}
		
		System.out.println("Answer: " + count);
	}
}
