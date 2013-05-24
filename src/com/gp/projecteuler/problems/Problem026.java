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

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

import com.gp.projecteuler.CommonMath;

public class Problem026 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> numList = new ArrayList<String>();
		BigDecimal one = new BigDecimal("1.0");
		for(BigDecimal bd = new BigDecimal("2.0"); bd.compareTo(new BigDecimal("1000.0")) < 0; bd = bd.add(new BigDecimal("1.0"))){
			numList.add(one.divide(bd, new MathContext(3000)).toString().substring(2));
		}
		
		String maxString = "";
		int maxSegment = 0;
		int number = 0;
		numLoop:
		for(String s : numList){
			s.substring(0, s.length() - 1);			
			for(int pos = 0; pos < s.length(); pos++){
				for(int segmentLength = 1; segmentLength < s.length() / 2; segmentLength++){
					if(segmentLength + pos <= s.length()){
						if(CommonMath.containsRepeatingPattern(s, s.substring(pos, pos + segmentLength), pos)){
							if(segmentLength > maxSegment){
								maxSegment = segmentLength;
								maxString = s;
								number = (int)(1.0 / Double.valueOf("0." + s));
							}
							continue numLoop;
						}
					}
				}
			}
		}
		System.out.println("Number (d): " + number + ", Number of repeating digits: " + maxSegment + ", The digits: " + maxString);
	}	
}
