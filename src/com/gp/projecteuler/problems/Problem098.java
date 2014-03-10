package com.gp.projecteuler.problems;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.gp.projecteuler.Trie;
import com.gp.projecteuler.FileUtil;

public class Problem098 {
	private Trie trie = new Trie();
	private Set<String> wordSet = new HashSet<String>();
	private Set<String> validPerms = new HashSet<String>();
	private Set<Integer> squares = new TreeSet<Integer>();
	
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		
		Problem098 p = new Problem098();	
		
		p.process();
		
		System.out.println("Duration: " + (System.currentTimeMillis() - start));
	}
	
	public void process() throws IOException{
		int largest = 0;
		
		int squared = 1;
		int i = 1;
		do{
			squared = i * i;
			squares.add(squared);
			i++;
		}
		while(squared <= 987654321);
		
		List<String> lines = FileUtil.getTextFromFile("./resources/problem098.txt");
		
		for(String line : lines){
			String[] words = line.split(",");
			for(String word : words){
				word = word.replace("\"", "");
				trie.add(word);
				wordSet.add(word);
			}
		}
		for(String word : wordSet){
			validPerms.clear();
			permutationFailFast(stringToList(word));
			if(validPerms.size() == 2){
				
				List<String> perms = new ArrayList<String>(validPerms);
				Map<String, Integer> letterMap = new HashMap<String, Integer>();
				
				int wordLength = perms.get(0).length();
				
				for(int square : squares){
					String numS = String.valueOf(square);
					if(numS.length() != wordLength){
						continue;
					}
					
					for(int j = 0; j < numS.length(); j++){
						letterMap.put(String.valueOf(perms.get(0).charAt(j)), 
									  Integer.valueOf(String.valueOf(numS.charAt(j))));
						
					}
					
					StringBuilder sb = new StringBuilder();
					for(int k = 0; k < perms.get(1).length(); k++){
						sb.append(letterMap.get(String.valueOf(perms.get(1).charAt(k))));
					}
					
					int permWordNum = Integer.valueOf(sb.toString());
					
					if(squares.contains(permWordNum) && sb.toString().length() ==
						(new TreeSet<Integer>(letterMap.values()).size())){
						if(permWordNum > largest){
							largest = permWordNum;
							
							System.out.println(validPerms);
							System.out.println(numS + ", " + sb.toString());
						}
					}
				}
			}
		}

	}
	
	public List<String> stringToList(String word){
		List<String> ret = new ArrayList<String>();
		for(char c : word.toCharArray()){
			ret.add(String.valueOf(c));
		}
		return ret;
	}
	
	public List<List<String>> permutationFailFast(List<String> list) throws IOException {
		List<String> empty = new ArrayList<String>();
	    return permutationFailFast(empty, list, list.size()); 
	}
	
	@SuppressWarnings("unchecked")
	private List<List<String>> permutationFailFast(List<String> prefix,
												   List<String> list, int length) {
		StringBuilder sb = new StringBuilder();
		
	    List<List<String>> permList = new ArrayList<List<String>>();
		if (list.size() == 0){
			return Arrays.asList(prefix);
		}
		else{
			for(int i = 0; i < list.size(); i++){
				List<String> pre = new ArrayList<String>();
				pre.addAll(prefix);
				pre.add(list.get(i));
				
				List<String> rem = new ArrayList<String>();
				rem.addAll(list.subList(0, i));
				rem.addAll(list.subList(i+1, list.size()));
				
				// Figure out if you should continue right here
				// check to see if what we have so far is found in the TrieNode
				// Also, everything needs to be a neighbor
				
				sb.delete(0, sb.length());
				for(String s : pre){
					sb.append(s);
				}
				
				if(trie.containsPartial(sb.toString())){
					
					if(trie.contains(sb.toString()) && sb.toString().length() == length){
						validPerms.add(sb.toString());
					}
					permList.addAll(permutationFailFast(pre, rem, length));
				}
			}  
		}
		return permList;
	}
}
