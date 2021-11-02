package ru.madbrains.simpleList;

import java.util.ArrayList;
import java.util.List;

public class WorkList {

    public static void print(SimpleList car) throws ArrayIndexOutOfBoundsException, NoEntityException {
        for(int i = 0; i< car.size();i++){
            System.out.println(car.get(i));
        }
        System.out.println("\n");
    }

    public static void main(String[] args) throws Exception {

        SimpleList skoda = new ListOperation("Skoda", 5);
        SimpleList toyota = new ListOperation("Toyota", 10);
        SimpleList test = new ListOperation();

        List testArray = new ArrayList();
        List testArray2 = new ArrayList();



        Cars octavia = new Cars("Octavia","2018",1.7f);
        Cars rapid = new Cars("Rapid","2015",0.7f);
        Cars karoq = new Cars("Karoq","2019",2f);
        Cars kodiaq = new Cars("Kodiaq","2020",2.4f);
        Cars superb = new Cars("Superb","2021",3.1f);
        Cars camry = new Cars("Camry","2015",1f);
        Cars corolla = new Cars("Corolla","2020",1.5f);

        System.out.println(test.size());
        test.add(camry);
        System.out.println(test.size());
        print(test);
        test.add(camry);
        test.add(camry);
        //test.add(null);
        test.add(camry);

        System.out.println(test.size());
        print(test);

        List car = new ArrayList();
        car.contains(camry);
        car.add(superb);

        testArray.add(camry);

        testArray.contains(corolla);

        testArray2.add(camry);
        testArray2.add(octavia);
        testArray2.add(rapid);

        testArray.addAll(testArray2);
    }
}


