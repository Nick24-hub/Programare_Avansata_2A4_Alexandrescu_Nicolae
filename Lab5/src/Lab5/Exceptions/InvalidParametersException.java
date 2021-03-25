package Lab5.Exceptions;

public class InvalidParametersException extends Exception{
    public void printErr() {
           System.err.println("Invalid parameters.");
        }
}
