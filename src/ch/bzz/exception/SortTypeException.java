package ch.bzz.exception;
/**
 * Thrown when a SortType, other than "asc" or "desc" is the parameter
 */
public class SortTypeException extends Exception{
    /**
     * Constructs a SortTypeException
     */
    public SortTypeException(){
        super ("sortType has to be \"asc\" or \"desc\" ");
    }
}
