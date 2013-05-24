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
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.gp.projecteuler.FileUtil;
import com.gp.projecteuler.Trie;

public class ScramblinSolver {

	public static class Coord{
		public int x;
		public int y;
		
		public Coord(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		public boolean neighbors(Coord c){
			if(Math.abs(c.x - x) <= 1 && Math.abs(c.y - y) <= 1){
				return true;
			}
			return false;
		}
	}
	
	private Map<Integer, Coord> lookup = new TreeMap<Integer, Coord>();
	private String[][] letters = new String[4][4];
	private Trie trie;
	private List<String> validWords = new ArrayList<String>();
	
	public List<String> getValidWords() {
		return validWords;
	}


	public void setValidWords(List<String> validWords) {
		this.validWords = validWords;
	}


	public static void main(String[] args) throws IOException {
		ScramblinSolver ss = new ScramblinSolver();
		
		ss.setLetters(new String[][]{
							{"r", "r", "n", "t", "e", "r"},
							{"w", "e", "s", "a", "a", "v"},
							{"t", "i", "d", "o", "r", "i"},
							{"s", "o", "c", "i", "s", "p"},
							{"l", "b", "o", "m", "a", "w"},
							{"y", "m", "z", "h", "n", "u"}
					 }
		);
		
		List<Integer> all = new ArrayList<Integer>();
		int iteration = 0;
		for(int y = 0; y < 6; y++){
			for(int x = 0; x < 6; x++){
				ss.getLookup().put(iteration, new Coord(x, y));
				all.add(iteration);
				iteration++;
			}
		}
		
		ss.setTrie(new Trie());
		long start = System.currentTimeMillis();
		List<String> words = FileUtil.getTextFromFile(
			//"./resources/uniqueWords.txt");
			"C:/Users/Gary/Dropbox/dev/checkout/trunk/Java/ProjectEuler/resources/scramblinClean.txt");
		
		System.out.println((System.currentTimeMillis() - start) + "ms to read words");
		
		for(String word : words){
			ss.getTrie().add(word);
		}
		System.out.println((System.currentTimeMillis() - start) + "ms to populate trie");
		ss.permutationFailFast(all, ss);
		
		Collections.sort(ss.getValidWords());
		
		for(String word : ss.getValidWords()){
			System.out.println(word + "," + word.length());
		}
		System.out.println((System.currentTimeMillis() - start) + "ms to complete");
	}


	public String[][] getLetters() {
		return letters;
	}


	public void setLetters(String[][] letters) {
		this.letters = letters;
	}


	public Map<Integer, Coord> getLookup() {
		return lookup;
	}


	public void setLookup(Map<Integer, Coord> lookup) {
		this.lookup = lookup;
	}
	
	/**
	 * Returns all permutations of the input List
	 * @param str
	 * @return
	 */
	public List<List<Integer>> permutationFailFast(List<Integer> list, ScramblinSolver ss) {
		List<Integer> empty = new ArrayList<Integer>();
	    return permutationFailFast(empty, list, ss); 
	}
	
	@SuppressWarnings("unchecked")
	private List<List<Integer>> permutationFailFast(List<Integer> prefix, List<Integer> list, ScramblinSolver ss) {
	    List<List<Integer>> permList = new ArrayList<List<Integer>>();
		if (list.size() == 0){
			return Arrays.asList(prefix);
		}
		else{
			for(int i = 0; i < list.size(); i++){
				List<Integer> pre = new ArrayList<Integer>();
				pre.addAll(prefix);
				pre.add(list.get(i));
				
				List<Integer> rem = new ArrayList<Integer>();
				rem.addAll(list.subList(0, i));
				rem.addAll(list.subList(i+1, list.size()));
				
				// Figure out if you should continue right here
				// check to see if what we have so far is found in the TrieNode
				// Also, everything needs to be a neighbor
				
				List<Coord> coords = listToCoords(pre, ss);
				String soFar = constructFromCoords(coords, ss);
				if(neighbors(coords) && ss.getTrie().containsPartial(soFar)){
					if(ss.getTrie().contains(soFar)){
						ss.getValidWords().add(soFar);
					}
					permList.addAll(permutationFailFast(pre, rem, ss));
				}
			}  
		}
		return permList;
	}
	
	private List<Coord> listToCoords(List<Integer> list, ScramblinSolver ss){
		List<Coord> coords = new ArrayList<Coord>();
		for(int i = 0; i < list.size(); i++){
			coords.add(ss.getLookup().get(list.get(i)));
		}
		return coords;
	}

	public static boolean neighbors(List<Coord> coords){
		for(int i = 0; i < coords.size() - 1; i++){
			if(!coords.get(i).neighbors(coords.get(i+1))){
				return false;
			}
		}
		return true;
	}
	
	private String constructFromCoords(List<Coord> coords, ScramblinSolver ss){
		StringBuilder sb = new StringBuilder();
		for(Coord c : coords){
			sb.append(ss.getLetters()[c.x][c.y]);
		}
		return sb.toString();
	}

	public Trie getTrie() {
		return trie;
	}


	public void setTrie(Trie trie) {
		this.trie = trie;
	}
}
