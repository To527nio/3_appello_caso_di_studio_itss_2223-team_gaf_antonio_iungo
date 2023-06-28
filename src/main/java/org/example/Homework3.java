package org.example;

//Proprietà: Validazione di una password
//
//        Genera 10 input casuali con password
//
//        Per ogni input:
//        - L'utente fornisce una password
//        - Si definiscono le seguenti proprieta' per definire una password valida:
//        1. La password è troppo corta (meno di 8 caratteri):
//        - Verifica che venga generato un errore di lunghezza insufficiente
//        2. La password è troppo lunga (più di 20 caratteri):
//        - Verifica che venga generato un errore di lunghezza eccessiva
//        3. La password non contiene caratteri speciali:
//        - Verifica che venga generato un errore di carattere speciale mancante
//        4. La password non contiene numeri:
//        - Verifica che venga generato un errore di numero mancante
//        5. La password non contiene lettere maiuscole:
//        - Verifica che venga generato un errore di lettera maiuscola mancante
//        6. La password non contiene lettere minuscole:
//        - Verifica che venga generato un errore di lettera minuscola mancante
//
//        Eseguire i test per le 100 password e verificare le partizioni

//-1 fuori dal range
//0 non accettato
//1 accettato

import java.util.Random;

public class Homework3 {
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 20;
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String NUMBERS = "0123456789";

    public static Integer validatePassword(String password) {
        if (password.length() < MIN_LENGTH) {
            return -1;
        }

        if (password.length() > MAX_LENGTH) {
            return -1;
        }

        boolean hasSpecialChar = false;
        boolean hasNumber = false;
        boolean hasUppercase = false;
        boolean hasLowercase = false;

        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARACTERS.indexOf(c) != -1) {
                hasSpecialChar = true;
            } else if (NUMBERS.indexOf(c) != -1) {
                hasNumber = true;
            } else if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            }
        }

        if (!hasSpecialChar) {
            return 0;
        }

        if (!hasNumber) {
            return 0;
        }

        if (!hasUppercase) {
            return 0;
        }

        if (!hasLowercase) {
            return 0;
        }

        return 1;
    }

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("LEGENDA : 0 non valido , 1 valido , -1 fuori dal range");
        for (int i = 0; i < 10; i++) {
            String password = generateRandomPassword(random.nextInt(random.nextInt(13) + 8));
            System.out.println("Password: " + password);
            System.out.println("Risultato: " + validatePassword(password));
            System.out.println("--------------------");
        }
    }

    private static String generateRandomPassword(int length) {
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int choice = random.nextInt(4);

            switch (choice) {
                case 0:
                    password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));
                    break;
                case 1:
                    password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
                    break;
                case 2:
                    password.append(Character.toUpperCase((char) (random.nextInt(26) + 'a')));
                    break;
                case 3:
                    password.append(Character.toLowerCase((char) (random.nextInt(26) + 'A')));
                    break;
            }
        }

        return password.toString();
    }
}

