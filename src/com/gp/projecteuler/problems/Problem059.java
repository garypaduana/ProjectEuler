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
import java.util.List;

import com.gp.projecteuler.CommonMath;
import com.gp.projecteuler.FileUtil;

public class Problem059 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		List<String> contents = FileUtil.getTextFromFile("./resources/Problem059.txt");
		String phrase = null;
		
		StringBuffer sb = new StringBuffer();
		for(String c : contents){
			System.out.println(c);
			String[] pieces = c.split(",");
			for(int i = 0; i < pieces.length; i++){
				int val = Integer.valueOf(pieces[i]);
				sb.append((char)val);
			}
			phrase = sb.toString();
		}
		
		sb = new StringBuffer();
		for(byte i = 97; i < 123; i++){
			for(byte j = 97; j < 123; j++){
				for(byte k = 97; k < 123; k++){
					sb.append((char)i);
					sb.append((char)j);
					sb.append((char)k);
					String decrypted = CommonMath.xorMessage(phrase, sb.toString());
					if(decrypted.contains(" the ")){
						System.out.println(decrypted);
						
						byte[] bytes = decrypted.getBytes();
						
						int sum = 0;
						for(byte b : bytes){
							sum += b;
						}
						System.out.println("key: " + sb.toString());
						System.out.println("Sum: " + sum);
					}
					sb.setLength(0);
				}
			}
		}
	}
}
