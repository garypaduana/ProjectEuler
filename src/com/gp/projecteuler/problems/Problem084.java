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

import java.util.SortedMap;
import java.util.TreeMap;

import com.gp.projecteuler.Monopoly;
import com.gp.projecteuler.Monopoly.Square;

/**
	Long problem description, please see:
	https://projecteuler.net/problem=84
 */
public class Problem084 {

	public static void main(String[] args) {
		
		Monopoly monopoly = new Monopoly();
		int rolls = 1000000;
		
		for(int i = 0; i < rolls; i++){
			monopoly.roll();
		}
		
		SortedMap<Double, Square> results = new TreeMap<Double, Square>();
		
		for(Square s : monopoly.getSquareFrequency().keySet()){
			double percent = (double)((double)monopoly
					.getSquareFrequency().get(s) * 100.0 / (double)rolls);
			
			results.put(percent, s);
		}
		
		String answer = "";
		for(double d : results.keySet()){
			System.out.println(d + ", " + results.get(d));
			answer = (results.get(d).getIndex() + "" + answer);
			if(answer.length() >= 6){
				answer = answer.substring(0, 6);
			}
		}
		
		System.out.println("\nAnswer: " + answer);
		
	}
}
