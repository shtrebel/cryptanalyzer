import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ConsoleService {

    Constants constants = new Constants();

    public String getFileNameInput(Scanner scanner){
        System.out.println(constants.TEXT_FOR_FILE_INPUT);
        scanner.nextLine(); //?
        String pathIn = scanner.nextLine();
        while (!Files.exists(Path.of(pathIn))){
            System.out.println(constants.TEXT_FOR_FILE_DOES_NOT_EXIST);
            pathIn = scanner.nextLine();
        }
        return pathIn;
    }

    public String getFileNameOutput(Scanner scanner) {
        System.out.println(constants.TEXT_FOR_FILE_OUTPUT);
        String pathOut = scanner.nextLine();
        while (!pathOut.endsWith(".txt")){
            System.out.println(constants.TEXT_FOR_VALID_FILE_OUTPUT);
            pathOut = scanner.nextLine();
        }
        Path path = Path.of(pathOut);
        if (!Files.exists(path)){
            try {
                Files.createFile(path);
                System.out.println(constants.TEXT_FOR_CREATE_FILE_OUTPUT + pathOut);
            } catch (IOException exception){
                System.out.println(constants.TEXT_FOR_FILE_CREATE_ERROR);
            }
        }
            return pathOut;
    }

    public int getKey(Scanner scanner){
        System.out.println(constants.TEXT_FOR_KEY);
        int key = scanner.nextInt();
        while (key < 0){
            System.out.println(constants.TEXT_FOR_VALID_KEY);
             key = scanner.nextInt();
        }
        return key;
    }
}
