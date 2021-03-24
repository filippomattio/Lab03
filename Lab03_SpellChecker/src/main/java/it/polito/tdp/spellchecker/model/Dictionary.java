package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Dictionary {
	
	private Set<RichWord> dizionarioIta = new HashSet<RichWord>();
	private Set<RichWord> dizionarioEng = new HashSet<RichWord>();

	
	public void loadDictionary(String language) {
		
		if(language.equals("English")) {
		try {
			FileReader fr = new FileReader("English.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while((word = br.readLine())!=null) {
				dizionarioEng.add(new RichWord(word,true));
			}
			br.close();
			System.out.println("File eng caricato");
			}
		catch(IOException e) {
			e.printStackTrace();
		}
		}
		
		if(language.equals("Italian")) {
		try {
			FileReader fr = new FileReader("Italian.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while((word = br.readLine())!=null) {
				dizionarioIta.add(new RichWord(word,true));
			}
			br.close();
			System.out.println("File ita caricato");
			}
		catch(IOException e) {
			System.out.println("File ita non presente");
		}
		}
	
	}
	
	public List<RichWord> spellCheckTextIta(List<String> inputTextList){
		List<RichWord> r = new LinkedList<RichWord>() ;
		for(String s: inputTextList) {
			RichWord w = new RichWord(s,false);
			if(this.dizionarioIta.contains(w)) {
				w.setCorretta(true);
			}
			else {
				r.add(w);
			}
			
	}
		return r;
	}
	public List<RichWord> spellCheckTextEng(List<String> inputTextList){
		List<RichWord> r = new LinkedList<>() ;
		RichWord w;
		for(String s: inputTextList) {
			w = new RichWord(s,false);
			if(this.dizionarioEng.contains(w)) {
				w.setCorretta(true);
			}
			else {
				r.add(w);
			}
			
	}
		return r;
	}


	
	

}
