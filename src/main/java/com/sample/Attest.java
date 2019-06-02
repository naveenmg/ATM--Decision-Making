package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import java.util.Scanner;
/**
 * This is a sample class to launch a rule.
 */
public class Attest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
            Message message = new Message();
    
            Scanner reader= new Scanner(System.in);
            System.out.println( "Ist die Karte gueltig ? j/n ");
            char a= reader.next(".").charAt(0);

            message.setkartegueltig(a);
            
            
            System.out.println( "Ist die Identitaetskontrolle erfolgreich ? j/n ");
            char b= reader.next(".").charAt(0);
            message.setpinrichtig(b);
            
            System.out.println( " Ist jetzt die dritte PIN-Eingabe? j/n ");
            char c= reader.next(".").charAt(0);
            message.setpin2malfalsch(c);
            
            System.out.println( "Ist der gewuenschte Betrag auszuzahlen? j/n ");
            char d= reader.next(".").charAt(0);
            message.setgeldgenug(d);
            
            
            reader.close();           
            

            kSession.insert(message);
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static class Message {


        private String message;

        private int status;

        private char kartegueltig, pinrichtig,pin2malfalsch,geldgenug;
        
        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
        public char getkartegueltig() {
            return this.kartegueltig;
        }

        public void setkartegueltig(char kartegueltig) {
            this.kartegueltig = kartegueltig;
        }
        
        public char getpinrichtig() {
            return this.pinrichtig;
        }

        public void setpinrichtig(char pinrichtig) {
            this.pinrichtig = pinrichtig;
        }
        public char getpin2malfalsch() {
            return this.pin2malfalsch;
        }

        public void setpin2malfalsch(char pin2malfalsch) {
            this.pin2malfalsch = pin2malfalsch;
        }
        public char getgeldgenug() {
            return this.geldgenug;
        }

        public void setgeldgenug(char geldgenug) {
            this.geldgenug = geldgenug;
        }
    }

}
