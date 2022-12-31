package io.bensing.kernel.interfaces;

import java.util.ArrayList;

public interface Result {
    boolean IsSuccessful();
    boolean HasError();
    ArrayList<String> Issues();
}

