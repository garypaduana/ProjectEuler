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

public class Card implements Comparable<Card>{
	
	public enum Suit{
		HEART("H"), SPADE("S"), CLUB("C"), DIAMOND("D");
		
		private String abbreviation;
		
		private Suit(String abbreviation){
			this.abbreviation = abbreviation;
		}
		
		public String getAbbreviation(){
			return abbreviation;
		}
	}
	
	public enum Value{
		TWO("2", 2), THREE("3", 3), FOUR("4", 4), FIVE("5", 5), SIX("6", 6),
			SEVEN("7", 7), EIGHT("8", 8), NINE("9", 9), TEN("T", 10),
			JACK("J", 11), QUEEN("Q", 12), KING("K", 13), ACE("A", 14);
		
		private String abbreviation;
		private int rank;
		
		private Value(String abbreviation, int rank){
			this.abbreviation = abbreviation;
			this.rank = rank;
		}
		
		public String getAbbreviation(){
			return abbreviation;
		}
		public int getRank(){
			return rank;
		}
	}
	
	private final Suit suit;
	private final Value value;
	
	public Card(Value value, Suit suit){
		this.value = value;
		this.suit = suit;
	}
	
	public Value getValue(){
		return value;
	}
	
	public Suit getSuit(){
		return suit;
	}
	
	@Override
	public int hashCode(){
		return value.getRank() * 31 * 
			(CommonMath.charArrayToAlphaPositionList(suit.getAbbreviation()).get(0) + 31);
	}
	
	@Override
	public boolean equals(Object o){
		if(o == null) return false;
		if(! (o instanceof Card)) return false;
		
		Card oArg = (Card)o;
		if(this.suit.equals(oArg.getSuit()) && this.value.equals(oArg.getValue())){
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString(){
		return value.getAbbreviation() + suit.getAbbreviation();
	}

	@Override
	public int compareTo(Card o) {
		if(this.value.getRank() > o.getValue().getRank()){
			return 1;
		}
		else if(this.value.getRank() < o.getValue().getRank()){
			return -1;
		}
		return 0;
	}
}
