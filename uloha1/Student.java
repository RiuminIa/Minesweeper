package uloha1;
import java.util.*;
public class Student {
    private int id;
    private String meno;
    private String preizvisko;
    private int vek;

    public Student(String meno){
        this.meno=meno;
    }
    public Student(int id, String meno, String preizvisko, int vek) {
        this.id = id;
        this.meno = meno;
        this.preizvisko = preizvisko;
        this.vek = vek;
    }
    public int compareByName(Object obj)
    {
        Student tmp = (Student)obj;
        return this.meno.compareTo(tmp.meno);
    }
    public int compareByAge(Object obj)
    {
        Student tmp = (Student)obj;
        if (this.vek>tmp.vek )
                return 1;
        else if (this.vek<tmp.vek)
                return -1;
        else return 0;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPreizvisko() {
        return preizvisko;
    }

    public void setPreizvisko(String preizvisko) {
        this.preizvisko = preizvisko;
    }

    public int getVek() {
        return vek;
    }

    public void setVek(int vek) {
        this.vek = vek;
    }
}
