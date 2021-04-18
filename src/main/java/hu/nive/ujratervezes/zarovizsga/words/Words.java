package hu.nive.ujratervezes.zarovizsga.words;

public class Words {
    /*
    A Words osztálynak legyen egy boolean hasMoreDigits(String s) metódusa, mely visszaadja,
    hogy a szóvan több számjegy van-e, mint többi karakter.
    Azaz a aa111 szóban három számjegy van és kettő többi, azaz true értéket ad vissza.
    21.25~ 44
     */

    public boolean hasMoreDigits(String s){
         int digits=0;

         for(Character ch: s.toCharArray()){
             if(Character.isDigit(ch)){
                 digits++;
             }
         }
//        System.out.println(digits);
         return digits> s.length()- digits;
    }
}
