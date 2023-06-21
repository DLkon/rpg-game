package models;

public class Arqueiro extends Personagem {

    public Arqueiro(String nome, String raca) {	
    super(nome, raca);
        
    }
        
    public int Atacar() {
        System.out.println("Arqueiro atirou uma flecha");
        return 13;
    }

    public double Defender() {
        double percent = 10/100;
        return percent;
    }

    

}
