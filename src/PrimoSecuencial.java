import java.util.ArrayList;
import java.util.List;

class PrimoSecuencial {
    private int _valor;
    private List<Integer> _primos;

    public PrimoSecuencial(int valor) {
        this._valor = valor;
        this._primos = new ArrayList<>();
    }

    public int getValor() {
        return _valor;
    }

    public List<Integer> getPrimos() {
        return _primos;
    }
    
    public void inicia() {
        for(int i = 0; i <= _valor; i++) {
            if(esPrimo(i)) {
                _primos.add(i);
            }
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
