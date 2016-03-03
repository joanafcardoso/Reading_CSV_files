package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cardoso on 27-Feb-16.
 */

public class PeopleList {
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
            FileReader fileReader = new FileReader("People.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            int noFirstLine = 0;

            while ((line = bufferedReader.readLine()) != null){
                //to exclude the first line
                noFirstLine++;
            if (noFirstLine == 1) {
                continue;
            }
            String[] data = line.split(",");
            list.add(new People(data[0],data[1],data[2],data[3],data[4],data[5],data[6]));
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        PeopleList peopleList = new PeopleList();
        peopleList.readCsv();
        peopleList.printDetails();
    }
}
