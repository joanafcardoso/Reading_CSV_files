package util;

import com.opencsv.CSVReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cardoso on 27-Feb-16.
 */

public class PeopleList2 {
    List<People> list = new ArrayList<>();

    private void printDetails() {
        System.out.printf("%-12s %-12s %-5s %-12s %-8s %-15s %-10s%n","First Name","Last Name", "Age",
                "City", "PostCode", "Street", "House No");
        System.out.printf("%-12s %-12s %-5s %-12s %-8s %-15s %-10s%n","----------","-----------",
                "-----","----------","--------","--------------","---------");
        for(People p: list){
            System.out.printf("%-12s %-12s %-5s %-12s %-8s %-15s %-10s%n",p.getFirstName(),
                    p.getLastName(),p.getAge(),p.getCity(),p.getPostCode(),p.getStreet(),p.getHouseNo());
        }
    }

    private void readCsv(){

        try {
            //using CSVReader to read the file
            CSVReader csvReader = new CSVReader (new FileReader("People.csv"), ',', '\t', 1);
            String[] line = null;
            while ((line = csvReader.readNext())!= null){
                People people2 = new People(line[0],line[1],line[2],line[3],line[4],line[5],line[6]);
                list.add(people2);
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        PeopleList2 peopleList2 = new PeopleList2();
        peopleList2.readCsv();
        peopleList2.printDetails();
    }
}
