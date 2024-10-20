package pres;

import dao.ICalcul;
import metier.IGestion;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PresDynamique {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Scanner scanner=new Scanner(new File("config.txt"));
        String daoClassName=scanner.nextLine();
        Class cCalcul=Class.forName(daoClassName);
        ICalcul calcul=(ICalcul) cCalcul.getConstructor().newInstance();
        System.out.println(calcul.getValue());

        String metier=scanner.nextLine();
        Class cGestion=Class.forName(metier);
        IGestion gestion=(IGestion) cGestion.getConstructor().newInstance();
        Method m=cGestion.getMethod("setCal",ICalcul.class);
        m.invoke(gestion,calcul);
        System.out.println(gestion.calcul());
    }
}
