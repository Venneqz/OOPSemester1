package Uebeung;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;


public class Alter {
    public static void main(String[] args)  throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String datumString = "28.12.2006";

        Date datum = df.parse(datumString);
        Date heute = new Date();
        long ms = heute.getTime()-datum.getTime();
        long sek= ms/1000;
        long min = sek/60;
        long std = min/60;
        long tage = std/24;
        long jahre = tage/365;
        System.out.println("Alter: "+jahre);
    }
}

