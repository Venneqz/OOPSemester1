package Praktika.Praktika2.BioTest;

public class BioTest {
    public static void main(String[] args) {

        //given examples

        Plant gras = new Plant();
        gras.setDescription("grün");
        gras.setName("Gras");

        Plant beeren = new Plant();
        beeren.setName("Beeren");
        beeren.setDescription("rot");

        Plant alge = new Plant();
        alge.setDescription("Silber");
        alge.setName("Alge");

        Animal fische = new Animal();
        fische.setName("Fisch");
        fische.setFood_plants("Algen");

        Animal zebra = new Animal();
        zebra.setName("Zebra");
        zebra.setFood_plants("Gras");

        Animal loewen = new Animal();
        loewen.setName("Löwe");
        loewen.setFood_animal("Zebra");

        Animal baeren = new Animal();
        baeren.setName("Bär");
        baeren.setFood_animal("Fisch");
        baeren.setFood_plants("Beeren");


        //Print out of examples
        System.out.println(zebra.setName() + " ist ein " + zebra.type());
        System.out.println(loewen.setName() + " ist ein " + loewen.type());
        System.out.println(baeren.setName() + " ist ein " + baeren.type());











    }
}
