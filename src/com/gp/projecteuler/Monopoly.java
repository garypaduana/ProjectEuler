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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Monopoly {

	public static enum CommunityChest{
		GOTO_GO(0), GOTO_JAIL(15), NC1(1), NC2(2),
		NC3(3), NC4(4), NC5(5), NC6(6), NC7(7), NC8(8), NC9(9),
		NC10(10), NC11(11), NC12(12), NC13(13), NC14(14);
		
		private int index;
		
		private CommunityChest(int index){
			this.index = index;
		}

		public int getIndex() {
			return index;
		}
	}
	
	public static enum Chance{
		GOTO_GO(0), GOTO_JAIL(1), GOTO_C1(2), GOTO_E3(3),
		GOTO_H2(4), GOTO_R1(5), GOTO_NEXT_RR1(6), GOTO_NEXT_RR2(7),
		GOTO_NEXT_U(9), GOTO_3SQUARES_BACK(10), NC6(8),
		NC1(11), NC2(12), NC3(13), NC4(14), NC5(15);
		
		private int index;
		
		private Chance(int index){
			this.index = index;
		}
		
		public int getIndex(){
			return index;
		}
	}
		
	public static enum Square{
		GO(0), A1(1), CC1(2), A2(3), T1(4),
		R1(5), B1(6), CH1(7), B2(8), B3(9),
		JAIL(10), C1(11), U1(12), C2(13), C3(14),
		R2(15), D1(16), CC2(17), D2(18), D3(19),
		FP(20), E1(21), CH2(22), E2(23), E3(24), 
		R3(25), F1(26), F2(27), U2(28), F3(29),
		G2J(30), G1(31), G2(32), CC3(33), G3(34),
		R4(35), CH3(36), H1(37), T2(38), H2(39);
		
		private int index;
		
		private Square(int index){
			this.index = index;
		}

		public int getIndex() {
			return index;
		}
		
		@Override
		public String toString(){
			return name() + "(" + index + ")";
		}
	}
	
	private Random random = new Random();
	private int dieSides = 6;
	private Map<Integer, Square> reverseLookupSquare = new TreeMap<Integer, Square>();
	private Map<Integer, CommunityChest> reverseLookupCommunityChest = new TreeMap<Integer, CommunityChest>();
	private Map<Integer, Chance> reverseLookupChance = new TreeMap<Integer, Chance>();
	private List<Boolean> doublesHistory = new ArrayList<Boolean>();
	
	private Map<Square, Integer> squareFrequency = new HashMap<Square, Integer>();
	
	public Map<Square, Integer> getSquareFrequency() {
		return squareFrequency;
	}

	int rollSum = 0;
	long communityChestSum = 0;
	long chanceSum = 0;
	
	public Monopoly(){
		for(Square s : Square.values()){
			reverseLookupSquare.put(s.getIndex(), s);
			squareFrequency.put(s, 0);
		}
		
		for(CommunityChest cc : CommunityChest.values()){
			reverseLookupCommunityChest.put(cc.getIndex(), cc);
		}
		
		for(Chance c : Chance.values()){
			reverseLookupChance.put(c.getIndex(), c);
		}
	}
	
	public void roll(){
		int die1 = random.nextInt(dieSides) + 1;
		int die2 = random.nextInt(dieSides) + 1;
		rollSum += die1 + die2;
		
		doublesHistory.add(die1 == die2);
		
		if(doublesHistory.size() > 3) doublesHistory.remove(0);
		
		if(doublesHistory.size() == 3 && doublesHistory.get(0) == true && 
				doublesHistory.get(1) == true && doublesHistory.get(2) == true){
			rollSum = Square.JAIL.getIndex();
		}
		
		if(rollSum > 39){
			rollSum = rollSum - 40;
		}
		
		evaluateRoll();
		
		squareFrequency.put(reverseLookupSquare.get(rollSum), 
				squareFrequency.get(reverseLookupSquare.get(rollSum)) + 1);
	}
	
	private void evaluateRoll(){
		Square landed = reverseLookupSquare.get(rollSum);
		
		if(landed.equals(Square.CC1) || landed.equals(Square.CC2) || landed.equals(Square.CC3)){
			executeCommunityChest();
		}
		else if(landed.equals(Square.CH1) || landed.equals(Square.CH2)|| landed.equals(Square.CH3)){
			executeChance();
		}
		else if(landed.equals(Square.G2J)){
			rollSum = Square.JAIL.getIndex();
		}
	}
	
	private void executeCommunityChest(){
		// Community Chest
		communityChestSum++;
		CommunityChest cc = reverseLookupCommunityChest.get((int)(communityChestSum % 16));
		
		if(cc.equals(CommunityChest.GOTO_GO)){
			rollSum = Square.GO.getIndex();
		}
		else if(cc.equals(CommunityChest.GOTO_JAIL)){
			rollSum = Square.JAIL.getIndex();
		}
	}
	
	private void executeChance(){
		// Chance
		chanceSum++;
		Chance c = reverseLookupChance.get((int)(chanceSum % 16));
		
		if(c.equals(Chance.GOTO_GO)){
			rollSum = Square.GO.getIndex();
		}
		else if(c.equals(Chance.GOTO_JAIL)){
			rollSum = Square.JAIL.getIndex();
		}
		else if(c.equals(Chance.GOTO_C1)){
			rollSum = Square.C1.getIndex();
		}
		else if(c.equals(Chance.GOTO_E3)){
			rollSum = Square.E3.getIndex();
		}
		else if(c.equals(Chance.GOTO_H2)){
			rollSum = Square.H2.getIndex();
		}
		else if(c.equals(Chance.GOTO_R1)){
			rollSum = Square.R1.getIndex();
		}
		else if(c.equals(Chance.GOTO_NEXT_RR1) || c.equals(Chance.GOTO_NEXT_RR2)){
			for(int square = (int)rollSum; square <= Square.R4.getIndex(); square++){
				if(reverseLookupSquare.get(square).equals(Square.R1)){
					rollSum = square;
					break;
				}
				else if(reverseLookupSquare.get(square).equals(Square.R2)){
					rollSum = square;
					break;
				}
				else if(reverseLookupSquare.get(square).equals(Square.R3)){
					rollSum = square;
					break;
				}
				else if(reverseLookupSquare.get(square).equals(Square.R4)){
					rollSum = square;
					break;
				}
			}
		}
		else if(c.equals(Chance.GOTO_NEXT_U)){
			for(int square = (int)rollSum; square <= Square.U2.getIndex(); square++){
				if(reverseLookupSquare.get(square).equals(Square.U1)){
					rollSum = square;
					break;
				}
				else if(reverseLookupSquare.get(square).equals(Square.U2)){
					rollSum = square;
					break;
				}
			}
		}
		else if(c.equals(Chance.GOTO_3SQUARES_BACK)){
			rollSum -= 3;
			if(rollSum < 0){
				rollSum += 40;
			}
			
			evaluateRoll();
		}
	}
}
