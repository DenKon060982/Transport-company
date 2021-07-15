package by.konovalchik.company.entity.logXML;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

public class Log  implements Serializable {
   private int id;
   private String text;

    public Log(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public Log() {
    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
