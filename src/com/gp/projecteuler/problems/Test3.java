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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gp.projecteuler.DatabaseUtil;
import com.gp.projecteuler.FileUtil;
import com.gp.projecteuler.UrlUtil;


public class Test3 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
//		List<String> urls = FileUtil.getTextFromFile("./resources/reddit.txt");
//		
//		for(String url : urls){
//			long start = System.currentTimeMillis();
//			executeRedditProcess(url);
//			System.out.println((System.currentTimeMillis() - start) + " ms for: " + url);
//		}
		
		Map<String, SortedSet<String>> wordsMap = new HashMap<String, SortedSet<String>>();
		
		for(String subreddit : expand(DatabaseUtil.executeImmediate("SELECT distinct subreddit from test.words"))){
			wordsMap.put(subreddit, new TreeSet<String>(expand(DatabaseUtil.executeImmediate(
					"SELECT word FROM test.words WHERE subreddit = '" + subreddit + "'"))));
		}
		
		for(String sub : wordsMap.keySet()){
			FileUtil.writeTextToFile("./resources/uniqueWords.txt", "From the perspective of: " + sub +
					", these words are unique to this subreddit:\r\n", true);
			
			wordLoop:
			for(String word : wordsMap.get(sub)){
				if(word.contains("http") || word.contains("href") || word.length() < 6) continue wordLoop;
				for(String otherSub : wordsMap.keySet()){
					if(otherSub.equals(sub)){
						continue;
					}
					if(wordsMap.get(otherSub).contains(word)){
						continue wordLoop;
					}
				}
				FileUtil.writeTextToFile("./resources/uniqueWords.txt", word + "\r\n", true);
			}
		}
	}
	
	public static List<String> expand(List<List<String>> words){
		List<String> results = new ArrayList<String>();
		
		for(List<String> l : words){
			for(String s : l){
				results.add(s);
			}
		}
		return results;
	}
		
	public static void executeRedditProcess(String url){
		List<String> contents = UrlUtil.getUrlContents(url);
		Set<String> filters = new HashSet<String>();
		filters.add("<div");
		filters.add("class=\"md\">");
		filters.add("<p>");
		filters.add("</p>");
		filters.add("\\");
		filters.add("/");
		
		List<String> sql = new ArrayList<String>();
		String subreddit = url.replace("http://www.reddit.com/r/", "");
		subreddit = subreddit.substring(0, subreddit.indexOf("/"));
		
		for(String s : contents){
			if(!s.contains("<div class=\"md\">")) continue;
			if(s.contains("commentarea")){
				s = s.substring(s.indexOf("commentarea"), s.length());
			}
			if(s.contains("reddit is a source for")) continue;
			
			int dateIndex = s.indexOf("datetime");
			String date = s.substring(dateIndex + 10, dateIndex + 10 + 19).replace("T", " ");
			
			Pattern p = Pattern.compile("http://www.reddit.com/user/([\\w]+).+");
			Matcher matcher = p.matcher(s);
			if(!matcher.find()){
				continue;
			}
			String username = matcher.group(1);
			s = s.substring(s.lastIndexOf("<div class=\"md\">"), s.length());
			
			String[] pieces = s.split(" ");
			
			for(String word : pieces){
				for(String filter : filters){
					word = word.replace(filter, "");
				}
				
				if(word.length() > 0){
					sql.add("insert into test.words (word, subreddit, username, timegroup) values ('" + word + 
						"', '" + subreddit + "', '" + username + "', '" + date + "')");
				}
			}
		}
		DatabaseUtil.execute(sql);
	}
}
