import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CryptoService {

    private final List ALPHABET = Arrays.asList('а', 'б', 'в',
            'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' ');

    public void crypt(String pathIn, String pathOut, int key) throws IOException {
        Path path = Path.of(pathIn);
        String text = Files.readString(path).toLowerCase();
        ArrayList<Character> characters = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            characters.add(text.charAt(i));
        }

        for (int i = 0; i < characters.size(); i++) {
            char symbol = characters.get(i);
            char temp = (char) ALPHABET.get((ALPHABET.indexOf(symbol)+key)%ALPHABET.size());
            characters.set(i,temp);
        }

        StringBuilder builder = new StringBuilder(characters.size());
        for (Character character: characters){
            builder.append(character);
        }
        String resultString = builder.toString();
        path = Path.of(pathOut);
        Files.writeString(path, resultString);
    }

    public void decrypt(String pathIn, String pathOut, int key) throws IOException {
        crypt(pathIn,pathOut,ALPHABET.size() - (key % ALPHABET.size()));
    }
}
