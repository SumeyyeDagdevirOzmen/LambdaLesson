import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda04 {
    /*
TASK :
fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
 */

    public static void main(String[] args) {

        Universite u01 = new Universite("bogazici","matematik",571,93);
        Universite u02 = new Universite("istanbul tk","matematik",600,81);
        Universite u03 = new Universite("istanbul","hukuk",1400,71);
        Universite u04 = new Universite("marmara","bilg muh",1080,77);
        Universite u05 = new Universite("odtu","gemi mh",333,74);
        List<Universite> unv = new ArrayList<>(Arrays.asList(u01, u02, u03, u04, u05));
        System.out.println(notOrt74BykUnv(unv));
        System.out.println();
        System.out.println(matBolumVarMi(unv));
        System.out.println();
        System.out.println(ogrSayisiBykSirala(unv));






    }
    //task 01-->Butun universitelerin notOrt'larinin 74' den buyuk olup olmadigini kontrol eden program create ediniz.

    public static boolean notOrt74BykUnv(List<Universite> unv){
        return unv.
                stream().//akis sagladik universiteler u01,u02,u03,u04,u05
                allMatch(t->t.getNotOrt()>74);
    }
    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matBolumVarMi(List<Universite> unv){
        return unv.
                stream().//
                anyMatch(t->t.getBolum().//akisdan gelen objelerin bolum isimleri alindi
                        toLowerCase().//bolum isimlerindeki karakterler kucuk harfe cevrildi
                        contains("mat"));
    }

    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> ogrSayisiBykSirala(List<Universite> unv) {
        return unv.
                stream(). // akış sağlandı
                        sorted(Comparator.comparing(Universite::getOgrenciSayisi).reversed()).
                // universiteler öğrenci sayısına göre terden sıralandı
                        collect(Collectors.toList()); // Stream yapısı List yapısına dönüştürüldü
    }
    }

/*
Stream<University> x = unv.
        stream().
        sorted(Comparator.comparing(University::getÖğrenciSayisi).reversed());
System.out.println(Arrays.toString(x.toArray()));
 */