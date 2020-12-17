class Pessoas{

    String nome;
    
    public Pessoas(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}


public class ArrayList {
    

    public static void main(String[] args) {
        
        ArrayList<Pessoas> pessoa = new ArrayList<>();

        pessoa.add(new Pessoas("Jose"));
        pessoa.add(new Pessoas("Maria"));
        pessoa.add(new Pessoas("Jose"));
        System.out.println(pessoa);
    }
}
