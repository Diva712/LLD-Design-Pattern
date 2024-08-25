
import java.util.*;

interface FileSystem {

  void ls();
}

class File implements FileSystem {
  String fileName;

  File(String fileName) {
    this.fileName = fileName;
  }

  public void ls() {
    System.out.println("File name is " + fileName);
  }
}

class Directory implements FileSystem {
  String dirName;
  List<FileSystem> list;

  Directory(String dirName) {
    this.dirName = dirName;
    this.list = new ArrayList<>();
  }

  void add(FileSystem fileSystem) {
    list.add(fileSystem);
  }

  public void ls() {
    System.out.println("Directory Name is " + dirName);
    for (FileSystem fileSystem : list) {
      fileSystem.ls();
    }
  }
}

public class Main {

  public static void main(String[] args) {

    Directory MovieDirectory = new Directory("Movie");
    FileSystem movie1 = new File("Border");
    MovieDirectory.add(movie1);

    Directory ComedyMovie = new Directory("Comedy Movie Directory");
    FileSystem movie2 = new File("Hulchul");
    FileSystem movie3 = new File("PK");
    ComedyMovie.add(movie2);
    ComedyMovie.add(movie3);
    MovieDirectory.add(ComedyMovie);

    MovieDirectory.ls();

  }
}
