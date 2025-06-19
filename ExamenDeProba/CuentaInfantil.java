public class CuentaInfantil extends Cuenta{
 private String tutor;
 private static int edadMaxima = 17;
 public CuentaInfantil(Cliente cliente, int num, String tutor) {
 super(cliente.getNombre(), cliente.getTel(), num);
 this.tutor = tutor;
 }
 @Override
 public String toString(){
 return "Cuenta: " + this.getNum() + " Cliente: " + this.getCliente() + " Saldo:" + this.getSaldo() + " Tutor: " + tutor;
 }
 public static int getEdadMaxima() {
 return edadMaxima;
 }
 public static void setEdadMaxima(int edadMaxima) {
 CuentaInfantil.edadMaxima = edadMaxima;
 }
 public String getTutor() {
 return tutor;
 }
}