package io.bensing.kernel.interfaces;

import java.util.ArrayList;

public interface Result {
    boolean IsSuccessful();
    boolean HasError();
    ArrayList<String> Issues();  // TODO - IDEA, add two types, a "User" (meant for an end user to see it), and a "System" (meant for system operators)
}

