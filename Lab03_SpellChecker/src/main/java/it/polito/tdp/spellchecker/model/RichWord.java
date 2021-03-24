package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	private boolean corretta ;
	private String parola;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.parola + "\n";
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public boolean isCorretta() {
		return corretta;
	}
	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}
	
	public RichWord(String parola, boolean c) {
		super();
		this.parola = parola;
		this.corretta=c;
		}
	@Override
	public boolean equals(Object obj) {
        RichWord w = (RichWord) obj;
        if(this.parola.equals(w.parola))
        	return true;
        else
        	return false;
        
		
	}

	

}
