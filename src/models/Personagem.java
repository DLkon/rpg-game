package models;

public class Personagem implements HabilidadeEspecial {
    private String nome;
    private String raca;
    private int hp;

    public Personagem(){

    }

    public Personagem(String nome, String raca){
        this.nome = nome; 
        this.raca = raca;
        this.hp = 100;
    }

    public int Atacar(){
        return 1;
    }

    public int Defender(){
        return 1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void usarHabilidadeEspecial() {
       
    }
    
    
    


}
