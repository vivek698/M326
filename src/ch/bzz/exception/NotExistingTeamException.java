package ch.bzz.exception;
/**
 * Thrown when a TeamException, that doesn't exist is searched
 */
public class NotExistingTeamException extends Exception{
    /**
     * Constructs a NotExistingTeamException
     */
    public NotExistingTeamException(){
        super ("Team does not exist");
    }

}
