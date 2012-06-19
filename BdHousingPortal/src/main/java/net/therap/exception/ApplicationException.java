package net.therap.exception;

/**
 * Created by IntelliJ IDEA.
 * User: ashraf
 * Date: 6/14/12
 * Time: 11:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationException extends RuntimeException {

    private String warningMessage;

    public String getWarningMessage() {
        return warningMessage;
    }

    public ApplicationException(String warningMessage) {
        this.warningMessage = warningMessage;
    }

}
