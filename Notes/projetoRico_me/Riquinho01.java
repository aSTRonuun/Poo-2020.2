enum Moeda{
    M10(0.10f, 1),
    M25(0.25f, 2),
    M50(0.50f, 3),
    M100(1f, 4);

    float valor;
    int volume;

    Moeda(float valor, int volume){
        this.valor = valor;
        this.volume = volume;
    }

    public String toString() {
        return "Valor: " + valor + "\nVolume: " + valor + "\n";
    }

}

class Item{
    String descricao;
    int volume;

    Item(String descricao, int volume){
        this.descricao = descricao;
        this.volume = volume;
    }

    public String toString() {
        return "Descricao:" + descricao + "\nVolume: " + volume + "\n";
    }
    
}

class Porco{
    String itens = "";
    float valor = 0.0f;
    int volume = 0;
    int volumeMax;
    boolean estaQuebrado = false;

    Porco(int volumeMax){
        this.volumeMax = volumeMax;
    }

    boolean adicionarDinheiro(Moeda moeda){
        if(estaQuebrado){
            System.out.println("O porco esta quebrado");
            return false;
        }
        if(moeda.volume + this.volume > this.volumeMax){
            System.out.println("Porco esta lotado");
            return false;
        }
        this.valor += moeda.valor;
        this.volume += moeda.volume;
        return true;
    }

    boolean adicionarItem(Item item){
        if(estaQuebrado){
            System.out.println("O porco esta quebrado");
            return false;
        }if(item.volume + this.volume > this.volumeMax){
            System.out.println("Porco esta lotado");
            return false;
        }
        this.volume += item.volume;
        if(this.itens.equals(""))
            this.itens = item.descricao;
        else 
            this.itens += ", " + item.descricao;
        return true;
    }


    boolean quebrar(){
        if(estaQuebrado){
            System.out.println("O porco esta quebrado");
            return false;
        }
        estaQuebrado = true;
        return true;
    }

    float pegarDinheiro(){
        if(!estaQuebrado){
            System.out.println("Você deve quebrar o porco primeiro");
            return 0.0f;
        }
        float aux = this.valor;
        this.valor = 0;
        return aux;
    }

    String pegarItem(){
        if(!estaQuebrado){
            System.out.println("Você deve quebrar o porco primeiro");
            return "";
        }
        String aux = this.itens;
        this.itens = "";
        return aux;
    }

    public String toString(){
        return itens + ":" + valor + ":" + volume + "/" + volumeMax + ":" + estaQuebrado;
    }


}

public class Riquinho01 {
    
    public static void main(String[] args) {
        Porco porco = new Porco(40);
        System.out.println(porco);
        porco.adicionarDinheiro(Moeda.M100);
        porco.adicionarDinheiro(Moeda.M100);
        System.out.println(porco);
        porco.adicionarItem(new Item("cordao de ouro", 10));
        System.out.println(porco);
        porco.adicionarItem(new Item("pigente kunai", 5));
        System.out.println(porco);
    }
}
