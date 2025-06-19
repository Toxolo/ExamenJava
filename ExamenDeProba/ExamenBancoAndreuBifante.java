import java.util.ArrayList;
import java.util.Collections;


public class ExamenBancoAndreuBifante {

    public static void muestraCuentas(ArrayList<Cuenta> cuentas) {
        System.out.println("\nCUENTAS");
        System.out.println("---------------------");
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getClass() == CuentaInfantil.class) {
            System.out.println("INFANTIL " + cuenta);
            } else {
            System.out.println(cuenta);
            }
        }
        System.out.println("\nEdad Max Infantil: " + CuentaInfantil.getEdadMaxima() +
        "\n");
    }



    public static void yaNoEsInfantil(ArrayList<Cuenta> listaCuentas, String nombre) {
        Cuenta cuentaBuscar = new CuentaInfantil(new Cliente(nombre, -1), -1, "-1");
        int indexEncontrado = listaCuentas.indexOf(cuentaBuscar);
        if (indexEncontrado == -1) { // Si no lo encuentra en la lista
        System.out.println("Error: Esa cuenta no esta en la lista");
        } else { // Si lo encuentra en la lista
        Cuenta cuentaEncontrada = listaCuentas.get(indexEncontrado);
        if (cuentaEncontrada.getClass() == CuentaInfantil.class) { // Comprueba que sea infantil
        Cuenta cuentaAdulta = new Cuenta(nombre,
        cuentaEncontrada.getCliente().getTel(), cuentaEncontrada.getNum());
        cuentaAdulta.setSaldo(cuentaEncontrada.getSaldo());
        // Los sustituimos
        listaCuentas.remove(cuentaEncontrada);
        listaCuentas.add(cuentaAdulta);
        System.out.println(cuentaAdulta.getCliente().getNombre() + " ha pasado a ser adulto/a!");
        } else { // Si la cuento no es infantil
        System.out.println("Error: Esa cuenta no es infantil!");
        }
        }
    }


    public static void main(String[] args) {
        // Ejercicio A
        Cuenta cuenta1 = new Cuenta("Andreu", 637842134, 1);
        cuenta1.setSaldo(1000);
        Cuenta cuenta2 = new CuentaInfantil(new Cliente("Alan", 63345134), 2, "Andreu");
        cuenta2.setSaldo(2000);
        Cuenta cuenta3 = new Cuenta("Guillem", 631231134, 3);
        cuenta3.setSaldo(1500);
        ArrayList<Cuenta> listaCuentas = new ArrayList<>();
        listaCuentas.add(cuenta1);
        listaCuentas.add(cuenta3);
        listaCuentas.add(cuenta2);
        // Ejercicio B
        System.out.println("\n--- EJERCICIO B ---");
        Cuenta cuentaBuscar = new Cuenta("-1", -1, 222);
        int indexEncontrado = listaCuentas.indexOf(cuentaBuscar);
        if (indexEncontrado == -1) {
        System.out.println("Error: Esa cuenta no esta en la lista");
        } else {
        Cuenta cuentaEncontrada = listaCuentas.get(indexEncontrado);
        System.out.println(cuentaEncontrada);
        }
        // Ejercicio C
        System.out.println("\n--- EJERCICIO C---");
        cuentaBuscar = new Cuenta("Pep Garcia", -1, 222);
        indexEncontrado = listaCuentas.indexOf(cuentaBuscar);
        if (indexEncontrado == -1) {
        System.out.println("Error: Esa cuenta no esta en la lista");
        } else {
        Cuenta cuentaEncontrada = listaCuentas.remove(indexEncontrado);
        System.out.println("Cuenta eliminada correctamente");
        }
        // Ejercicio D
        System.out.println("\n--- EJERCICIO D ---");
        Cuenta cuentaEliminar = new Cuenta("Hacker", 999, 666);
        cuentaEliminar.setSaldo(-666);
        listaCuentas.add(cuentaEliminar);
        muestraCuentas(listaCuentas);
        for (int i = 0; i < listaCuentas.size(); i++) {
        if (listaCuentas.get(i).getSaldo() < 0) {
        listaCuentas.remove(i);
        System.out.println("Cuenta corrupta eliminada");
        i--; //Preguntar Andreu
        }
        }
        muestraCuentas(listaCuentas);
        // Ejercicio E
        System.out.println("\n--- EJERCICIO E ---");
        cuenta1.transferir(cuenta1, 100); // Dará error ya que es la misma cuenta
        muestraCuentas(listaCuentas);
        cuenta1.transferir(cuenta2, 100);
        cuenta2.transferir(cuenta3, (cuenta1.getSaldo()/2));
        muestraCuentas(listaCuentas);
        // Ejercicio F
        System.out.println("\n--- EJERCICIO F ---");
        Collections.sort(listaCuentas);
        muestraCuentas(listaCuentas);
        // Ejercicio G
        System.out.println("\n--- EJERCICIO G ---");
        Collections.sort(listaCuentas, new ComparadorCuentaSaldo());
        muestraCuentas(listaCuentas);
        cuenta3.transferir(cuenta1, 525);
        Collections.sort(listaCuentas, new ComparadorCuentaSaldo());
        muestraCuentas(listaCuentas);
        // Ejercicio H
        System.out.println("\n--- EJERCICIO H ---");
        yaNoEsInfantil(listaCuentas, "Andreu");
        yaNoEsInfantil(listaCuentas, "Alan");
        yaNoEsInfantil(listaCuentas, "Pepe");
        muestraCuentas(listaCuentas);
    }
}