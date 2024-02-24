import java.util.Arrays;
import java.util.List;

public class Constants {

    public final String TEXT_FOR_SELECT = "Введите номер режима, который вы хотите использовать (1 - Шифровка; 2 - Расшифровка; 3 - Поиск грубой силой):";
    public final String TEXT_FOR_FILE_INPUT = "Введите путь к файлу, откуда взять данные:";
    public final String TEXT_FOR_FILE_OUTPUT = "Введите путь к файлу, куда записать результат:";
    public final String TEXT_FOR_KEY = "Введите количетсво знаков, на которое сдвинуть:";
    public final String TEXT_FOR_FILE_DOES_NOT_EXIST = "Файл не существует!\nВведите еще раз:";
    public final String TEXT_FOR_VALID_FILE_OUTPUT = "Файл должен иметь расширение .txt\nВведите еще раз:";
    public final String TEXT_FOR_CREATE_FILE_OUTPUT = "Мы позаботились о вас и создали файл по адресу:";
    public final String TEXT_FOR_FILE_CREATE_ERROR = "Ошибка при создании файла!";
    public final String TEXT_FOR_VALID_KEY = "Ключ должен быть больше 0!";
    public final String TEXT_FOR_FILE_ERROR = "Ошибка при работе с файлами!";
    public final String TEXT_FOR_VALID_MODE = "Такого режима нет. Введите еще раз:";
    public final String TEXT_FOR_DIGIT_MODE = "Ошибка ввода. Необходимо вводить число.";
    public final String TEXT_FOR_READY = "Готово!";

    public final List ALPHABET = Arrays.asList('а', 'б', 'в',
            'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' ');

    public final char SPACE = ' ';
}
