import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Wrong argument1");
            System.exit(0);
        }
        Path path = null;
        if (args[0].startsWith("--current-folder=")) {
            path = Paths.get(args[0].substring(17));
        } else {
            System.out.println("Wrong argument2");
            System.exit(0);
        }
        if (!Files.isDirectory(path)) {
            System.out.println("Wrong argument3");
            System.exit(0);
        }

        Scanner scanner = new Scanner(System.in);
        String input;
        while ((input = scanner.nextLine()) != null) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "ls":
                    Stream<Path> pathStream = Files.walk(path, 1);
                    List<Path> pathList = pathStream.collect(Collectors.toList());
                    for (Path p : pathList) {
                        if (!p.equals(path) && !p.getFileName().toString().startsWith("."))
                            System.out.println(p.getFileName() + " " + Files.size(p) + " KB");
                    }
                    break;
                case "cd":
                    if (command[1] == null || command[1].isEmpty()) {
                        System.out.println("Wrong cd command");
                        break;
                    }
                    Path pathTmp = path;
                    path = Paths.get(path.toString() + "/" + command[1]);
                    if (Files.exists(path) && Files.isDirectory(path)) {
                        path = path.normalize();
                        System.out.println(Paths.get(path.toAbsolutePath() + "/"));
                    } else {
                        path = pathTmp;
                        System.out.println("Wrong path");
                    }
                    break;
                case "mv":
                    if (command[1] == null || command[1].isEmpty() || command[2] == null || command[2].isEmpty()) {
                        System.out.println("Wrong mv command");
                        break;
                    }
                    Path source = Paths.get(path + "/" + command[1]).normalize();
                    Path target = Paths.get(path + "/" + command[2]).normalize();
                    try {
                        if (Files.isRegularFile(source)) {
                            if (Files.isDirectory(target)) {
                                target = Paths.get(target + "/" + source.getFileName());
                            }
                            Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
                        } else
                            System.out.println("Can't find source file");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "exit":
                    System.out.println("Bye!");
                    System.exit(0);
                default:
                    System.out.println("Oooops, something wrong!");
            }
        }
    }
}
