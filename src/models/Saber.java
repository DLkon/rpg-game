package models;

public class Saber extends Personagem {
    public Saber(){

    }

    public Saber(String nome, String raca){
        super(nome, raca);
    }

    public int Atacar(){
        return 20;
    }

    public double Defender(){
        return 0.2;
    }
}
