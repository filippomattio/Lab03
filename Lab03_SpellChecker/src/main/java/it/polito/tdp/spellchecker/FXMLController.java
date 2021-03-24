/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

	import javafx.scene.control.Button;
	import javafx.scene.control.ComboBox;
	import javafx.scene.control.Label;
	import javafx.scene.control.TextArea;


	public class FXMLController {
		private Dictionary dictionary;
	    @FXML
	    private ComboBox<String> boxForma;

	    @FXML
	    private TextArea txtUtente;

	    @FXML
	    private Button btnSpell;

	    @FXML
	    private TextArea txtRisultato;

	    @FXML
	    private Label txtSbagliato;

	    @FXML
	    private Button btnClear;

	    @FXML
	    void doClear(ActionEvent event) {
	    	this.txtRisultato.setText("");
	    	this.txtUtente.setText("");
	    	this.txtSbagliato.setText("");

	    }

	    @FXML
	    void doSpellCheck(ActionEvent event) {
	    	List<String> s = new ArrayList();
	    	String ss = this.txtUtente.getText();
	    	ss.toLowerCase();
            ss.replaceAll("“[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
            String[] sss = ss.split(" ");
            for(String q : sss) {
            	s.add(q);
            }
            List<RichWord> par;
            
	     if(this.boxForma.getValue().equals("Italian")) {
	    		 par = dictionary.spellCheckTextIta(s);
	    		
	    	}
	     else {
	    	 par = dictionary.spellCheckTextEng(s);
	    	}
	     String m = "";
	     for(RichWord rr : par) {
	    	 m = m+ (rr.toString());
	    	 
	     }
	     this.txtRisultato.setText(m);
	     this.txtSbagliato.setText("This text contains "+par.size() + " wrong words");
	     
	 

	    }
	    public void setModel (Dictionary m) throws IOException{
	    	this.dictionary=m;
	    	boxForma.getItems().add("English");
	    	boxForma.getItems().add("Italian");
	    	dictionary.loadDictionary("English");
	    	dictionary.loadDictionary("Italian");
	    	
	    	
	    	}

	


    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }
}


