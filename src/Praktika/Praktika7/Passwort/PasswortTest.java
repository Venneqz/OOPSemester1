package Praktika.Praktika7.Passwort;

public class PasswortTest {
    public static void main(String[] args) {
        PasswortGenerator test1 = new PasswortGenerator();
        test1.erstellePasswort("java ist eine objekt-orientierte sprache!");
        test1.printPassword(test1.getPassword());
        test1.printPasswordHelp(test1.getPasswordHelp());

        PasswortGenerator test2 = new PasswortGenerator();
        test2.erstellePasswort("Java ist auch eine Insel (von Christian Ullenboom) ");
        test2.printPassword(test2.getPassword());
        test2.printPasswordHelp(test2.getPasswordHelp());
    }
}
