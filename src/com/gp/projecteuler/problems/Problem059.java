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

/**
	Each character on a computer is assigned a unique code and the 
	preferred standard is ASCII (American Standard Code for Information 
	Interchange). For example, uppercase A = 65, asterisk (*) = 42, and 
	lowercase k = 107.
	
	A modern encryption method is to take a text file, convert the bytes 
	to ASCII, then XOR each byte with a given value, taken from a secret 
	key. The advantage with the XOR function is that using the same 
	encryption key on the cipher text, restores the plain text; for 
	example, 65 XOR 42 = 107, then 107 XOR 42 = 65.
	
	For unbreakable encryption, the key is the same length as the plain 
	text message, and the key is made up of random bytes. The user would 
	keep the encrypted message and the encryption key in different 
	locations, and without both "halves", it is impossible to decrypt 
	the message.
	
	Unfortunately, this method is impractical for most users, so the 
	modified method is to use a password as a key. If the password is 
	shorter than the message, which is likely, the key is repeated 
	cyclically throughout the message. The balance for this method is 
	using a sufficiently long password key for security, but short 
	enough to be memorable.
	
	Your task has been made easy, as the encryption key consists of 
	three lower case characters. Using cipher1.txt (right click and 
	'Save Link/Target As...'), a file containing the encrypted ASCII 
	codes, and the knowledge that the plain text must contain common 
	English words, decrypt the message and find the sum of the ASCII 
	values in the original text.
 */
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
						System.out.println("Answer: " + sum);
					}
					sb.setLength(0);
				}
			}
		}
	}
}
