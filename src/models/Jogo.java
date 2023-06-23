package models;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jogo {
    private Scanner scanner;
    private Personagem jogador;
    private ArrayList<Personagem> jogadores;

    public Jogo(){
        scanner = new Scanner(System.in);
        jogadores = new ArrayList<Personagem>();
    }

    public void iniciar(){
        exibirMenu();
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch(opcao){
            case 1: 
                criarPersonagem();   
                infoPersonagem();       
        } 


    }

      public void batalhar(){
            jogador = escolherPersonagem();

            //rodada jogador vs todos os oponentes
            for(Personagem adversario : jogadores){

                Random random = new Random();

                System.out.println("--------------------------------------------------");
                System.out.println("Seu personagem: " + jogador.getNome());
                System.out.println("Adversario: " + adversario.getNome());
                System.out.println("--------------------------------------------------");

                //rodada jogados vs oponente
               
                    while (jogador.getHp() > 0 && adversario.getHp() > 0) {   
                        System.out.println("Ações disponíveis:");
                        System.out.println("1. Atacar");
                        System.out.println("2. Defender");
                        System.out.println("3. Habilidade Especial");
                        System.out.print("Escolha a ação: ");

                        int acaoJogador = scanner.nextInt();
                        scanner.nextLine();

                        int acaoAdversario = random.nextInt(3) + 1;
                        

                        switch(acaoJogador) {
                              
                            case 1: 
                                int danoJogador = jogador.Atacar();
                                if(acaoAdversario == 2){
                                    //condição de jogador atacar e o oponente se defender
                                    danoJogador = danoJogador / adversario.Defender();
                                    System.out.println(" ");
                                    System.out.println("Adversario Defendeu");
                                    System.out.println(" ");
                                    adversario.setHp(adversario.getHp() - danoJogador);

                                } else if (acaoAdversario == 1) {
                                    //condição de ambos se atacarem
                                    int danoAdversario = adversario.Atacar();
                                    adversario.setHp(adversario.getHp() - danoJogador);
                                    jogador.setHp(jogador.getHp() - danoAdversario);
                                    System.out.println(" ");
                                }
                                break;
                            case 2:
                                if(acaoAdversario == 1) {
                                    //condição do jogador se defender e o adversario atacar
                                    int danoAdversario = adversario.Atacar();
                                    int defesa = jogador.Defender();
                                    System.out.println(" ");
                                    System.out.println(adversario.getNome() + " atacou ");
                                    System.out.println(jogador.getNome() + " defendeu o ataque");
                                    System.out.println(" ");
                                    jogador.setHp(jogador.getHp() - (danoAdversario / defesa));
                                    
                                } else if(acaoAdversario == 2) {
                                    System.out.println("Nada acontece, ambos se defenderam");
                                }
                                break;
                            case 3:
                                System.out.println(" ");
                                System.out.println("jogador usou habilidade especial");
                                jogador.usarHabilidadeEspecial();
                                break;
                            default: 
                                System.out.println(" ");
                                System.out.println("Opção invalida");  
                                break;                           

                        }

                        if(acaoAdversario == 3){
                            adversario.usarHabilidadeEspecial();
                        }



                        System.out.println("Status de vida");
                        System.out.println("Vida do jogador " + jogador.getHp());
                        System.out.println("Vida do oponenete " + adversario.getHp());
                        System.out.println(" ");

                    }


                    //verifica quem ganhou
                    if(jogador.getHp() > 0){
                        System.out.println("");
                        System.out.println("Voce venceu, indo para a prxima rodada ...");
                        jogador.setHp(100);
                    } else {
                        System.out.println("");
                        System.out.println("Voce perdeu ..." + adversario.getNome() + " te derrotou" );
                        System.out.println("Game Over");
                        break;
                    }
                    

                
            }

            System.out.println("VOCE GANHOU!!");
            

            

        }

    public void exibirMenu(){
        System.out.println("Bem vindo ao Arena RPG! Selecione uma opção!");
        System.out.println("1. Criar personagem!");
        System.out.println("2. Instruções sobre o jogo.");
        System.out.println("3. Sair do jogo");
    }

    public void criarPersonagem(){
    while(jogadores.size() < 3) {
        System.out.println("Criação do personagem:");
        System.out.println("Escolha o nome do seu personagem: ");
        String nome = scanner.nextLine();
        System.out.println("Escolha a raça do seu personagem");
        String raca = scanner.nextLine();
        System.out.println("Agora escolha a sua raça que voce ira batalhar");
        System.out.println("1. Saber");
        System.out.println("2. Arqueiro");
        int classe = scanner.nextInt();
        scanner.nextLine();

        switch(classe){
            case 1: 
                jogador = new Saber(nome, raca);
                jogadores.add(jogador);
                System.out.println("tamanho da lista de jogadores " + jogadores.size());
                break;
            case 2:
                 jogador = new Arqueiro(nome, raca);
                 jogadores.add(jogador);
  
                break;
            default:
                System.out.println("Classe não existente");
                criarPersonagem();
                break;   
        }

    }
       
   
    }

       public void infoPersonagem(){
        for(int i = 0; i < jogadores.size(); i++ ) {
            System.out.println("Nome: " + jogadores.get(i).getNome());
            System.out.println("Raça: " + jogadores.get(i).getRaca());
            System.out.println("Classe: " + jogadores.get(i).getClass().getSimpleName());
            System.out.println(" ");
        }
            opcoes();
        }
        
       
        public void editarPersonagem(){
   
            System.out.println("Qual personagem deseja editar?");
            for(int i = 0; i < jogadores.size(); i++ ){
                System.out.println( i + " " + jogadores.get(i).getNome());
            }
            int opcaoPersonagem = scanner.nextInt();
            scanner.nextLine();

            System.out.println("1. Trocar nome");
            System.out.println("2. Trocar raca");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao){
                case 1:
                    System.out.println("Digite o novo nome");
                    String novoNome = scanner.nextLine();
                    jogadores.get(opcaoPersonagem).setNome(novoNome);
                    infoPersonagem();
                    break;
                case 2:
                    System.out.println("Digite a nova raça");
                    String raca = scanner.nextLine();
                    jogadores.get(opcaoPersonagem).setRaca(raca);
                    infoPersonagem();
                    break;
                    
            }

        }


        public void opcoes(){
            System.out.println("1. Ir para a Arena");
            System.out.println("2. Editar personagem ");
            System.out.println("3. Deletar personagem");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {
                case 1: 
                    batalhar();
                    break;

                case 2:
                    editarPersonagem(); 
                    break;

                case 3: 
                    deletarPersonangem();
                    break;

                default:
                    System.out.println("Opção invalida");
                    opcoes();
                    break;
            }
        }

        public void deletarPersonangem(){
            System.out.println("Personagem deletado!");
            jogador = new Personagem(null, null);
        }

        public Personagem escolherPersonagem(){
            System.out.println("Bem vindo a Arena");
            System.out.println("Escolha o personagem que voce ira controlar!");
            for(int i  = 0; i < jogadores.size(); i++){
                System.out.println(i + ": " + jogadores.get(i).getNome());
            }
            
            int opcao  = scanner.nextInt();
            scanner.nextLine();

            
            Personagem jogadorEscolhido =  jogadores.get(opcao);
            //removendo jogador da lista
            jogadores.remove(opcao);
            return jogadorEscolhido;
            
            
        }
}
