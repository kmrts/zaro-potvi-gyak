package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.List;

public class CleaningService {
    /*
    Legyen egy CleaningService osztály, mely nyilvántartja az ingatlanokat. A következő metódusokat implementáld:

void add(Cleanable cleanable) - hozzáaad egy ingatlant
int cleanAll() - kitakarítja az összes ingatlant, és visszaadja, hogy mennyibe került, ezután nem marad egy ingatlan sem
int cleanOnlyOffices() - kitakarítja csak az irodákat, és visszaadja, hogy mennyibe került. Ezután csak a házak maradnak.
List<Cleanable> findByAddressPart(String address) - visszaadja azokat az ingatlanokat, melynek címében szerepel a paraméterként megadott érték
String getAddresses() - visszaadja az ingatlanok címeit vesszővel és egy szóközzel elválasztva
Ez két feladatnak számít, első az osztályok és interfész létrehozása, és a CleaningService osztály első metódusa egy feladat.
A többi metódus még egy feladatnak számít.
     */

    private List<Cleanable> cleanables= new ArrayList<>();

    public List<Cleanable> getCleanables() {
        return new ArrayList<>(cleanables);
    }

    public void add(Cleanable cleanable){
        cleanables.add(cleanable);
    }

    public int cleanAll(){
        int sum= 0;

        for(Cleanable cl: cleanables){
            sum+= cl.clean();
        }
        cleanables.clear();
        return sum;
    }

    public int cleanOnlyOffices(){
        int sum= 0;
        List<Cleanable> removable= new ArrayList<>();

        for(Cleanable cl: cleanables){
            if(cl instanceof Office){
                sum+= cl.clean();
                removable.add(cl);
            }

        }
        cleanables.removeAll(removable);

        return sum;
    }
    public List<Cleanable> findByAddressPart(String address){
        List<Cleanable> result= new ArrayList<>();

        for(Cleanable cl: cleanables){
            if(cl.getAddress().contains(address)){
                result.add(cl);
            }
        }
        return result;
    }
    public String getAddresses(){
        StringBuilder sb= new StringBuilder("");
        for(Cleanable cl: cleanables){
            sb.append(cl.getAddress());
            sb.append(", ");
        }
        if(!sb.isEmpty()){
            sb.delete(sb.length()-2, sb.length());
        }

        return sb.toString();

    }
}
