
package toto.alkalmazas;

public class Fordulo {
    
    private int ev;
    private int het;
    private String forduloaHeten;
    private String datum;
    private int _14nyeremeny;
    private String[] nyertesek;
    private int _13nyeremeny;
    private int _12nyeremeny;
    private int _11nyeremeny;
    private int _10nyeremeny;

      public Fordulo(int ev, int het, String forduloaHeten, String datum, int _14nyeremeny, String[] nyertesek, int _13nyeremeny, int _12nyeremeny, int _11nyeremeny, int _10nyeremeny) {
        this.ev = ev;
        this.het = het;
        this.forduloaHeten = forduloaHeten;
        this.datum = datum;
        this._14nyeremeny = _14nyeremeny;
        this.nyertesek = nyertesek;
        this._13nyeremeny=_13nyeremeny;
        this._12nyeremeny=_12nyeremeny;
        this._11nyeremeny=_11nyeremeny;
        this._10nyeremeny=_10nyeremeny;
    }

    public int get13nyeremeny() {
        return _13nyeremeny;
    }

    public int get12nyeremeny() {
        return _12nyeremeny;
    }

    public int get11nyeremeny() {
        return _11nyeremeny;
    }

    public int get10nyeremeny() {
        return _10nyeremeny;
    }

    public String[] getNyertesek() {
        return nyertesek;
    }

    public void setNyertesek(String[] nyertesek) {
        this.nyertesek = nyertesek;
    }

    public int get14nyeremeny() {
        return _14nyeremeny;
    }

    public void set14nyeremeny(int _14nyeremeny) {
        this._14nyeremeny = _14nyeremeny;
    }
      
    public int getEv() {
        return ev;
    }

    public void setEv(int ev) {
        this.ev = ev;
    }

    public int getHet() {
        return het;
    }

    public void setHet(int het) {
        this.het = het;
    }

    public String getForduloaHeten() {
        return forduloaHeten;
    }

    public void setForduloaHeten(String forduloaHeten) {
        this.forduloaHeten = forduloaHeten;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }  
    
    
//    @Override
//    public String toString() {
//        return String.format("%d - %d - %d - %d", 
//                this.ev, this.het, this.forduloaHeten, this.datum, this._14nyeremeny, 
//                this.nyertesek, this._13nyeremeny, this._12nyeremeny, this._11nyeremeny, this._10nyeremeny);
//    }    
    
}