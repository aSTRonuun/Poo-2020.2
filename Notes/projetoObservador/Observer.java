import java.util.*;

interface ObservadorChegada{
    void adicionei(int value);
}

class Guardador{ //observavel
    private List<Integer> lista;
    private List<ObservadorChegada> observadores;
    public Guardador(){
        lista = new ArrayList<>();
        observadores = new ArrayList<>();
    }
    public void registrarObservador(ObservadorChegada obs){
        observadores.add(obs);
    }
    public void addValue(int value){
        lista.add(value);
        for(ObservadorChegada obs : observadores)
            obs.adicionei(value);
    }
    public List<Integer> getAll(){
        return lista;
    }
}

class GuardadorInvertido{
    private List<Integer> lista;
    public GuardadorInvertido(Guardador guardador){
        lista = new ArrayList<>();
        guardador.registrarObservador(new ObservadorChegada(){
            public void adicionei(int value) {                
                lista.add(-value);
            }
        });
    }
    List<Integer> getAll(){
        return lista;
    }
}


public class Observer{
    public static void main(String[] args) {
        Guardador guardador = new Guardador();
        GuardadorInvertido ginvert = new GuardadorInvertido(guardador);
        
        guardador.registrarObservador(new ObservadorChegada(){
            public void adicionei(int value) {
                System.out.println("Estou vendo tudo: " + value);
            }
        });

        guardador.registrarObservador(new ObservadorChegada(){
            public void adicionei(int value) {
                if(value > 1)
                    System.out.println("Estou vendo so os maiores de 5: " + value);
            }
        });

        guardador.registrarObservador((int x) -> {System.out.println("Dobro: " + 2 * x);});


        guardador.addValue(5);
        guardador.addValue(7);
        guardador.addValue(1);
        guardador.addValue(2);
        System.out.println(guardador.getAll());
        System.out.println(ginvert.getAll());
    }
}
