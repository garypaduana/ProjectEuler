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
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.gp.projecteuler.CommonMath;
import com.gp.projecteuler.FileUtil;

/**
	Euler's Totient function, phi(n) [sometimes called the phi function], 
	is used to determine the number of positive numbers less than or equal to
	n which are relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, 
	are all less than nine and relatively prime to nine, phi(9)=6.
	The number 1 is considered to be relatively prime to every positive number, 
	so phi(1)=1.
	
	Interestingly, phi(87109)=79180, and it can be seen that 87109 is a 
	permutation of 79180.
	
	Find the value of n, 1  n  107, for which phi(n) is a permutation of n and 
	the ratio n/phi(n) produces a minimum.
 */
public class Problem070 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		Set<Long> primes = new TreeSet<Long>();
		
		List<String> primeStrings = FileUtil.getTextFromFile(
				"./resources/primesUnder10Million.txt");
		
		for(String s : primeStrings){
			primes.add(Long.valueOf(s));
		}
		
		System.out.println("Done computing primes. Size: " + primes.size());
		
		double lowestRatio = 50;
		long nAtLowest = 0;
		List<MyEulerWorker> tList = new ArrayList<MyEulerWorker>();
		
		for(long n = 2; n <= 10000000; n+=10000){
			MyEulerWorker myWorker = new MyEulerWorker(n, n+10000, primes, lowestRatio, nAtLowest);
			
			myWorker.start();
			tList.add(myWorker);
			
			while(tList.size() > 5){
				for(Iterator<MyEulerWorker> it = tList.iterator(); it.hasNext();){
					MyEulerWorker tt = it.next();
					if(!tt.isAlive()){
						if(tt.getLowestRatio() < lowestRatio){
							lowestRatio = tt.getLowestRatio();
							nAtLowest = tt.getnAtLowest();
							System.out.println("NEW RECORD: lowest ratio: " + 
									lowestRatio + ", nAtLowest: " + nAtLowest);
						}
						it.remove();
					}
				}
			}
		}
		System.out.println("Answer: " + nAtLowest);
	}
}

class MyEulerWorker extends Thread implements Runnable{
	
	private long start;
	private long stop;
	private double lowestRatio;
	
	public double getLowestRatio() {
		return lowestRatio;
	}

	public void setLowestRatio(double lowestRatio) {
		this.lowestRatio = lowestRatio;
	}

	public long getnAtLowest() {
		return nAtLowest;
	}

	public void setnAtLowest(long nAtLowest) {
		this.nAtLowest = nAtLowest;
	}

	private long nAtLowest;
	private Set<Long> primes;

	public MyEulerWorker(long start, long stop, Set<Long> primes, double lowestRatio, long nAtLowest){
		this.start = start;
		this.stop = stop;
		this.primes = primes;
		this.lowestRatio = lowestRatio;
		this.nAtLowest = nAtLowest;
	}
	
	@Override
	public void run() {	
		for(long n = start; n <= stop; n++){			
			long value = CommonMath.eulerTotientPrimeFactorizationCached(n, primes);
			if(CommonMath.isInSamePermutationSet(Long.toString(value), Long.toString(n))){
				
				double ratio = (double)n / (double)value;
				
				if(ratio < lowestRatio){
					lowestRatio = ratio;
					nAtLowest = n;
				}
			}
			
		}		
	}
}
