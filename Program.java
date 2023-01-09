
public class Program {

  public static void main(String[] args) {

    Word doc1 = new Word();
    doc1.setModel(new StringFormat());
    doc1.appendData("Раз два");

    doc1.setFormat(new FunnyFormat());
    doc1.click();

    doc1.appendData("три четыре");
    doc1.setFormat(new SadFormat());
    doc1.click();

    doc1.setFormat(new NewFormat());
    doc1.click();

    // #region
    // Document doc = new Document();
    // doc.setWorker(new Worker(22, 221, "Какое-то имя"));

    // doc.SaveAs();// Save html
    // // xml
    // // <xml>
    // // <Worker>
    // // <age>22</age>
    // // <salary>221</salary>
    // // <name>Какое-то имя</name>
    // // </Worker>
    // // </xml>

    // // md
    // doc.SaveAs();// Save md
    // // # Worker
    // // * age 22
    // // * salary 221
    // // * name Какое-то имя

    // // json
    // doc.SaveAs();// Save json
    // // {
    // // "worker" : {
    // // "age":22,
    // // "salary":221,
    // // "name":"Какое-то имя",
    // // }
    // // }
    // #endregion
  }
}

abstract class Model {
  abstract String getRawData();

  abstract void appendRawData(String t);
}

class StringFormat extends Model {

  String text = "";

  @Override
  String getRawData() {
    return text;
  }

  @Override
  void appendRawData(String t) {
    text += t;
  }

}

class Word {
  Model model;

  public void setModel(Model model) {
    this.model = model;
  }

  TitleFormat format;

  public void appendData(String text) {
    model.appendRawData(text);
  }

  public void setFormat(TitleFormat f) {
    format = f;
  }

  void click() {
    format.print(model.getRawData());
  }
}

interface TitleFormat {
  void print(String text);
}

class FunnyFormat implements TitleFormat {

  @Override
  public void print(String text) {
    System.out.println("😄" + " " + text);
  }

}

class SadFormat implements TitleFormat {

  @Override
  public void print(String text) {
    System.out.println("😔" + " " + text);
  }

}

class NewFormat implements TitleFormat {

  @Override
  public void print(String text) {
    System.out.println(" ❤️ " + text + " ❤️ ");
  }

}

// #region
class Document {
  Button button;

  public Document() {

  }
}

class Button {

  public void click() {
    // ...
  }
}

class Worker {
  int age;
  int salary;
  String name;
}

// #endregion