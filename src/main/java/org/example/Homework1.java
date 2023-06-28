package org.example;

import java.util.*;

public class Homework1 {

    public static void main(String[] args) throws RuntimeException {
        // Parte 1: Gestione dell'input dell'utente
        int n = 1;
        int m = 1;

        String[] nomi = {"marco"};
        int[] numeri = {1};

        String messaggio = effettuaOperazioni(n, m, nomi, numeri);
        System.out.println(messaggio);
    }

    public static String effettuaOperazioni(int n, int m, String[] nomi, int[] numeri) throws RuntimeException {

        if (n != m)
        {
            return "Il numero di elementi inseriti non corrisponde";
        }
        else
        {
            if (n<=0)
            {
                return("Non e' possibile inserire una grandezza pari o minore di 0");
            }
            else {

                if(nomi.length != m || numeri.length != n)
                {
                    return "La lunghezza di uno dei due o entrambe le liste non corrisponde alla dimensione fornita in input";
                }

                for (int i = 0; i <= n-1; i++)
                {
                    if (numeri[i] < 0)
                    {
                        return ("Non e' possibile inserire un numero negativo");
                    }
                    if (numeri[i] > 99 )
                    {
                        return ("Il numero inserito e' troppo grande (offpoint) ");
                    }
                    if (nomi[i] == null) {
                        return ("Non e' possibile inserire stringhe nulle");
                    }
                }
            }

            // Calcola il quadrato dei numeri pari e il cubo dei numeri dispari
            List<Integer> quadrati = new ArrayList<>();
            List<Integer> cubi = new ArrayList<>();

            for (int i = 0; i <= n-1; i++) {
                if (numeri[i] % 2 == 0)
                {
                    int quadrato = numeri[i] * numeri[i];
                    if (quadrato < 100)
                    {
                        quadrati.add(quadrato);
                    }
                }
                else
                {
                    int cubo = numeri[i] * numeri[i] * numeri[i];
                    if (cubo < 200)
                    {
                        cubi.add(cubo);
                    }
                }
            }

            // Unisci i quadrati e i cubi in un unico array e ordina il tutto
            List<Integer> numeriOrdinati = new ArrayList<>();
            numeriOrdinati.addAll(quadrati);
            numeriOrdinati.addAll(cubi);
            Collections.sort(numeriOrdinati);


            Arrays.sort(nomi);

            // Stampa i numeri ordinati
            for (int numero : numeriOrdinati) {
                System.out.println(numero);
            }

            // Stampa i nomi ordinati
            for (String nome : nomi) {
                System.out.println(nome);
            }

        }
        return "Codice terminato con successo";
    }

}
