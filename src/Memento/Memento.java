package Memento;

/**
 * Created by mitulmanish on 29/05/2016.
 */
public class Memento {

    private String storedGameFilePath;

    public Memento(String storedGameFilePath) {
        this.storedGameFilePath = storedGameFilePath;
    }

    public String getSavedState() {
        return storedGameFilePath;
    }
}
