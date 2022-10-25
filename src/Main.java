import console.ConsoleReader;
import encryptor.ContinuousEncryptionHandler;

import java.io.IOException;

public class Main {

  public static void main(String[] args) {
    try (ConsoleReader consoleReader = new ConsoleReader()) {
      ContinuousEncryptionHandler.performContinuousEncryption(consoleReader);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
