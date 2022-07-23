package b7_abtract_class_and_interface.thuc_hanh.animal_class_and_interface_edible.animal;

import b7_abtract_class_and_interface.thuc_hanh.animal_class_and_interface_edible.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
