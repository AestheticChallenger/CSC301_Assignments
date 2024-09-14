public class InvalidOptionSelectedException extends Exception{
  public InvalidOptionSelectedException() {
    super("The option you have selected is invalid. Please try again.\n");
  }
}
