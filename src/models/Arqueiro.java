package models;

public class Arqueiro extends Personagem  {
    private int dano;
    
 

    public Arqueiro(String nome, String raca) {	
        super(nome, raca);
        this.dano  = 12;
    }
        
    public int Atacar() {
        System.out.println("Arqueiro atirou uma flecha");
        return dano;
    }

    
   
    public int Defender() {
        return 2;
    }

   
    public void  usarHabilidadeEspecial() {
        System.out.println("");
        System.out.println("Arqueiro agora consegue atirar 3 flechas");
        setDano(getDano() * 3);

    }

       public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    

}
