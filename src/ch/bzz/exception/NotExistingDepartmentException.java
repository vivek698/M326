package ch.bzz.exception;

/**
 * Thrown when a Department, that doesn't exist is searched
 */
public class NotExistingDepartmentException extends Exception{
    /**
     * Constructs a NotExistingDepartmentException
     */
    public NotExistingDepartmentException(){
        super ("Department does not exist");
    }

}
