package Lab5.Exceptions;

public class InvalidTypeException extends Exception{
    public void printErr() {
        System.err.println("Invalid type.");
    }
}
