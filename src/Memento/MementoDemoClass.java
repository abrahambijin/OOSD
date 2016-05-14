package Memento;

/**
 * Created by mitulmanish on 14/05/2016.
 */
public class MementoDemoClass {

    public static void main(String [] args) {
        CareTaker caretaker = new CareTaker();

        Originator originator = new Originator();

        //originator.set(pass the game object here);

        caretaker.addMemento(originator.saveToMemento());
        // originator returnsa new memento object which is then added
        // to the list


        originator.restoreFromMemento(caretaker.getMemento(1));
        // fetch from memento from list and get the state by querying the originator
    }
}
