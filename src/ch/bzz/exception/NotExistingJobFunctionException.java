package ch.bzz.exception;
/**
 * Thrown when a JobFunction, that doesn't exist is searched
 */
public class NotExistingJobFunctionException extends Exception{
    /**
     * Constructs a NotExistingJobFunctionException
     */
    public NotExistingJobFunctionException(){
        super ("JobFunction does not exist");
    }

}
