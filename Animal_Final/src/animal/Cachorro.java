/*
  Subclasse da classe "Animal_Domesticado".  Armazena a raca do cao, alem dos atributos de sua super classe.
 */
package animal;
import Brinquedo.Bola_Brinquedo;
import Dono.Movimento;
import java.util.Objects;
import javax.swing.JOptionPane;
/**
 *
 * @author ABGerson
 */
public class Cachorro extends Animal_Domesticado{

    public String raca;
    
    public Cachorro(String apelido, String nomeCientifico, String classe, String codigoAnimal, int idade, float peso, String nomePopular, int contDoenca, boolean Doente, String raca) {        
        super(apelido, nomeCientifico, classe, codigoAnimal, idade, peso, "Cachorro", contDoenca, Doente);
        this.setRaca(raca);
    }

    public Cachorro() {
        super();
        this.raca = "Vira-Lata";
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        if(!raca.isEmpty())
        this.raca = raca;
        else
        this.raca = "Vira-Lata";
    }
    
    
    
    public void Brincar(Movimento brinquedo){
      if(brinquedo instanceof Bola_Brinquedo)  {
          JOptionPane.showMessageDialog(null,this.getApelido() + " brinca com a bola.");            
      }else{
         JOptionPane.showMessageDialog(null, this.getApelido() + " rejeita seu brinquedo");            
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
     s = s + this.raca; 
     return s;
    }
    
    @Override
    public boolean equals(Object o){
       if(super.equals(o) == true){
           return o instanceof Cachorro && (((Cachorro)o).raca == null ? this.raca == null : ((Cachorro)o).raca.equals(this.raca));   
       }else{
       return false; 
       }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.raca);
        return hash;
    }
    
    
}
