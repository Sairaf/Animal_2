/**
 *
 * @author Abner Farias - 12/11/2014
 * 
 * Aqui que a execução do programa ocorre. Recebendo os import das classes auxiliares e subclasses,
 * Esta classe possui um menu para poder realizar as ações desejadas(Adicionar animal, alimentá-lo, verificar se ele corre risco de extincao, etc.)
 * Ela possui dois métodos: "ShowMenu()" que mostra as opções que veresão ser tomadas, e o "cls()", que "emula" a função
 * system("cls") do c++.
 * 
 * No mais, a classe possui diversos atributos que auxiliarão na criação dos objetos, e a maior parte do programa é feito nas outras classes
 * 
 */
package Main;

import Comida.Comida;
import Comida.Racao;
import animal.Animal;
import animal.Animal_Domesticado;
import animal.Animal_Selvagem;
import Dono.Dono;
import animal.Cachorro;
//import static Main.Main.Menu.ShowMenu;
//import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
        

public class Main {
    
    public static final int MAXANIMAIS = 20;  
    
    public static final void Welcome(){
        System.out.println("Bem vindo ao sistema de Registro de animais");
    }
    
    public static void ShowMenu()
      {
          System.out.println("1 - Adicionar Animal Domesticado. ");   
          System.out.println("2 - Adicionar Animal Selvagem. ");   
          System.out.println("3 - Adicionar Dono. ");   
          System.out.println("4 - Verificar se animal esta doente. ");   
          System.out.println("5 - Alimentar Animal. ");   
          System.out.println("6 - Verificar quão velho o animal está. ");             
          System.out.println("7 - Verificar o Risco de extinção do animal");
          System.out.println("8 - Listar");
          System.out.println("0 - Sair.");   
          System.out.println("\n");
          System.out.println("Escolha uma opção:\n");
      }

   public static void cls(){       
      int i;
      for( i = 0;i < 20; i++){
          System.out.println("\n");  
      }
   }
   
    
    public static void main(String[] args) {
        Animal[] animais = new Animal[MAXANIMAIS];
        Animal_Domesticado auxD = new Animal_Domesticado();
        Animal_Selvagem auxS = new Animal_Selvagem();
        Dono dono = new Dono();
        Racao comida = new Racao();
        //ArrayList <Animal> animais= new ArrayList<> ();
        
        //====================================================================
        int cont = 0;
        
        String nome_Cientifico, classe, codigo_Animal, perigo_Extincao = "Desconhecido", nome_Popular, nome_Dono, qualidade_Tratamento = "Desc", apelido, nomeComida, raca;
        int idade , cont_Doenca = 0, num_Animais, num_Donos, qualidade_Dono, expectativa_Vida,populacao ;
        float peso,calorias;
        boolean lider = false, doente, qualidade_Comida = true;
        int opcao,meses;
        
        Scanner sc = new Scanner(System.in);        
        //====================================================================
        
        Welcome();
        ShowMenu();
        System.out.println("\n");
        
        opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opcao desejada: "));
        /*
        System.out.println("Digite a opcao desejada: ");
        opcao = Integer.parseInt(sc.nextLine());*/
        
        
         do{
         switch(opcao){
             case 1:
                 if(cont < MAXANIMAIS){
                  nome_Cientifico = JOptionPane.showInputDialog("Digite o nome cientifico do animal");
                  classe = JOptionPane.showInputDialog("Digite a classe do animal");
                  codigo_Animal = JOptionPane.showInputDialog("Digite o codigo do animal (Codigo deve conter exatamente 12 digitos)");
                  nome_Popular = JOptionPane.showInputDialog("Digite o nome popular do animal");
                  peso = Float.parseFloat(JOptionPane.showInputDialog("Digite o peso do animal"));
                  idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do animal"));
                  apelido = JOptionPane.showInputDialog("Digite o apelido do animal");
                  doente = false;     
                  if(nome_Popular.equalsIgnoreCase("Cachorro")){
                   raca= JOptionPane.showInputDialog("Digite a raca do cachorro");
                   animais[cont] = new Cachorro(apelido, nome_Cientifico, classe, codigo_Animal, idade, peso, nome_Popular, cont_Doenca, doente,raca);                      
                   auxD = (Cachorro) animais[cont];
                  }else{
                
                  animais[cont] = new Animal_Domesticado(apelido, nome_Cientifico, classe, codigo_Animal, idade, peso, nome_Popular, cont_Doenca, doente);
                  auxD = (Animal_Domesticado) animais[cont];
                  
                  }
                  System.out.println("Animal Domestico adicionado com sucesso!!!");               
                  animais[cont] = auxD;
                  cont++;      
              
                           
                 }else{
                     System.out.println("Limite de animais alcancado");                      
                 }
      
                 ShowMenu();
                 
                 opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opcao desejada: "));
                 break;
                  /*   
                  System.out.println("Digite o nome cientifico do animal:");
                  nome_Cientifico = sc.nextLine();
                  System.out.println("Digite a classe do animal:");
                  classe = sc.nextLine();
                  System.out.println("\nDigite o codigo do animal (Codigo deve conter 12 Digitos):");
                  codigo_Animal = sc.nextLine();
                  System.out.println("\nDigite o nome popular do animal:");
                  nome_Popular = sc.nextLine();
                  System.out.println("\nDigite o peso do animal:");
                  peso = Float.parseFloat(sc.nextLine());
                  System.out.println("\nDigite a idade do animal:");
                  idade= Integer.parseInt(sc.nextLine());
                  System.out.println("\nDigite o apelido do animal:");
                  apelido= sc.nextLine();
                   */                                  
             case 2:
                 if(cont < MAXANIMAIS){
                  System.out.println("\nDigite o nome cientifico do animal:");
                  nome_Cientifico = sc.nextLine();
                  System.out.println("\nDigite a classe do animal:");
                  classe = sc.nextLine();
                  System.out.println("\nDigite o codigo do animal(Codigo deve conter 12 Digitos):");
                  codigo_Animal = sc.nextLine();
                  System.out.println("\nDigite o nome popular do animal:");
                  nome_Popular = sc.nextLine();
                  System.out.println("\nDigite o peso do animal (Em kilos):");
                  peso = Float.parseFloat(sc.nextLine());
                  System.out.println("\nDigite a idade do animal (Em anos):");
                  idade= Integer.parseInt(sc.nextLine());
                  if(lider == false){
                   System.out.println("\nEste animal e o lider do grupo: (0-y/1-n): ");
                   opcao = Integer.parseInt(sc.nextLine());
                   if(opcao == 0){
                   lider = true;                        
                   }else{
                    lider = false;   
                   }
                  }
                  
                  doente = false;                        
                  animais[cont] = new Animal_Selvagem(lider, nome_Cientifico, classe, codigo_Animal, idade, perigo_Extincao, peso, nome_Popular, cont_Doenca, doente);
                  auxS = (Animal_Selvagem) animais[cont];
                  System.out.println("Animal Domestico adicionado com sucesso!!!");                                    
                  animais[cont] = auxS;
                  cont++;
                  
                 }else{
                     System.out.println("Limite de animais alcancado");                      
                 }
                 ShowMenu();
                 opcao = Integer.parseInt(sc.nextLine());
                 break;
                 
             case 3:
                 if(cont > 0){
                 opcao = cont+2;
                 while(opcao > cont-1){
                  System.out.println("Qual animal voce deseja adicionar dono? ");         
                  opcao = Integer.parseInt(sc.nextLine());;
                 }
                 
                  if(animais[opcao] instanceof Animal_Domesticado){
                   
                  System.out.println("\nDigite o nome do dono: ");
                  nome_Dono = sc.nextLine();
                  System.out.println("\nEste dono possui quantos Animais?: ");
                  num_Animais = Integer.parseInt(sc.nextLine());
                  System.out.println("\nDe 0 a 10, Digite a qualidade do Tratamento do dono com os seus animas: ");
                  qualidade_Dono = Integer.parseInt(sc.nextLine());
                  dono.setNomeDono(nome_Dono);;
                  dono.setNumeroAnimais(num_Animais);
                  dono.Verificar_Qualidade_Tratamento(qualidade_Dono);
                  auxD = (Animal_Domesticado) animais[opcao];
                  auxD.setDono(dono);
                  animais[opcao] = auxD;
                  
                  
                 }else{
                    System.out.println("Animais selvagens nao tem dono...Eu acho");   
                 }
               }else{
                     System.out.println("Nao existe animal suficientes para realizar esta operacao\n");   
                  }
                 
                 
                 ShowMenu();
                 opcao = Integer.parseInt(sc.nextLine());
                 break;
             case 4:
                 opcao = cont+2;
                 if(cont > 0){
                  while(opcao > cont-1){
                   System.out.println("Qual animal voce deseja Verificar se esta doente? ");         
                   opcao = Integer.parseInt(sc.nextLine());
                  }
                     int expec;
                     System.out.println("Digite a expectativa de vida do animal");
                     expec = Integer.parseInt(sc.nextLine());
                     animais[opcao].Verificar_Se_Esta_Doente(animais[opcao], expec);
                     
                 }else{
                     System.out.println("Nao existe animais registrado para realizar esta operacao");   
                  }                
                 System.out.println("\n");
                 ShowMenu();
                 opcao = Integer.parseInt(sc.nextLine());
                 break;
             case 5:
                 if(cont > 0){
                 opcao = cont+2;
                 while(opcao > cont-1){
                  System.out.println("Qual animal voce deseja alimentar? ");         
                  opcao = Integer.parseInt(sc.nextLine());
                 } 
                 System.out.println("\nDigite o nome da Comida: ");
                 nomeComida = sc.nextLine();
                 System.out.println("\nDigite quantas calorias a comida possui");
                 System.out.println("\n 8000 calorias = 1 kilo");
                 calorias = Float.parseFloat(sc.nextLine());
                 System.out.println("\nHa Quantos meses ela foi produzida");
                 meses = Integer.parseInt(sc.nextLine());;
                 
                 comida.setNomeComida(nomeComida);
                 comida.setCalorias(calorias);
                 comida.setMesesProducao(meses);
                 
                 animais[opcao].Comer(comida);
                 
                 System.out.println("\n");
                     
                 }else{
                     System.out.println("ao existem animais a ser adicionados");
                 }
                 ShowMenu();
                 opcao = Integer.parseInt(sc.nextLine());
                 break;
                 
             case 6:    
                 if(cont > 0){
                  opcao = cont+2;
                  while(opcao > cont-1){
                   System.out.println("Qual animal voce deseja alimentar? ");         
                   opcao = Integer.parseInt(sc.nextLine());
                  }
                  System.out.println("Digite a Expectativa de vida deste animal: ");
                  expectativa_Vida = Integer.parseInt(sc.nextLine());
                  animais[opcao].Velhice(expectativa_Vida);
                     
                 }else{
                      System.out.println("Nao existem animais a ser adicionados");
                 }
                     
                 
                 System.out.println("\n\n");
                 ShowMenu();
                 opcao = Integer.parseInt(sc.nextLine());
                 break;
             case 7:
                 if(cont > 0){
                  opcao = cont+2;
                  while(opcao > cont-1){
                   System.out.println("Qual animal voce deseja Verificar o risco de extinção? ");         
                   opcao = Integer.parseInt(sc.nextLine());
                  }
                  System.out.println("Digite a populacao deste animal");
                  populacao = Integer.parseInt(sc.nextLine());                                            
                  String aux;
                  aux = animais[opcao].Verificar_Perigo_Extincao(populacao);
                  animais[opcao].setPerigoExtincao(aux);
                 System.out.println("\n" +aux);
                 }else{
                    System.out.println("Nao existem animais a ser adicionados");  
                 }
                 
                 
                 System.out.println("\n\n");
                 ShowMenu();
                 opcao = Integer.parseInt(sc.nextLine());
                 break;
             case 8:
                 if(cont > 0){
                 for(opcao = 0; opcao <cont; opcao++){
                     if(animais[opcao] instanceof Animal_Domesticado){
                         System.out.println("\nE um animal domestico"); 
             
                     }else if(animais[opcao] instanceof Animal_Selvagem){
                         System.out.println("\nE um animal Selvagem");    
                     }
                    System.out.println(animais[opcao]);  
                  }    
                 }else{
                     System.out.println("Nenhum animal foi registrado");  
                 }
                                 
                 System.out.println("\n\n");
                 ShowMenu();
                 opcao = Integer.parseInt(sc.nextLine());
                 break;
             case 0:
                 System.exit(0);
             default:
                 System.out.println("Opcao invalida");
                 System.out.println("\n\n");
                 ShowMenu();
                 opcao = Integer.parseInt(sc.nextLine());
                 break;
         }            
        }while(opcao != 0);
       }
        
    }
 



