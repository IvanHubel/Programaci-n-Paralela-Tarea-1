import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Primos {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Ingrese el valor máximo N para buscar números primos: ");
        Scanner leer = new Scanner(System.in);
        int valor = leer.nextInt();
        
        // Búsqueda secuencial
        PrimoSecuencial sec = new PrimoSecuencial(valor);
        sec.inicia();
        System.out.println("Números primos hasta " + valor + " (secuencial): " + sec.getPrimos());
        
        // Búsqueda paralela
        System.out.println("Ingrese la cantidad de hilos que desea utilizar: ");
        int hilos = leer.nextInt();
        
        PrimoParalelo paralelo[] = new PrimoParalelo[hilos];
        int rango = valor / hilos;
        
        // Crear y asignar rangos a cada hilo
        for(int k = 0; k < hilos; k++) {
            int inicio = k * rango;
            int fin = (k == hilos - 1) ? valor : (k + 1) * rango;
            String nombre = "Hilo " + (k + 1);
            paralelo[k] = new PrimoParalelo(inicio, fin, nombre);
        }
        
        // Iniciar los hilos
        for(int i = 0; i < hilos; i++) {
            paralelo[i].start();
        }
        
        // Esperar a que terminen todos los hilos y recolectar resultados
        List<Integer> todosPrimos = new ArrayList<>();
        for(int k = 0; k < hilos; k++) {
            paralelo[k].join();
            todosPrimos.addAll(paralelo[k].getPrimos());
        }
        
        System.out.println("Números primos hasta " + valor + " (paralelo): " + todosPrimos);
    }
}