package hu.nive.ujratervezes.zarovizsga.cleaning;

public class House implements Cleanable{
    /*
    Legyen két osztály, mely implementálja, a House és a Office!
    A House egy családi ház, melynek meg lehessen adni a címét és az alapterületét.
    A ház kitakarítása négyzetméterenként 80 Ft.
    Az Office egy iroda, melynek meg lehessen adni a címét, az alapterületét és a szintek számát.
    Az iroda kitakarítása négyzetméterenként 100 Ft. Természetesen az összes szintet számolni kell.
     */
    private String address;
    private int area;

    public House(String address, int area) {
        this.address = address;
        this.area = area;
    }

    @Override
    public int clean() {
        return area* 80;
    }

    @Override
    public String getAddress() {
        return address;
    }

//    public int getArea() {
//        return area;
//    }
}
