package Praktika.Praktika7.Passwort;

import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;

public class PasswortGenerator {
    private String password;
    private String passwordHelp;



    void erstellePasswort(String entry) {
        //check if the entry is empty
        if (entry.isEmpty()) {
            System.out.println("The entry is empty!");
            System.exit(0);
        }
        try {
            password = entry;
            String[] words = password.split(" "); //split the string into words
            String firstLetters = ""; //for storing the first letters of each word
            for (int i = 0; i < words.length; i++) {
                if (i % 2 == 0) {
                    //get the first non-special character
                    for (int j = 0; j < words[i].length(); j++) {
                        if (Character.isLetter(words[i].charAt(j))) {
                            firstLetters = firstLetters + toLowerCase(words[i].charAt(j)); //make it lowercase
                            break;
                        }
                    }
                }
                else {
                    //get the first non-special character
                    for (int j = 0; j < words[i].length(); j++) {
                        if (Character.isLetter(words[i].charAt(j))) {
                            firstLetters = firstLetters + toUpperCase(words[i].charAt(j)); //make it uppercase
                            break;
                        }
                    }
                }
            }
            passwordHelp = firstLetters;
        }
        catch (Exception e) {
            System.out.println("Ungültige Eingabe");
        }
    }


    //Printer
    void printPassword(String password) {
        System.out.println("Ausgabe des Passworts: " + password);
        System.out.println("");
    }

    void printPasswordHelp(String passwordHelp) {
        System.out.println("Ausgabe der Passwort-Hilfe: " + passwordHelp);
        System.out.println("");
    }


    //getter and setter
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordHelp() {
        return passwordHelp;
    }

    public void setPasswordHelp(String passwordHelp) {
        this.passwordHelp = passwordHelp;
    }
}
