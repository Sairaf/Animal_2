/*
A classe "Racao" contém as informações mínimas para uma ração. Não possui muitos atributos
"nomeComida" recebe o nome do limento, que é de certa forma desnecessário, diferente das "calorias", que 
definirão quanto o animal vai engordar. MesesProdução indica quanto tempo esta ração/comida foi produzida ou encontra-se podre,
sendo este atributo útil para verificar a "qualidade" da comida, que impacta na saúde do animal

Além dos velhos conhecidos getters e setters, além de sobrescrição dos métodos "toString", "equals" e "Hashcode".
 */
package Comida;

import java.util.Objects;

/**
 *
 * @author ABGerson
 */
public class Racao implements Comida {
  private String  nomeComida;
   private float     calorias;
   private boolean qualidadeComida;//true - para boa| false - para ruim
   private int     mesesProducao; //Há quanto tempo ela foi produzida ou Animal/PLanta morreu
   
   public Racao()
   {
    this.nomeComida = "Desconhecido"   ;
    this.calorias = 0;
    this.qualidadeComida = true;
    this.mesesProducao = 0;
   }

    public Racao(String nomeComida, int calorias, boolean qualidadeComida, int mesesProducao) {
        this.nomeComida = nomeComida;
        this.calorias = calorias;
        this.qualidadeComida = qualidadeComida;
        this.mesesProducao = mesesProducao;
    }

   
   
    public String getNomeComida() {
        return nomeComida;
    }

    public void setNomeComida(String nomeComida) {
        if(!nomeComida.isEmpty()){
         this.nomeComida = nomeComida;   
        }else{
         this.nomeComida = "nao declarada";        
        }
            
        
    }

    public float getCalorias() {
        return calorias;
    }

    public void setCalorias(float calorias) {
        if(calorias >= 0){
         this.calorias = calorias;   
        }else{
         this.calorias = 0;     
        }        
    }

    public boolean isQualidadeComida() {
        return qualidadeComida;
    }

    public void setQualidadeComida(boolean qualidadeComida) {
        this.qualidadeComida = qualidadeComida;
    }

    public int getMesesProducao() {
        return mesesProducao;
    }

    public void setMesesProducao(int mesesProducao) {
        this.mesesProducao = mesesProducao;
    }
    
   @Override
   public boolean Verificar_Qualidade(Comida comida){
     if(((Racao) comida).mesesProducao > 6)  {
        return true; 
     }else{
        return false; 
     }         
   }
   
   @Override
   public String toString(){
     String s = null;
      s = "\n Nome da Comida: "+ this.nomeComida + "\n Calorias: " + this.calorias + "\n Produzido a " + this.getMesesProducao() + " Meses" ;
     
      if(this.qualidadeComida == false){
        s = s + "A qualidade da comida e pessima"  ;
      }else{
        s = s + "A qualidade da comida e boa"  ;  
      }
     return s;
   }   
   
   @Override
   public boolean equals(Object o){
     return o instanceof Racao && ((Racao)o).calorias == this.calorias && (((Racao)o).nomeComida == null ? this.nomeComida == null : ((Racao)o).nomeComida.equals(this.nomeComida)) && ((Racao)o).mesesProducao == this.mesesProducao && ((Racao)o).qualidadeComida == this.qualidadeComida;
   }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.nomeComida);
        hash = 79 * hash + Float.floatToIntBits(this.calorias);
        hash = 79 * hash + (this.qualidadeComida ? 1 : 0);
        hash = 79 * hash + this.mesesProducao;
        return hash;
    }
}
