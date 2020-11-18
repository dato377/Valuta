package ge.edu.btu.model;

import java.io.Serializable;

public class Message implements Serializable {

    public String message;

    public Message() {

    }

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
