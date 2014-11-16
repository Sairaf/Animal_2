/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comida;

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
}
