package io.bensing.kernel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ValidationTests {

    @Test
    @Tag("Small")
    @DisplayName("Successfully instantiate Validation, default is invalid with and empty message")
    public void InstantiateValidation() {
        var validation = new Validation();
        Assertions.assertFalse(validation.isValid());
        Assertions.assertTrue(validation.isInvalid());
        Assertions.assertEquals("", validation.getValidationMessage());
    }

    @Test
    @Tag("Small")
    @DisplayName("Update default validation to represent a valid state.")
    public void UpdateToValid() {
        var validation = new Validation();
        validation.setAsValid();
        Assertions.assertTrue(validation.isValid());
        Assertions.assertFalse(validation.isInvalid());
        Assertions.assertEquals("", validation.getValidationMessage());
    }

    @Test
    @Tag("Small")
    @DisplayName("Update default validation to represent an invalid state.")
    public void UpdateToInvalid() {
        var validation = new Validation();
        validation.setAsInvalid("This is invalid because I said so!");
        Assertions.assertTrue(validation.isInvalid());
        Assertions.assertFalse(validation.isValid());
        Assertions.assertEquals("This is invalid because I said so!", validation.getValidationMessage());
    }

    @Test
    @Tag("Small")
    @DisplayName("Reset a valid Validation")
    public void ResetValidValidation() {
        var validation = new Validation();
        validation.setAsValid();
        validation.Reset();
        Assertions.assertFalse(validation.isValid());
        Assertions.assertTrue(validation.isInvalid());
        Assertions.assertEquals("", validation.getValidationMessage());
    }

    @Test
    @Tag("Small")
    @DisplayName("Reset a invalid Validation")
    public void ResetInvalidValidation() {
        var validation = new Validation();
        validation.setAsInvalid("This is invalid, go ahead and reset it.");
        validation.Reset();
        Assertions.assertFalse(validation.isValid());
        Assertions.assertTrue(validation.isInvalid());
        Assertions.assertEquals("", validation.getValidationMessage());
    }
}
