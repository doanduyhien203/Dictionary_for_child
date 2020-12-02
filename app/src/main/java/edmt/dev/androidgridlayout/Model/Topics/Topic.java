package edmt.dev.androidgridlayout.Model.Topics;
import java.util.List;
import edmt.dev.androidgridlayout.Model.Vocabulary;

abstract public class Topic {
    public List<Vocabulary> listVocabularies;
    public String name;
    public String srcImg;
    public String srcFile;

    public Topic( String name, String srcImg, String srcFile) {

        this.name = name;
        this.srcImg = srcImg;
        this.srcFile = srcFile;
    }

    public void printList(){
        for(int i = 0; i < listVocabularies.size(); i++){
            System.out.println(listVocabularies.get(i).toString());
        }
    }
    public void voiceText(){

    }

    public List<Vocabulary> getListVocabularies() {
        return listVocabularies;
    }

    public String getName() {
        return name;
    }

    public String getSrcImg() {
        return srcImg;
    }

    public String getSrcFile() {
        return srcFile;
    }

    public void setListVocabularies(List<Vocabulary> listVocabularies) {
        this.listVocabularies = listVocabularies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSrcImg(String srcImg) {
        this.srcImg = srcImg;
    }

    public void setSrcFile(String srcFile) {
        this.srcFile = srcFile;
    }
}
