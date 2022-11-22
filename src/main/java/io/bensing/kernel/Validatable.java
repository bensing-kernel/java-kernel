package io.bensing.kernel;

public interface Validatable {
    boolean IsValid();
    String ValidationMessage();
}
