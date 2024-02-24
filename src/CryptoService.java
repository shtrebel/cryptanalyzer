import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CryptoService {

    Constants constants = new Constants();

    public void crypt(String pathIn, String pathOut, int key) {
        try {
            Path path = Path.of(pathIn);
            String text = Files.readString(path).toLowerCase();
            ArrayList<Character> characters = new ArrayList<>();

            for (int i = 0; i < text.length(); i++) {
                characters.add(text.charAt(i));
            }

            for (int i = 0; i < characters.size(); i++) {
                char symbol = characters.get(i);
                char temp = (char) constants.ALPHABET.get((constants.ALPHABET.indexOf(symbol) + key) % constants.ALPHABET.size());
                characters.set(i, temp);
            }

            StringBuilder builder = new StringBuilder(characters.size());
            for (Character character : characters) {
                builder.append(character);
            }
            String resultString = builder.toString();
            path = Path.of(pathOut);
            Files.writeString(path, resultString);
            System.out.println(constants.TEXT_FOR_READY);
        }catch (IOException exception){
            System.out.println(constants.TEXT_FOR_FILE_ERROR);
        }
    }

    public void decrypt(String pathIn, String pathOut, int key) {
        crypt(pathIn,pathOut,constants.ALPHABET.size() - (key % constants.ALPHABET.size()));
    }

    public void bruteForce(String pathIn, String pathOut) {
        try {
            Path path = Path.of(pathIn);
            String text = Files.readString(path).toLowerCase();
            char[] characters = text.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            char mostFrequancyCharacter = 0;
            int max = 0;
            int key;

            for (char character : characters) {
                if (map.containsKey(character)) {
                    map.put(character, map.get(character) + 1);
                } else {
                    map.put(character, 1);
                }
            }

            Set<Character> set = map.keySet();

            for (char element : set) {
                if (max == 0 || map.get(element) > max) {
                    max = map.get(element);
                }
            }

            for (Character character : map.keySet()) {
                if (map.get(character).equals(max)) {
                    mostFrequancyCharacter = character;
                }
            }

            key = constants.ALPHABET.indexOf(mostFrequancyCharacter) - constants.ALPHABET.indexOf(constants.SPACE);

            decrypt(pathIn, pathOut, key);
        }catch (IOException exception){
            System.out.println(constants.TEXT_FOR_FILE_ERROR);
        }
    }
}
