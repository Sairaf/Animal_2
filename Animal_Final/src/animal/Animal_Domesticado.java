/**
 *
 * @author Abner Farias
 */

/*
  Sendo uma "filha" da classe Animal, Animal_Domesticado herda todos os atributos da classe Añimal. Portanto não explicarei dos
  detalhes da superclasse.

  Entao, o que a torna especial? Nao muito infelizmente. Alem de possuir um static final para ter o controle do que esta criando, cada animal possui um apelido
 (cachorro = Totó), e o objeto dono e auxDono indica quais são as informçaoes do Dono. A classe tem um método para verificar qual a qualidade do
  criador, sem contar que ele sobreescreve as funções "Habitat", "equals" e "toString"
 */
package animal;

import Dono.Dono;
import animal.Animal;
import java.util.Objects;



public class Animal_Domesticado extends Animal {
  //  private static final int MAX = 10;
    
    protected String apelido;
    private Dono dono =  new Dono();
    private Dono auxDono = new Dono();        
    //protected ArrayList <Dono> dono = new ArrayList <>();


    public Animal_Domesticado(String apelido, String nomeCientifico, String classe, String codigoAnimal, int idade, float peso, String nomePopular, int contDoenca, boolean Doente) {            
        super(nomeCientifico, classe, codigoAnimal, idade,  peso, nomePopular, contDoenca, Doente);
        int cont;        
        this.setApelido(apelido);
        this.setDono(dono);
    }
    
    public Animal_Domesticado(){
        super();
        this.apelido = "Nao possui";
        this.setDono(dono);            
    }
    
    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        if(!apelido.isEmpty()){
        this.apelido = apelido;
       }else{
        this.apelido = "Nao possui"    ;
       }
    }

    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        if(dono != null){
         this.dono = dono;
        }else{         
         this.dono = auxDono;   
        }
                
    }
   
    public void Adicionar_Dono(Dono dono){
        
       this.setDono(dono);
    }
    
        
    @Override
    public String Habitat(){
        return "Casa, Fazendas, etc.";  
    }
    
    @Override
    public String toString(){
      String s;
      int cont;
      s = super.toString();
      s = s+ "\n=========================\n\nApelido: " + this.apelido;
      s = s + "\n"  ;
      s = s + "\nHabitat: "+ this.Habitat();
      if(this.dono != null)
      s = s +this.dono.toString();
      return s;
    }

    @Override
    public boolean equals(Object o){       
        if(super.equals(o) == true){
            return o instanceof Animal_Domesticado && (((Animal_Domesticado)o).getApelido() == null ? this.getApelido() == null : ((Animal_Domesticado)o).getApelido().equals(this.getApelido())) && ((Animal_Domesticado)o).getDono() == this.getDono();
        }else{
         return false;   
        }    
   }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.apelido);
        hash = 97 * hash + Objects.hashCode(this.dono);
        hash = 97 * hash + Objects.hashCode(this.auxDono);
        return hash;
    }
    
    
}
