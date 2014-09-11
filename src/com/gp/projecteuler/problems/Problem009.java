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

/**
 * A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Problem009 {

	public static void main(String[] args) {
		long start = System.nanoTime();
		outer:
		for(int a = 1; a < 1000; a++){
			for(int b = 1; b < 1000; b++){
				int c = 1000 - a - b;
				if((c * c) != (a * a + b * b)){
					continue;
				}
				
				long end = System.nanoTime();
				System.out.println("a: " + a + ", b: " + b + ", c: " + c + ", product: " + (a * b * c));
				System.out.println("Answer: " + (a * b * c) + ", " + (end - start) / 1e6 + "ms");
				break outer;
			}
		}
	}

}
