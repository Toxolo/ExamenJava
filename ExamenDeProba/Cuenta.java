import java.util.Objects;
public class Cuenta implements Comparable<Cuenta>{
 private int num;
 private Cliente cliente;
 private int saldo;
 public Cuenta(String nombreCliente, int tel, int num) {
 this.cliente = new Cliente(nombreCliente, tel);
 this.num = num;
 }
 @Override
 public String toString(){
 return "Cuenta: " + num + " Cliente: " + cliente + " Saldo: " + saldo;
 }
 @Override
 public boolean equals(Object o) {
 if (!(o instanceof Cuenta cuenta)) return false;
 return this.cliente.getNombre().equals(cuenta.cliente.getNombre()) | this.num ==
cuenta.num;
 }
 @Override
 public int compareTo(Cuenta cuenta) {
 return this.num - cuenta.num;
 }
 public void transferir(Cuenta destino, int importe) {
 if (!this.equals(destino)) {
 if (importe < this.saldo) {
 this.saldo -= importe;
 destino.saldo += importe;
 System.out.println("Transferencia realizada");
 } else {
 System.out.println("Error: Saldo insuficiente");
 }
 } else {
 System.out.println("Error: Cuentas iguales");
 }
 }
 public int getNum() {
 return num;
 }
 public Cliente getCliente() {
 return cliente;
 }
 public int getSaldo() {
 return saldo;
 }
 public void setSaldo(int saldo) {
 this.saldo = saldo;
 }
}