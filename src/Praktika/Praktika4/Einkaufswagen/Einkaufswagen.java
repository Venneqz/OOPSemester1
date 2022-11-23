package Praktika.Praktika4.Einkaufswagen;

import java.util.Iterator;
import java.util.ArrayList;

public class Einkaufswagen {
    private ArrayList<String> list = new ArrayList<String>(5);
    private int counter = 0;


    //add to cart method
    public void addToCart(String item) {
        if (counter <= 4) { //space for new items
            if (item == "") { //check for empty input
                System.out.println("Bitte gebe ein Item ein ,welches" +
                        " du der Liste hinzufügen möchtest!");
            } else { //input new item
                System.out.println("Es wurde " + item + " hinzugefügt");
                list.add(item);
                counter++;
            }
        } //full cart
        else {
            System.out.println("Dein Einkaufswagen hat bereits 5 Items und kann nicht mehr aufnehmen, " +
                    "entferne ein vorhandenes Item bevor du ein neues hinzufügen kannst");
        }
        System.out.println("");
    }


    //remove methode
    public void removeFromCart(String item) {
        System.out.println("Es wurde " + item + " Entfernt");
        System.out.println("");
        Iterator<String> check = list.iterator();
        list.remove(item);
        counter--;
    }


    //print method
    public void showContent() {
        //check for empty array
        if (list.isEmpty()) {
            System.out.println("Dein Einkufswagen ist leer");
            System.out.println("");
        } else {
            System.out.println("Inhalt der Liste: ");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
            System.out.println("");
        }
    }

    //print for size
    public void size() {
        boolean empty = list.isEmpty(); //checking for empty array
        if (empty == true) {
            System.out.println("Die Liste ist leer");
            System.out.println("");
        } else {
            System.out.println("Länge der Liste: " + list.size());
            System.out.println("");
        }
    }

}
