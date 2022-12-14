package lambda_practice;

public class Apartman {
    //Pojo class object olusturdugumuz Class'dir.En eski Java objesi.1.private2.constructorlar3.getter ve setter
    // 4.toString()methodu: Programin icine soutlamak istersem otomatik olarak ciksin diye
    private String cephe;
    private int katSayisi;
    private int kira;
    //1-parametresiz constructor
    public Apartman() {
    }
    //2-Bol parametreli constructor
    public Apartman(String cephe, int katSayisi, int kira) {
        this.cephe = cephe;
        this.katSayisi = katSayisi;
        this.kira = kira;
    }
    //3-Getter ve Setter


    public String getCephe() {
        return cephe;
    }

    public void setCephe(String cephe) {
        this.cephe = cephe;
    }

    public int getKatSayisi() {
        return katSayisi;
    }

    public void setKatSayisi(int katSayisi) {
        this.katSayisi = katSayisi;
    }

    public int getKira() {
        return kira;
    }

    public void setKira(int kira) {
        this.kira = kira;
    }
    //4-toString() Methodu

    @Override
    public String toString() {
        return "Apartman{" +
                "cephe='" + cephe + '\'' +
                ", katSayisi=" + katSayisi +
                ", kira=" + kira +
                '}';
    }
}
