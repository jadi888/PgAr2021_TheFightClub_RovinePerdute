package RovinePerdute.unibs.it;
import java.*;
import java.util.*;

public class Citta {

    private int X;
    private int Y;
    private int H;
    private String Nome;
    private int ID;
    private LinkedHashMap<String, Integer> CollegamentoCon = new LinkedHashMap<>();

    public Citta(int x, int y, int h, String nome, int id){
        this.X = x;
        this.Y = y;
        this.H = h;
        this.Nome = nome;
        this.ID = id;
    }

    public void setX(int x){
        this.X = x;
    }

    public void setY(int y) {
        this.Y = y;
    }

    public void setH(int h) {
        this.H = h;
    }

    public void setNome(String nome) {
       this.Nome = nome;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCollegamentoCon(LinkedHashMap<String, Integer> collegamentoCon){
        this.CollegamentoCon = collegamentoCon;

    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getH() {
        return H;
    }

    public String getNome() {
        return Nome;
    }

    public int getID() {
        return ID;
    }

    public LinkedHashMap<String, Integer> getCollegamentoCon() {
        return CollegamentoCon;
    }

    @Override
    public String toString() {
        return "Citta{" + "X=" + X + ", Y=" + Y + ", H=" + H + ", Nome='" + Nome + '\'' + ", ID=" + ID +
                ", collegato con" + CollegamentoCon +
                '}';
    }


}
