import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.awt.SystemColor.menu;

public class Lambda03 {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("trileçe","havucDilim","güvec","kokorec",
                "küşleme","arabAşı","waffle","künefe","güvec"));


        alfBykTekrsz(menu);
        System.out.println();
        charSayisiTersSiraliUnique(menu);
        System.out.println();
        chrSayisiBykSirali(menu);
        System.out.println();
        harfSayisi7denAzKontrol(menu);
        System.out.println();
        wIleBaslayanElKontrol(menu);
        System.out.println();
        xIleBitenElemanKontrol(menu);
        System.out.println();
        charSAyisiEnBykElPrint(menu);
        ilkElHrcSonHrfSiraliPrint(menu);
        System.out.println();





    }

    //list.stream().sorted().distinct().forEach(t-> System.out.println(t.toUpperCase()+ " "));
    // Task -1 : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfBykTekrsz(List<String> yemek) {
        yemek.
                stream().//akis basladi
                map(String::toUpperCase).//Buyuk harf
                sorted().//Dogal siralandi(alfabetik)
                distinct().//elemanlarin tekrarsiz olmasini sagladi
                forEach(t -> System.out.print(t + " "));//print
    }

    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void charSayisiTersSiraliUnique(List<String> ikram) {
        ikram.stream().//akis alindi
                map(String::length).//akisi guncelledim kelimelrin uzunlugu olarak.
                sorted(Comparator.
                reverseOrder()).//ters sirali
                distinct().//tekrarsiz
                forEach(Lambda01::yazdir);

    }
    // Task-3 : List elemanlarini, character sayisina gore kckten byk e gore print ediniz..

    public static void chrSayisiBykSirali(List<String> ikram) {
        ikram.
                stream().//akis saglandi
                sorted(Comparator.comparing(String::length)).//String ifadeleri karakter sayisina gore  k->b ye  gore siraladim.
                forEach(Lambda03::yazdir);//print
    }

    public static void yazdir(String a) {
        System.out.print(a + " ");
    }


// ******************************************************************************************
// *********************** anyMatch() *** allMatch() **** noneMatch() ************************
//*******************************************************************************************

//anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
//allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
//noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    // Task-4 : List elelmmalarinin hepsinin karakter sayisinin 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void harfSayisi7denAzKontrol(List<String> ikram) {

        System.out.println(ikram.
                stream().
                allMatch(t->t.length()<=7) ? "list elemanlari 7 ve daha az harften olusuyor":
                "list elemanlari 7 harften buyuk");
    }
    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.
    public static void wIleBaslayanElKontrol(List<String> ikram){
        System.out.println(ikram.stream().
                noneMatch(t -> t.startsWith("w")) ? "w ile yemek ismi mi olur" : "w ile yemek icat ettik.");
    }
    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı var mi kontrol ediniz.


public static void xIleBitenElemanKontrol(List<String> ikram) {
    System.out.println(ikram.
            stream().
            anyMatch(t -> t.endsWith("x")) ? "x ile biterse masallah " : "x ile yemek ismi biter mi hic");
}

// Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void charSAyisiEnBykElPrint(List<String> ikram){
        Stream<String> sonIsim = ikram.
                stream().//Akis saglandi
                sorted(Comparator.comparing(t->t.toString().length()).
                        reversed()).//Karakter sayisina gore tersten siralandi.
                limit(1);//Limit methodu kullanilarak sadece ilk eleman cagrildi.

        //Limit() methodunun donen degeri Stream<String> yapidadir.

        System.out.println(Arrays.toString(sonIsim.toArray()));//sonIsim.toArray()---> Stream olan akis Array'e cevrildi
        //Arrays.toString(sonIsim.toArray())--> Array'i String yapiya ceviriyor.
    }

// Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void ilkElHrcSonHrfSiraliPrint(List<String>ikram){
        ikram.stream().//Akis saglandi
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))).//Son harfine gore alfabetik siralandi
                skip(1).//Akisdaki ilk eleman haric tutuldu
                forEach(Lambda03::yazdir);//ekrana print edildi

        //skip ilk n elemanı atlar limit ilk n elemanı gösterir
    }

}