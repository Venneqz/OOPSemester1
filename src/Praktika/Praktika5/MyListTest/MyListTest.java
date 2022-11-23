package Praktika.Praktika5.MyListTest;

import Praktika.Praktika5.MyList.MyList;

public class MyListTest {
    public static void main(String[] args) {
        MyList test = new MyList();
        test.addToList(0, 0);
        test.addToList(1,-1);
        test.addToList(1,2);
        test.addToList(1,3);
        test.addToList(1,4);
        test.addToList(1,5);
        test.addToList(1,1);
        test.ausgabe();
        test.removeFromList(3);
        test.ausgabe();
        test.removeDuplicates();
        test.ausgabe();
        test.sortList();
        test.ausgabe();
        test.kombiZahlen(9);
    }
}
