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

public class Pair{
	private int a;
	private int b;
	
	public Pair(int a, int b){
		this.a = a;
		this.b = b;
	}
	
	public int getA(){
		return a;
	}
	
	public int getB(){
		return b;
	}
	
	@Override
	public boolean equals(Object o){
		if(o == null){
			return false;
		}
		else if(! (o instanceof Pair)){
			return false;
		}
		else if(((Pair)o).getA() == this.a && ((Pair)o).getB() == this.b){
			return true;
		}
		else return false;
	}
	
	@Override
	public int hashCode(){
		return a * 31 + b * 31;
	}
	
	@Override
	public String toString(){
		return "a: " + a + ", b: " + b;
	}
}
