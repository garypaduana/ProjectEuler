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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.gp.projecteuler.Card.Suit;
import com.gp.projecteuler.Card.Value;

public class PokerHand implements Comparable<PokerHand>{
	
	public enum HandResult{
		
		ROYAL_FLUSH(10), STRAIGHT_FLUSH(9), FOUR_OF_A_KIND(8),
			FULL_HOUSE(7), FLUSH(6), STRAIGHT(5), THREE_OF_A_KIND(4),
			TWO_PAIRS(3), ONE_PAIR(2), HIGH_CARD(1);
		
		private List<Integer> sortedRanks = new ArrayList<Integer>();
		private int rank;
		private HandResult(int rank){
			this.rank = rank;
		}
		
		public int getRank(){
			return this.rank;
		}

		public List<Integer> getSortedRanks() {
			return sortedRanks;
		}
	}
	
	private List<String> rawCards;
	private List<Card> cards = new ArrayList<Card>();
	private Map<String, Suit> suitMap = new HashMap<String, Suit>();
	private Map<String, Value> valueMap = new HashMap<String, Value>();
	private HandResult handResult = null;
	
	public PokerHand(List<String> cards){
		this.rawCards = cards;
		init();
	}
		
	private void init(){
		for(Suit suit : Suit.values()){
			suitMap.put(suit.getAbbreviation(), suit);
		}
		
		for(Value value : Value.values()){
			valueMap.put(value.getAbbreviation(), value);
		}
		
		for(String s : rawCards){
			Card c = new Card(valueMap.get(s.substring(0, 1)), suitMap.get(s.substring(1, 2)));
			cards.add(c);
		}
		
		computeHandResult();
		this.handResult.getSortedRanks().addAll(findSortedRanks(cards));
	}
	
	private void computeHandResult(){
				
		// #### Royal Flush ####
		for(Suit suit : Suit.values()){
			if(cards.contains(new Card(Value.TEN, suit)) &&
			   cards.contains(new Card(Value.JACK, suit)) &&
			   cards.contains(new Card(Value.QUEEN, suit)) &&
			   cards.contains(new Card(Value.KING, suit)) &&
			   cards.contains(new Card(Value.ACE, suit))){
				this.handResult = HandResult.ROYAL_FLUSH;
				return;
			}
		}
		
		// #### Straight Flush, Striaght, and Flush ####
		List<Integer> ranks = new ArrayList<Integer>();
		for(Card c : cards){
			ranks.add(c.getValue().getRank());
		}
		boolean consecutive = true;
		for(int i = Collections.min(ranks); i < Collections.min(ranks) + 5; i++){
			if(!ranks.contains(i)){
				consecutive = false;
				break;
			}	
		}
		
		boolean sameSuit = true;
		
		Suit aSuit = null;
		for(Card c : cards){
			if(aSuit == null){
				aSuit = c.getSuit();
			}
			
			if(!aSuit.equals(c.getSuit())){
				sameSuit = false;
				break;
			}
		}
				
		if(consecutive && sameSuit){
			this.handResult = HandResult.STRAIGHT_FLUSH;
			return;
		}
		else if(sameSuit){
			this.handResult = HandResult.FLUSH;
			return;
		}
		else if(consecutive){
			this.handResult = HandResult.STRAIGHT;
			return;
		}
		
		// #### Four of a Kind, Full House, Three of a Kind, Two Pairs, One Pair ####
		
		Map<Integer, Integer> duplicateRankMap = findDuplicateRanks(cards);
		
		// 5 of a kind, not possible
		if(duplicateRankMap.size() == 1){
			
		}
		else if(duplicateRankMap.size() == 2){
			if(Collections.max(duplicateRankMap.values()) == 4){
				this.handResult = HandResult.FOUR_OF_A_KIND;
				return;
			}
			else{
				this.handResult = HandResult.FULL_HOUSE;
				return;
			}
		}
		else if(duplicateRankMap.size() == 3){
			if(Collections.max(duplicateRankMap.values()) == 3){
				this.handResult = HandResult.THREE_OF_A_KIND;
				return;
			}
		}
		
		int pairCount = 0;
		for(int value : duplicateRankMap.values()){
			if(value == 2){
				pairCount++;
			}
		}
		
		if(pairCount == 2){
			this.handResult = HandResult.TWO_PAIRS;
			return;
		}
		else if(pairCount == 1){
			this.handResult = HandResult.ONE_PAIR;
			return;
		}
				
		this.handResult = HandResult.HIGH_CARD;
		return;
	}
	
	public List<Card> getCards(){
		return this.cards;
	}
	
	@Override
	public boolean equals(Object o){
		if(o == null) return false;
		if(! (o instanceof PokerHand)) return false;
		
		PokerHand oPh = (PokerHand)o;
		
		if(cards.containsAll(oPh.getCards()) &&
			oPh.getCards().containsAll(this.cards) &&
			this.cards.size() == oPh.getCards().size()){
			return true;
		}
		return false;
	}
	
	@Override 
	public int hashCode(){
		int code = 1;
		for(Card c : cards){
			code *= c.hashCode();
		}
		
		return code;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(Card card : cards){
			sb.append(card.toString() + " ");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append(", HandResult: " + handResult.toString());
		return sb.toString();
	}
	
	@Override
	public int compareTo(PokerHand ph) {
		if(this.handResult.getRank() > ph.getHandResult().getRank()){
			return 1;
		}
		else if(this.handResult.getRank() < ph.getHandResult().getRank()){
			return -1;
		}
		else if(this.handResult.getRank() == ph.getHandResult().getRank()){
			
			if(this.handResult.equals(HandResult.STRAIGHT_FLUSH)){
				for(int i = this.handResult.getSortedRanks().size() - 1; i >= 0; i--){
					if(this.handResult.getSortedRanks().get(i) > ph.getHandResult().getSortedRanks().get(i)){
						return 1;
					}
					else if(this.handResult.getSortedRanks().get(i) < ph.getHandResult().getSortedRanks().get(i)){
						return -1;
					}
				}
			}
			else if(this.handResult.equals(HandResult.FOUR_OF_A_KIND)){
				return compareDups(ph, 4);
			}
			else if(this.handResult.equals(HandResult.FULL_HOUSE)){
				Map<Integer, Integer> thisDups = findDuplicateRanks(this.cards);
				Map<Integer, Integer> phDups = findDuplicateRanks(ph.getCards());
				
				int thisThreeCard = 0;
				for(int card : thisDups.keySet()){
					if(thisDups.get(card) == 3){
						thisThreeCard = card;
					}
				}
				
				int phThreeCard = 0;
				for(int card : phDups.keySet()){
					if(phDups.get(card) == 3){
						phThreeCard = card;
					}
				}
				
				if(thisThreeCard > phThreeCard){
					return 1;
				}
				else if(thisThreeCard < phThreeCard){
					return -1;
				}
				else{
					thisDups.remove(thisThreeCard);
					phDups.remove(thisDups);
					
					int thisPair = 0;
					int dupPair = 0;
					for(int card : thisDups.keySet()){
						thisPair = thisDups.get(card);
						break;
					}
					for(int card : phDups.keySet()){
						dupPair = phDups.get(card);
						break;
					}
					
					if(thisPair > dupPair) return 1;
					else if(thisPair < dupPair) return -1;
					else return 0;
				}
			}
			else if(this.handResult.equals(HandResult.FLUSH) || this.handResult.equals(HandResult.STRAIGHT)){
				List<Integer> thisRanks = findSortedRanks(this.cards);
				List<Integer> dupRanks = findSortedRanks(ph.getCards());
				
				for(int i = thisRanks.size() - 1; i >= 0; i--){
					if(thisRanks.get(i) > dupRanks.get(i)) return 1;
					else if(thisRanks.get(i) < dupRanks.get(i)) return -1;
				}
				return 0;
			}
			else if(this.handResult.equals(HandResult.THREE_OF_A_KIND)){
				return compareDups(ph, 3);
			}
			else if(this.handResult.equals(HandResult.TWO_PAIRS)){
				Map<Integer, Integer> thisDups = findDuplicateRanks(this.cards);
				Map<Integer, Integer> phDups = findDuplicateRanks(ph.getCards());
				
				List<Integer> thisPairValues = new ArrayList<Integer>();
				int thisSingle = 0;
				List<Integer> phPairValues = new ArrayList<Integer>();
				int phSingle = 0;
				
				for(int i : thisDups.keySet()){
					if(thisDups.get(i) > 1){
						thisPairValues.add(i);
					}
					else{
						thisSingle = i;
					}
				}
				
				for(int i : phDups.keySet()){
					if(phDups.get(i) > 1){
						phPairValues.add(i);
					}
					else{
						phSingle = i;
					}
				}
				
				Collections.sort(thisPairValues);
				Collections.sort(phPairValues);
				
				for(int i = thisPairValues.size() - 1; i >= 0; i--){
					if(thisPairValues.get(i) > phPairValues.get(i)) return 1;
					else if(thisPairValues.get(i) < phPairValues.get(i)) return -1;
				}
				
				if(thisSingle > phSingle){
					return 1;
				}
				else if(thisSingle < phSingle){
					return -1;
				}
				
				return 0;
			}
			else if(this.handResult.equals(HandResult.ONE_PAIR)){
				return compareDups(ph, 2);
			}
			else if(this.handResult.equals(HandResult.HIGH_CARD)){
				if(findSortedRanks(this.cards).get(4) > findSortedRanks(ph.getCards()).get(4)){
					return 1;
				}
				if(findSortedRanks(this.cards).get(4) < findSortedRanks(ph.getCards()).get(4)){
					return -1;
				}
			}
		}
		
		// ROYAL FLUSH
		return 0;
	}

	public HandResult getHandResult() {
		return handResult;
	}
	
	public int maxCard(List<Card> cards){
		int max = 0;
		for(Card c : cards){
			if(c.getValue().getRank() > max){
				max = c.getValue().getRank();
			}
		}
		return max;
	}
	
	private int compareDups(PokerHand ph, int n){
		Map<Integer, Integer> thisDups = findDuplicateRanks(this.cards);
		Map<Integer, Integer> phDups = findDuplicateRanks(ph.getCards());
		
		int thisMatchCard = 0;
		for(int card : thisDups.keySet()){
			if(thisDups.get(card) == n){
				thisMatchCard = card;
			}
		}
		
		int phMatchCard = 0;
		for(int card : phDups.keySet()){
			if(phDups.get(card) == n){
				phMatchCard = card;
			}
		}
		
		if(thisMatchCard > phMatchCard){
			return 1;
		}
		if(thisMatchCard < phMatchCard){
			return -1;
		}
		else{
			List<Integer> thisSortedRanks = findSortedRanks(this.cards);
			List<Integer> phSortedRanks = findSortedRanks(ph.getCards());
			
			for(int i = thisSortedRanks.size() - 1; i >= 0; i--){
				if(thisSortedRanks.get(i) != thisMatchCard){
					if(thisSortedRanks.get(i) > phSortedRanks.get(i)){
						return 1;
					}
					else if(thisSortedRanks.get(i) < phSortedRanks.get(i)){
						return -1;
					}
				}
			}
		}
		
		return 0;
	}
	
	public List<Integer> findSortedRanks(List<Card> cards){
		List<Integer> ranks = new ArrayList<Integer>();
		
		for(Card c : cards){
			ranks.add(c.getValue().getRank());
		}
		
		Collections.sort(ranks);
		
		return ranks;
	}
	
	public Map<Integer, Integer> findDuplicateRanks(List<Card> cards){
		Map<Integer, Integer> duplicateRankMap = new TreeMap<Integer, Integer>();
		
		for(Card c : cards){
			if(duplicateRankMap.containsKey(c.getValue().getRank())){
				duplicateRankMap.put(c.getValue().getRank(), duplicateRankMap.get(c.getValue().getRank()) + 1);
			}
			else{
				duplicateRankMap.put(c.getValue().getRank(), 1);
			}
		}
		return duplicateRankMap;
	}
}
