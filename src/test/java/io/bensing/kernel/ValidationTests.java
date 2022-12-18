package io.bensing.kernel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ValidationTests {

    @Test
    @Tag("Small")
    @DisplayName("Successfully instantiate Validation, default is valid with and no message.")
    public void InstantiateValidation() {
        var validation = new Validation();
        Assertions.assertTrue(validation.IsValid());
        Assertions.assertFalse(validation.IsInvalid());
        Assertions.assertEquals(0, validation.ValidationMessages().size());
        Assertions.assertEquals(0, validation.ValidationMessageCount());
    }

    @Test
    @Tag("Small")
    @DisplayName("Update default validation to represent an invalid state.")
    public void UpdateToInvalid() {
        var validation = new Validation();
        validation.AddMessage("This is invalid because I said so!");
        Assertions.assertTrue(validation.IsInvalid());
        Assertions.assertFalse(validation.IsValid());

        Assertions.assertEquals(1, validation.ValidationMessageCount());
        Assertions.assertTrue(validation.ValidationMessages().contains("This is invalid because I said so!"));
    }

    @Test
    @Tag("Small")
    @DisplayName("A validation with multiple validation messages.")
    public void AddManyValidationMessages() {
        var validation = new Validation();
        validation.AddMessage("Validation Message 1");
        validation.AddMessage("Validation Message 2");
        validation.AddMessage("Validation Message 3");
        validation.AddMessage("Validation Message 4");
        validation.AddMessage("Validation Message 5");
        Assertions.assertTrue(validation.IsInvalid());
        Assertions.assertFalse(validation.IsValid());

        Assertions.assertEquals(5, validation.ValidationMessageCount());
        Assertions.assertTrue(validation.ValidationMessages().contains("Validation Message 1"));
        Assertions.assertTrue(validation.ValidationMessages().contains("Validation Message 2"));
        Assertions.assertTrue(validation.ValidationMessages().contains("Validation Message 3"));
        Assertions.assertTrue(validation.ValidationMessages().contains("Validation Message 4"));
        Assertions.assertTrue(validation.ValidationMessages().contains("Validation Message 5"));
    }


}
