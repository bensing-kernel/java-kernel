package io.bensing.kernel;

import io.bensing.kernel.interfaces.Result;
import io.bensing.kernel.interfaces.Validatable;

import java.util.ArrayList;

/**
 * Outcome is an implementation of the Result behavior.
 * It's a compositional element which encapsulates and manages undecided (default), success, and failure state for
 * any class which requires a Result behavior.
 */
public class Outcome implements Result {

    /**
     * Contains the list of issues
     */
    private ArrayList<String> issues;
    /**
     * Element which tracks if the outcome is a success.
     */
    private boolean isSuccess ;
    /**
     * Element which tracks if the outcome is a failure.
     */
    private boolean hasError;

    /**
     * The private constructor used for the builder implementation.
     *<p>
     * Outcome can only be created via it's builder interface.
     *
     * @param builder The Outcome builder class which contains the properly constructed data.
     */
    private Outcome(Outcome.Builder builder) {
        this.issues = builder.issues;
        this.hasError = builder.hasError;
        this.isSuccess = builder.isSuccess;
    }

    /**
     * Tells you if the outcome object is set as a success.
     * <p>
     * If this is false, it does not mean there is an error.  The default behavior is to have IsSuccessful() return false
     * and HasError() return false.  This two false values indicate the outcome object is in an undecided state.
     *
     * @return boolean the success flag
     */
    public boolean IsSuccessful() {
        return this.isSuccess;
    }

    /**
     * Tells you if the outcome object is set as an error.
     *<p>
     * If this is false, it does not mean there is a success.  The default behavior is to have HasError() return false
     * and IsSuccessful() return false.  This two false values indicate the outcome object is in an undecided state.
     *
     * @return boolean the failure flag
     */
    public boolean HasError() {
        return this.hasError;
    }

    /**
     * Add an issue to the issue list.
     *
     * @param issue The issue to add to the Outcomes issues list.
     */
    public void ReportIssue(String issue) {
        this.setErrorGate();
        this.issues.add(issue);
    }

    public void MakeIssuesFrom(Validatable validatable) {
        if (validatable == null ){ return; }
        validatable.ValidationMessages().forEach(this::ReportIssue);
    }

    /**
     * Allows you to report a successful operation. This sets the outcome to a successful state if, and only if, there
     * are currently no issues. If the outcome currently has issues, this function will ensure current state is
     * maintained.
     */
    public void ReportSuccess() {
        if (this.HasError()) { return; }
        this.setAsSuccess();
    }

    /**
     * Retrieve a list of all the issues reported to the Outcome.
     *
     * @return A list of issues which are strings.
     */
    public ArrayList<String> Issues() {
        return this.issues;
    }

    /**
     * Will set the outcome as an error if, and only if, the current state is either a success or undecided.
     */
    private void setErrorGate() {
        if (this.IsSuccessful() || this.isUndecided()) { this.setAsErrored(); }
    }

    /**
     * Calculates if the outcome is in an undecided state
     * @return The flag that denotes if the outcome is an undecided state
     */
    private boolean isUndecided() {
        var notSuccess = !this.IsSuccessful();
        var notError = !this.HasError();

        return notSuccess && notError;
    }

    /**
     * Sets the outcome to an errored state;
     */
    private void setAsErrored() {
        this.isSuccess = false;
        this.hasError = true;
    }

    /**
     * Sets the outcome to a successful state.  Clears the list of issues.
     */
    private void setAsSuccess() {
        this.isSuccess = true;
        this.hasError = false;
        if (this.hasIssues()) { this.issues = new ArrayList<>(); }
    }

    /**
     * Calculates if the outcome contains any issues.
     * @return The flag which denotes if there are any recorded issues.
     */
    private boolean hasIssues() {
        return this.issues.size() > 0;
    }

    /**
     * The Outcome builder class which allows you to build outcomes with three default states: Success, Failure,
     * Undecided.
     * <p>
     *     Success - Initially set to a success state containing a list without issues.
     *     Failure - Initially set to an error state containing a list with the provided issue.
     *     Undecided - Initially set to the state where it's neither a success nor failure. Contains an empty issues
     *     list.
     * </p>
     */
    public static class Builder {

        private final ArrayList<String> issues = new ArrayList<>();
        private boolean isSuccess = false;
        private boolean hasError = false;

        /**
         * Initially set to a success state containing a list without issues.
         *
         * @return An Outcome object constructed as successfully
         */
        public Outcome Success() {
            this.isSuccess = true;
            return new Outcome(this);
        }

        /**
         * Initially set to an error state containing a list with the provided issue.
         *
         * @return An Outcome object constructed with an error
         */
        public Outcome Failure(String failureMessage) {
            this.issues.add(failureMessage);
            this.hasError = true;
            return new Outcome(this);
        }

        /**
         * Initially set to the state where it's neither a success nor failure. Contains an empty issues list.
         *
         * @return An Outcome object constructed with either an error or a success.
         */
        public Outcome Undecided() {
            return new Outcome(this);
        }
    }



}
