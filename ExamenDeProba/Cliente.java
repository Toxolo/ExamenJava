public class Cliente {
 private String nombre;
 private int tel;
 public Cliente(String nombre, int tel) {
 this.nombre = nombre;
 this.tel = tel;
 }
 @Override
 public String toString() {
 return nombre + " (" + tel + ")";
 }
 public String getNombre() {
 return nombre;
 }
 public int getTel() {
 return tel;
 }
}