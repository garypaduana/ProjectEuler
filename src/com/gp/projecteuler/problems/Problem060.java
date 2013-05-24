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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gp.projecteuler.CommonMath;

public class Problem060 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		CommonMath cm = new CommonMath();
		Set<Set<Long>> goodPairSet = new HashSet<Set<Long>>();
		
		List<Long> primes = CommonMath.findPrimesUnder(9000);
		
		for(int i = 0; i < primes.size(); i++){
			for(int j = 0; j < primes.size(); j++){
				if(primes.get(i) == primes.get(j)) continue;
				boolean valid = false;
				String way1 = Long.toString(primes.get(i)) + Long.toString(primes.get(j));
				String way2 = Long.toString(primes.get(j)) + Long.toString(primes.get(i));
				
				if(cm.isPrimeCached(Long.valueOf(way1))){
					if(cm.isPrimeCached(Long.valueOf(way2))){
						valid = true;
					}
				}
				
				if(valid){
					Set<Long> gp = new HashSet<Long>();
					gp.add((long)primes.get(i));
					gp.add((long)primes.get(j));
					goodPairSet.add(gp);
				}
			}
		}
		
//		StringBuilder sb = new StringBuilder();
//		for(Set<Long> set : goodPairSet){
//			sb.setLength(0);
//			for(Long l : set){
//				sb.append(l);
//				sb.append(" ");
//			}
//			//System.out.println(sb.toString());
//		}
		
		Set<Set<Long>> goodQuadSet = new HashSet<Set<Long>>();
		
		for(Set<Long> setA : goodPairSet){
			bLoop:
			for(Set<Long> setB : goodPairSet){
				if(setA.equals(setB)) continue;

				for(long c : setA){
					for(long d : setB){
						if(c == d) continue bLoop;
						
						if(!cm.isPrimeCached(Long.valueOf(Long.toString(c) + Long.toString(d))) ||
						   !cm.isPrimeCached(Long.valueOf(Long.toString(d) + Long.toString(c)))){
							continue bLoop;
						}
					}
				}

				Set<Long> gp = new HashSet<Long>();
				gp.addAll(setA);
				gp.addAll(setB);
				goodQuadSet.add(gp);
			}
		}
		
		StringBuilder sb2 = new StringBuilder();
		for(Set<Long> set : goodQuadSet){
			sb2.setLength(0);
			for(Long l : set){
				sb2.append(l);
				sb2.append(" ");
			}
			System.out.println(sb2.toString());
		}
		
		
		Set<Set<Long>> goodPentSet = new HashSet<Set<Long>>();
		
		for(Set<Long> setA : goodQuadSet){
			bLoop:
			for(long prime : primes){
				for(long c : setA){
					if(c == prime) continue bLoop;
						
					if(!cm.isPrimeCached(Long.valueOf(Long.toString(c) + Long.toString(prime))) ||
					   !cm.isPrimeCached(Long.valueOf(Long.toString(prime) + Long.toString(c)))){
						continue bLoop;
					}
				}

				Set<Long> gp = new HashSet<Long>();
				gp.addAll(setA);
				gp.add(prime);
				goodPentSet.add(gp);
			}
		}
		
		StringBuilder sb3 = new StringBuilder();
		for(Set<Long> set : goodPentSet){
			sb3.setLength(0);
			for(Long l : set){
				sb3.append(l);
				sb3.append(" ");
			}
			System.out.println("Pents: " + sb3.toString());
		}
		
		System.out.println(System.currentTimeMillis() - start);
	}

}
