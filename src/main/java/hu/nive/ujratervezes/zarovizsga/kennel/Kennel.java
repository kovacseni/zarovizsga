package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    private List<Dog> dogs = new ArrayList<>();

    public List<Dog> getDogs() {
        return new ArrayList<>(dogs);
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void feedAll() {
        for (Dog d : dogs) {
            d.feed();
        }
    }

    public Dog findByName(String name) {
        for (Dog d : dogs) {
            if (d.getName().equals(name)) {
                return d;
            }
        }
        throw new IllegalArgumentException("No dog with this name.");
    }

    public void playWith(String name, int hours) {
        for (Dog d : dogs) {
            if (d.getName().equals(name)) {
                d.play(hours);
            }
        }
    }

    public List<String> getHappyDogNames(int minHappiness) {
        List<String> happyDogNames = new ArrayList<>();
        for (Dog d : dogs) {
            if (d.getHappiness() > minHappiness) {
                happyDogNames.add(d.getName());
            }
        }
        return happyDogNames;
    }
}
