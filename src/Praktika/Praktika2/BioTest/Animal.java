package Praktika.Praktika2.BioTest;

public class Animal {

    //Strings
        private String name; //String for animal name
        private String food_animal = "-"; //String for animals that eat other animals
        private String food_plants = "-"; //String for animals that eat plants
        private String type; //String for animal type



        //Getter and Setter
    public String setName() {
        return name;
    }

    public void setName(String beschreibung) {
        this.name = beschreibung;
    }

    public String getFood_animal() {
        return food_animal;
    }

    public void setFood_animal(String food_animal) {
        this.food_animal = food_animal;
    }

    public String getFood_plants() {
        return food_plants;
    }

    public void setFood_plants(String food_plants) {
        this.food_plants = food_plants;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }




    //Methods

    public String type(){ //looking what food the animal is eating to determine the type
        if (food_animal != "-" && food_plants == "-"){ //check if animal food string isnt empty -> carnivore
            return "Fleischfresser";
        }
        if (food_plants != "-" && food_animal == "-"){ //check if plant food string isnt empty -> herbivore
            return "Pflanzenfresser";
        }
        else {
            return "Allesfresser"; //if both arent empty -> omnivore
        }
    }
}



