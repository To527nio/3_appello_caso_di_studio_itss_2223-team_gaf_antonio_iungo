import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import org.example.*;


class TestHomework1 {

    //T1 m uguale ad n ed entrambi uguali 0
    @ParameterizedTest
    @MethodSource("provideIntegers")
    void NequalsMequals0(int n, int m , String[] nomi,int[] numeri){

        Homework1.effettuaOperazioni(n,m,nomi,numeri);
        assertEquals(m,0);
        assertEquals(n,0);
        assertEquals(n,m);
    }

    static Stream<Arguments> provideIntegers() {
        return Stream.of(
                Arguments.of( 0,0,new String[]{"Ciao"},new int[]{1})
        );
    }

    //T2 n negativo
    @ParameterizedTest
    @MethodSource("test2")
    public void nShouldBeNegative(int n, int m , String[] nomi,int[] numeri)
    {
        Homework1.effettuaOperazioni(n,m,nomi,numeri);
        assertTrue(n < 0 );
    }

    static Stream<Arguments> test2() {
        return Stream.of(
                Arguments.of( -1,3,new String[]{"Ciao"},new int[]{1})
        );
    }

    //T3 m negativo
    @ParameterizedTest
    @MethodSource("test3")
    public void mShouldBeNegative(int n, int m , String[] nomi,int[] numeri)
    {
        Homework1.effettuaOperazioni(n,m,nomi,numeri);
        assertTrue(m < 0 );
    }
    static Stream<Arguments> test3() {
        return Stream.of(
                Arguments.of( 4,-10,new String[]{"Ciao"},new int[]{1})
        );
    }

    //T4 n diverso da m
    @ParameterizedTest
    @MethodSource("test4")
    public void MNotEqualsN(int n, int m , String[] nomi,int[] numeri)
    {
        Homework1.effettuaOperazioni(n,m,nomi,numeri);
        assertTrue(m != n);
    }

    static Stream<Arguments> test4() {
        return Stream.of(
                Arguments.of( 4,-10,new String[]{"Ciao"},new int[]{1})
        );
    }


    //T5 n non intero
    @ParameterizedTest
    @MethodSource("test5")
    public void MisInteger ( Object n, int m, String[] nomi,int[] numeri)  {
        boolean local1=false;
        try {
            int intValue = Integer.parseInt(n.toString()); // Conversione del primo argomento a un intero
        } catch (NumberFormatException e) {
            local1=true;
        }
        assertTrue(local1);
    }
    static Stream<Arguments> test5 () {
        return Stream.of(
                Arguments.of("p", 1, new String[]{"Ciao"}, new int[]{1}),
                Arguments.of("p", 2, new String[]{"Ciao", "Ciao", "Ciao"}, new int[]{4, 1, 4})
        );
    }

    //T6 m non intero
    @ParameterizedTest
    @MethodSource("NisInteger")
    public void NisInteger ( int n, Object m, String[] nomi,int[] numeri)  {
        boolean local1=false;
        try {
            int intValue = Integer.parseInt(m.toString()); // Conversione del primo argomento a un intero
        } catch (NumberFormatException e) {
            local1=true;
        }
        assertTrue(local1);
    }
    static Stream<Arguments> NisInteger () {
        return Stream.of(
                Arguments.of(1,"p", new String[]{"Ciao"}, new int[]{1}),
                Arguments.of(1,"p", new String[]{"Ciao", "Ciao", "Ciao"}, new int[]{4, 1, 4})
        );
    }


    //T7: numero inserito nell’array numeri è negativo
    @ParameterizedTest
    @MethodSource("provideIntArraysWithNegative")
    void testNegativeNumberInArray(int n, int m,String[] nomi,int[] numeri)  {
        Homework1.effettuaOperazioni(n,m,nomi,numeri);
        assertTrue(Arrays.stream(numeri).anyMatch(numero -> numero < 0 ),
                "numeri contiene almeno 1 numero negativo: " + Arrays.toString(numeri));
    }

    private static Stream<Arguments> provideIntArraysWithNegative() {
        return Stream.of(
                Arguments.of(2, 2,new String[]{"ciao", "hola"},new int[]{1,-1}),
                Arguments.of(3, 3,new String[]{"ciao", "hola", "hello"},new int[]{1, 1,-1})
        );
    }

    //T8 numero inserito nell’array numeri non è intero
    @ParameterizedTest
    @MethodSource("numberinArrayisnotInteger")
    public void numberinArrayisnotInteger ( int n, int m, String[] nomi,Object[] numeri)  {
        boolean local1=false;
        try {
            int intValue = Integer.parseInt(numeri.toString());
        } catch (NumberFormatException e) {
            local1=true;
        }
        assertTrue(local1);
    }
    static Stream<Arguments> numberinArrayisnotInteger () {
        return Stream.of(
                Arguments.of(2,2, new String[]{"Ciao"}, new Object[]{3, "c"}),
                Arguments.of(3,3, new String[]{"Ciao", "Ciao", "Ciao"}, new Object[]{"cio", 1, 4})
        );
    }

    //T9: elemento inserito nell’array numeri e' offpoint
    @ParameterizedTest
    @MethodSource("testOffpointNumber")
    void testOffpointNumber(int n, int m,String[] nomi,int[] numeri) throws NullPointerException {
        Homework1.effettuaOperazioni(n,m,nomi,numeri);
        assertTrue(Arrays.stream(numeri).anyMatch(numero -> numero >= 100 ),
                "numeri contiene almeno un numero offpoint: " + Arrays.toString(numeri));
    }

    private static Stream<Arguments> testOffpointNumber() {
        return Stream.of(
                Arguments.of(2, 2,new String[]{"cece","ciao"},new int[]{100,1}),
                Arguments.of(3, 3,new String[]{"ciao", "mano","casa"},new int[]{120, 3, 2})
        );
    }


    //T10: elemento inserito nell’array nomi è null
    @ParameterizedTest
    @MethodSource("testNameNullInArray")
    void testNameNullInArray(int n, int m,String[] nomi,int[] numeri) throws NullPointerException {
        Homework1.effettuaOperazioni(n,m,nomi,numeri);
        assertTrue(Arrays.stream(nomi).anyMatch(nome -> nome == null ),
                "nomi contiene una stringa null: " + Arrays.toString(nomi));
    }

    private static Stream<Arguments> testNameNullInArray() {
        return Stream.of(
                Arguments.of(2, 2,new String[]{"c",null},new int[]{1,1}),
                Arguments.of(3, 3,new String[]{"ciao", null,"c"},new int[]{1, 3, 2})
        );
    }


    //T11:Nomi [] contiene stringhe non vuote di lunghezza maggiore di 1 e Numeri[] contiene n numeri positivi
    @ParameterizedTest
    @MethodSource("testNameIntInArray")
    void testNameIntInArray(int n, int m,String[] nomi,int[] numeri)  {
        Homework1.effettuaOperazioni(n,m,nomi,numeri);

        assertFalse(Arrays.stream(numeri).anyMatch(numero -> numero <= 0),
                "i numeri sono tutti positivi: " + Arrays.toString(numeri));

        assertFalse(Arrays.stream(nomi).anyMatch(nome -> nome == ""),
                "il nome e' vuoto: " + Arrays.toString(nomi));

    }

    private static Stream<Arguments> testNameIntInArray() {
        return Stream.of(
                Arguments.of(2, 2,new String[]{"ciao", "halo"},new int[]{1,1}),
                Arguments.of(3, 3,new String[]{"ciao", "halo","hello"},new int[]{1, 1,4})
        );
    }

    // T12: contiene stringhe non vuote di lunghezza maggiore di 1 e Numeri[] contiene almeno un numero uguale a 0
    @ParameterizedTest
    @MethodSource("testNumber0InArray")
    void testNumber0InArray(int n, int m,String[] nomi,int[] numeri) {
        Homework1.effettuaOperazioni(n,m,nomi,numeri);

        assertFalse(Arrays.stream(nomi).anyMatch(nome -> nome == ""),
                "il nome e' vuoto: " + Arrays.toString(nomi));

        assertTrue(Arrays.stream(numeri).anyMatch(numero -> numero == 0),
                "Lo 0 non è presente nell'array numeri: " + Arrays.toString(numeri));
    }

    private static Stream<Arguments> testNumber0InArray() {
        return Stream.of(
                Arguments.of(2, 2,new String[]{"ciao", "ll"},new int[]{1,0}),
                Arguments.of(3, 3,new String[]{"ciao", "halo","hello"},new int[]{1, 2,0})
        );
    }

    //T13 Nomi [] contiene stringhe non vuote di lunghezza maggiore di 1 e Numeri[] contiene almeno 1 numero il cui cubo/quadrato supera il limite
    @ParameterizedTest
    @MethodSource("testStringNotEmptyandNumberThatExceedLimit")
    void testStringNotEmptyandNumberThatExceedLimit(int n, int m,String[] nomi,int[] numeri) {
        Homework1.effettuaOperazioni(n,m,nomi,numeri);

        assertFalse(Arrays.stream(nomi).anyMatch(nome -> nome == ""),
                "il nome e' vuoto: " + Arrays.toString(nomi));

        assertTrue(Arrays.stream(numeri).anyMatch(numero -> (numero % 2 == 0) && numero >= 10 || numero > 5 ),
                "numri contiene un numero il cui cubo/quadrato supera il limite: " + Arrays.toString(numeri));
    }

    private static Stream<Arguments> testStringNotEmptyandNumberThatExceedLimit() {
        return Stream.of(
                Arguments.of(2, 2,new String[]{"ciao", "ll"},new int[]{7,3}),
                Arguments.of(3, 3,new String[]{"ciao", "halo","hello"},new int[]{11,2,1})
        );
    }

    //T14 Nomi [] contiene stringhe non vuote di lunghezza maggiore di 1 e Numeri[] contiene almeno un numero uguale a 1
    @ParameterizedTest
    @MethodSource("testStringNotEmptyandNumberone")
    void testStringNotEmptyandNumberone(int n, int m,String[] nomi,int[] numeri) {
        Homework1.effettuaOperazioni(n,m,nomi,numeri);

        assertFalse(Arrays.stream(nomi).anyMatch(nome -> nome == ""),
                "il nome e' vuoto: " + Arrays.toString(nomi));

        assertTrue(Arrays.stream(numeri).anyMatch(numero -> numero == 1),
                "numeri contiene un numero uguale a 1: " + Arrays.toString(numeri));
    }

    private static Stream<Arguments> testStringNotEmptyandNumberone() {
        return Stream.of(
                Arguments.of(2, 2,new String[]{"ciao", "ll"},new int[]{1,3}),
                Arguments.of(3, 3,new String[]{"ciao", "halo","hello"},new int[]{11,2,1})
        );
    }

    //T15 Nomi [] contiene stringhe di lunghezza 1 e Numeri[] contiene n numeri positivi
    @ParameterizedTest
    @MethodSource("String1andNumberPositive")
    void String1andNumberPositive(int n, int m,String[] nomi,int[] numeri){
        Homework1.effettuaOperazioni(n,m,nomi,numeri);

        assertFalse(Arrays.stream(nomi).anyMatch(nome -> nome.length() != 1 ),
                "nomi contiene almeno 1 stringa di lunghezza 1: " + Arrays.toString(nomi));

        assertFalse(Arrays.stream(numeri).anyMatch(numero -> numero <= 0),
                "i numeri sono tutti positivi: " + Arrays.toString(numeri));
    }
    private static Stream<Arguments> String1andNumberPositive() {
        return Stream.of(
                Arguments.of(2, 2,new String[]{"s", "c"},new int[]{2,1}),
                Arguments.of(3, 3,new String[]{"a", "s","d"},new int[]{3,2,8})
        );
    }

    //T16 Nomi [] contiene stringhe di lunghezza 1 e Numeri[] contiene almeno un numero uguale a 0
    @ParameterizedTest
    @MethodSource("String1and1number0")
    void String1and1number0(int n, int m,String[] nomi,int[] numeri){
        Homework1.effettuaOperazioni(n,m,nomi,numeri);

        assertFalse(Arrays.stream(nomi).anyMatch(nome -> nome.length() != 1 ),
                "nomi contiene almeno 1 stringa di lunghezza 1: " + Arrays.toString(nomi));

        assertTrue(Arrays.stream(numeri).anyMatch(numero -> numero == 0),
                "Lo 0 non è presente nell'array numeri: " + Arrays.toString(numeri));
    }

    private static Stream<Arguments> String1and1number0() {
        return Stream.of(
                Arguments.of(2, 2,new String[]{"s", "c"},new int[]{0,1}),
                Arguments.of(3, 3,new String[]{"a", "s","d"},new int[]{3,1,0})
        );
    }

    //T17 Nomi [] contiene stringhe di lunghezza 1 e Numeri[] contiene almeno 1 numero il cui cubo/quadrato supera il limite
    @ParameterizedTest
    @MethodSource("String1and1numbercubeover")
    void String1and1numbercubeover(int n, int m,String[] nomi,int[] numeri){

        Homework1.effettuaOperazioni(n,m,nomi,numeri);

        assertFalse(Arrays.stream(nomi).anyMatch(nome -> nome.length() != 1 ),
                "nomi contiene almeno 1 stringa di lunghezza 1: " + Arrays.toString(nomi));

        assertTrue(Arrays.stream(numeri).anyMatch(numero -> (numero % 2 == 0) && numero >= 10 || numero > 5 ),
                "numeri contiene un numero il cui cubo/quadrato supera il limite: " + Arrays.toString(numeri));

    }
    private static Stream<Arguments> String1and1numbercubeover() {
        return Stream.of(
                Arguments.of(2, 2,new String[]{"s", "c"},new int[]{1,10}),
                Arguments.of(3, 3,new String[]{"a", "s","d"},new int[]{3,12,0})
        );
    }

    //T18:Nomi [] contiene stringhe di lunghezza 1 e Numeri[] contiene almeno un numero uguale a 1
    @ParameterizedTest
    @MethodSource("String1and1numberone")
    void String1and1numberone(int n, int m,String[] nomi,int[] numeri){

        Homework1.effettuaOperazioni(n,m,nomi,numeri);

        assertFalse(Arrays.stream(nomi).anyMatch(nome -> nome.length() != 1 ),
                "nomi contiene almeno 1 stringa di lunghezza 1: " + Arrays.toString(nomi));

        assertTrue(Arrays.stream(numeri).anyMatch(numero -> numero == 1 ),
                "numeri contiene un numero 1: " + Arrays.toString(numeri));

    }
    private static Stream<Arguments> String1and1numberone() {
        return Stream.of(
                Arguments.of(2, 2,new String[]{"s", "c"},new int[]{1,10}),
                Arguments.of(3, 3,new String[]{"a", "s","d"},new int[]{3,1,0})
        );
    }


    //T19: Nomi [] contiene almeno 1 stringa vuota e Numeri[] contiene n numeri positivi
    @ParameterizedTest
    @MethodSource("Stringnullandnpositive")
    void Stringnullandnpositive(int n, int m,String[] nomi,int[] numeri){
        Homework1.effettuaOperazioni(n,m,nomi,numeri);

        assertTrue(Arrays.stream(nomi).anyMatch(nome -> nome == ""),
                "il nome e' vuoto: " + Arrays.toString(nomi));

        assertFalse(Arrays.stream(numeri).anyMatch(numero -> numero <= 0),
                "i numeri sono tutti positivi: " + Arrays.toString(numeri));

    }
    private static Stream<Arguments> Stringnullandnpositive() {
        return Stream.of(
                Arguments.of(2, 2,new String[]{"a", ""},new int[]{1,100}),
                Arguments.of(3, 3,new String[]{"a", "s",""},new int[]{2,12,3})
        );
    }

    //T20: Nomi [] contiene almeno 1 stringa vuota e Numeri[] contiene almeno un numero uguale a 0
    @ParameterizedTest
    @MethodSource("testNameNullNumber0InArray")
    void testNameNullNumber0InArray(int n, int m,String[] nomi,int[] numeri) {
        Homework1.effettuaOperazioni(n,m,nomi,numeri);

        assertTrue(Arrays.stream(nomi).anyMatch(nome -> nome == ""),
                "il nome e' vuoto: " + Arrays.toString(nomi));

        assertTrue(Arrays.stream(numeri).anyMatch(numero -> numero == 0),
                "Lo 0 non è presente nell'array numeri: " + Arrays.toString(numeri));
    }

    private static Stream<Arguments> testNameNullNumber0InArray() {
        return Stream.of(
                Arguments.of(2, 2,new String[]{"ciao", ""},new int[]{1,0}),
                Arguments.of(3, 3,new String[]{"ciao", "","hello"},new int[]{1, 2,0})
        );
    }

    //T21: Nomi [] contiene almeno 1 stringa vuota e Numeri[] contiene almeno 1 numero il cui cubo/quadrato supera il limite
    @ParameterizedTest
    @MethodSource("testNameNullStringandonenumberthatexeedlimit")
    void testNameNullStringandonenumberthatexeedlimit(int n, int m,String[] nomi,int[] numeri) {
        Homework1.effettuaOperazioni(n,m,nomi,numeri);

        assertTrue(Arrays.stream(nomi).anyMatch(nome -> nome == ""),
                "il nome e' vuoto: " + Arrays.toString(nomi));

        assertTrue(Arrays.stream(numeri).anyMatch(numero -> (numero % 2 == 0) && numero >= 10 || numero > 5 ),
                "numeri contiene un numero il cui cubo/quadrato supera il limite: " + Arrays.toString(numeri));
    }

    private static Stream<Arguments> testNameNullStringandonenumberthatexeedlimit() {
        return Stream.of(
                Arguments.of(2, 2,new String[]{"ciao", ""},new int[]{7,0}),
                Arguments.of(3, 3,new String[]{"ciao", "","hello"},new int[]{11, 2,0})
        );
    }

    //T22: Nomi [] contiene almeno 1 stringa vuota e Numeri[] contiene almeno un numero uguale a 1
    @ParameterizedTest
    @MethodSource("testContainsEmptyStringandNumberOne")
    void testContainsEmptyStringandNumberOne(int n, int m,String[] nomi,int[] numeri){
        Homework1.effettuaOperazioni(n,m,nomi,numeri);

        assertTrue(Arrays.stream(nomi).anyMatch(nome -> nome == ""),
                "nomi contiene almeno una stringa vuota: " + Arrays.toString(nomi));

        assertTrue(Arrays.stream(numeri).anyMatch(numero -> numero == 1),
                "numeri contiene almeno un numero 1 : " + Arrays.toString(numeri));

    }
    private static Stream<Arguments> testContainsEmptyStringandNumberOne() {
        return Stream.of(
                Arguments.of(2, 2,new String[]{"ciao", ""},new int[]{1,3}),
                Arguments.of(3, 3,new String[]{"ciao", "","hello"},new int[]{1,2,3})
        );
    }

    //T23: Nomi [] contiene numeri e Numeri[] contiene n numeri positivi
    @ParameterizedTest
    @MethodSource("testContainsNumberinString")
    void testContainsNumberinString(int n, int m,String[] nomi,int[] numeri){
        Homework1.effettuaOperazioni(n,m,nomi,numeri);

        assertTrue(Arrays.stream(nomi).anyMatch(nome -> nome.matches(".*\\d.*")),
                "nomi contiene numeri: " + Arrays.toString(nomi));

        assertFalse(Arrays.stream(numeri).anyMatch(numero -> numero <= 0),
                "i numeri sono tutti positivi: " + Arrays.toString(numeri));

    }


    private static Stream<Arguments> testContainsNumberinString() {
        return Stream.of(
                Arguments.of(2, 2,new String[]{"cia3o", "jl"},new int[]{1,3}),
                Arguments.of(3, 3,new String[]{"cia3o", "halo","hello"},new int[]{1,2,3})
        );
    }

    //T24: Nomi [] contiene numeri e Numeri[] contiene almeno un numero uguale a 0
    @ParameterizedTest
    @MethodSource("testContainsNumberinStringAndNumber0")
    void testContainsNumberinStringAndNumber0(int n, int m,String[] nomi,int[] numeri) {
        Homework1.effettuaOperazioni(n,m,nomi,numeri);

        assertTrue(Arrays.stream(nomi).anyMatch(nome -> nome.matches(".*\\d.*")),
                "nomi contiene numeri: " + Arrays.toString(nomi));

        assertTrue(Arrays.stream(numeri).anyMatch(numero -> numero == 0),
                "Lo 0 non è presente nell'array numeri: " + Arrays.toString(numeri));

    }

    private static Stream<Arguments> testContainsNumberinStringAndNumber0() {
        return Stream.of(
                Arguments.of(2, 2,new String[]{"hhh1h23", "khh8g"},new int[]{1,0}),
                Arguments.of(3, 3,new String[]{"ci434ao", "l3434ola","3434miao"},new int[]{0,6,3})
        );
    }

    //T25: Nomi [] contiene numeri e Numeri[] contiene almeno 1 numero il cui cubo/quadrato supera il limite
    @ParameterizedTest
    @MethodSource("testContainsNumberinStringAndNumberThatexceedLimit")
    void testContainsNumberinStringAndNumberThatexceedLimit(int n, int m,String[] nomi,int[] numeri) {
        Homework1.effettuaOperazioni(n,m,nomi,numeri);

        assertTrue(Arrays.stream(nomi).anyMatch(nome -> nome.matches(".*\\d.*")),
                "nomi contiene numeri: " + Arrays.toString(nomi));

        assertTrue(Arrays.stream(numeri).anyMatch(numero -> (numero % 2 == 0) && numero >= 10 || numero > 5 ),
                "numeri contiene un numero il cui cubo/quadrato supera il limite: " + Arrays.toString(numeri));

    }

    private static Stream<Arguments> testContainsNumberinStringAndNumberThatexceedLimit() {
        return Stream.of(
                Arguments.of(2, 2,new String[]{"ciao4", "lola"},new int[]{7,1}),
                Arguments.of(2, 2,new String[]{"ciao", "lola2"},new int[]{10,8}),
                Arguments.of(3, 3,new String[]{"ciao3", "lola","lollo"},new int[]{11,1,1})
        );
    }

    //T26: Nomi [] contiene numeri e Numeri[] contiene almeno un numero uguale a 1
    @ParameterizedTest
    @MethodSource("testnumbersinstringandnumberone")
    void testnumbersinstringandnumberone(int n, int m,String[] nomi,int[] numeri) {
        Homework1.effettuaOperazioni(n,m,nomi,numeri);

        assertTrue(Arrays.stream(nomi).anyMatch(nome -> nome.matches(".*\\d.*")),
                "nomi contiene numeri: " + Arrays.toString(nomi));

        assertTrue(Arrays.stream(numeri).anyMatch(numero -> numero == 1),
                "numeri contiene un numero il cui cubo/quadrato supera il limite: " + Arrays.toString(numeri));

    }

    private static Stream<Arguments> testnumbersinstringandnumberone() {
        return Stream.of(
                Arguments.of(2, 2,new String[]{"ciao4", "lola"},new int[]{7,1}),
                Arguments.of(2, 2,new String[]{"ciao", "lola3"},new int[]{10,1}),
                Arguments.of(3, 3,new String[]{"ciao3", "lola","lollo"},new int[]{11,1,1})
        );
    }
    //T27 Il numero di elementi contenuti negli array numeri e nomi non corrisponde alle variabili m ed n
    @ParameterizedTest
    @MethodSource("testListLengthMismatch")
    void testListLengthMismatch(int n, int m, String[] nomi, int[] numeri) {
        String result = Homework1.effettuaOperazioni(n, m, nomi, numeri);

        assertEquals("La lunghezza di uno dei due o entrambe le liste non corrisponde alla dimensione fornita in input", result);
    }

    private static Stream<Arguments> testListLengthMismatch() {
        return Stream.of(
                Arguments.of(2, 2, new String[]{"ciao", "lola"}, new int[]{7, 2, 4}),
                Arguments.of(1, 1, new String[]{"ciao", "lola", "lollo"}, new int[]{7, 2})
        );

    }

    //T28 Nomi[] contiene nomi uguali, stampa solo una volta il nome anche con CAPS differente
    @ParameterizedTest
    @MethodSource("testnameContainsEqualNameAlthoughTheyStartWithDifferentCaps")
    void nameContainsEqualNameAlthoughTheyStartWithDifferentCaps(int n, int m,String[] nomi,int[] numeri) {
        Homework1.effettuaOperazioni(n,m,nomi,numeri);

        boolean containsSameNamesWithDifferentCaps = Arrays.stream(nomi)
                .anyMatch(nome -> Arrays.stream(nomi)
                        .anyMatch(otherNome -> !nome.equals(otherNome) && nome.equalsIgnoreCase(otherNome)));

        assertTrue(containsSameNamesWithDifferentCaps,
                "nomi contiene nomi uguali ma con caps differente: " + Arrays.toString(nomi));

    }
    private static Stream<Arguments> testnameContainsEqualNameAlthoughTheyStartWithDifferentCaps() {
        return Stream.of(
                Arguments.of(4, 4,new String[]{"Federico", "federico"},new int[]{7,1})
        );
    }

    //T29 Numeri[] contiene numeri uguali, stampa solo una volta il numero.
    @ParameterizedTest
    @MethodSource("testNumbersHaveDuplicatedNumbers")
    void NumbersHaveDuplicatedNumbers(int n, int m,String[] nomi,int[] numeri) {
        Homework1.effettuaOperazioni(n,m,nomi,numeri);

        boolean hasDuplicateNumbers = Arrays.stream(numeri)
                .anyMatch(numero -> Arrays.stream(numeri)
                        .filter(num -> num == numero)
                        .count() >= 2);

        assertTrue(hasDuplicateNumbers, "numeri contiene almeno due numeri uguali: " + Arrays.toString(numeri));

    }
    private static Stream<Arguments> testNumbersHaveDuplicatedNumbers() {
        return Stream.of(
                Arguments.of(4, 4,new String[]{"Federico", "federico"},new int[]{7,7})
        );
    }
}