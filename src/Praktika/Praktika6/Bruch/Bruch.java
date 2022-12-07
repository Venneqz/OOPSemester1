package Praktika.Praktika6.Bruch;

public class Bruch {
    private int zaehler;
    private int nenner;


    public Bruch(int pZaehler, int pNenner){
        //for negative numbers
        if(pZaehler < 0 && pNenner < 0){
            pNenner = pNenner * -1;
        }
        else if(pZaehler > 0 && pNenner < 0){
            pNenner = pNenner * -1;
            pZaehler = pZaehler * -1;
        }
        //check for unavailable divisions
        if (pNenner == 0){
            System.out.println("The fraction denominator cant be 0");
            System.out.println("Setting the numerator to 1");
            zaehler = 0;
            nenner = 1;
        }else{ //applying the division
            zaehler = pZaehler;
            nenner = pNenner;
        }
    }


    public Bruch() { //for adding fractions
    }


    public Bruch add (Bruch f){
        Bruch newFraction = new Bruch(); //creating new fraction
        int z = this.zaehler * f.nenner + f.zaehler * this.nenner; //adjusting the denominator
        int n = this.nenner * f.nenner; //adjusting the numerator

        //returning the new fraction
        newFraction.zaehler = z;
        newFraction.nenner = n;

        System.out.println("");
        return newFraction;
    }



    public Bruch multiply (Bruch f){
        Bruch newFraction = new Bruch(); //creating new fraction
        int z = this.zaehler * f.zaehler; //adjusting the denominator
        int n = this.nenner * f.nenner; //adjusting the numerator

        //returning the new fraction
        newFraction.zaehler = z;
        newFraction.nenner = n;
        return newFraction;
    }

    public String toString(){
        return this.zaehler + "/" + this.nenner; //printing out the fraction as string
    }
}
