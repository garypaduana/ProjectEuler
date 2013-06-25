package com.gp.projecteuler.problems;

import java.math.BigDecimal;
import java.math.MathContext;

import com.gp.projecteuler.CommonMath;

public class Problem094 {

	public static final BigDecimal EPSILON = new BigDecimal("0.000000000000000000001"); 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		BigDecimal a;
		BigDecimal b;
		BigDecimal p;
		BigDecimal interim;
		BigDecimal two = new BigDecimal(2);
		
		
		for(int i = 2; i < 10000; i++){
			
			a = BigDecimal.valueOf(i + 1);
			b = BigDecimal.valueOf(i);
			p = (a.multiply(two).add(b)).divide(two);
			interim = p.multiply(p.subtract(a)
					.multiply(p.subtract(b)).multiply(p.subtract(a)));
			BigDecimal area1 = CommonMath.bigSqrt(interim);
			
			a = BigDecimal.valueOf(i - 1);
			p = (a.multiply(two).add(b)).divide(two);
			BigDecimal area2 = CommonMath.bigSqrt(p.multiply(p.subtract(a)
					.multiply(p.subtract(b)).multiply(p.subtract(a))));
			
			if(area1.remainder(BigDecimal.ONE, MathContext.DECIMAL32).compareTo(EPSILON) <= 0){
				System.out.println(a.toString() + ", " + a.toString() + ", " + b.toString() + ", " + area1.toString());
			}
			if(area2.remainder(BigDecimal.ONE, MathContext.DECIMAL32).compareTo(EPSILON) <= 0){
				System.out.println(a.toString() + ", " + a.toString() + ", " + b.toString() + ", " + area2.toString());
			}
		}
	}

}
