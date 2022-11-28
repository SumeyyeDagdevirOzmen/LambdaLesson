package lambda_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda01 {
    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));

        hepsiniYazdir(list);
        System.out.println();
        negativePrint(list);
        System.out.println();
        ciftPrint(list);
        System.out.println();
        pzCiftPrint(list);
        System.out.println();
        pozVeyaCiftYaz(list);
        System.out.println();
        kareYazdir(list);
        System.out.println();
        ciftKupPrint(list);
        System.out.println();
        KareTekrarsiz(list);
        System.out.println();
        kckBykSorted(list);
        System.out.println();
        bykKckReverseSorted(list);
        System.out.println();
        pozKup5List(list);
        System.out.println("pozKup5List(List) = " + pozKup5List(list));
        pozKup5List2(list);
        System.out.println("pozKareSon5DegilList(list) = " + pozKareSon5DegilList(list));
        System.out.println("elToplam(list) = " + elToplam(list));
        System.out.println(elToplamReference(list));
        System.out.println(elToplamReferenceInt(list));
        pozElToplam(list);

    }

    // S1:listi aralarinda bosluk birakarak yazdiriniz
    public static void hepsiniYazdir(List<Integer> l) {
        l.stream().forEach((t) -> System.out.print(t + " "));
    }

    //S2: sadece negatif olanlari yazdir
    public static void negativePrint(List<Integer> l) {
        l.stream().filter(t -> (t < 0)).forEach((t) -> System.out.print(t + " "));
    }

    //S3: cift olanlardan yeni bir liste olustur
    public static void ciftPrint(List<Integer> l) {
        l.stream().filter(t -> t % 2 == 0).forEach((t) -> System.out.print(t + " "));
    }

    //S3:Pozitif ve cift olanlari yazdir
    public static void pzCiftPrint(List<Integer> l) {
        l.stream().filter((t) -> t > 0 && t % 2 == 0).forEach((t) -> System.out.print(t + " "));
    }


    //S5:pozitif veya çift olanları yazdırın
    public static void pozVeyaCiftYaz(List<Integer> l) {


        l.stream().filter(t -> t % 2 == 0 || t > 0).forEach((t) -> System.out.print(t + " "));
    }
    //map():stream den gelen elemanları baska ttıplere donusturmek veya uzerlerınde
  //ıslem yapmak ıcın (update) kullanılır
    // S6: list in elemanlarin karelerini aynı satırda bır bosluklu yazdıralım
    public static void kareYazdir(List<Integer> l) {
        l.stream().map(t->t*t).forEach((t) -> System.out.print(t + " "));
    }
 //S7: Listin cift elemanlarının kuplerini  aynı satırda bır bosluklu yazdıralım
    public static void ciftKupPrint(List<Integer> l) {
        l.stream().filter(t -> t % 2 == 0).map(t->t*t*t).forEach((t) -> System.out.print(t + " "));
    }

    //S8 : list in elemanlarin karelerinden tekrarsiz yazdıralım
    public static void KareTekrarsiz(List<Integer> l) {
        l.stream().map(t->t*t).distinct().forEach((t) -> System.out.print(t + " "));
        //distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.
        // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
        // Sıralı akışlar için, farklı elemanın seçimi sabittir
        // (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
        // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.
    }
    //S9: listin elemanlarini kucukten buyuge siralayalim
    public static void kckBykSorted(List<Integer> l) {
        l.stream().sorted().forEach(t-> System.out.print(t+" "));
    }
//S10: listin elemanlarini buyukten kucuge siralayalim
public static void bykKckReverseSorted(List<Integer> l) {
    //sorted(Comparator.reverseOrder()) ==> Doğal sıralamanın tersini uygulayan bir karşılaştırıcı

    l.stream().sorted(Comparator.reverseOrder()).forEach((t) -> System.out.print(t + " "));
    }

    // S11: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    public static List<Integer> pozKup5List(List<Integer> l) {
        return l.stream().filter(t->t>0).map(t->t*t*t).filter(t->t%10==5).collect(Collectors.toList());//Olanlar icinden bazilarini sectik filtreledik, degistirmedigimiz icin filter methodunu kullandik.
    }
    public static void pozKup5List2(List<Integer> l) {
        List<Integer>List=l.stream().filter(t->t>0).map(t->t*t*t).filter(t->t%10==5).collect(Collectors.toList());
        //Olanlar icinden bazilarini sectik filtreledik, degistirmedigimiz icin filter methodunu kullandik.
        System.out.println(List);
    }

//S12: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
    public static List<Integer> pozKareSon5DegilList(List<Integer> l) {


      List<Integer>list = l.stream().filter((t) -> t >0).map(t->t*t).filter(t->t% 10 != 5).collect(Collectors.toList());
      return list;
    }
    // S13 :list elemanlarinin toplamini bulalim
    /*
        reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
        kullanımı yaygındır pratiktir.
        Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
        bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
        reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
        reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
        İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

*/

    public static int elToplam(List<Integer>l){
        int i = l.stream().reduce(0,(x,y)->x+y);
        return i;
    }

    public static int elToplamReference(List<Integer>l){
        int i = l.stream().reduce(0,Math::addExact);
        return i;
    }
    public static int elToplamReferenceInt(List<Integer>l){
        int i = l.stream().reduce(0,Integer::sum);
        return i;
    }
    //S.14:List'in pozitif elemanlarinin toplamini bulalim
    public static void pozElToplam(List<Integer>l){
        System.out.println(l.stream().filter(t -> t > 0).reduce(0, Integer::sum));
    }

}
/*
    System.out.println(myList.
                stream().filter(t ->  t > 0).collect(Collectors.toList()));
 */