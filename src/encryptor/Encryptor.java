package encryptor;

public class Encryptor {

  private static final int SHIFT_CONSTANT = -3;

  private Encryptor() {

  }

  public static String encrypt(String input) {
    StringBuilder result = new StringBuilder();
    if (input == null) {
      return result.toString();
    }

    char[] chars = input.toCharArray();
    for (char character : chars) {
      result.append(shiftCharacter(character, SHIFT_CONSTANT));
    }

    return result.toString();
  }

  private static char shiftCharacter(char character, int shift) {
    int distance = 'z' - 'a' + 1;
    int directionMultiplier = getShiftDirection(shift);
    char shiftedCharacter = (char) (character + shift);

    if (character == ' ') {
      return character;
    }
    if ((isInRange(character, 'a', 'z') && !isInRange(shiftedCharacter, 'a', 'z')) || (isInRange(character, 'A', 'Z') && !isInRange(shiftedCharacter, 'A', 'Z'))) {
      shiftedCharacter = (char) (shiftedCharacter - directionMultiplier * (distance));
    }
    return shiftedCharacter;
  }

  static boolean isInRange(char character, int min, int max) {
    return character >= min && character <= max;
  }

  static int getShiftDirection(int shift) {
    return shift >= 0 ? 1 : -1;
  }
}
