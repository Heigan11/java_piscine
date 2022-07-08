import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws IOException {

        Map<String, String> signaturesMap = new HashMap<>();

        int maxLength = fileToMap(signaturesMap);

        Scanner scanner = new Scanner(System.in);
        String path = "";
        while (!(path = scanner.nextLine()).equals("42")) {
            try {
                FileInputStream fileInputStream = new FileInputStream(path);
                FileOutputStream fileOutputStream = new FileOutputStream("result.txt", true);
                StringBuilder builder = new StringBuilder();
                boolean undefined = true;
                int a, i = 0;
                while ((a = fileInputStream.read()) != -1 && i < maxLength) {
                    builder.append(String.format("%02X ", a));
                    i++;
                }
                String fileSignature = builder.toString();
                for (String key : signaturesMap.keySet()) {
                    if (fileSignature.startsWith(key)) {
                        String value = signaturesMap.get(key);
                        fileOutputStream.write(value.getBytes());
                        fileOutputStream.write('\n');
                        System.out.println("PROCESSED");
                        undefined = false;
                        break;
                    }
                }
                if (undefined == true) {
                    System.out.println("UNDEFINED");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static int fileToMap(Map<String, String> signaturesMap){
        int maxLength = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream("signatures.txt");
            int c;
            while ((c = fileInputStream.read()) != -1) {
                StringBuilder builder = new StringBuilder();
                while ((char) c != '\n' || fileInputStream.available() == 0) {
                    builder.append((char) c);
                    c = fileInputStream.read();
                    if (c == -1) {
                        break;
                    }
                }

                String[] keyAndValue = builder.toString().split(", ");
                signaturesMap.put(keyAndValue[1], keyAndValue[0]);

                String tmp = keyAndValue[1].replaceAll("\\s", "");
                if (tmp.length() > maxLength)
                    maxLength = tmp.length();
            }
            fileInputStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return maxLength/2;
    }
}