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

import com.gp.projecteuler.FileUtil;
import com.gp.projecteuler.PokerHand;

public class Problem054 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		List<String> deals = FileUtil.getTextFromFile("./resources/Problem054.txt");
		int player1Wins = 0;
		for(String deal : deals){
			
			String[] cards = deal.split(" ");

			PokerHand ph1 = new PokerHand(Arrays.asList(cards).subList(0, 5));
			PokerHand ph2 = new PokerHand(Arrays.asList(cards).subList(5, 10));
			
			if(ph1.compareTo(ph2) == 1){
				player1Wins++;
			}
		}
		System.out.println(player1Wins);
		System.out.println(System.currentTimeMillis() - start);
	}

}
