/**
 *
 * @author Abner Farias - 12/11/2014
 * 
 * Aqui que a execução do programa ocorre. Recebendo os import das classes auxiliares e subclasses,
 * Esta classe possui um menu para poder realizar as ações desejadas(Adicionar animal, alimentá-lo, verificar se ele corre risco de extincao, etc.)
 * Ela possui dois métodos: "ShowMenu()" que mostra as opções que veresão ser tomadas, e o "cls()", que "emula" a função
 * system("cls") do c++.
 * 
 * Opções disponíveis pelo switch-case:
 * 
 * Adicionar Animal Domesticado.            - Adicional um animal ao vetor de animais. Caso o nome popular deste animal seja "cachorro", um objeto da classe cachorro será adicionado
 * Adicionar Animal Selvagem.               - Cria um animal da classe Animal_Selvagem e o adiciona ao vetor
 * Adicionar Dono.                          - Caso o animal seja domesticável, um dono pode ser adicionado a ele
 * Verificar se animal esta doente.         - Diz se o animal escolhido está doente ou não
 * Alimentar Animal.                        - Alimenta o animal, podendo aumentar o peso deste
 * Verificar quão velho o animal está.      - Indica em qual faixa etária o animal está
 * Verificar o risco de extinção do animal  - Retorna quão ameaçada o animal está
 * Listar                                   - Escreve todos os animais do vetor
 * Adicionar_Brinquedo                      - Adicionar um brinquedo, que o animal pode brincar ou não
 * Brincar com o animal                     - Se o animal for um cachorro, ele brinca com o brinquedo
 * Sair.                                    - Sai do prograga
 * 
 * No mais, a classe possui diversos atributos que auxiliarão na criação dos objetos, e a maior parte do programa é feito nas outras classes
 * 
 */
package Main;

import Brinquedo.Bola_Brinquedo;
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
        
    }
    
    public static final void ShowMenu()
      {
          JOptionPane.showMessageDialog(null, "Bem vindo ao sistema de Registro de animais\n1 - Adicionar Animal Domesticado.\n2 - Adicionar Animal Selvagem.\n3 - Adicionar Dono.\n4 - Verificar se animal esta doente.\n5 - Alimentar Animal.\n6 - Verificar quão velho o animal está.\n 7 - Verificar o Risco de extinção do animal\n8 - Listar\n9- Adicionar_Brinquedo \n10 - Brincar com o animal\n0 - Sair.\nEscolha uma opcao  ");          
         /* System.out.println("1 - Adicionar Animal Domesticado. ");   
          System.out.println("2 - Adicionar Animal Selvagem. ");   
          System.out.println("3 - Adicionar Dono. ");   
          System.out.println("4 - Verificar se animal esta doente. ");   
          System.out.println("5 - Alimentar Animal. ");   
          System.out.println("6 - Verificar quão velho o animal está. ");             
          System.out.println("7 - Verificar o Risco de extinção do animal");
          System.out.println("8 - Listar");
          System.out.println("0 - Sair.");   
          System.out.println("\n");
          System.out.println("Escolha uma opção:\n");*/
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
        Bola_Brinquedo bola = new Bola_Brinquedo();
        Dono dono = new Dono();
        Racao comida = new Racao();
        //ArrayList <Animal> animais= new ArrayList<> ();
        
        //====================================================================
        int cont = 0, flag = 0;        
        String nome_Cientifico, classe, codigo_Animal, perigo_Extincao = "Desconhecido", nome_Popular, nome_Dono, qualidade_Tratamento = "Desc", apelido, nomeComida, raca, marca, estado_Conservacao, material_Feito, cor;
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
                  JOptionPane.showMessageDialog(null, "Animal Domestico adicionado com sucesso!!!");               
                  animais[cont] = auxD;
                  cont++;      
              
                           
                 }else{
                     JOptionPane.showMessageDialog(null, "Limite de animais alcancado");                      
                 }
      
                 ShowMenu();
                 
                 opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opcao desejada: "));
                 break;
                         
             case 2:
                 if(cont < MAXANIMAIS){
                  nome_Cientifico = JOptionPane.showInputDialog("Digite o nome cientifico do animal");
                  classe = JOptionPane.showInputDialog("Digite a classe do animal");
                  codigo_Animal = JOptionPane.showInputDialog("Digite o codigo do animal (Codigo deve conter exatamente 12 digitos)");
                  nome_Popular = JOptionPane.showInputDialog("Digite o nome popular do animal");
                  peso = Float.parseFloat(JOptionPane.showInputDialog("Digite o peso do animal"));
                  idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do animal"));
                  if(lider == false){
                   opcao = Integer.parseInt(JOptionPane.showInputDialog("\nEste animal e o lider do grupo: (0-y/1-n): "));
                   if(opcao == 0){
                   lider = true;                        
                   }else{
                    lider = false;   
                   }
                  }
                  doente = false;                        
                  animais[cont] = new Animal_Selvagem(lider, nome_Cientifico, classe, codigo_Animal, idade, perigo_Extincao, peso, nome_Popular, cont_Doenca, doente);
                  auxS = (Animal_Selvagem) animais[cont];
                  JOptionPane.showMessageDialog(null, "Animal Domestico adicionado com sucesso!!!");                                    
                  animais[cont] = auxS;
                  cont++;
                  
                 }else{
                     JOptionPane.showMessageDialog(null, "Limite de animais alcancado");                      
                 }
                 ShowMenu();
                 
                 opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opcao desejada: "));
                 break;
                 
             case 3:
                 if(cont > 0){
                 opcao = cont+2;
                 while(opcao > cont-1){
                  opcao = Integer.parseInt(JOptionPane.showInputDialog("Qual animal voce deseja adicionar dono? "));                           
                 }
                 
                  if(animais[opcao] instanceof Animal_Domesticado){
                   
                  nome_Dono = JOptionPane.showInputDialog("\nDigite o nome do dono: ");
                  num_Animais = Integer.parseInt(JOptionPane.showInputDialog("\nEste dono possui quantos Animais?: ")); 
                  qualidade_Dono =  Integer.parseInt(JOptionPane.showInputDialog("\nDe 0 a 10, Digite a qualidade do Tratamento do dono com os seus animas: "));
                  dono.setNomeDono(nome_Dono);;
                  dono.setNumeroAnimais(num_Animais);
                  dono.Verificar_Qualidade_Tratamento(qualidade_Dono);
                  auxD = (Animal_Domesticado) animais[opcao];
                  auxD.setDono(dono);
                  animais[opcao] = auxD;
                  
                  
                 }else{
                    JOptionPane.showMessageDialog(null, "Animais selvagens nao tem dono...Eu acho");   
                 }
               }else{
                    JOptionPane.showMessageDialog(null, "Nao existe animal suficientes para realizar esta operacao\n");   
                  }
                 
                 
                 ShowMenu();
                 opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opcao desejada: "));
                 break;
				 
             case 4:
                 opcao = cont+2;
                 if(cont > 0){
                  while(opcao > cont-1){     
                   opcao = Integer.parseInt(JOptionPane.showInputDialog("Qual animal voce deseja Verificar se esta doente?"));
                  }
                     int expec;
                     expec = Integer.parseInt(JOptionPane.showInputDialog("Digite a expectativa de vida do animal"));
                     animais[opcao].Verificar_Se_Esta_Doente(animais[opcao], expec);
                     
                 }else{
                     JOptionPane.showMessageDialog(null,"Nao existe animais registrado para realizar esta operacao");   
                  }                
                // System.out.println("\n");
                 ShowMenu();
                 opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opcao desejada: "));
                 break;
             case 5:
                 if(cont > 0){
                 opcao = cont+2;
                 while(opcao > cont-1){
                  opcao = Integer.parseInt(JOptionPane.showInputDialog("Qual animal voce deseja alimentar? "));
                 } 
                 nomeComida = JOptionPane.showInputDialog("\nDigite o nome da Comida: ");                 
                 calorias = Float.parseFloat( JOptionPane.showInputDialog("Digite o nome da Comida: \n(Digite quantas calorias a comida possui)"));
                 meses = Integer.parseInt(JOptionPane.showInputDialog("\nHa Quantos meses ela foi produzida"));                                  
                 comida.setNomeComida(nomeComida);
                 comida.setCalorias(calorias);
                 comida.setMesesProducao(meses);
                 
                 animais[opcao].Comer(comida);

                 }else{
                     JOptionPane.showMessageDialog(null, "Nao existem animais a ser adicionados");
                 }
                 ShowMenu();
                 opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opcao desejada: "));
                 break;
                 
             case 6:    
                 if(cont > 0){
                  opcao = cont+2;
                  while(opcao > cont-1){                   
                   opcao = Integer.parseInt(JOptionPane.showInputDialog("Qual animal voce deseja alimentar? "));
                  }
                  expectativa_Vida = Integer.parseInt(JOptionPane.showInputDialog(("Digite a Expectativa de vida deste animal: ")));                  
                  animais[opcao].Velhice(expectativa_Vida);
                     
                 }else{
                      JOptionPane.showMessageDialog(null,"Nao existem animais a ser adicionados");
                 }
                     
                                 
                 ShowMenu();
                 opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opcao desejada: "));
                 break;
             case 7:
                 if(cont > 0){
                  opcao = cont+2;
                  while(opcao > cont-1){
                   opcao = Integer.parseInt(JOptionPane.showInputDialog(("Qual animal voce deseja Verificar o risco de extinção? ")));                   
                  }
                  populacao = Integer.parseInt(JOptionPane.showInputDialog("Digite a populacao deste animal"));
                  String aux;
                  aux = animais[opcao].Verificar_Perigo_Extincao(populacao);
                  animais[opcao].setPerigoExtincao(aux);
                  JOptionPane.showMessageDialog(null, "\n" +aux); 
                 }else{
                    JOptionPane.showMessageDialog(null,"Nao existem animais a ser adicionados");  
                 }
                 
                                  
                 ShowMenu();
                 opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opcao desejada: "));
                 break;
             case 8:
                 if(cont > 0){
                 for(opcao = 0; opcao <cont; opcao++){
                     if(animais[opcao] instanceof Animal_Domesticado){
                         JOptionPane.showMessageDialog(null, "\nAnimal domestico\n" + animais[opcao] ); 
             
                     }else if(animais[opcao] instanceof Animal_Selvagem){
                            JOptionPane.showMessageDialog(null, "\nAnimal selvagem\n" + animais[opcao] ); 
                     }                    
                  }    
                 }else{
                     JOptionPane.showMessageDialog(null, "Nenhum animal foi registrado");  
                 }
                                 
                 ShowMenu();
                 opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opcao desejada: "));
                 break;
             case 9:

                 marca = JOptionPane.showInputDialog("Digite a marca do brinquedo");
                 estado_Conservacao = JOptionPane.showInputDialog("Digite o estado de conservacao do brinquedo");
                 material_Feito = JOptionPane.showInputDialog("Digite o material que o brinquedo foi feito");
                 cor  = JOptionPane.showInputDialog("Digite a cor  do objeto (MAX 3)");
                 bola= new Bola_Brinquedo(marca, estado_Conservacao, material_Feito, cor);
                 flag = 1;
                 ShowMenu();
                 opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opcao desejada: "));
                 break;
             case 10:
                 if(cont > 0 || flag == 0){
                  opcao = cont+2;
                  while(opcao > cont-1){
                   opcao = Integer.parseInt(JOptionPane.showInputDialog(("Qual animal voce deseja Verificar o risco de extinção? ")));                   
                  }
                  if(animais[opcao] instanceof Cachorro){
                    ((Cachorro)animais[opcao]).Brincar(bola);
                  }else{
                    JOptionPane.showMessageDialog(null,"O animal nao gosta do brinquedo registrado");
                  }
                 }else{
                   JOptionPane.showMessageDialog(null, "Nenhum animal foi registrado ou nao existe brinquedo registracdo");     
                 }
                 break;
             case 0:

                 System.exit(0);
             default:
                 JOptionPane.showMessageDialog(null,"Opcao invalida");                 
                 ShowMenu();
                 opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opcao desejada: "));
                 break;
         }            
        }while(opcao != 0);
       }
        
    }
 



