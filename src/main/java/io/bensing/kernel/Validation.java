package io.bensing.kernel;

import io.bensing.kernel.interfaces.Validatable;

import java.util.ArrayList;

public class Validation implements Validatable {

    private final ArrayList<String> messages;

    public Validation() {
        this.messages = new ArrayList<String>();
    }

    public void AddMessage(String message) {
        this.messages.add(message);
    }
    public void IncludeMessagesFrom(ArrayList<String> messages) {
        this.messages.addAll(messages);
    }

    public boolean IsValid() {
        return this.ValidationMessageCount() == 0;
    }
    public boolean IsInvalid() {
        return !this.IsValid();
    }
    public ArrayList<String> ValidationMessages() {
        return this.messages;
    }
    public int ValidationMessageCount() {
        return this.messages.size();
    }

}
