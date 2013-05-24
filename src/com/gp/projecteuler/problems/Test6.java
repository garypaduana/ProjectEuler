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

import java.util.ArrayList;
import java.util.List;

public class Test6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i = 0; i < 50; i++){
			System.out.println(fibonacci(i));
		}
	}

	public static long fibonacci(int n){
		List<Long> values = new ArrayList<Long>();
		values.add(0L);
		values.add(1L);
		
		for(int i = 2; i <= n; i++){
			values.add(values.get(i - 1) + values.get(i - 2));
		}
		return values.get(n);
	}
}
