package Praktika.Praktika8.Poststation;

public class Fahrradgruppe {
    private Fahrrad startFahrrad = null;
    private int fahrradAnzahl = 0;
    private int ladung = 0;
    private int gesamtSpeed = 0;
    private int minSpeed = 0;

    //for adding a new bike to the group
    void addFahrrad(Fahrrad fahrrad){
        //if there is no bike in the group
        if (startFahrrad == null){
            startFahrrad = fahrrad;
            gesamtSpeed = fahrrad.getMaxSpeed();
            minSpeed = fahrrad.getMaxSpeed();
            fahrradAnzahl++;
        } else { //if there is at least one bike in the group
            fahrrad.setNext(startFahrrad);
            startFahrrad = fahrrad;
            gesamtSpeed += fahrrad.getMaxSpeed();
            if (fahrrad.getMaxSpeed() < minSpeed){
                minSpeed = fahrrad.getMaxSpeed();
            }
            fahrradAnzahl++;
        }
    }

    void addLadung(int anzahl){
        //if the group is empty
        if (startFahrrad == null){
            System.out.println("Es gibt keine Fahrräder in der Gruppe");
        }
        else {
            ladung += anzahl; //add the load up
            Fahrrad tmp;
            Fahrrad max;
            //add the load one by one up on the bikes
            for (int i = 0; i < anzahl; i++) {
                tmp = startFahrrad;
                max = startFahrrad;
                while (tmp.getNext() != null) {
                    tmp = tmp.getNext();
                    if (max.speed() < tmp.speed()) max = tmp;
                }
                max.setLadung(max.getLadung() + 1);
            }
        }
    }

    //for printing the group's travel speed
    int reisegeschwindigkeit() {
        //if the group is empty
        if (startFahrrad == null){
            System.out.println("Es gibt keine Fahrräder in der Gruppe");
        }
        else {
        /*if (fahrradAnzahl <= 3){
            System.out.println("Die Fahrradgruppe ist zu klein um zu fahren");
            System.exit(0);
         */
         //find the bike with the lowest speed
            Fahrrad tmp = startFahrrad;
            Fahrrad min = startFahrrad;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
                if (min.speed() > tmp.speed()) min = tmp;
            }
            //return the lowest speed
            minSpeed = min.speed();
        }
        return minSpeed;
    }

    void uebersicht(){
        //if the group is empty
        if (startFahrrad == null){
            System.out.println("Es gibt keine Fahrräder in der Gruppe");
        }
        System.out.println("Anzahl der Fahrräder: " + fahrradAnzahl);
        System.out.println("Gesamtgeschwindigkeit/Maximales Gesamtgewicht: " + gesamtSpeed);
        System.out.println("Ladung: " + ladung);
        System.out.println("Reisegeschwindigkeit: " + reisegeschwindigkeit());
        for (Fahrrad tmp = startFahrrad; tmp != null; tmp = tmp.getNext()){
            System.out.println("Fahrrad: " + tmp.getMaxSpeed() + " Ladung: " + tmp.getLadung() + " Geschwindigkeit: " + tmp.speed());
        }
        System.out.println();
    }
}
