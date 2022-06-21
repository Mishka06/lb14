import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите y ");
        int t = scanner.nextInt();
        Formula did = new Formula(t);
        did.displayFormula();
        System.out.print("Введите слово ");
        String word = scanner.next();
        if (word.equals("save")) {
            try (ObjectOutputStream fww = new ObjectOutputStream(new FileOutputStream("C://lb14/src/lb14.txt"))) {
                fww.writeObject(did);
                fww.writeInt(t);
                System.out.println("Выполнено");

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("Ошибка");
        }
        System.out.print("Введите второе слово ");
        String word2 = scanner.next();
        if (word2.equals("upload")) {
            try (ObjectInputStream pt = new ObjectInputStream(new FileInputStream("C://lb14/src/lb14.txt"))) {
                Formula form = (Formula) pt.readObject();
                System.out.println(form.y);
                System.out.println("Готово");
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        else {
            System.out.println("Ошибка");
        }
    }
}
class Formula implements Serializable {
    float y;

    public Formula(float y) {
        this.y = y;
    }

    public void displayFormula() {
        double vector = y- (Math.sin(y));
        System.out.println(vector);
    }
}