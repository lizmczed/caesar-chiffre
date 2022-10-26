package encryptor;

import console.ConsoleReader;

public class ContinuousEncryptionHandler {
  private ContinuousEncryptionHandler() {
    // do nothing
  }

  public static void performContinuousEncryption(ConsoleReader consoleReader) {
    final boolean exit = false;
    while (!exit) {
      String input = consoleReader.fetchNextInput();
      String output = Encryptor.encrypt(input.substring(0, input.length() - 1));
      handleInputOutput(input, output);
    }
  }

  private static void handleInputOutput(String input, String output) {
    System.out.printf("%s %s -> %s", '\r', input, output);
  }
}
