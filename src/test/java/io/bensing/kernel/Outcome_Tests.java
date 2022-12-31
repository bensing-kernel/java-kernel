package io.bensing.kernel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class Outcome_Tests {

    @Test
    @Tag("small")
    @DisplayName("Create a default outcome that is not successful nor an error.")
    public void CreateDefaultOutcome() {
        var outcome = new Outcome.Builder().Undecided();
        Assertions.assertFalse(outcome.IsSuccessful(), "Expected IsSuccessful() to be false.");
        Assertions.assertFalse(outcome.HasError(), "Expected HasError() to be false.");
        Assertions.assertEquals(0, outcome.Issues().size(), "Did not expect there to be any issues.");
    }

    @Test
    @Tag("small")
    @DisplayName("Create a successful outcome")
    public void CreateSuccessfulOutcome() {
        var outcome = new Outcome.Builder().Success();
        Assertions.assertTrue(outcome.IsSuccessful(), "Expected IsSuccessful() to be true.");
        Assertions.assertFalse(outcome.HasError(), "Expected HasError() to be false.");
        Assertions.assertEquals(0, outcome.Issues().size(), "Did not expect there to be any issues.");
    }

    @Test
    @Tag("small")
    @DisplayName("Create a failed outcome with an issue.")
    public void CreateOutcomeWithIssue() {
        var issue = "The Error You Are Supposed To Get";
        var outcome = new Outcome.Builder().Failure(issue);

        Assertions.assertFalse(outcome.IsSuccessful(), "Expected IsSuccessful() to be true.");
        Assertions.assertTrue(outcome.HasError(), "Expected HasError() to be false.");
        Assertions.assertTrue(outcome.Issues().contains(issue), "The outcome does not contain the expected issue.");
    }

    @Test
    @Tag("small")
    @DisplayName("Create an outcome with more than one issue.")
    public void CreateOutcomeWithMoreThanOneIssue() {
        var issue1 = "The first error You Are Supposed To Get";
        var issue2 = "The second error You Are Supposed To Get";
        var outcome = new Outcome.Builder().Failure(issue1);
        outcome.ReportIssue(issue2);

        Assertions.assertFalse(outcome.IsSuccessful(), "Expected IsSuccessful() to be true.");
        Assertions.assertTrue(outcome.HasError(), "Expected HasError() to be false.");
        Assertions.assertTrue(outcome.Issues().contains("The first error You Are Supposed To Get"),
                "The outcome does not contain the first expected issue.");
        Assertions.assertTrue(outcome.Issues().contains("The second error You Are Supposed To Get"),
                "The outcome does not contain the second expected issue.");
    }

    @Test
    @Tag("small")
    @DisplayName("Go from an initial success to a failure")
    public void SuccessToFailure() {
        var outcome = new Outcome.Builder().Success();

        outcome.ReportIssue("There is an issue");

        Assertions.assertFalse(outcome.IsSuccessful(), "Expected IsSuccessful() to be true.");
        Assertions.assertTrue(outcome.HasError(), "Expected HasError() to be false.");
        Assertions.assertTrue(outcome.Issues().contains("There is an issue"),
                "The outcome does not contain the expected issue.");
    }

    @Test
    @Tag("small")
    @DisplayName("Go from an undecided outcome to a failure.")
    public void UndecidedToFailure() {
        var outcome = new Outcome.Builder().Undecided();

        outcome.ReportIssue("There is an issue");

        Assertions.assertFalse(outcome.IsSuccessful(), "Expected IsSuccessful() to be false.");
        Assertions.assertTrue(outcome.HasError(), "Expected HasError() to be true.");
        Assertions.assertTrue(outcome.Issues().contains("There is an issue"),
                "The outcome does not contain the expected issue.");
    }

    @Test
    @Tag("small")
    @DisplayName("Go from an initial undecided to a success")
    public void UndecidedToSuccess() {
        var outcome = new Outcome.Builder().Undecided();
        outcome.ReportSuccess();

        Assertions.assertTrue(outcome.IsSuccessful(), "Expected IsSuccessful() to be true.");
        Assertions.assertFalse(outcome.HasError(), "Expected HasError() to be false.");
        Assertions.assertEquals(0, outcome.Issues().size(), "Did not expect any issues.");
    }

    @Test
    @Tag("small")
    @DisplayName("If the outcome has issues, and a success is reported, the outcome must not be reported as a success.")
    public void OnceFailureAlwaysFailure() {
        var outcome = new Outcome.Builder().Failure("The failure message.");
        outcome.ReportSuccess();

        Assertions.assertFalse(outcome.IsSuccessful(), "Expected IsSuccessful() to be false.");
        Assertions.assertTrue(outcome.HasError(), "Expected HasError() to be true.");
        Assertions.assertTrue(outcome.Issues().contains("The failure message."),
                "The outcome does not contain the expected issue.");
    }



}
