import java.util.Comparator;

public class ComparadorCuentaSaldo implements Comparator<Cuenta> {
 @Override
 public int compare(Cuenta cuenta1, Cuenta cuenta2) {
 if (cuenta1.getSaldo() == cuenta2.getSaldo()) {
 String nombreCliente1 = cuenta1.getCliente().getNombre();
 String nombreCliente2 = cuenta2.getCliente().getNombre();
 return nombreCliente1.compareTo(nombreCliente2);
 }
 return cuenta1.getSaldo() - cuenta2.getSaldo();
 }
}