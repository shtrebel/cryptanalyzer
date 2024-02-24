import java.util.InputMismatchException;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        CryptoService cryptoService = new CryptoService();
        ConsoleService consoleService = new ConsoleService();
        Constants constants = new Constants();
        Scanner scanner = new Scanner(System.in);

        System.out.println(constants.TEXT_FOR_SELECT);
        try {
            int value = scanner.nextInt();

            while (value < 1 || value > 3) {
                System.out.println(constants.TEXT_FOR_VALID_MODE);
                value = scanner.nextInt();
            }

        switch (value) {
            case 1: {
                String pathIn = consoleService.getFileNameInput(scanner);
                String pathOut = consoleService.getFileNameOutput(scanner);
                int key = consoleService.getKey(scanner);
                cryptoService.crypt(pathIn, pathOut, key);
                break;
            }
            case 2: {
                String pathIn = consoleService.getFileNameInput(scanner);
                String pathOut = consoleService.getFileNameOutput(scanner);
                int key = consoleService.getKey(scanner);
                cryptoService.decrypt(pathIn, pathOut, key);
                break;
            }
            case 3: {
                String pathIn = consoleService.getFileNameInput(scanner);
                String pathOut = consoleService.getFileNameOutput(scanner);
                cryptoService.bruteForce(pathIn, pathOut);
                break;
            }
        }
        }catch (InputMismatchException exception){
            System.out.println(constants.TEXT_FOR_DIGIT_MODE);
        }
    }
}