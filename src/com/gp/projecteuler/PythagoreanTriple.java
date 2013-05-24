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


public class PythagoreanTriple {
	
	private static class PythagoreanValues{
		private int a;
		private int b;
		private int c;
		private int m;
		private int n;
		private int q;
		private int aP;
		private int bP;
		private int cP;
		
		public PythagoreanValues(int a, int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
			initValues();
		}
		private void initValues(){
			m = c - b;
			n = c - a;
			q = a + b - c;
			aP = -q + m;
			bP = -q + n;
			cP = -q + m + n;
		}
		
		public int getaP() {
			return aP;
		}

		public int getbP() {
			return bP;
		}

		public int getcP() {
			return cP;
		}
	}
	
	private int a;
	private int b;
	private int c;
	
	private List<PythagoreanTriple> children = new ArrayList<PythagoreanTriple>();
					
	public PythagoreanTriple(int a, int b, int c, int maxSum){
		
		PythagoreanValues pv1 = new PythagoreanValues(-a, b, c);
		PythagoreanValues pv2 = new PythagoreanValues(a, -b, c);
		PythagoreanValues pv3 = new PythagoreanValues(-a, -b, c);
		
		
		if(a + b + c < maxSum){
			children.add(new PythagoreanTriple(pv1.getaP(), pv1.getbP(), pv1.getcP(), maxSum));
			children.add(new PythagoreanTriple(pv2.getaP(), pv2.getbP(), pv2.getcP(), maxSum));
			children.add(new PythagoreanTriple(pv3.getaP(), pv3.getbP(), pv3.getcP(), maxSum));
		}
		
		this.a = a;
		this.b = b;
		this.c = c;
	}
		
	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public int getC() {
		return c;
	}
		
	@Override
	public String toString(){
		return "(" + a + ", " + b + ", " + c + ")";
	}

	public List<PythagoreanTriple> getChildren() {
		return children;
	}

	public void setChildren(List<PythagoreanTriple> children) {
		this.children = children;
	}
}