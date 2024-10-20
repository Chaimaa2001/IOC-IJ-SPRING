package pres;

import dao.CalculV1;
import metier.Gestion;

public class presStatique {
    public static void main(String[] args) {
        //injection des dependences par instenciation statique
        Gestion gestion =new Gestion();
        CalculV1 cal=new CalculV1();
        gestion.setCal(cal);
        System.out.println(gestion.calcul());
    }
}
