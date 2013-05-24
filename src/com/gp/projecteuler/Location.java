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

public class Location{
	int row;
	int col;
	
	public Location(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	@Override
	public boolean equals(Object o){
		if(o == null) return false;
		if(! (o instanceof Location)) return false;
		Location loc = (Location)o;
		if(loc == this) return true;
		
		if(loc.row == this.row && loc.col == this.col) return true;
		else return false;
	}
	
	@Override
	public int hashCode(){
		return this.row * 31 + this.col * 31;
	}
	
	@Override
	public String toString(){
		return "(" + row + ", " + col + ")";
	}
}
