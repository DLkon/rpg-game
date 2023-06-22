package models;

public class Saber extends Personagem {
    public Saber(){

    }

    public Saber(String nome, String raca){
        super(nome, raca);
    }

    public int Atacar(){
        System.out.println("O espdachim usou sua lamina");
        return 20;
    }

    public int Defender(){
        return 3;
    }
}
