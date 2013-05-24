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

import java.util.ArrayList;
import java.util.List;

public class Node {
		
	private Location location;
	private long weight;
	private long tentativeWeight = Long.MAX_VALUE;
	private boolean visited = false;
	private List<Node> parents = new ArrayList<Node>();
	private List<Node> children = new ArrayList<Node>();
	
	public Node(long weight, Location location){
		this.weight = weight;
		this.location = location;
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	public long getTentativeWeight() {
		return tentativeWeight;
	}

	public void setTentativeWeight(long tentativeWeight) {
		this.tentativeWeight = tentativeWeight;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Node> getParents() {
		return parents;
	}

	public void setParents(List<Node> parents) {
		this.parents = parents;
	}
	
	public void addChild(Node child){
		if(child == null) return;
		children.add(child);
		child.parents.add(this);
	}
	
	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	@Override
	public String toString(){
		return "location: " + location.toString() + ", weight: " + weight + ", tentativeWeight: " + tentativeWeight + ", visited: " + visited;
	}
	
	@Override
	public boolean equals(Object o){
		if(o == null) return false;
		if(! (o instanceof Node)) return false;
		if(o == this) return true;
		Node oNode = (Node) o;
		return oNode.getLocation().equals(this.getLocation());
	}
	
	@Override
	public int hashCode(){
		return this.location.hashCode();
	}
}
