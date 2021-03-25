package Lab5.Exceptions;

public class InvalidCommandException extends Exception{
    public void printErr() {
        System.err.println("Invalid command.");
    }
}
