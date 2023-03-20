import java.util.*;

public class Registration {
    private final static String RUSSIAN_ALPHABIT = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private final static String RANDOM_SYMBOL = "!”#$%&’()*";
    private final Map<String, char[]> userData = new HashMap<>();
    public int leight;

    public Registration() {
    }

    public Map<String, char[]> randomPassword(String login) {
        char[] passwordChars;
        if (isLogin(login)) {
            leight = login.length();
            passwordChars = generationPassword(login.length()).toCharArray();
            userData.put(login, passwordChars);
            getAboutResult(passwordChars, login);
        } else {
            System.out.println("Логин не может быть меньше 5 символов.");
        }
        return userData;
    }

    public String getAboutResult(char[] passwordChars, String login) {
        StringBuilder getAbRes = new StringBuilder();
        for (char g : passwordChars) {
            getAbRes.append(g);
        }
        System.out.println("login: " + login + "\nПароль: " + getAbRes);
        return "";
    }

    public boolean isLogin(String login) {
        return login.trim().length() >= 5;
    }

    private String generationPassword(int leight) {
        StringBuilder value = new StringBuilder();
        value.append(RUSSIAN_ALPHABIT.charAt(randomLetter()))
                .append(RUSSIAN_ALPHABIT.charAt(randomLetter()))
                .append(randomNumberLeight(leight))
                .append(randomFourNumber())
                .append(RANDOM_SYMBOL.charAt(randomSymbol()))
                .append(RUSSIAN_ALPHABIT.toLowerCase().charAt(randomLetter()));
        return String.valueOf(value);
    }

    private int randomLetter() {
        return (int) (Math.random() * 33);
    }

    private int randomNumberLeight(int leight) {
        return (int) (Math.random() * leight * leight) % 10;
    }

    private int randomFourNumber() {
        return (int) (Math.random() * 10);
    }

    private int randomSymbol() {
        return (int) (Math.random() * RANDOM_SYMBOL.length());
    }

    public String getData() {
        String value = null;
        StringBuilder result = new StringBuilder();
        TreeSet<String> allUserData = new TreeSet<>();
        for (Map.Entry<String, char[]> entry : userData.entrySet()) {
            String key = entry.getKey();
            value = Arrays.toString(entry.getValue());
            allUserData.add(("Логин: " + key + "\nПароль: " +
                    (value.replaceAll("[[\\[+\\]], ]", "")) + "\n"));
        }
        return allUserData.toString().replaceAll(", ", "\n");
    }
}
