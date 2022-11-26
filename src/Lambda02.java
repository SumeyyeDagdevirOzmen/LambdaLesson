import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {
    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<Integer>(Arrays.asList(4,2,6,11,-5,7,3,15));
        ciftKarePrint(sayi);
        System.out.println();
        tekKupBirFazlaPrint(sayi);
        System.out.println();
        maxElBul(sayi);
        System.out.println();
        structuredMaxElBul(sayi);
        System.out.println();
        maxElBul(sayi);
        System.out.println();
        structuredMaxElBul(sayi);
        System.out.println();
        ciftKareMaxPrint(sayi);
        System.out.println();
        elTopla(sayi);
        System.out.println();
        ciftCarp(sayi);
        System.out.println();
        minBul(sayi);
        System.out.println();
        System.out.println();
        bestenBuyukTekKck(sayi);
        System.out.println();
        ciftKareKbSortPrint(sayi);


    }

    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz.
    public static void ciftKarePrint(List<Integer> sayi ){
        sayi.
                stream().
                filter(Lambda01::ciftBul).//Akisdaki cift sayilari filtreledim.4,2,6
                map(t->t*t).//16,4,36 map==>Stream icerisindeki elemanlari baska degerlere donusturur,aksiyon öncesi elemanlar aksiyon sonrası degişime ugrar
                forEach(Lambda01::yazdir);
    }

    // Task 2: Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void tekKupBirFazlaPrint(List<Integer> sayi){
        sayi.
                stream().
                filter(t->t%2!=0).//11,-5,7,3,15
                map(t->(t*t*t)+1).//Yani akışın içindeki elemanlar da değişiklik olduğunda map kullanacagiz.Akisin icindeki degerleri map ile degidtirmis oluyoruz
                forEach(Lambda01::yazdir);//1332 -124 344 28 3376
    }
//    public static void tekBul(int a){
//        if(a% 2 != 0){
//            System.out.print((a*a*a)+1);
//        }
//    }

                // Task-3 : Functional Programming ile listin cift elemanlarinin
                // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz.

    public static void ciftKarekokPrint(List<Integer> sayi){

        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).//Akis guncellendi
                forEach(t-> System.out.println(t+" "));//Lambda expression
    }

    // Task-4 : list'in en buyuk elemanini yazdiriniz.
    public static void maxElBul(List<Integer> sayi){
       Optional<Integer> maxSayi = sayi.//Optinal yapi Java 8 ile gelen bir degisikliktir.
               stream().
                reduce(Math::max);//Eger benim result'im tek bir deger ise o zaman reduce terminal operatoru kullanilir.
        System.out.println(maxSayi);//Optional[15]
    }
        //Structral yapi ile cozelim.
    public static void structuredMaxElBul(List<Integer> sayi){
        int max =Integer.MIN_VALUE;//max=Math.max(max,sayi.get(i)); sekilde de bulunabilir.
        System.out.println("max = " + max);//max = -2147483648
        for (int i = 0; i <sayi.size() ; i++) {
            if(sayi.get(i)>max){
                max=sayi.get(i);
            }

        }
        System.out.println("max number = " + max);//max number = 15

    }
    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKareMaxPrint(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).map(a -> a * a).
                reduce(Integer::max));// Integer::max methodu, Math::max' a gore daha hizli calisir.//Optional[36]

    }

    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...
    public static void elTopla(List<Integer> sayi){
        int toplam =sayi.stream().reduce(0,(a,b)->a+b);
        System.out.println("toplam = " + toplam);//toplam = 43
        /*
            * a ilk degerini her zaman atanan degerden (ilk parametre) alır,
                bu örnekte 0 oluyor
            * b degerini her zamana  stream()'dan akısdan alır
            * a ilk degerinden sonraki her değeri action(işlem)'dan alır

            */

    }
    // Task-7 : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void ciftCarp(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact));//Optional[48]//method reference kullandik

        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1, (a, b) -> (a * b)));//48//Lambda expression kullandik.
    }

    // Task-8 : List'teki elemanlardan en kucugunu  print ediniz
    public static void minBul(List<Integer> sayi){
        //1 yol:method reference kullandik
        System.out.println(sayi.
                stream().
                reduce(Integer::min));//Optional[-5] //Math::min yapabilirsiniz
        //2.Yol:
        System.out.println(sayi.stream().
                reduce(Integer.MAX_VALUE, (t, u) -> t < u ? t : u));
        //3.Yol:method reference
        System.out.println(sayi.
                stream().
                reduce(Lambda02::byMiracMin));
    }
    public static int byMiracMin(int a, int b){
        return (a<b) ? a:b;//ternary//byMiracMin(4,9)

    }

    // Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void bestenBuyukTekKck(List<Integer> sayi){

        System.out.println(sayi.
                stream().
                filter(a -> a > 5 && a % 2 != 0).
                reduce(Lambda02::byMiracMin));//Optional[7]
    }

    // Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftKareKbSortPrint(List<Integer> sayi){
        sayi.
                stream().//Akisi baslattik
                filter(Lambda01::ciftBul).//Akis icindeki cift sayilari aldim.
                map(t->t*t).//sayilarin karesi ile yeni bir akis olusturdum
                sorted().//akis icindeki sayilari natural-order olarak siraladim
                forEach(Lambda01::yazdir);//Akis icindeki sayilari ekrana yazdim //4 16 36
    }


   /*
   Note:
    Eger ilave birseyler yazmadan  hazir java methodlarindan cagiriyor isek "Method  reference",
    ilave biseyler yaziyor isek "lambda expression"  kullaniyoruz.
    Optinal deger almak istemiyorsan Lambda Expression kullanmalisin.

     */


}
