import java.util.ArrayList;
import java.util.List;

class PrimoParalelo extends Thread {
    private int _inicio;
    private int _fin;
    private List<Integer> _primos;
    private String _nombre;

    public PrimoParalelo(int inicio, int fin, String nombre) {
        this._inicio = inicio;
        this._fin = fin;
        this._nombre = nombre;
        this._primos = new ArrayList<>();
    }

    public int getInicio() {
        return _inicio;
    }

    public int getFin() {
        return _fin;
    }

    public List<Integer> getPrimos() {
        return _primos;
    }

    public String getNombre() {
        return _nombre;
    }
    
    @Override
    public void run() {
        try {
            System.out.println("Iniciando búsqueda en " + _nombre + " desde " + _inicio + " hasta " + _fin);
            
            for(int i = _inicio; i <= _fin; i++) {
                if(esPrimo(i)) {
                    _primos.add(i);
                }
            }
            
            System.out.println(_nombre + " encontró " + _primos.size() + " primos: " + _primos);
        } catch(Exception e) {
            System.out.println("Ocurrió un error en el hilo: " + _nombre);
        }
    }
    
    private boolean esPrimo(int numero) {
        if(numero <= 1) return false;
        if(numero == 2) return true;
        if(numero % 2 == 0) return false;
        
        for(int i = 3; i * i <= numero; i += 2) {
            if(numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}