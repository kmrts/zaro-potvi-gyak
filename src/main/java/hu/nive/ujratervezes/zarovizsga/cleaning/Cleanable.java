package hu.nive.ujratervezes.zarovizsga.cleaning;

public interface Cleanable {
    /*
    Legyen egy Cleanable interfészed, annak int clean() és String getAddress() metódusa.
    Ez azt jelenti, hogy valamit ki lehet takarítani (amit visszaad a metódus, az a takarítás ára), valamint lennie kell egy címének is.
    58p
     */

    int clean();
    String getAddress();
}
