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

import com.gp.projecteuler.FileUtil;
import com.gp.projecteuler.Node;

/**
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

		3
		7 4
		2 4 6
		8 5 9 3
		
		That is, 3 + 7 + 4 + 9 = 23.
		
		Find the maximum total from top to bottom of the triangle below:
		
		75
		95 64
		17 47 82
		18 35 87 10
		20 04 82 47 65
		19 01 23 75 03 34
		88 02 77 73 07 63 67
		99 65 04 28 06 16 70 92
		41 41 26 56 83 40 80 70 33
		41 48 72 33 47 32 37 16 94 29
		53 71 44 65 25 43 91 52 97 51 14
		70 11 33 28 77 73 17 78 39 68 17 57
		91 71 52 38 17 14 91 43 58 50 27 29 48
		63 66 04 68 89 53 67 30 73 16 69 87 40 31
		04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

		NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route.
 		However, Problem 67, is the same challenge with a triangle containing one-hundred rows;
 		it cannot be solved by brute force, and requires a clever method! ;o)
 * @author asus
 *
 */
public class Problem018 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		List<String> lines = FileUtil.getTextFromFile("./resources/Problem067.txt");
//		Node root = getRootNode(lines);
//		root.setTentativeWeight(0);
//		
//		Node currentNode = root;
		
		List<List<Integer>> values = new ArrayList<List<Integer>>();
		for(String s : lines){
			List<Integer> row = new ArrayList<Integer>();
			String[] pieces = s.split(" ");
			
			for(String num : pieces){
				row.add(Integer.valueOf(num));
			}
			values.add(row);			
		}
		
		for(List<Integer> l : values){
			System.out.println(l);
		}
		
		System.out.println("###############################");
		
		for(int i = lines.size() - 1; i > 0; i--){
			for(int x = 0; x < values.get(i - 1).size(); x++){
				int greaterValue = values.get(i).get(x) > values.get(i).get(x+1) ? values.get(i).get(x) : values.get(i).get(x+1);
				values.get(i - 1).set(x, values.get(i - 1).get(x) + greaterValue);
			}
			
			for(int x = 0; x < values.get(i).size(); x++){
				values.get(i).set(x, 0);
			}
			
			for(List<Integer> l : values){
				System.out.println(l);
			}
			
			System.out.println("###############################");
		}
	}
	
	/*
	public static Node getRootNode(List<String> lines){
		Node root = null;
		List<Node> previousRow = null;
		
		for(String line : lines){
			if(root == null){
				root = new Node(Long.valueOf(line));
				previousRow = new ArrayList<Node>();
				previousRow.add(root);
			}
			else{
				String[] pieces = line.split(" ");
				List<Node> rowNodes = new ArrayList<Node>();
				
				for(int i = 0; i < pieces.length; i++){
					Node node = new Node(Long.valueOf(pieces[i]));
					rowNodes.add(node);
					
					if(i == 0){
						previousRow.get(0).getChildren().add(node);
					}
					else if(i == pieces.length - 1){
						previousRow.get(i - 1).getChildren().add(node);
					}
					else{
						previousRow.get(i - 1).getChildren().add(node);
						previousRow.get(i).getChildren().add(node);
					}
				}
				previousRow = rowNodes;
			}			
		}
		
		return root;
	}
	*/

}
