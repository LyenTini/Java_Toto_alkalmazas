
package toto.alkalmazas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class TotoAlkalmazas {
public static List<Fordulo> fordulokLista = new ArrayList<>();

    private static String Datumozas(int ev, int het)
    {
        int ho = het/7;
        if (ho==0) {
            ho=1;
        }
        int nap = het %7;
        return ev + "." + ho + "." + nap;
    }
    public static void Beolvas(){
        try{
            
            FileReader fr = new FileReader("toto.csv");
            BufferedReader br = new BufferedReader(fr);
            String sor;
            String[] daraboltSor;
            
            int _14ny=0;
            int _13ny=0;
            int _12ny=0;
            int _11ny=0;
            int _10ny=0;
            
            while ((sor = br.readLine()) != null) 
            {
                daraboltSor = sor.split(";");
                int ev = Integer.parseInt(daraboltSor[0]);
                int het = Integer.parseInt(daraboltSor[1]);
                String forduloaHeten = daraboltSor[2];
                if (forduloaHeten.equals("")) {
                    forduloaHeten="1";
                }
                String datum = daraboltSor[3];
                if (datum.equals("")) {
                    datum = Datumozas(ev,het);
                }
                String _14nyeremeny = daraboltSor[5];
                if (_14nyeremeny.contains(" Ft")) {
                    _14ny = Integer.parseInt(_14nyeremeny.replace(" Ft","").replace(" ",""));
                }
                String _13nyeremeny = daraboltSor[7];
                if (_13nyeremeny.contains(" Ft")) {
                    _13ny = Integer.parseInt(_13nyeremeny.replace(" Ft","").replace(" ",""));
                }
                String _12nyeremeny = daraboltSor[9];
                if (_12nyeremeny.contains(" Ft")) {
                    _12ny = Integer.parseInt(_12nyeremeny.replace(" Ft","").replace(" ",""));
                }
                String _11nyeremeny = daraboltSor[11];
                if (_11nyeremeny.contains(" Ft")) {
                    _11ny = Integer.parseInt(_11nyeremeny.replace(" Ft","").replace(" ",""));
                }
                String _10nyeremeny = daraboltSor[13];
                if (_10nyeremeny.contains(" Ft")) {
                    _10ny = Integer.parseInt(_10nyeremeny.replace(" Ft","").replace(" ",""));
                }
                
                
                
                String[] nyertesek = {daraboltSor[14], daraboltSor[15], daraboltSor[16], daraboltSor[17],
                daraboltSor[18], daraboltSor[19], daraboltSor[20], daraboltSor[21], daraboltSor[22],
                daraboltSor[23], daraboltSor[24], daraboltSor[25], daraboltSor[26], daraboltSor[27]};
                
                fordulokLista.add(new Fordulo(ev, het, forduloaHeten, datum,_14ny, nyertesek, _13ny, _12ny,_11ny, _10ny));
                
            }
        fr.close();
      
        } 
        catch (Exception e) {
            System.err.printf("Hiba történt %s", e);
        }
    }
    
    public static void LegnagyobbNyeremeny()
    {
        List<Integer> legnagyobb = new ArrayList<Integer>();
        int max = 0;
        for (int i = 0; i <fordulokLista.size(); i++) {
            if (fordulokLista.get(i).get14nyeremeny()> max) {
                max = fordulokLista.get(i).get14nyeremeny();
            }
        }
        System.out.printf("A legnagyobb nyeremény, amit rögzítettek: %s Ft", max);
    }
    
    public static void Statisztika()
    {
        double hazai=0;
        double vendeg=0;
        double dontetlen=0;
        String[] seged;
        for (int i = 0; i <fordulokLista.size(); i++) {
             seged = fordulokLista.get(i).getNyertesek();
             for (int j = 0; j < seged.length; j++) {
                 if (seged[j].equals("1")) {
                     hazai++;
                 }
                 else if (seged[j].equals("2")) {
                     vendeg++;
                 }
                 if (seged[j].equals("X")) {
                     dontetlen++;
                 }
            }
        }
        
        double osszes = hazai+vendeg+dontetlen;
        
        double hazaiSz = Math.round(((hazai/osszes)*100)*100);
        double vendegSz = (Math.round((vendeg/osszes)*100)*100) ;
        double dontetlenSz = Math.round(((dontetlen/osszes)*100)*100);    
        
        
        System.out.println("Statisztika: #1 csapat nyert: " + hazaiSz/100 + " %, #2 csapat nyert: " + vendegSz/100 + " %, döntetlen: " + dontetlenSz/100 + " %");

    } 
    
    public static void Bekeres()
    {
        try
        {
        Scanner sc = new Scanner(System.in);
        String datum;
        String tippeles;
        String[] nyertesek = null;
        System.out.println("Kérem adjon meg egy dátumot! Pl: 2019.07.15.");
        datum = sc.nextLine();
        System.out.println("Kérem adjon meg egy tippet!");
        
        tippeles = sc.nextLine().toUpperCase();
        String[] tippek = tippeles.split("");
        
        int index=0;
        for (int i = 0; i < fordulokLista.size(); i++) {
            if (fordulokLista.get(i).getDatum().equals(datum)) {
               nyertesek = fordulokLista.get(i).getNyertesek();
               index=i;
            }
        }
        int siker=0;
        for (int i = 0; i < nyertesek.length; i++) {
            if (nyertesek[i].equals(tippek[i])) {
                siker++;
            }
        }
        switch(siker){
            case 10: System.out.println("Eredmény: találat:" + siker + ", nyeremény: " + fordulokLista.get(index).get10nyeremeny() + " Ft"); break;
            case 11: System.out.println("Eredmény: találat:" + siker + ", nyeremény: " + fordulokLista.get(index).get11nyeremeny() + " Ft"); break;
            case 12: System.out.println("Eredmény: találat:" + siker + ", nyeremény: " + fordulokLista.get(index).get12nyeremeny() + " Ft"); break;
            case 13: System.out.println("Eredmény: találat:" + siker + ", nyeremény: " + fordulokLista.get(index).get13nyeremeny() + " Ft"); break;
            case 14: System.out.println("Eredmény: találat:" + siker + ", nyeremény: " + fordulokLista.get(index).get14nyeremeny() + " Ft"); break;
            default: System.out.println("Nem nyertél! Tálaltatok száma: " + siker); break;        
        }
        }
        catch(Exception e){
                System.out.println("Érvényes dátum, vagy megfelelő mennyiségű tipp szükséges!");
        }
    }        
    public static void main(String[] args) {
        
        Beolvas();
        LegnagyobbNyeremeny();
        System.out.println("");
        Statisztika();
        System.out.println("");
        Bekeres();
        
    }
}
