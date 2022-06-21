package ch.bzz.exception;

public class NotExistingJobFunctionException extends Exception{
    public NotExistingJobFunctionException(){
        super ("JobFunction does not exist");
    }

}
