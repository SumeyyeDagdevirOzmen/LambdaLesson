public class Universite {
    //Pojo Class'in icinde field' lar olur.Hepsinin erisim belirleyicisi private olucak ve getter ve setterla olacak
    private String univercity;
    private String bolum;
    private int ogrenciSayisi;
    private int notOrt;

    //Parametresiz constructor
    public Universite() {
    }
    //Parametreli Constructor
    public Universite(String univercity, String bolum, int ogrenciSayisi, int notOrt) {
        this.univercity = univercity;
        this.bolum = bolum;
        this.ogrenciSayisi = ogrenciSayisi;
        this.notOrt = notOrt;
    }

    //Getter and Setter
    public String getUnivercity() {
        return univercity;
    }

    public void setUnivercity(String univercity) {
        this.univercity = univercity;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getOgrenciSayisi() {
        return ogrenciSayisi;
    }

    public void setOgrenciSayisi(int ogrenciSayisi) {
        this.ogrenciSayisi = ogrenciSayisi;
    }

    public int getNotOrt() {
        return notOrt;
    }

    public void setNotOrt(int notOrt) {
        this.notOrt = notOrt;
    }

    @Override
    public String toString() {
        return "Universite{" +
                "univercity='" + univercity + '\'' +
                ", bolum='" + bolum + '\'' +
                ", ogrenciSayisi=" + ogrenciSayisi +
                ", notOrt=" + notOrt +
                '}';
    }
}
