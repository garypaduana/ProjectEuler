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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UrlUtil {

	public static List<String> getUrlContents(String urlString){
		List<String> contents = new ArrayList<String>();
		InputStream is = null;
		BufferedReader br = null;
		String line;
		URL url = null;

		try {
		    url = new URL(urlString);
		    is = url.openStream();
		    br = new BufferedReader(new InputStreamReader(is));

		    while ((line = br.readLine()) != null){
		        contents.add(line);
		    }
		}
		catch (MalformedURLException mue){
			mue.printStackTrace();
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
		finally{
			try{
				is.close();
		    } 
			catch (IOException ioe) {
		    
			}
		}
		
		return contents;
	}
}
