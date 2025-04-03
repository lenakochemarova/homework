public class HomeworkString {

    public static void numberOfLetters(String str, char c) {
        String[] strings = str.split("\\s+");
        for (String word : strings) {
            if (!word.matches("[А-Яа-яЁё]+"))
                continue;
            int res = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.toLowerCase().charAt(i) == c)
                    res++;
            }
            System.out.printf("Слово: %s, количество букв '%c' - %d\n", word, c, res);
        }
    }

    public static boolean phoneNumberCheck(String str) {
        return str.matches("^\\+\\d{1,3}-\\d{3}-\\d{3}-\\d{2}-\\d{2}$");
    }

    public static void deleteLettersAndSpaces(String str) {
        str = str.replaceAll("[A-Za-zА-Яа-яЁё\\s]", "");
        System.out.println("Очищенная строка - \"" + str + "\"");

    }

    public static void main(String[] args) {
        numberOfLetters("Проверочное слово - Естественное", 'е');
        System.out.println(phoneNumberCheck("+7-906-063-60-84"));
        deleteLettersAndSpaces("Здравствуйт3! Эт0 пр0верка.");
    }
}
