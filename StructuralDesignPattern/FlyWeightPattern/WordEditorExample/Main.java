import java.util.HashMap;
import java.util.Map;

interface ILetter {
  void display(int x, int y);
}

class DocumentCharater implements ILetter {

  private int size;
  private String font;
  private char character;

  DocumentCharater(char character, int size, String font) {
    this.character = character;
    this.font = font;
    this.size = size;
  }

  public int getSize() {
    return size;
  }

  public String getFont() {
    return font;
  }

  public char getCharacter() {
    return character;
  }

  @Override
  public void display(int x, int y) {
    System.out
        .println("Character " + character + " of size " + size + " is display at cordinate x : " + x + " y : " + y);
  }

}

class DocumentFactory {
  public static Map<Character, ILetter> mpp = new HashMap<>();

  public static ILetter createDocumentLetter(char c) {

    if (mpp.containsKey(c)) {
      System.out.println("It is cached Object Reference !! ");
      return mpp.get(c);
    } else {
      DocumentCharater documentCharater = new DocumentCharater(c, 10, "Arial");
      mpp.put(c, documentCharater);
      return documentCharater;
    }
  }
}

public class Main {

  public static void main(String[] args) {
    ILetter Letter1 = DocumentFactory.createDocumentLetter('t');
    Letter1.display(9, 1);

    ILetter Letter2 = DocumentFactory.createDocumentLetter('t');
    Letter2.display(4, 3);

  }

}
