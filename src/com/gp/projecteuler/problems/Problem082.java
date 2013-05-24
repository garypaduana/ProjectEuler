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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.gp.projecteuler.CommonMath;
import com.gp.projecteuler.FileUtil;
import com.gp.projecteuler.Node;
import com.gp.projecteuler.Location;

public class Problem082 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		
		List<String> sample = FileUtil.getTextFromFile("./resources/Problem083.txt");
		
		List<List<Long>> elements = new ArrayList<List<Long>>();
		
		for(String s : sample){
			String[] pieces = s.split(",");
			List<Long> row = new ArrayList<Long>();
			for(String piece : pieces){
				row.add(Long.valueOf(piece));
			}
			elements.add(row);
		}
		
		Map<Integer, Integer> rowToDistanceMap = new TreeMap<Integer, Integer>();
		Map<Location, Node> nodes = new HashMap<Location, Node>();
		
		for(int row = 0; row < elements.size(); row++){
			for(int col = 0; col < elements.get(0).size(); col++){
				Location loc = new Location(row, col);
				nodes.put(loc, new Node(elements.get(row).get(col), loc));
			}
		}
		
		for(int row = 0; row < elements.size(); row++){
			for(int col = 0; col < elements.get(0).size(); col++){
				Location thisLocation = new Location(row, col);
				nodes.get(thisLocation).addChild(nodes.get(new Location(row - 1, col)));
				nodes.get(thisLocation).addChild(nodes.get(new Location(row + 1, col)));
				nodes.get(thisLocation).addChild(nodes.get(new Location(row, col + 1)));
				
				// Remove this line to solve problem 82
				// also need to change the destination set
				nodes.get(thisLocation).addChild(nodes.get(new Location(row, col - 1)));
			}
		}
		
		Set<Node> destinationNodeSet = new HashSet<Node>();
		for(int i = 0; i < elements.size(); i++){
			destinationNodeSet.add(nodes.get(new Location(i, elements.get(0).size() - 1)));
		}
		
		System.out.println(CommonMath.findShortestPathDistance(nodes.get(new Location(0,0)), new HashSet<Node>(Arrays.asList(nodes.get(new Location(79,79)))), new HashSet<Node>(nodes.values())));
		System.out.println(System.currentTimeMillis() - start);
	}
}
