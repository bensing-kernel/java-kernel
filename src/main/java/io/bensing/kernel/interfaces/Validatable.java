package io.bensing.kernel.interfaces;

import java.util.ArrayList;

public interface Validatable {

    boolean IsValid();
    boolean IsInvalid();
    ArrayList<String> ValidationMessages();
}
