package Uebeung.Fahrbar;

public class FahrbarTest {
    public static void main(String[] args) {
        //new ArrayList<Fahrbar>();
        Fahrbar[] fahrbar = new Fahrbar[2];
        fahrbar[0] = new Auto();
        fahrbar[1] = new Fahrrad();
        //iteriere über fahrbar
        for (Fahrbar f : fahrbar) {
            f.verzoegern(10);
            f.beschleunigen(10);
        }
    }
}
