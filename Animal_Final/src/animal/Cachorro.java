/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;
import Brinquedo.Bola_Brinquedo;
import Dono.Movimento;
/**
 *
 * @author ABGerson
 */
public class Cachorro extends Animal_Domesticado{

    public Cachorro(String apelido, String nomeCientifico, String classe, String codigoAnimal, int idade, float peso, String nomePopular, int contDoenca, boolean Doente) {
        super(apelido, nomeCientifico, classe, codigoAnimal, idade, peso, "Cachorro", contDoenca, Doente);
    }

    public Cachorro() {
        super();
    }
    
    void Brincar(Movimento brinquedo){
      if(brinquedo instanceof Bola_Brinquedo)  {
          System.out.println(this.getApelido() + " brinca com a bola.");            
      }else{
          System.out.println(this.getApelido() + " rejeita seu brinquedo");            
      }
    }
    
    @Override 
    public void Mover(){
        System.out.println("Movimenta-se correndo ou andando.");  
    }
    
    @Override
    public String toString(){
     String s;
     s = super.toString();
     return s;
    }
}
