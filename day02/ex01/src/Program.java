import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Program {

    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.out.println("Wrong number of arguments!");
            System.exit(-1);
        }

        Scanner fileA = null;
        Scanner fileB = null;

        try {
            FileInputStream fileInputStreamA = new FileInputStream(args[0]);
            fileA = new Scanner(fileInputStreamA);
            FileInputStream fileInputStreamB = new FileInputStream(args[1]);
            fileB = new Scanner(fileInputStreamB);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> textA = new ArrayList<>();
        ArrayList<String> textB = new ArrayList<>();
        TreeSet<String> dicA = new TreeSet<>();

        for (int i = 0; Objects.requireNonNull(fileA).hasNext(); i++) {
            String str = fileA.next();
            dicA.add(str);
            textA.add(str);
        }

        for (int i = 0; Objects.requireNonNull(fileB).hasNext(); i++) {
            String str = fileB.next();
            dicA.add(str);
            textB.add(str);
        }

        if (textA.size() == 0 || textB.size() == 0) {
            System.out.println("Similarity = 0.00");
            System.exit(0);
        }

        FileOutputStream dictionary = new FileOutputStream("dictionary.txt", false);
        dictionary.write(dicA.toString().getBytes(StandardCharsets.UTF_8));

        int[] arrayA = new int[dicA.size()];
        int[] arrayB = new int[dicA.size()];

        TreeSet<String> tmp = new TreeSet<>();
        tmp.addAll(dicA);

        for (int i = 0; i < dicA.size(); i++) {
            for (int j = 0; j < textA.size(); j++) {
                if (tmp.first().equals(textA.get(j))) {
                    arrayA[i]++;
                }
            }
            tmp.remove(tmp.first());
        }

        tmp.addAll(dicA);

        for (int i = 0; i < dicA.size(); i++) {
            for (int j = 0; j < textB.size(); j++) {
                if (tmp.first().equals(textB.get(j))) {
                    arrayB[i]++;
                }
            }
            tmp.remove(tmp.first());
        }

        double numerator = 0;
        for (int i = 0; i < arrayA.length; i++) {
            numerator += arrayA[i] * arrayB[i];
        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < arrayA.length; i++) {
            a += Math.pow(arrayA[i], 2);
            b += Math.pow(arrayB[i], 2);
        }
        double denominator = Math.sqrt(a) * Math.sqrt(b);
        Double similarity = (numerator / denominator);
        System.out.printf("Similarity = %.4s\n", similarity);
    }
}
