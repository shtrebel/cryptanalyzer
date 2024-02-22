import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        CryptoService cryptoService = new CryptoService();
        ConsoleService consoleService = new ConsoleService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер режима, который вы хотите использовать (1 - Шифровка; 2 - Расшифровка; 3 - Поиск грубой силой");
        int value = scanner.nextInt();

        switch (value){
            case 1: {
                String pathIn = consoleService.getFileNameInput();
                String pathOut = consoleService.getFileNameOutput();
                int key = consoleService.getKey();
                cryptoService.crypt(pathIn, pathOut, key);
                break;
            }
            case 2:{
                String pathIn = consoleService.getFileNameInput();
                String pathOut = consoleService.getFileNameOutput();
                int key = consoleService.getKey();
                cryptoService.decrypt(pathIn, pathOut, key);
                break;
            }
        }
    }
}