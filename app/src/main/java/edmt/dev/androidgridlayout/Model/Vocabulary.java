package edmt.dev.androidgridlayout.Model;

import java.io.Serializable;
import java.util.Comparator;

public class Vocabulary implements Comparator<Vocabulary>, Serializable  {
    private String en;
    private String vn;
    private String srcImg;

    public Vocabulary(String en, String vn, String srcImg) {
        this.en = en;
        this.vn = vn;
        this.srcImg = srcImg;
    }

    @Override
    public String toString() {
        return "Vocabulary{" +
                "en='" + en + '\'' +
                ", vn='" + vn + '\'' +
                ", srcImg='" + srcImg + '\'' +
                '}';
    }

    public void setEn(String en) {
        this.en = en;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public String getEn() {
        return en;
    }

    public String getVn() {
        return vn;
    }

    @Override
    public int compare(Vocabulary vocabulary, Vocabulary t1) {
        return vocabulary.getEn().compareTo(t1.getEn());
    }
}