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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	public static List<String> getTextFromFile(String path) throws IOException{
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(new File(path)));
			List<String> lineList = new ArrayList<String>();
			
			String line = null;
			while((line = br.readLine()) != null){
				lineList.add(line);
			}
		
			return lineList;
		}
		finally{
			if(br != null){
				br.close();
			}
		}
	}
	
	public static String getRawTextFromFile(String path) throws IOException{
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		try{
			br = new BufferedReader(new FileReader(new File(path)));
			
			String line = null;
			while((line = br.readLine()) != null){
				sb.append(line);
				sb.append("\r\n");
			}
		
			return sb.toString();
		}
		finally{
			if(br != null){
				br.close();
			}
		}
	}
	
	public static void writeTextToFile(String path, String contents, boolean append) throws IOException{
		BufferedWriter bw = null;
		try{
			bw = new BufferedWriter(new FileWriter(new File(path), append));	
			bw.append(contents);
		}
		finally{
			if(bw != null){
				bw.close();
			}
		}
	}
}
