package circus;

import circus.animal.*;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {
        makeAnimalsTalk();
        System.out.println("Total value of animals " + calculateAssetValue(animals));
        System.out.println("Total value of equipments " + calculateAssetValue(equipments));

        System.out.println("Number of animals: " + animals.length);



        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));
        System.out.println("Number of animals: " + animalArrayList.size());
        animalArrayList.add(new Tiger("Sherkhan"));
        System.out.println("Num of animals: " + animalArrayList.size());

        Duck louie = new Duck("Louie");
        animalArrayList.add(louie);
        Elephant donald = new Elephant("Donald");
        animalArrayList.add(donald);

        for (Animal a : animalArrayList){
            System.out.println(a);
        }
        System.out.println("Louie's position is: " + animalArrayList.indexOf(louie)); //RECALL INDEX OF CAN ONLY BE USED if instance is generated. EG
                                                                                        //Duck louie = new Duck("Louie"). If just animalArrayList.add(new Tiger("Sherkhan")),
                                                                                    //won't be able to use "indexOf"

        animalArrayList.sort(Animal.AnimalNameComparator);
        for(Animal a: animalArrayList) {
            System.out.println(a);
        }
        System.out.println(animalArrayList.indexOf(louie));
        System.out.println(animalArrayList.toString());
    }
}
