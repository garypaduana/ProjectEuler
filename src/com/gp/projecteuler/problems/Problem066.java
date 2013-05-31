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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gp.projecteuler.CommonMath;

/**
	Consider quadratic Diophantine equations of the form:
	
	x^2 – Dy^2 = 1
	
	For example, when D=13, the minimal solution in x is 649^2 – 13*180^2 = 1.
	
	It can be assumed that there are no solutions in positive integers when
	D is square.
	
	By finding minimal solutions in x for D = {2, 3, 5, 6, 7}, we obtain the
	following:
	
	3^2 – 2*2^2 = 1
	2^2 – 3*1^2 = 1
	9^2 – 5*4^2 = 1
	5^2 – 6*2^2 = 1
	8^2 – 7*3^2 = 1
	
	Hence, by considering minimal solutions in x for D <= 7, the largest x
	is obtained when D=5.
	
	Find the value of D  1000 in minimal solutions of x for which the largest
	value of x is obtained.
 */
public class Problem066 {

	public static void main(String[] args) throws InterruptedException {
		
		long start = System.currentTimeMillis();
		List<Integer> squares = new ArrayList<Integer>();
		List<Integer> dList = new ArrayList<Integer>();
		
		for(int i = 2; i <= 1000; i++){
			squares.add(i*i);
			if(!squares.contains(i)){
				dList.add(i);
			}
		}
				
		BigInteger maxX = new BigInteger("0");
		int dAtMaxX = 0;
		
		for(int i : dList){
			List<Integer> pattern = CommonMath.findContinuedFractionPattern(i);
			String expression = CommonMath.generateGenericRepeatingFractionExpression(pattern);
			String evaluated = CommonMath.evaluateStandardFormRepeatingFractionExpression(expression);
			
			String[] pieces = evaluated.split("/");
			
			BigInteger x = new BigInteger(pieces[0].trim());
			BigInteger y = new BigInteger(pieces[1].trim());
			
			if(x.compareTo(maxX) > 0){
				maxX = x;
				dAtMaxX = i;
			}
			System.out.println("d: " + i + "\tcomputed: " + 
					(x.multiply(x).subtract(BigInteger.valueOf(i).multiply(y).multiply(y))).toString()
					+ "\tevaluated: " + evaluated + "\tpattern: " + pattern);
			
			
		}
		System.out.println("Max X: " + maxX + ", Answer (D): " + dAtMaxX);
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}
}
	
 class MyWorker extends Thread implements Runnable{
	
	private double start;
	private double stop;
	private List<Integer> initialList = new ArrayList<Integer>();
	private List<Integer> removeList = new ArrayList<Integer>();

	public List<Integer> getRemoveList() {
		return removeList;
	}

	public void setRemoveList(List<Integer> removeList) {
		this.removeList = removeList;
	}

	public MyWorker(double start, double stop, List<Integer> initialList){
		this.start = start;
		this.stop = stop;
		this.initialList.addAll(initialList);
	}
	
	@Override
	public void run() {	
		for(double x = start; x <= stop; x++){			
			for(Iterator<Integer> it = initialList.iterator(); it.hasNext();){
				int d = it.next();
				
				double ySquared = (x * x - 1) / d;
				double y = Math.sqrt(ySquared);
				if(Math.floor(y) != y) continue;

				if(x * x - ySquared * d == 1){
					removeList.add(d);
				}
			}
			
		}		
	}
}

