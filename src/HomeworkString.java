public class HomeworkString {

    public static void numberOfLetters(String str, char c) {
        char[] array = str.toLowerCase().toCharArray();
        int result = 0;
        for (char i : array) {
            if (i == c) {
                result++;
            }
        }
        System.out.println("В строке буква '" + c + "' встречается " + result + " раз");
    }

    public static boolean phoneNumberCheck(String str) {
        return str.matches("^\\+\\d{1,3}\\(?\\d{1,3}\\)?(?:\\d[\\- ]?){5,12}\\d$");
    }

    public static void deleteLettersAndSpaces(String str) {
        str = str.replaceAll("[A-Za-zА-Яа-яЁё\\s]", "");
        System.out.println("Очищенная строка - \"" + str + "\"");

    }

    public static void main(String[] args) {
        numberOfLetters("Проверочный текст", 'е');
        System.out.println(phoneNumberCheck("+7(906)063-60-84"));
        deleteLettersAndSpaces("Здравствуйт3! Эт0 пр0верка.");
    }
}
