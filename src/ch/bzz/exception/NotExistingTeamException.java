package ch.bzz.exception;

public class NotExistingTeamException extends Exception{
    public NotExistingTeamException(){
        super ("Team does not exist");
    }

}
