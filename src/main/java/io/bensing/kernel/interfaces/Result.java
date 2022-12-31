package io.bensing.kernel.interfaces;

import java.util.ArrayList;

public interface Result {
    boolean WasSuccess();
    boolean HasError();
    ArrayList<String> Issues();
}
