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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.*;
import java.util.TreeMap;
import java.util.TreeSet;

import com.gp.projecteuler.Point;
import com.gp.projecteuler.Point.Type;

public class CommonMath {

	private Map<Long, Set<Long>> eulerTotientCache = new TreeMap<Long, Set<Long>>();
	private Set<Long> primes = new TreeSet<Long>();
	private Set<Long> composites = new TreeSet<Long>();
	private Map<Long, List<Long>> factors = new TreeMap<Long, List<Long>>();
	private Map<Long, BigInteger> partitionsMap = new TreeMap<Long, BigInteger>();
	
	private static final BigDecimal SQRT_DIG = new BigDecimal(400);
	private static final BigDecimal SQRT_PRE = new BigDecimal(10).pow(SQRT_DIG.intValue());
	public static final BigInteger ONE_MILLION = new BigInteger("1000000");
	
	public static List<Long> pentagonalCache = new ArrayList<Long>();
	static{
		pentagonalCache.add(1L);
		for(long i = 1; i < 10000; i++){
			pentagonalCache.add(pentagonal(i));
			pentagonalCache.add(pentagonal(-i));
		}
	}
		
	/**
	 * For any long n, returns a List of all factors including 1 and n.
	 * 
	 * @param n
	 * @return
	 */
	public static List<Long> findFactors(long n){
		List<Long> factors = new ArrayList<>();
		IntStream.iterate(1, i -> i + 1)
				 .limit((long) Math.sqrt(n) + 1)
				 .filter(i -> n % i == 0)
				 .forEach(i -> { 
					 factors.add((long) i);
					 factors.add(n / i);
				 });
		return factors;
	}
			
	/**
	 * For any long n, returns a List of all proper divisors (no duplicates and excluding n).
	 * 
	 * @param n
	 * @return
	 */
	public static List<Long> findProperDivisors(long n){
		List<Long> result = new ArrayList<Long>(new HashSet<Long>(findFactors(n)));
		result.remove(n);
		return result;
	}
	
	/**
	 * Sums a List of Numbers.
	 * 
	 * @param numbers
	 * @return
	 */
	public static long sumListOfNumber(List<? extends Number> numbers){
		long sum = 0;
		for(Number number : numbers){
			sum += number.longValue();
		}
		return sum;
	}
	
	public static long sumListOfLong(List<Long> numbers){
		long sum = 0;
		for(long number : numbers){
			sum += number;
		}
		return sum;
	}
	
	/**
	 * Brute force check to determine if a number is prime.
	 * 
	 * @param num
	 * @return
	 */
	public static boolean isPrime(long num){
		if(num <= 1){
			return false;
		}
		if(num == 2){
			return true;
		}
		if(num % 2 == 0){
			return false;
		}
		long upper = (long)Math.sqrt(num) + 1;
		
		for(long i = 3; i <= upper; i += 2){
			if(num % i == 0){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Brute force check to determine if a number is prime
	 * using java 8 streams.
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isPrime8(long n) {
	    return n > 1 && LongStream.rangeClosed(2, (long) Math.sqrt(n))
	    						  .noneMatch(divisor -> n % divisor == 0);
	}
	
	/**
	 * Uses an internal cache to make repetitive searches faster.
	 * @param num
	 * @return
	 */
	public boolean isPrimeCached(long num){
		if(composites.contains(num)){
			return false;
		}
		if(primes.contains(num)){
			return true;
		}
		
		if(isPrime(num)){
			primes.add(num);
			return true;
		}
		else{
			composites.add(num);
			return false;
		}
	}
	
	/**
	 * Returns a List of the numerical positions of an array of char
	 * as the characters correspond to the alphabet. (a = 1, b = 2, ..., z = 26)
	 * Case insensitive.
	 * 
	 * @param array
	 * @return
	 */
	public static List<Integer> charArrayToAlphaPositionList(String text){
		char[] array = text.toUpperCase().toCharArray();
		List<Integer> intList = new ArrayList<Integer>();
		
		for(char c : array){
			intList.add((int)c - 64);
		}
		
		return intList;
	}
	
	/**
	 * Finds all abundant integers from 0 to the upperLimit, inclusive.
	 * 
	 * @param upperLimit
	 * @return
	 */
	public static List<Integer> findAbundantIntegers(int upperLimit){
		List<Integer> abundantIntegers = new ArrayList<Integer>();
		for(int i = 0; i <= upperLimit; i++){
			List<Long> divisors = CommonMath.findProperDivisors(i);
			if(CommonMath.sumListOfNumber(divisors) > i){
				abundantIntegers.add(i);
			}
		}
		return abundantIntegers;
	}
	
	/**
	 * Finds the unique Set of sums of any two abundantIntegers combined exhaustively.
	 * e.g. if abundantIntegers is of size 10, there will be 10*10 sums produced and the
	 * duplicates discarded.
	 * 
	 * @param abundantIntegers
	 * @return
	 */
	public static Set<Integer> findSumsOfAbundantNumbers(List<Integer> abundantIntegers){
		Set<Integer> sumsOfAbundantNumbers = new HashSet<Integer>();
		// This should already be sorted, but just to be sure.
		Collections.sort(abundantIntegers);
		
		outer:
		for(int abundantInteger : abundantIntegers){
			if(abundantInteger > 28132){
				return sumsOfAbundantNumbers;
			}
			for(int pair : abundantIntegers){
				if(abundantInteger + pair > 28123){
					continue outer;
				}
				sumsOfAbundantNumbers.add(abundantInteger + pair);
			}
		}
		
		return sumsOfAbundantNumbers;
	}
	
	/**
	 * Determines if there is a repeating pattern in a string based on a sub string and a
	 * starting position.
	 * @param base
	 * @param sub
	 * @param pos
	 * @return
	 */
	public static boolean containsRepeatingPattern(String base, String sub, int pos){
		
		int count = 0;
		if(sub.length() > base.length()){
			throw new IllegalArgumentException("substring is longer than base string!");
		}
		for(int i = pos; i < base.length() - sub.length(); i+=sub.length()){
			if(base.substring(i, i + sub.length()).equals(sub)){
				count++;
			}
			else{
				count = 0;
			}
		}
		return count > 1 ? true : false;
	}
	
	/**
	 * Computes a to the power of b.  a and b are both BigInteger.
	 * @param a
	 * @param b
	 * @return
	 */
	public static BigInteger pow(BigInteger a, BigInteger b){
		BigInteger result = BigInteger.valueOf(1L);
		for(BigInteger i = BigInteger.valueOf(1); i.compareTo(b) <= 0; i = i.add(BigInteger.valueOf(1))){
			result = result.multiply(a);
		}
		return result;
	}
	
	/**
	 * Determines if the two integers contain a shared digit that occurs exactly once.
	 * Returns the lowest counting number digit that matches.
	 * @param a
	 * @param b
	 * @return
	 */
	public static int containsCommonNumber(int a, int b){
		for(int i = 0; i < 10; i++){
			if(containsCount(a, i) == 1 && containsCount(b, i) == 1){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Determines the number of times a digit occurs within a larger number.
	 * @param number
	 * @param digit
	 * @return
	 */
	public static int containsCount(int number, int digit){
		String numStr = Integer.toString(number);
		int count = 0;
		for(int i = 0; i < numStr.length(); i++){
			if(Integer.valueOf(numStr.substring(i, i + 1)).toString().equals(Integer.toString(digit))){
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Computes a factorial for a given number, n.
	 * Does not account for problems that may arise in 64 bit long overflow.
	 * @param n
	 * @return
	 */
	public static long factorial(long n){
		
		if(n == 0){
			return 1;
		}
		long product = 1;
		for(long i = n; i > 0; i--){
			product = product * i;
		}
		
		return product;
	}
	
	/**
	 * Returns the sum of each digit's factorial.
	 * 
	 * e.g. 145 returns 1! + 4! + 5! = 145
	 * @param num
	 * @return
	 */
	public static long factorialSumOfDigits(long num){
		long sum = 0;
		String s = Long.toString(num);
		
		for(char c : s.toCharArray()){
			sum += factorial(Long.valueOf(String.valueOf(c)));
		}
		return sum;
	}
	
	/**
	 * Returns all permutations of the input string.
	 * @param str
	 * @return
	 */
	public static List<String> permutation(String str) {
	    return permutation("", str); 
	}
	
	private static List<String> permutation(String prefix, String str) {
	    List<String> permList = new ArrayList<String>();
		if (str.length() == 0){
			return Arrays.asList(prefix);
		}
		else{
			for(int i = 0; i < str.length(); i++){
				permList.addAll(permutation(prefix + str.charAt(i), 
					str.substring(0, i) + str.substring(i+1, str.length())));
			}  
		}
		return permList;
	}
	
	/**
	 * Returns all permutations of the input List
	 * @param str
	 * @return
	 */
	public static <T> List<List<T>> permutation(List<T> list) {
		List<T> empty = new ArrayList<T>();
	    return permutation(empty, list); 
	}
	
	@SuppressWarnings("unchecked")
	private static <T> List<List<T>> permutation(List<T> prefix, List<T> list) {
	    List<List<T>> permList = new ArrayList<List<T>>();
		if (list.size() == 0){
			return Arrays.asList(prefix);
		}
		else{
			for(int i = 0; i < list.size(); i++){
				List<T> pre = new ArrayList<T>();
				pre.addAll(prefix);
				pre.add(list.get(i));
				
				List<T> rem = new ArrayList<T>();
				rem.addAll(list.subList(0, i));
				rem.addAll(list.subList(i+1, list.size()));

				permList.addAll(permutation(pre, rem));
			}  
		}
		return permList;
	}
	
	/**
	 * Finds all rotations of a string (not permutations). e.g. A string of length 10 will
	 * only have 10 rotations.  Each rotation begins at a new position in the string and
	 * wraps around the end of the String back to the 0 position until reaching where it started.
	 * @param str
	 * @return
	 */
	public static List<String> rotations(String str){
		List<String> rotationList = new ArrayList<String>();
		
		for(int i = 0; i < str.length(); i++){
			rotationList.add(str.substring(i) + str.substring(0, i));
		}
		
		return rotationList;
	}
	
	/**
	 * Determines if a String is a palindrome.
	 * @param str
	 * @return
	 */
	public static boolean isPalindrome(String str){
		return str.equals(reverse(str));
	}
	
	/**
	 * Determines if a long number is a palindrome.
	 * @param num
	 * @return
	 */
	public static boolean isPalindrome(long num){
		String forward = Long.toString(num);
		String reverse = reverse(forward);
		return forward.equals(reverse);
	}
	
	/**
	 * Reverses a String.
	 * @param str
	 * @return
	 */
	public static String reverse(String str){
		StringBuilder sb = new StringBuilder();
		
		char[] chars = str.toCharArray();
		for(int i = chars.length - 1; i >= 0; i--){
			sb.append(String.valueOf(chars[i]));
		}
		return sb.toString();
	}
	
	public static String swapFraction(String str){
		if(! (str.lastIndexOf("/") == str.indexOf("/"))){
			throw new IllegalArgumentException("Input string does not contain a \"/\" division symbol!");
		}
		String[] parts = str.split("/");
		
		return parts[1].trim() + " / " + parts[0].trim();
	}
	
	/**
	 * Determines if the concatenation of a List of numbers produces a
	 * pandigital number that contains exactly once each of the numbers from
	 * low to high, inclusive. e.g. 123456789 is pandigital from 1 to 9.
	 *  
	 * 1223 is not pandigital from 1 to 3.
	 * The List may have just one element.
	 * @param numbers
	 * @param low
	 * @param high
	 * @return
	 */
	public static boolean isPandigital(List<? extends Number> numbers, int low, int high){
		
		String cat = concat(numbers);
		
		if(high < low){
			throw new IllegalArgumentException("high must be higher than low!");
		}
		
		if(cat.length() != (high - low + 1)){
			return false;
		}
		
		for(int i = low; i <= high; i++){
			cat = cat.replaceFirst(Integer.toString(i), "");
		}
		
		return cat.length() == 0;
	}
	
	/**
	 * Concatenates a List of Number and forms a single String in the order received.
	 * @param numList
	 * @return
	 */
	public static String concat(List<? extends Number> numList){
		StringBuilder sb = new StringBuilder();
		
		for(Number n : numList){
			sb.append(n.toString());
		}
		
		return sb.toString();
	}
	
	/**
	 * Finds all distinct prime factors for a given number.
	 * @param num
	 * @param primes
	 * @param primeList
	 * @return
	 */
	public static Set<Long> findDistinctPrimeFactors(long num, Set<Long> primes,
			List<Long> primeList){
		Set<Long> factors = new TreeSet<Long>();
		if(primes.contains(num)){
			factors.add(num);
			return factors;
		}
		
		for(int i = 0; i < primeList.size(); i++){
			
			if(primeList.get(i) > num){
				break;
			}
			if(num % primeList.get(i) == 0){
				factors.add(primeList.get(i));
				num = num / primeList.get(i);
				i = 0;
			}
		}
		return factors;
	}
	
	/**
	 * Fail-fast prime factorization that fails once the upperLimit is 
	 * exceeded.  This is used when searching for numbers that have no more 
	 * than upperLimit number of distinct prime factors.  A null is returned
	 * instead of an empty Set to show that the condition has been violated.
	 * 
	 * @param num
	 * @param primes
	 * @param upperLimit
	 * @return
	 */
	public static Set<Long> findDistinctPrimeFactors(
			long num, Set<Long> primes){
		
		Set<Long> factors = new TreeSet<Long>();
		if(primes.contains(num)){
			factors.add(num);
			return factors;
		}
		
		long i = 2;
		while(i <= (long)Math.sqrt(num)){
			if(!primes.contains(i)){
				i++;
				continue;
			}
			
			if(num % i == 0){
				factors.add(i);
				if(primes.contains(num / i)){
					factors.add(num / i);
				}
				
				num = num / i;
				i = 2;
			}
			i++;
		}
		
		return factors;
	}
	
	/**
	 * Computes the factorial using a BigInteger, which allows for much larger
	 * results than traditional numbers.
	 * @param num
	 * @return
	 */
	public static BigInteger bigFactorial(long num){
		if(num == 0){
			return new BigInteger("1");
		}
		BigInteger product = new BigInteger("1");
		for(long i = num; i > 0; i--){
			product = product.multiply(BigInteger.valueOf(i));
		}
		
		return product;
	}
	
	/**
	 * Sums all digits in a String of numbers.
	 * @param val
	 * @return
	 */
	public static long sumString(String val){
		
		long sum = 0;
		char[] chars = val.toCharArray();
		
		for(char c : chars){
			sum += Integer.valueOf(String.valueOf(c));
		}
		return sum;
	}
	
	/**
	 * XORs a message with a secret key to produce cipher text.
	 * @param message
	 * @param key
	 * @return
	 */
	public static String xorMessage(String message, String key){
		try{
			if(message == null || key == null) return null;
						
			char[] keys = key.toCharArray();
			char[] mesg = message.toCharArray();
			int m1 = mesg.length;
			int k1 = keys.length;
			char[] newmsg = new char[m1];
			
			for(int i = 0; i < m1; i++){
				newmsg[i] = (char)(mesg[i]^keys[i%k1]);
			}
			
			mesg = null;
			keys = null;
			return new String(newmsg);
		}
		catch(Exception ex){
			return null;
		}
	}
	
	/**
	 * XORs a message with a secret key to produce cipher text. Computes a SHA hash of the
	 * secret key to make it more robust.
	 * @param message
	 * @param key
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */
	public static String xorMessageWithShaSalt(String message, String key) 
			throws UnsupportedEncodingException, NoSuchAlgorithmException{
		
		byte[] bytesOfKey = key.getBytes("UTF-8");
		MessageDigest md = MessageDigest.getInstance("SHA");
		byte[] theDigest = md.digest(bytesOfKey);
		key = new BigInteger(1, theDigest).toString(16);
		
		return xorMessage(message, key);
	}
	
	/**
	 * Finds the total collection of distinct prime factors of a number.
	 * @param num
	 * @return
	 */
	public static Set<Long> findDistinctPrimeFactorsWithRecursion(long num){
		Set<Long> factors = new TreeSet<Long>();
		for(long i = 2; i <= num; i++){
			if(!CommonMath.isPrime(i)) continue;
			if(num % i == 0){
				factors.add(i);
				factors.addAll(findDistinctPrimeFactorsWithRecursion(num / i));
			}
		}
		return factors;
	}
	
	/**
	 * Determines if a string is a permutation of another string.
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean isInSamePermutationSet(String a, String b){
		if(a.length() != b.length()) return false;
		
		for(int i = 0; i < a.length(); i++){
			if(!b.contains(String.valueOf(a.charAt(i)))) return false;
			b = b.replaceFirst(String.valueOf(a.charAt(i)), "");
		}
		return b.length() == 0;
	}
	
	/**
	 * 
	 * @param exp
	 * @return
	 */
	public static String evaluateStandardFormRepeatingFractionExpression(String exp){
		while(exp.contains("(") || exp.contains("+")){
			String sub = null;
			boolean last = false;
			if(exp.contains("(")){
				sub = exp.substring(exp.lastIndexOf("("), exp.indexOf(")") + 1);
			}
			else{
				last = true;
				sub = exp;
			}
			sub = sub.replace("(", "");
			sub = sub.replace(")", "");
			String[] adds = sub.split("\\+");

			BigInteger a, b, c, d;
			
			a = adds[0].contains("/") ? new BigInteger(adds[0].split("/")[0].replace("(", "").trim()) : new BigInteger(adds[0].replace("(", "").trim());
			b = adds[0].contains("/") ? new BigInteger(adds[0].split("/")[1].replace("(", "").trim()) : new BigInteger("1");
			c = adds[1].contains("/") ? new BigInteger(adds[1].split("/")[0].replace("(", "").trim()) : new BigInteger(adds[1].replace("(", "").trim());
			d = adds[1].contains("/") ? new BigInteger(adds[1].split("/")[1].replace("(", "").trim()) : new BigInteger("1");

			String simp = add(a,b,c,d);
			exp = exp.replace(sub, simp);
			if(!last){
				exp = exp.replace(exp.substring(exp.lastIndexOf("1/"), exp.lastIndexOf("1/") + 4 + simp.length()), CommonMath.swapFraction(simp));
			}
		}
		return exp;
	}
	
	/**
	 * Adds two fractions together and returns a non-reduced String representation of that addition.
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @return
	 */
	public static String add(BigInteger a, BigInteger b, BigInteger c, BigInteger d){
		return a.multiply(d).add(b.multiply(c)).toString() + " / " + (d.multiply(b)).toString(); 
	}

	public static String generateSquareRootOfTwoRepeatingFractionExpression(int depth){
		String base = "1 + 1/2";
		String replace = "(2 + 1/2)";
		StringBuilder sb = new StringBuilder();
		sb.append(base);
		for(int i = 0; i < depth - 1; i++){
			sb.replace(sb.lastIndexOf("2"), sb.lastIndexOf("2") + 1, replace);
		}
		return sb.toString();
	}

	public static String generateERepeatingFractionExpression(int depth){
		
		if(depth == 1){
			return "2 / 1";
		}
		String base = "2 + 1/1";
		
		StringBuilder sb = new StringBuilder();
		List<String> pattern = new ArrayList<String>();
		pattern.add("1");
		pattern.add("k");
		pattern.add("1");
		int k = 2;
		int kCount = 1;
		sb.append(base);
		String last = "1";
		String replace = null;
		
		for(int i = 1; i < depth - 1; i++){
			String re = pattern.get(i % 3);
			if(re.equals("k")){
				re = Integer.toString(k * kCount);
				kCount += 1;
			}
			String next = pattern.get((i + 1) % 3);
			if(next.equals("k")){
				next = Integer.toString(k * (kCount + 1));
			}
			
			replace = "(" + last + " + 1/" + re + ")";
			
			sb.replace(sb.lastIndexOf(last), sb.lastIndexOf(last) + last.length(), replace);
			last = re;
		}
		
		return sb.toString();
	}
	
	
	public static String generateGenericRepeatingFractionExpression(List<Integer> pattern){
		String base = null;
		if(pattern.size() > 1){
			base = pattern.get(0) + " + 1/" + pattern.get(1);
		}
		else if(pattern.size() == 1){
			return Integer.toString(0);
		}
		else{
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(base);
		
		String last = Integer.toString(pattern.get(1));
		String replace = null;
		
		for(int i = 2; i < pattern.size(); i++){
			String re = Integer.toString(pattern.get(i));
			replace = "(" + last + " + 1/" + re + ")";
			sb.replace(sb.lastIndexOf(last), sb.lastIndexOf(last) + last.length(), replace);
			last = re;
		}
		
		return sb.toString();
	}
	
	public static List<Integer> findContinuedFractionPattern(int num){
		List<Integer> pattern = new ArrayList<Integer>();
		
		BigDecimal sqrt = bigSqrt(new BigDecimal(Integer.toString(num)));
		BigDecimal numSqrt = sqrt;
		int an = sqrt.intValue();
		
		pattern.add(an);
		
		boolean patternFound = false;
		while(!patternFound){
			
			sqrt = new BigDecimal("1").divide(sqrt.subtract(new BigDecimal(Integer.toString(an))), new MathContext(1000));
			an = sqrt.intValue();
			
			BigDecimal close = sqrt.subtract(numSqrt).subtract(sqrt.subtract(numSqrt).setScale(0, RoundingMode.FLOOR));
			if(close.compareTo(new BigDecimal("0.0001")) <= 0 || close.compareTo(new BigDecimal("0.9999")) >= 0){
				if((pattern.size() - 1) % 2 == 0){
					int size = pattern.size();
					pattern.add(pattern.get(0) * 2);
					for(int k = 1; k < size; k++){
						pattern.add(pattern.get(k));
					}
				}
				patternFound = true;
				return pattern;
			}
			pattern.add(an);
		}
		return null;
	}
	
	public static List<Integer> findExtendedContinuedFractionPattern(int num){
		List<Integer> pattern = new ArrayList<Integer>();
		
		BigDecimal sqrt = bigSqrt(new BigDecimal(Integer.toString(num)));
		BigDecimal numSqrt = sqrt;
		int an = sqrt.intValue();
		
		pattern.add(an);
		
		boolean patternFound = false;
		while(!patternFound){
			
			sqrt = new BigDecimal("1").divide(sqrt.subtract(
				new BigDecimal(Integer.toString(an))), new MathContext(1000));
			an = sqrt.intValue();
			
			BigDecimal close = sqrt.subtract(numSqrt).subtract(
				sqrt.subtract(numSqrt).setScale(0, RoundingMode.FLOOR));
			if(close.compareTo(new BigDecimal("0.0000001")) <= 0 || 
					close.compareTo(new BigDecimal("0.9999999")) >= 0){

				pattern.add(pattern.get(0) * 2);
				patternFound = true;
				return pattern;
			}
			
			pattern.add(an);
		}
		return null;
	}

	public static String evaluateERepeatingFractionExpression(String fraction){

		return null;
	}
		 
	/**
	 * Private utility method used to compute the square root of a BigDecimal.
	 * 
	 * @author Luciano Culacciatti 
	 * @url http://www.codeproject.com/Tips/257031/Implementing-SqrtRoot-in-BigDecimal
	 * @param c
	 * @param xn
	 * @param precision
	 * @return
	 */
	private static BigDecimal sqrtNewtonRaphson  (BigDecimal c, BigDecimal xn, BigDecimal precision){
		BigDecimal fx = xn.pow(2).add(c.negate());
		BigDecimal fpx = xn.multiply(new BigDecimal(2));
		BigDecimal xn1 = fx.divide(fpx,2*SQRT_DIG.intValue(),RoundingMode.HALF_DOWN);
		xn1 = xn.add(xn1.negate());
		BigDecimal currentSquare = xn1.pow(2);
		BigDecimal currentPrecision = currentSquare.subtract(c);
		currentPrecision = currentPrecision.abs();
		if (currentPrecision.compareTo(precision) <= -1){
			return xn1;
		}
		return sqrtNewtonRaphson(c, xn1, precision);
	}
		
	/**
	 * Uses Newton Raphson to compute the square root of a BigDecimal.
	 * 
	 * @author Luciano Culacciatti 
	 * @url http://www.codeproject.com/Tips/257031/Implementing-SqrtRoot-in-BigDecimal
	 * @param c
	 * @return
	 */
	public static BigDecimal bigSqrt(BigDecimal c){
		return sqrtNewtonRaphson(c,new BigDecimal(1),new BigDecimal(1).divide(SQRT_PRE));
	}
	
	public Set<Long> eulerTotientBruteForce(long n){
		Set<Long> nDivisors = getCachedFactors(n);
		
		Set<Long> relativelyPrime = new TreeSet<Long>();
		outer:
		for(long i = 1; i < n; i++){
			Set<Long> testProperDivisors = getCachedFactors(i);
			
			for(long testDivisor : testProperDivisors){
				if(nDivisors.contains(testDivisor) && testDivisor != 1){
					continue outer;
				}
			}
			relativelyPrime.add(i);
		}		
		return relativelyPrime;
	}
	
	private Set<Long> getCachedFactors(long n){
		if(!eulerTotientCache.containsKey(n)){
			Set<Long> thisProperDivisors = new TreeSet<Long>(CommonMath.findFactors(n));
			eulerTotientCache.put(n, thisProperDivisors);
			return thisProperDivisors;
		}
		else{
			return eulerTotientCache.get(n);
		}
	}
	
	public static long eulerTotientPrimeFactorization(long n){
		
		double sum = n;
		for(long factor : findDistinctPrimeFactorsWithRecursion(n)){
			sum = sum * (1 - 1 / (double)factor);
		}
		return (long)sum;
	}
	
	/**
	 * Calculates the number of numbers that are coprime to n.
	 * 
	 * @param n
	 * @param primeFactors
	 * @return
	 */
	public static long eulerTotient(long n, List<Long> primeFactors){
		
		double sum = n;
		for(long factor : primeFactors){
			sum = sum * (1 - 1 / (double)factor);
		}
		return (long)sum;
	}
	
	/**
	 * Euler's product formula example:
	 * 
	 * phi(36) = phi(2^2 * 3^2) = 36 * (1-1/2) * (1-1/3) = 36 * 1/2 * 2/3 = 12
	 * 
	 * @param n
	 * @param primes
	 * @return
	 */
	public static long eulerTotientPrimeFactorizationCached(long n, Set<Long> primes){
		
		double sum = n;
		Set<Long> primeFactors = findDistinctPrimeFactors(n, primes);

		for(long factor : primeFactors){
			sum = sum * (1 - 1 / (double)factor);
		}
		return (long)sum;
	}
	
	/**
	 * Determines if two Sets of Number intersect at all.  If just one element from either
	 * Set appears in both Sets then there is an intersection.
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean intersects(Set<? extends Number> a, Set<? extends Number> b){
		for(Number numA : a){
			if(b.contains(numA)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Simplifies the Fraction to simplest terms.
	 * @param fraction
	 * @return
	 */
	public Fraction reducedProperFraction(Fraction fraction){
		
		List<Long> numDivisors = new ArrayList<Long>();
		if(factors.containsKey(fraction.getNumerator())){
			numDivisors.addAll(factors.get(fraction.getNumerator()));
		}
		else{
			numDivisors.addAll(CommonMath.findFactors(fraction.getNumerator()));
		}
		
		List<Long> denomDivisors = new ArrayList<Long>();
		if(factors.containsKey(fraction.getDenominator())){
			denomDivisors.addAll(factors.get(fraction.getDenominator()));
		}
		else{
			denomDivisors.addAll(CommonMath.findFactors(fraction.getDenominator()));
		}
		
		Collections.sort(numDivisors);
		Collections.sort(denomDivisors);
		
		int denomIndex = denomDivisors.size() - 1;
		for(int i = numDivisors.size() - 1; i >= 0; i--){
			
			if(numDivisors.get(i).equals(denomDivisors.get(denomIndex))){
				return new Fraction(fraction.getNumerator() / numDivisors.get(i),
					fraction.getDenominator() / numDivisors.get(i));
			}
			
			if(numDivisors.get(i) > denomDivisors.get(denomIndex)){
				continue;
			}
			
			while(numDivisors.get(i) < denomDivisors.get(denomIndex)){
				denomIndex--;
			}
			
			if(numDivisors.get(i).equals(denomDivisors.get(denomIndex))){
				return new Fraction(fraction.getNumerator() / numDivisors.get(i),
					fraction.getDenominator() / numDivisors.get(i));
			}
		}
		
		return fraction;
	}

	public static List<Long> findPrimesUnder(long upper) {
		List<Long> primes = new ArrayList<Long>();
		for(Long i = 0L; i < upper; i++){
			if(isPrime(i)){
				primes.add(i);
			}
		}
		return primes;
	}
	
	/**
	 * Converts a List of String to a List of Long.
	 * @param strList
	 * @return
	 */
	public static List<Long> convertList(List<String> strList){
		List<Long> list = new ArrayList<Long>();
		for(String s : strList){
			list.add(Long.valueOf(s));
		}
		return list;
	}
	
	/**
	 * Uses Djikstra's algorithm to find the shortest path between one Node and any Set of Nodes.
	 * @param startNode
	 * @param destinationNodeSet
	 * @param allNodes
	 * @return
	 */
	public static long findShortestPathDistance(Node startNode, Set<Node> destinationNodeSet, Set<Node> allNodes){
		Node current = startNode;
		Set<Node> unvisited = new HashSet<Node>(allNodes);
		boolean finished = false;
		long shortestDistance = Long.MAX_VALUE;
		
		for(Node n : allNodes){
			n.setTentativeWeight(Long.MAX_VALUE);
			n.setVisited(false);
		}
		current.setTentativeWeight(current.getWeight());
		Node nextCurrent = null;
		while(!finished){
			
			for(Node child : current.getChildren()){
				if(child.isVisited()) continue;
				if(current.getTentativeWeight() + child.getWeight() < child.getTentativeWeight()){
					child.setTentativeWeight(current.getTentativeWeight() + child.getWeight());
				}
			}
			
			current.setVisited(true);
			unvisited.remove(current);
			
			for(Node destNode : destinationNodeSet){
				if(destNode.isVisited()){
					finished = true;
					shortestDistance = destNode.getTentativeWeight();
				}
			}
			
			long smallest = Long.MAX_VALUE;
			for(Node node : unvisited){
				if(node.isVisited()) continue;
				if(node.getTentativeWeight() < smallest){
					smallest = node.getTentativeWeight();
					nextCurrent = node;
				}
			}
			
			current = nextCurrent;
		}
		
		return shortestDistance;
	}
	
	/**
	 * Returns the number of ways the number n can be partitioned
	 * into sums of positive integers larger than k. 
	 * @param k
	 * @param n
	 * @return
	 */
	public static long partitionWithRecursion(long k, long n){
		long sum = 0;
		if(k > n) return 0;
		if(k == n) return 1;
		sum += partitionWithRecursion(k+1, n) + partitionWithRecursion(k, n-k);
		return sum;
	}
	
	/**
	 * Creates a List of List of Long that contains all of the different ways positive whole numbers
	 * can be summed to the number n.
	 * @param n
	 * @return
	 */
	public static List<List<Long>> partitionVerboseWithRecursion(long n){
		return partitionVerboseWithRecursion(n, n, "");
	}
	
	/**
	 * Creates a List of List of Long that contains all of the different ways positive whole numbers
	 * can be summed to the number n.
	 * @param n
	 * @param max
	 * @param prefix
	 * @return
	 */
	public static List<List<Long>> partitionVerboseWithRecursion(long n, long max, String prefix){
		List<List<Long>> masterList = new ArrayList<List<Long>>();
		if(n == 0){
			String[] pieces = prefix.split(" ");
			List<Long> list = new ArrayList<Long>();
			
			for(String s : pieces){
				if(s.length() == 0) continue;
				list.add(Long.valueOf(s));
			}
			masterList.add(list);
			
			return masterList;
		}
		
		for(long i = Math.min(max, n); i >= 1; i--){
			masterList.addAll(partitionVerboseWithRecursion(n-i, i, prefix + " " + i));
		}
		
		return masterList;
	}
		
	/**
	 * Finds the number of ways a number can be partitioned using a pentagonal number series.
	 * Pentagonal numbers are used in this form:
	 *	p(k) = p(k - 1) + p(k - 2) - p(k - 5) - p(k - 7) + p(k - 12) + p(k - 15) - p(k - 22) ...
	 * @param n
	 * @return
	 */
	public BigInteger partitionsFinite(long n){
		partitionsMap.put(0L, new BigInteger("1"));
		// The values of all previous partitions are required and must first be calculated.
		for(long i = 1; i < n; i++){
			if(!partitionsMap.containsKey(i)){
				partitionsFinite(i);
			}
		}
		
		BigInteger product = new BigInteger("0");
		int addCount = 0;
		int index = 1;
		long k = n - generalizedPentagonal(index);
		while(k >= 0){
			if(addCount < 2){
				product = product.add(partitionsMap.get(k));
				addCount++;
			}else{
				product = product.subtract(partitionsMap.get(k));
				addCount++;
				if(addCount == 4){
					addCount = 0;
				}
			}		
			k = n - generalizedPentagonal(++index);
		}
		if(n != 0){
			partitionsMap.put((long)n, product);
		}
		
		return partitionsMap.get(n);
	}
		
	/**
	 * Returns the pentagonal number corresponding to index m.
	 * @param m
	 * @return
	 */
	public static long pentagonal(long m){
		return m * (3 * m - 1) / 2;
	}
	
	/**
	 * Returns the generalized pentagonal number corresponding to the index m.
	 * @param m
	 * @return
	 */
	public static long generalizedPentagonal(long m){
		if(pentagonalCache.size() > m){
			return pentagonalCache.get((int)m);
		}
		if(m == 0) return 0;
		m++;
		long i = m / 2;
		
		if(m % 2 == 0){
			return pentagonal(i);
		}
		else{
			return pentagonal(-(i));
		}
	}
	
	/**
	 * Returns the triangle number that exists at a specified position.
	 * Triangle numbers: 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
	 * @param num
	 * @return
	 */
	public static long findTriangleNumberAtPosition(long num){
		long sum = 0;
		for(long i = 1; i < num; i++){
			sum += i;
		}
		return sum;
	}
	
	/**
	 * The following iterative sequence is defined for the set of positive integers:
	 * n -> n/2 (n is even)
	 * n -> 3n + 1 (n is odd)
	 * 
	 * Based on input, n, returns the next number in the sequence.
	 * @param n
	 * @return
	 */
	public static long findNextInCollatzSequence(long n){
		if(n %2 == 0){
			return n / 2;
		}
		else{
			return 3 * n + 1;
		}
	}
	
	/**
	 * Returns row n of Pascal's Triangle.  Functional up until the point a value
	 * exceeds a 64bit long value.
	 * 
	 * The general solution is:
	 * 
	 * (n, k) = (n, k-1) * ((n + 1 - k) / k)
	 * 
	 * where n is the row and k is the column
	 * 
	 * Using combinations, it can be found as:
	 * 
	 * (n, k) = (n!) / (k! * (n - k)!)
	 *  
	 * @param n
	 * @return
	 * @throws Exception 
	 */
	public static List<Long> find64BitRowInPascalsTriangle(int n) throws Exception{
		// This very quickly overflows:
		// factorial(n) / (factorial(k) * factorial(n-k));
		
		List<Long> values = new ArrayList<Long>();
		
		for(int i = 0; i <= n; i++){
			if(i == 0){
				values.add(1L);
			}
			else{
				long val = values.get(i-1) * (n + 1 - i) / i;
				
				if(val < 1){
					throw new Exception("64-bit long overflow encountered!");
				}
				else{
					values.add(val);
				}
			}
		}
		
		return values;
	}
	
	/**
	 * Returns row n of Pascal's Triangle.  Uses BigInteger to allow arbitrarily
	 * large calculations limited by memory available.
	 * 
	 * The general solution is:
	 * 
	 * (n, k) = (n, k-1) * ((n + 1 - k) / k)
	 * 
	 * where n is the row and k is the column
	 * 
	 * Using combinations, it can be found as:
	 * 
	 * (n, k) = (n!) / (k! * (n - k)!)
	 *  
	 * @param n
	 * @return
	 * @throws Exception 
	 */
	public static List<BigInteger> findRowInPascalsTriangle(int n) throws Exception{
		// This very quickly overflows:
		// factorial(n) / (factorial(k) * factorial(n-k));
		
		List<BigInteger> values = new ArrayList<BigInteger>();
		
		for(int i = 0; i <= n; i++){
			if(i == 0){
				values.add(BigInteger.ONE);
			}
			else{
				BigInteger numerator = BigInteger.valueOf(n).add(BigInteger.ONE).subtract(BigInteger.valueOf(i));
				BigInteger val = values.get(i-1).multiply(numerator).divide(BigInteger.valueOf(i));
				values.add(val);
			}
		}
		
		return values;
	}
	
	/**
	 * Returns the number of consecutive primes produced by the quadratic
	 * equation: n� + an + b
	 * 
	 * @param a
	 * @param b
	 * @param cm
	 * @return
	 */
	public static int evaluateEulerQuadraticFormula(int a, int b){
		
		int n = 0;
		while(true){
			
			int product = (n * n) + (a * n) + b;
			if(isPrime(product)){
				n++;
			}
			else{
				return n;
			}
		}
	}
	
	/**
	 * Returns a number derived by concatenating positions within a larger
	 * number.  
	 * 
	 * Example:
	 * number: 34293482348
	 * positions:[1,5,8]
	 * returns: 332
	 * 
	 * @param num - the number used to create a new number
	 * @param positions - the positions within num that should be extracted
	 * 	to form a new number.  1-based indexing.
	 * @return
	 */
	public static int buildNumberFromLargerNumber(long num, List<Integer> positions){
		String numStr = Long.toString(num);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i : positions){
			try{
				sb.append(String.valueOf(numStr.charAt(i - 1)));
			}
			catch(Exception e){
				System.out.println(num + ", " + positions);
			}
		}
		return Integer.valueOf(sb.toString());
	}
	
	/**
	 * Taking a triangle of this form:
	 * 
	 * 	75
	 *	95 64
	 *	17 47 82
	 *	18 35 87 10
	 *	20 04 82 47 65
	 *	19 01 23 75 03 34
	 *
	 *	... and so on, to an arbitrary length, find the weight of the greatest
	 *	path through from top to bottom, touching every row and not moving
	 *	laterally more than one position with each move.  In the example above,
	 *	from 75, either 95 or 64 can be chosen next.  If 64 is chosen, then
	 *	only 47 or 82 could be chosen in the following move, and so on until
	 *	the last row has been reached.
	 *
	 *	This solution is done by looking at the end of the triangle first and
	 * 	then working backwards.  Each part in the tree has two children (except
	 *	for the last row).  The maximum weight of the parent can be determined
	 * 	by choosing the larger of the two children.  On the next iteration that
	 *	parent becomes a child and then competes with its siblings for the
	 * 	largest weight for its parent.  When the top of the triangle is reached
	 * 	the maximum weight path is obtained.
	 *
	 * @param triangle
	 * @return
	 */
	public static long maximumDistanceThroughTriangle(List<String> triangle){
		List<List<Integer>> values = new ArrayList<List<Integer>>();
		for(String s : triangle){
			List<Integer> row = new ArrayList<Integer>();
			String[] pieces = s.split(" ");
			
			for(String num : pieces){
				row.add(Integer.valueOf(num));
			}
			values.add(row);			
		}
		
		for(int i = triangle.size() - 1; i > 0; i--){
			// Find the larger of the two child values and assign it and
			// its parent's value to the parent.
			for(int x = 0; x < values.get(i - 1).size(); x++){
				int greaterValue = values.get(i).get(x) > values.get(i).get(x+1) ?
						values.get(i).get(x) : values.get(i).get(x+1);
				values.get(i - 1).set(x, values.get(i - 1).get(x) + greaterValue);
			}
			
			// Set the children to zero
			for(int x = 0; x < values.get(i).size(); x++){
				values.get(i).set(x, 0);
			}
		}
		
		return values.get(0).get(0);
	}
	
	/**
	 * Opens a text file and reads in comma separated elements.
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static List<List<Long>> getElementsFromFile(String path) throws IOException{
		List<String> sample = FileUtil.getTextFromFile(path);
		
		List<List<Long>> elements = new ArrayList<List<Long>>();
		
		for(String s : sample){
			String[] pieces = s.split(",");
			List<Long> row = new ArrayList<Long>();
			for(String piece : pieces){
				row.add(Long.valueOf(piece));
			}
			elements.add(row);
		}
		
		return elements;
	}
	
	/**
	 * Constructs a Node Map structure based on a raw data element structure
	 * that was most likely created from a text file.
	 * 
	 * @param elements
	 * @return
	 */
	public static Map<Location, Node> buildNodeFromElements(List<List<Long>> elements){
		Map<Location, Node> nodes = new HashMap<Location, Node>();
		
		for(int row = 0; row < elements.size(); row++){
			for(int col = 0; col < elements.get(0).size(); col++){
				Location loc = new Location(row, col);
				nodes.put(loc, new Node(elements.get(row).get(col), loc));
			}
		}
		
		return nodes;
	}
	
	/**
	 * Long power calculation.  Roughly 10x faster than 
	 * Math.pow(double a, double b) cast to long.
	 * 
	 * @param num
	 * @param power
	 * @return
	 */
	public static long pow(long num, long power){
		if(power < 0){
			throw new IllegalArgumentException("Power is less than zero!");
		}
		long product = 1;
		for(int i = 0; i < power; i++){
			product *= num;
		}
		return product;
	}
	
public static List<List<Point>> findEdges(List<Point> points, Point centroid, Type t){
		
		List<List<Point>> edges = new ArrayList<List<Point>>();
		
		Point a = centroid;
		Point b = findFarthestPoint(points, centroid, t);
		Point first = new Point(b.getX(t), b.getY(t), 0);
		Point last = b;
		Point c = null;
		int count = 0;
		
		do{
			double maxAngle = 0.0;
			
			for(Point potential : points){
				if(potential.equals(a) || potential.equals(b) || potential.equals(last)) continue;
				double ab = findDistance(a, b, t);
				double bc = findDistance(b, potential, t);
				double ca = findDistance(potential, a, t);
				
				Map<Double, Double> angles = findAngles(ab, bc, ca);
				
				// verify clockwise direction by taking cross product
				double crossProduct = (b.getX(t)-a.getX(t))*(potential.getY(t)-a.getY(t)) -
									  (b.getY(t)-a.getY(t))*(potential.getX(t)-a.getX(t));
				
				if(crossProduct <= 0){
					continue;
				}
				
				if(angles.get(ca) > maxAngle){
					maxAngle = angles.get(ca);
					c = potential;
				}
			}
			if(c == null){
				throw new RuntimeException("Could not find valid point in perimeter!");
			}
			
			// a, b, and c are known, draw line from b to c
			List<Point> edge = new ArrayList<Point>();
			edge.add(b);
			edge.add(c);
			edges.add(edge);
			
			last = b;
			b = new Point(c.getX(t), c.getY(t), 0);
			c = null;
			count++;
			if(count > points.size()){
				break;
			}
		}while(!first.equals(b));
		
		return edges;
	}
	
	public static Point findCentroid(List<Point> points){
		float xSum = 0.0f;
		float ySum = 0.0f;
		float zSum = 0.0f;
		
		for(Point p : points){
			xSum += p.getX();
			ySum += p.getY();
			zSum += p.getZ();
		}
		
		if(points.size() == 0){
			return null;
		}
		
		return new Point(xSum / points.size(), ySum / points.size(), zSum / points.size());
	}
		
	public static Map<Double, Double> findAngles(double a, double b, double c){
		Map<Double, Double> sideToAngleMap = new HashMap<Double, Double>();
		
		sideToAngleMap.put(a, Math.toDegrees(Math.acos((b*b + c*c - a*a) / (2*b*c))));
		sideToAngleMap.put(b, Math.toDegrees(Math.acos((a*a + c*c - b*b) / (2*a*c))));
		sideToAngleMap.put(c, 180 - sideToAngleMap.get(a) - sideToAngleMap.get(b));
		
		return sideToAngleMap;
	}
	
	public static Point findFarthestPoint(List<Point> points, Point centroid, Type t){
		Point farthestPoint = null;
		double max = Double.MIN_VALUE;
		for(Point p : points){
			double distance = findDistance(p, centroid, t);
			if(distance > max){
				max = distance;
				farthestPoint = p;
			}
		}
		return farthestPoint;
	}
	
	public static Point findNearestPoint(List<Point> points, Point centroid, Type t){
		Point nearestPoint = null;
		double min = Double.MAX_VALUE;
		for(Point p : points){
			double distance = findDistance(p, centroid, t);
			if(distance < min){
				min = distance;
				nearestPoint = p;
			}
		}
		return nearestPoint;
	}
	
	public static double findDistance(Point a, Point b, Type t){
		return Math.sqrt((Math.pow((a.getX(t) - b.getX(t)), 2) +
						  Math.pow((a.getY(t) - b.getY(t)), 2) +
						  Math.pow((a.getZ(t) - b.getZ(t)), 2)));
	}
}