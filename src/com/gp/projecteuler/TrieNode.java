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

package com.gp.projecteuler;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	private String value;
	private Map<String, TrieNode> children = new HashMap<String, TrieNode>();
	private boolean end;
	
	public TrieNode(String value){
		this.value = value;
	}
	
	public void add(String word){
		if(word.length() > 1){
			String head = word.substring(0, 1);
			TrieNode child = children.get(head);
			if(child != null){
				child.add(word.substring(1, word.length()));
			}
			else{
				child = new TrieNode(head);
				children.put(head, child);
				child.add(word.substring(1, word.length()));
			}
		}
		if(word.length() == 1){
			TrieNode child = new TrieNode(word);
			child.setEnd(true);
			children.put(word, child);
			
		}
	}
	
	public boolean contains(String word){
		if(word.length() > 0){
			if(word.length() == 1 && children.containsKey(word) && children.get(word).isEnd()){
				return true;
			}
			if(children.containsKey(word.substring(0, 1))){
				return children.get(word.substring(0, 1)).contains(word.substring(1, word.length()));
			}
		}
		return false;
	}
	
	public boolean containsPartial(String word){
		if(word.length() > 0){
			if(word.length() == 1 && children.containsKey(word)){
				return true;
			}
			if(children.containsKey(word.substring(0, 1))){
				return children.get(word.substring(0, 1)).containsPartial(word.substring(1, word.length()));
			}
		}
		return false;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Map<String, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(Map<String, TrieNode> children) {
		this.children = children;
	}

	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}
	
}
