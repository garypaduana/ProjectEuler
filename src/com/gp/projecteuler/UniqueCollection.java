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
import java.util.Collections;
import java.util.List;

public class UniqueCollection{
	private List<Integer> collection = new ArrayList<Integer>();
	
	public UniqueCollection(List<Integer> collection){
		this.collection.addAll(collection);
	}
	
	public UniqueCollection(int a, int b, int c){
		collection.add(a);
		collection.add(b);
		collection.add(c);
	}
	
	public List<Integer> getCollection(){
		return collection;
	}
		
	@Override
	public boolean equals(Object o){
		if(o == null){
			return false;
		}
		else if(o == this){
			return true;
		}
		else if(!(o instanceof UniqueCollection)){
			return false;
		}
		
		UniqueCollection arg = (UniqueCollection)o;
		
		if(arg.getCollection().size() != collection.size()){
			return false;
		}
		
		Collections.sort(arg.getCollection());
		Collections.sort(collection);
		
		for(int i = 0; i < arg.getCollection().size(); i++){
			if(!arg.getCollection().get(i).equals(collection.get(i))){
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public int hashCode(){
		
		int result = 1;
		for(Integer i : collection){
			result = result * i * 31;
		}
		return result;
	}
	
	@Override
	public String toString(){
		return collection.toString();
	}
}