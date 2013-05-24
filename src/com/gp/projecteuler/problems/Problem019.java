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

import java.util.Calendar;

public class Problem019 {

	/**
	 * You are given the following information, but you may prefer to do some research for yourself.

		1 Jan 1900 was a Monday.
		Thirty days has September,
		April, June and November.
		All the rest have thirty-one,
		Saving February alone,
		Which has twenty-eight, rain or shine.
		And on leap years, twenty-nine.
		A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
		How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
	 */
	public static void main(String[] args) {
		
		
		Calendar cal = Calendar.getInstance();
		
		cal.clear();
		cal.set(Calendar.YEAR, 2000);
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		
		long endTime = cal.getTimeInMillis();
		cal.clear();
		cal.set(Calendar.YEAR, 1901);
		long beginTime = cal.getTimeInMillis();
		
		int sundayFirstCount = 0;
		for(long t = beginTime; t <= endTime; t += 86400000){
			cal.add(Calendar.MILLISECOND, 86400000);
			if(cal.get(Calendar.DAY_OF_MONTH) == 1 && cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
				System.out.println(cal.getTime());
				sundayFirstCount++;
			}
		}
		
		System.out.println(sundayFirstCount);
	}

}
