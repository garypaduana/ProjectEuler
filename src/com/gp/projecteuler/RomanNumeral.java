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

package com.gp.projecteuler;

public class RomanNumeral {
	
	private String expression;
	private long value;
	private String optimalExpression;
	
	public enum Numeral{
		I(1), V(5), X(10),
		L(50), C(100), D(500), M(1000);
		
		private int value;
		
		private Numeral(int value){
			this.value = value;
		}
	}
	
	public RomanNumeral(String expression){
		this.expression = expression;
		value = computeValue(expression);
		optimalExpression = findOptimalExpression(value);
		
	}
	
	public static long computeValue(String expression){
		
		for(int i = 0; i < expression.length(); i++){
			Numeral.valueOf(String.valueOf(expression.charAt(i)));
			
		}
		return 0;
	}
	
	public static String findOptimalExpression(long value){
		
		return null;
	}

}
