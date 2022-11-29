import java.util.*;
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
        System.out.println(matBolumSayisi(unv));
        System.out.println();
        System.out.println(ogrncSayisi550BykMaxOrt(unv));
        System.out.println();
        System.out.println(ogrncSayisi1050AzMinNotOrt(unv));


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
                stream(). // akış sağlandı //List<Universite>--->(U01,u02,u03,u04,u05)
                        sorted(Comparator.comparing(Universite::getOgrenciSayisi).reversed()).
                // universiteler öğrenci sayısına göre tersden sıralandı
                        collect(Collectors.toList()); // Stream yapısı List yapısına dönüştürüldü
    }
    //task 04-->"matematik" bolumlerinin sayisini  print ediniz.

    public static int matBolumSayisi(List<Universite> unv){
       return (int)unv.stream().//Akis sagladim
               filter(t->t.getBolum().contains("mat")).//Matematik bolumu olan unv.sectim
               count();//secilen unv. sayisini aldim
    }
    //task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
    public static OptionalInt ogrncSayisi550BykMaxOrt(List<Universite> unv){
        return unv.stream().
                filter(t->t.getOgrenciSayisi()>550).
                mapToInt(t->t.getNotOrt()).
                max();//Akisdan gelen en buyuk sayiyi verir.sonucta tek bir ifade istedigi icin null riski var
    }

    //task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.

    public static OptionalInt ogrncSayisi1050AzMinNotOrt(List<Universite> unv) {


        return unv.
                stream().
                filter(t -> t.getOgrenciSayisi() < 1050).
                mapToInt(t->t.getNotOrt()).
                min();
        /*
        return unv.
        stream().
        filter(t->t.getOgrSayisi()<1050).
        mapToInt(Universite::getNotOrt).//veya t->t.getNotOrt()
                min();
         */
    }
    }

/*
Stream<University> x = unv.
        stream().
        sorted(Comparator.comparing(University::getÖğrenciSayisi).reversed());
System.out.println(Arrays.toString(x.toArray()));
 */