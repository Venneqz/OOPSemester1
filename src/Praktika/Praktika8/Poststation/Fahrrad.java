package Praktika.Praktika8.Poststation;

class Fahrrad {
    private int ladung;
    private int maxSpeed;
    private int speed;
    private Fahrrad next = null;

    //to get the bike's speed
    int speed(){
        if (ladung >= maxSpeed) return 0;
        return (maxSpeed - ladung);
    }

    //for creating a new bike
    public Fahrrad(int maxSpeed) {
        this.ladung = ladung;
        this.maxSpeed = maxSpeed;

    }
    public int getLadung() {
        return ladung;
    }
    public void setLadung(int ladung) {
        this.ladung = ladung;
    }
    public int getMaxSpeed() {
        return maxSpeed;
    }
    public Fahrrad getNext() {
        return next;
    }
    public void setNext(Fahrrad next) {
        this.next = next;
    }
}
