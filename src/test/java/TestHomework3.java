package org.example;

import net.jqwik.api.*;
import net.jqwik.api.constraints.Size;
import net.jqwik.api.statistics.Histogram;
import net.jqwik.api.statistics.NumberRangeHistogram;
import net.jqwik.api.statistics.Statistics;
import net.jqwik.api.statistics.StatisticsReport;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHomework3 {

    //genera e testa tutte le possibili situazioni
    @Property(tries = 10)
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void testRandomPassword(@ForAll("stringheCasuali")  String Password){
        Integer result = Homework3.validatePassword(Password);
        Statistics.label("Ecco le statistiche generate").collect(result);
    }

    @Provide
    Arbitrary<String> stringheCasuali() {
        return Arbitraries.strings().withCharRange('!', '~');
    }

    //genera e testa situazioni accettate

    @Property(tries = 10)
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void testAcceptedPassword(@ForAll("stringheAccettate") String Password){
        Integer result = Homework3.validatePassword(Password);
        Statistics.collect("Password Accettate : Cod." ,result);
        assertEquals(result ,1);
    }

    @Provide
    Arbitrary<String> stringheAccettate() {
        return Arbitraries.strings().withCharRange('!', '~').filter(s -> s.length() >= 8 && s.length() <= 20 &&
                s.matches(".*[A-Z].*") && s.matches(".*[a-z].*") && s.matches(".*\\d.*")
                && s.matches(".*[!@#$%^&*()].*") && s.matches(".*[0-9].*"));
    }

    //genera e testa situazioni non accettate

    @Property(tries = 10)
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void testNotAcceptedPassword(@ForAll("stringheNonAccettate") String Password){
        Integer result = Homework3.validatePassword(Password);
        Statistics.collect("Password Non accettate : Cod." ,result);
        assertEquals(result ,0);
    }

    @Provide
    Arbitrary<String> stringheNonAccettate() {
        return Arbitraries.strings().filter(s -> s.length() >= 8 && s.length() <= 20 && s.matches(".*[a-z].*"));
    }

    //genera e testa situazioni Out of Range

    @Property(tries = 10)
    @Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void testOutOfRangePassword(@ForAll("stringheOutOfRange") String Password){
        Integer result = Homework3.validatePassword(Password);
        Statistics.collect("Password Out of Range : Cod." ,result);
        assertEquals(result, -1);
    }

    @Provide
    Arbitrary<String> stringheOutOfRange() {
        return Arbitraries.strings().withCharRange('!', '~').filter(s -> s.length() < 8 &&
                s.matches(".*[A-Z].*") && s.matches(".*[a-z].*") && s.matches(".*\\d.*")
                && s.matches(".*[!@#$%^&*()].*") && s.matches(".*[0-9].*"));
    }


}
