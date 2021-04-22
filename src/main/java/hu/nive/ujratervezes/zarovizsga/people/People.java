package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {
    /*
    A People osztályban implementáld a int getNumberOfMales(String path) metódust! A metódus paraméterként megkapja egy fájl elérési útvonalát.
    A tesztesetben ez a src/test/resources/people.csv, így ebbe a könyvtárba tedd a fájlt!

A fájl formátuma:

id,first_name,last_name,email,gender,ip_address
1,Rebekkah,Lashmore,rlashmore0@rambler.ru,Male,140.220.218.69
2,Chiquia,Konmann,ckonmann1@auda.org.au,Male,54.83.30.17
3,Gloria,Bascomb,gbascomb2@ebay.co.uk,Male,67.210.132.201

A metódus adja vissza, hogy hány férfi van a fájlban!

8p
     */

    public int getNumberOfMales(String path){
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            int numOfMales= 0;
            String line;
            while ((line = reader.readLine())  != null) {
//                System.out.println(line);

                String[] parts= line.split(",");
                if(parts[4].equals("Male")){
                    numOfMales++;
                }
            }
            return numOfMales;

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
