package ch.bzz.exception;

public class SortTypeException extends Exception{
    public SortTypeException(){
        super ("sortType has to be \"asc\" or \"desc\" ");
    }
}
