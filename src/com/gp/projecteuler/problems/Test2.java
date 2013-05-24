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
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gp.projecteuler.CommonMath;
import com.gp.projecteuler.Fraction;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> values = new HashSet<String>();
		
		values.addAll(CommonMath.permutation("B888888"));
		values.addAll(CommonMath.permutation("BB88888"));
		values.addAll(CommonMath.permutation("BBB8888"));
		values.addAll(CommonMath.permutation("BBBB888"));
		values.addAll(CommonMath.permutation("BBBBB88"));
		values.addAll(CommonMath.permutation("BBBBBB8"));
		values.addAll(CommonMath.permutation("BBBBBBB"));
		values.addAll(CommonMath.permutation("8888888"));
		System.out.println(values.size());
		
		StringBuffer sb = new StringBuffer();
		int i = 1;
		List<String> listStr = new ArrayList<String>(values);
		Collections.sort(listStr);
		for(String value : listStr){
			sb.append(value);
			sb.append(" ");
			if(i % 8 == 0){
				sb.append("\r\n");
				sb.append("    ");
			}
			i++;
		}
		
		System.out.println(sb.toString());
	}

}
