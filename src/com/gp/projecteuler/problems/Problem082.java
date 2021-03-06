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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gp.projecteuler.CommonMath;
import com.gp.projecteuler.Location;
import com.gp.projecteuler.Node;

/**
	NOTE: This problem is a more challenging version of Problem 81.
	
	The minimal path sum in the 5 by 5 matrix below, by starting in any 
	cell in the left column and finishing in any cell in the right column, 
	and only moving up, down, and right, is indicated in red and bold; 
	the sum is equal to 994.
	
	
	131	673	234	103	18
	201	96	342	965	150
	630	803	746	422	111
	537	699	497	121	956
	805	732	524	37	331
	
	(201, 96, 342, 234, 103, 18)
	
	Find the minimal path sum, in matrix.txt (right click and 
	'Save Link/Target As...'), a 31K text file containing a 80 by 80
	 matrix, from the left column to the right column.
 */
public class Problem082 {

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		
		List<List<Long>> elements = CommonMath
				.getElementsFromFile("./resources/Problem082.txt");
		Map<Location, Node> nodes = CommonMath.buildNodeFromElements(elements);
		
		for(int row = 0; row < elements.size(); row++){
			for(int col = 0; col < elements.get(0).size(); col++){
				Location thisLocation = new Location(row, col);
				nodes.get(thisLocation).addChild(nodes.get(new Location(row - 1, col)));
				nodes.get(thisLocation).addChild(nodes.get(new Location(row + 1, col)));
				nodes.get(thisLocation).addChild(nodes.get(new Location(row, col + 1)));
			}
		}
		
		Set<Node> destinationNodeSet = new HashSet<Node>();
		for(int i = 0; i < elements.size(); i++){
			destinationNodeSet.add(nodes.get(
				new Location(i, elements.get(0).size() - 1)));
		}
		
		long shortestDistance = Long.MAX_VALUE;
		
		for(int i = 0; i < elements.size(); i ++){
			long result = CommonMath.findShortestPathDistance(
				nodes.get(new Location(i,0)),
				destinationNodeSet,
				new HashSet<Node>(nodes.values()));
			
			if(result < shortestDistance){
				shortestDistance = result;
			}
		}
		
		System.out.println("Answer: " + shortestDistance);
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}
}
