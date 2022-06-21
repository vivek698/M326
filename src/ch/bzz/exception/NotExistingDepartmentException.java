package ch.bzz.exception;

public class NotExistingDepartmentException extends Exception{
    public NotExistingDepartmentException(){
        super ("Department does not exist");
    }

}
