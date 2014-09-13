package com.gp.projecteuler.problems;

import java.util.List;

import com.gp.projecteuler.CommonMath;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Problem003_Java8 {

	public static void main(String[] args) {
		long num = 600851475143L;
		List<Long> factorList = CommonMath.findFactors(num);
		System.out.println(factorList.stream()
				  					 .filter(f -> CommonMath.isPrime(f))
				  					 .sorted(((a, b) -> b.compareTo(a)))
				  					 .findFirst().get());
	}
}
