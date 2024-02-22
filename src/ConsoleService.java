import java.util.Scanner;

public class ConsoleService {

    public String getFileNameInput(){
        System.out.println("Введите имя файла, откуда взять данные:");
        String pathIn = "C:\\Users\\aasht_wr2h90k\\IdeaProjects\\cryptanalyzer\\src\\input.txt" ;
        return pathIn;
    }

    public String getFileNameOutput(){
        System.out.println("Введите имя файла, куда записать результат:");
        String pathOut = "C:\\Users\\aasht_wr2h90k\\IdeaProjects\\cryptanalyzer\\src\\result.txt";
        return pathOut;
    }

    public int getKey(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количетсво знаков, на которое сдвинуть:");
        int key = scanner.nextInt();
        return key;
    }




}
