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
import java.util.List;

import com.gp.projecteuler.CommonMath;
import com.gp.projecteuler.*;
import com.gp.projecteuler.Point.Type;


public class Problem102 {

	public static void main(String[] args) throws IOException {
		
		Point origin = new Point(0.0f, 0.0f, 0.0f);
		int originInsideCount = 0;
		
		List<String> values = FileUtil.getTextFromFile("./resources/triangles.txt");
		
		for(String line : values){
			List<Point> points = new ArrayList<Point>();
			String[] pieces = line.split(",");
			Point a = new Point(Float.valueOf(pieces[0]), Float.valueOf(pieces[1]), 0f);
			Point b = new Point(Float.valueOf(pieces[2]), Float.valueOf(pieces[3]), 0f);
			Point c = new Point(Float.valueOf(pieces[4]), Float.valueOf(pieces[5]), 0f);
			
			points.add(a);
			points.add(b);
			points.add(c);
			points.add(origin);
			
			List<List<Point>> edges = CommonMath.findEdges(
					points, CommonMath.findCentroid(points), Type.DIMEN);

			boolean originInside = true;
			for(List<Point> edge : edges){
				if(edge.contains(origin)){
					originInside = false;
				}
			}
			
			if(originInside){
				originInsideCount++;
			}
		}
		
		System.out.println(originInsideCount);
	}
}
