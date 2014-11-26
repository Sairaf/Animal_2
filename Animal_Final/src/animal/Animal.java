

/*
 SuperClasse abstrata responsável por definir todo Animal deste programa. Extende para duas classes: "Animal_Domesticado" e 
 "Animal_Selvagem". Decidi usar estas subclasses pois poderia criar facilmente subclasses a partir delas (Animal_Domesticado 
 derivaria em cão, gato, coelho, etc.).

 Assumindo que cada animal tenha um nome Científico (ex: Panthera tigris), uma classe (ex: mamífero, inseto), um codigo(000000432812)
 idade(ex: 13 anos, 35 anos), um peso, nomePopular(Pantheras tigris == Tigre), um contador de doenças( crece conforme o animal
 come alimentos estragados) e um verificador se ele está doente ou não, é possível criar um objeto desta classe.

 Nos métodos, temos o "Comer(Comida)", onde, dada uma comida X, o animal alimenta-se dela, um método "Verificar_perigo_Extincao"
 que retorna um indicador de qual o perigo de extinção de um animal, "Velhice(int Expectativa Vida)", que dada uma expectativa de vida,
 retorna uma mensagem que varia dependendo da (idade atual/expectativa vida), além de um método que indica se ele está doente.

 Existem outros métodos, como o "toString(Animal)", responsável por realizar uma função parecida com o operador "<<" do c++, e o "Habitat()"
 indicando qual lugar será mais provável encontrar estes animais, e este será sobreescrito por suas subclasse, além de sobrescrever os métodos "hashcode()" e "equals()"
 */
package animal;

import Comida.Comida;
import Comida.Racao;
import java.util.Scanner;
import Dono.Movimento;
import java.util.Random;
import java.util.Objects;
/**
 *
 * @author ABGerson
 */
public abstract class Animal implements Movimento, ComparableTo<Animal>{
  
  protected String  nomeCientifico;
  protected String  classe;
  protected String  codigoAnimal;
  protected int     idade;
  protected String  perigoExtincao;
  protected float   peso;
  protected String  nomePopular;
  protected int     contDoenca;
  protected boolean Doente;
  
  Scanner sc = new Scanner(System.in);
  
  public Animal(){
    this.nomeCientifico = "Desconhecido"  ;
    this.classe = "Desconhecida";
    this.codigoAnimal = "0000000";
    this.idade = 0;
    this.perigoExtincao ="Desconhecido";
    this.peso = 0;
    this.nomePopular = "Desconhecido";
    this.Doente = false;
    this.contDoenca = 0;
  }

    public Animal(String nomeCientifico, String classe, String codigoAnimal, int idade, float peso, String nomePopular, int contDoenca, boolean Doente) {
        this.setNomeCientifico(nomeCientifico);
        this.setClasse(classe);
        this.setCodigoAnimal(codigoAnimal);
        this.setIdade(idade);
        this.perigoExtincao = "Desconhecido";
        this.setPeso(peso);
        this.setNomePopular(nomePopular);
        this.setContDoenca(contDoenca);
        this.setDoente(Doente);
    }

    
    public Animal(final Animal animalCpy){
        this.nomeCientifico = animalCpy.nomeCientifico;
        this.classe = animalCpy.classe;
        this.codigoAnimal = animalCpy.codigoAnimal;
        this.idade = animalCpy.idade;
        this.nomePopular = animalCpy.nomePopular;
        this.perigoExtincao = animalCpy.perigoExtincao;
        this.peso = animalCpy.peso;   
        this.contDoenca = animalCpy.contDoenca;
        this.Doente = animalCpy.Doente;
    }
    
    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        if(!nomeCientifico.isEmpty() ){           
           this.nomeCientifico = nomeCientifico; 
        }else{
          this.nomeCientifico ="Nao declarado";
        }
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        if(!classe.isEmpty()){
         this.classe = classe;   
        }else{
         this.classe = "Não declarada";      
        }
        
    }

    public String getCodigoAnimal() {
        return codigoAnimal;
    }

    public void setCodigoAnimal(String codigoAnimal) {
        int cont;
        if(!codigoAnimal.isEmpty() && codigoAnimal.length() == 12 && codigoAnimal.matches("[0-9]*") && !"000000000000".equals(codigoAnimal)){                       
         this.codigoAnimal = codigoAnimal;
        }else{
         this.codigoAnimal = "Desconhecido";               
        }           
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if(idade > 0)
         this.idade = idade;
    }

    public String getPerigoExtincao() {
        return perigoExtincao;
    }

    public void setPerigoExtincao(String perigo) {
        if(!perigo.isEmpty())
         this.perigoExtincao = perigo;
        
    }

    public float getPeso() {
        return peso;
    }

    public int getContDoenca() {
        return contDoenca;
    }

    public void setContDoenca(int contDoenca) {
        if(contDoenca > 0){
         this.contDoenca = contDoenca;
        }else{
          this.contDoenca = 0;  
        }
        
    }

    public boolean isDoente() {
        return Doente;
    }

    public void setDoente(boolean doente) {
        this.Doente = doente;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public void setPeso(float peso) {
        if(peso > 0)
        {
         this.peso = peso;
        }else{            
          this.peso = 10;
        }
            
    }

    public String getNomePopular() {
        return nomePopular;
    }

  public void setNomePopular(String nomePopular) {
        if(!nomePopular.isEmpty())
        {
         this.nomePopular = nomePopular;
        }else{
         this.nomePopular = "Desconhecido";    
        }
            
    }

  
  @Override  
  public void Mover(){
      System.out.println("DEsconhecido");;
  }
  public static String Verificar_Perigo_Extincao(int populacao){
   if(populacao < 2500)   {
    return "Especie em estado crítico de extinção";    
   }else if(populacao >= 2500 && populacao < 10000){
    return "Especie em perigo de extinção";       
   }else if(populacao >= 10000 && populacao < 20000){
    return "Especie em vulneravel a extinção";          
   }else{
    return "Especie nao esta em perigode extinção";          
   }       
  }
  
  public void Comer(Comida comida){
   float kilo;
   float result;   
   if(comida instanceof Racao){
    System.out.println(this.nomePopular +  "esta comendo " + ((Racao)comida).getNomeComida() + "\n");
    kilo = ((Racao) comida).getCalorias()/8000;
    result = this.peso;
    this.peso+=kilo;
    if(this.peso - result>= 0){
       result = result - this.peso;
       System.out.println("O animal encorgou " + result + "kilos.\n");   
     }
    
    if(((Racao)comida).isQualidadeComida() == false){
     this.contDoenca++;  
    }  
   }
   
   }
   
   @Override
   public int CompareTo(Animal animal){
       if(this.idade < animal.idade){
       return -1;
       }
       if(this.idade > animal.idade){
       return 1;
       }
       return 0;
   }
  
  public int Velhice(int expectativa_Vida){
    int aux = idade/expectativa_Vida;  
          System.out.println(aux);
    if(aux < 0.25){
        System.out.println("Um filhote");  
        return 0;
    }else if(aux >= 0.25 && aux < 0.50){
        System.out.println("Ainda um garoto");   
        return 1;
    } else if(aux >= 0.50 && aux < 0.75){
        System.out.println("Um adulto");   
        return 2;
    } else if(aux >= 0.75 && aux < 1){
        System.out.println("Um velho");   
        return 3;
   }else{
        System.out.println("Alem da expectativa de vida");     
        return 4;
    }
  }
  
 
  public void Verificar_Se_Esta_Doente(Animal animal, int expectativa_Vida){
      int aux; 
      
      Random rand = new Random();
      int aux_Random = rand.nextInt(3)+0;
      
      
      aux = animal.Velhice(expectativa_Vida);
      if(aux == 0 && animal.getContDoenca()+aux_Random >= 5){
        System.out.println("Este animal  esta doente");  ;
      }
      
      if(aux == 1 && animal.getContDoenca()+aux_Random >= 8){
        System.out.println("Este animal  esta doente");  ;
      }
      
      if(aux == 2 && animal.getContDoenca()+aux_Random >= 10){
        System.out.println("Este animal  esta doente");  ;
      }
      
      if(aux == 3 && animal.getContDoenca()+aux_Random >= 3){
        System.out.println("Este animal  esta doente");  ;
      }
      if(aux == 4 && animal.getContDoenca()+aux_Random >= 2){
        System.out.println("Este animal  esta doente");  ;
      }
      
      else{
        System.out.println("Este animal nao esta doente");  ;
      }
  }
  
  public String Habitat()
  {
      return "Desconhecido";   
  }
  
  @Override
  public String toString(){
   String s = "\nNome cientifico: "+ this.nomeCientifico + "\n Nome Popular: " +this.nomePopular+ "\n Classe: " + this.classe + "\n Codigo do Animal: " + this.codigoAnimal + "\n Perigo de Extincao: " + this.perigoExtincao + "\n Idade: " + this.idade + "\n Peso: " +this.peso  ;   
   if(this.Doente == false){
     s = s +"\n O animal Nao esta doente. ";  
   }else{
     s = s +"\n Animal esta doente. ";    
   }
      return s;
   } 
  
  @Override 
  public boolean equals(Object o){
          int i = 0;
      return o instanceof Animal && (((Animal)o).getNomeCientifico() == null ? this.getNomeCientifico() == null : ((Animal)o).getNomeCientifico().equals(this.getNomeCientifico())) && (((Animal) o).getCodigoAnimal() == null ? this.getCodigoAnimal() == null : ((Animal) o).getCodigoAnimal().equals(this.getCodigoAnimal())) && (((Animal)o).getClasse() == null ? this.getClasse() == null : ((Animal)o).getClasse().equals(this.getClasse())) && ((Animal)o).idade == this.getIdade() && (((Animal)o).nomePopular == null ? this.nomePopular == null : ((Animal)o).nomePopular.equals(this.nomePopular)) && ((Animal)o).getContDoenca() == this.getContDoenca() && ((Animal)o).getPeso() == this.getPeso();


 }

  @Override
  public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nomeCientifico);
        hash = 97 * hash + Objects.hashCode(this.classe);
        hash = 97 * hash + Objects.hashCode(this.codigoAnimal);
        hash = 97 * hash + this.idade;
        hash = 97 * hash + Objects.hashCode(this.perigoExtincao);
        hash = 97 * hash + Float.floatToIntBits(this.peso);
        hash = 97 * hash + Objects.hashCode(this.nomePopular);
        hash = 97 * hash + this.contDoenca;
        hash = 97 * hash + (this.Doente ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.sc);
        return hash;
    }
  
  
}
