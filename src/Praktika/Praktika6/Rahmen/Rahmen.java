package Praktika.Praktika6.Rahmen;

public class Rahmen {
    private String[] entry;

    public void frame() {
        //check if entry is null
        if (entry == null || entry.length == 0) {
            System.out.println("Array cant be empty");
            System.exit(0);
            return;
        }


        int n = entry[0].length();
        String[] temp = new String[entry.length + 2];

        //for filling the first line
        temp[0] = "*";
        for (int i = 0; i < n + 3; i++) {
            temp[0] = temp[0] + "*";
        }

        //for filling the last line
        temp[temp.length - 1] = "*";
        for (int j = 0; j < n + 3; j++) {
            temp[temp.length - 1] = temp[temp.length - 1] + "*";
        }


        //for filling in the text and formatting it
        //first leading star and space
        for (int k = 1; k < temp.length - 1; k++) {
            temp[k] = "* " + entry[k - 1];
            //then the String and ending spaces and star
            for (int m = temp[k].length(); m < temp[0].length(); m++) {
                if (m == temp[0].length() - 1) {
                    temp[k] = temp[k] + "*";
                } else {
                    temp[k] = temp[k] + " ";
                }
            }
        }

        //for printing it out
        for (int l = 0; l < temp.length; l++) {
            System.out.println(temp[l]);
        }
    }


    public String[] getEntry() {
        return entry;
    }

    public void setEntry(String[] entry) {
        this.entry = entry;
    }
}
