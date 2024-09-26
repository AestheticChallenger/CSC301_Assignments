package Exceptions;

public class LessThanZeroAmountFoundException extends Exception{
  public LessThanZeroAmountFoundException() {
    super("The amount should be more than 0.");
  }
}
