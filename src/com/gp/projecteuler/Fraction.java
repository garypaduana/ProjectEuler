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

public class Fraction implements Comparable<Fraction>{

	private long numerator;
	private long denominator;
	
	public Fraction(long numerator, long denominator){
		this.setNumerator(numerator);
		this.setDenominator(denominator);
	}

	public long getNumerator() {
		return numerator;
	}

	public void setNumerator(long numerator) {
		this.numerator = numerator;
	}

	public long getDenominator() {
		return denominator;
	}

	public void setDenominator(long denominator) {
		this.denominator = denominator;
	}
	
	@Override
	public String toString(){
		return numerator + " / " + denominator;
	}
	
	@Override
	public boolean equals(Object o){
		if(o == null){
			return false;
		}
		else if(! (o instanceof Fraction)){
			return false;
		}
		
		Fraction oFrac = (Fraction)o;
		
		if(oFrac.getNumerator() == numerator && oFrac.getDenominator() == denominator){
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode(){
		return ((Long)numerator).hashCode() * ((Long)denominator).hashCode();
	}

	@Override
	public int compareTo(Fraction arg0) {
		double arg0Dec = (double)arg0.getNumerator() / (double)arg0.getDenominator();
		
		if(arg0.getNumerator() == this.numerator &&
			arg0.getDenominator() == this.denominator){
			return 0;
		}
		else if(arg0Dec > ((double)this.numerator / (double)this.denominator)){
			return -1;
		}
		else if(arg0Dec < ((double)this.numerator / (double)this.denominator)){
			return 1;
		}
		else{
			return (arg0.getNumerator() > this.numerator) ? -1 : 1;
		}
	}
}
