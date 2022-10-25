package console;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;

public final class ConsoleReader implements Closeable {

  public static final int BUFFER_SIZE = 1024;
  private final BufferedInputStream bufferedInputStream;

  public ConsoleReader() {
    bufferedInputStream = new BufferedInputStream(System.in);
  }

  public String fetchNextInput() {
    byte[] buffer = new byte[BUFFER_SIZE];
    int read;
    try {
      read = bufferedInputStream.read(buffer);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    return new String(Arrays.copyOf(buffer, read));
  }

  @Override
  public void close() throws IOException {
    bufferedInputStream.close();
  }
}
