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

public class Test4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int places = 0; places < 10; places++){
			System.out.println("pi to " + places + ": " + String.valueOf(calculatePi(places)).substring(0, places + 2));
		}
	}
	
	public static double calculatePi(int places){
		double val = 4.0;
		double factor = 0.0;
		double lastDiff = 1.0;
		double lastFactor = 0.0;
		boolean add = true;
		long odd = 1;
		double threshold = Double.valueOf("1e-" + (places + 1));
		
		while(Math.abs(lastDiff) >= threshold){
			lastFactor = factor;
			factor += (add == true ? (1.0/odd) : (-1.0/odd));
			lastDiff = (val * factor) - (val * lastFactor);
			odd += 2;
			add = !add;
		}
		double rounder = Double.valueOf("1e" + (places));
		System.out.println(odd);
		return Math.round(rounder * val * factor) / rounder;
	}

}
