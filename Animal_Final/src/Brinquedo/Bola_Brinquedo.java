/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Brinquedo;

import Dono.Movimento;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author ABGerson
 */
public class Bola_Brinquedo implements Movimento{
    private String marca;
    private String estado_Conservacao;
    private String material_Feito;
    private ArrayList <String> cor = new ArrayList<>();

    public Bola_Brinquedo(String marca, String estado_Conservacao, String material_Feito, String cor) {
        this.setMarca(marca);
        this.setEstado_Conservacao(estado_Conservacao);
        this.setMaterial_Feito(material_Feito);
        this.setCor(cor);
    }

    public Bola_Brinquedo() {
        this.setMarca("Desconhecida");
        this.setEstado_Conservacao("Desconhecida");
        this.setMaterial_Feito("Desconhecido");
        this.setCor("Desconhecido");
    }
   
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
       if(!marca.isEmpty()) 
        this.marca = marca;
       else
        this.marca = "Nao informado";   
    }

    public String getEstado_Conservacao() {
        return estado_Conservacao;
    }

    public void setEstado_Conservacao(String estado_Conservacao) {
        if(!estado_Conservacao.isEmpty()){
         this.estado_Conservacao = estado_Conservacao;    
        }else{
         this.estado_Conservacao = "Nao informado";       
        }
       
    }

    public String getMaterial_Feito() {
        return material_Feito;
    }

    public void setMaterial_Feito(String material_Feito) {
        if(!material_Feito.isEmpty()){
         this.material_Feito = material_Feito;   
        }else{
         this.material_Feito = "Nao informado";      
        }
        
    }

    public ArrayList <String> getCor() {
        return cor;
    }

    public void setCor(String cor) {
        if(!cor.isEmpty() && this.cor.size() <3){
         this.cor.add(cor);   
        }else if( this.cor.size() < 3){
         this.cor.add("Nao informado");      
        }
        
    }

    @Override
    public void Mover(){
        System.out.println("A bola rola");  
    }
    
    @Override
    public String toString() {
        String s;
        s = "\n Marca da bola:" + this.getMarca() + "\nMaterial que a bola e feita: " + this.getMaterial_Feito() 
             + "\n Estado de conservacao da bola" + this.getEstado_Conservacao() + "\n Cor(es) da bola: ";
        int i;
        ArrayList <String> aux = new ArrayList<>();
        aux = this.getCor();
        for(i = 0; i < aux.size(); i++){
         s = s + aux.get(i) + " ";
        }
        return s;
    }

    @Override
    public boolean equals(Object o){
      return o instanceof Bola_Brinquedo && ((Bola_Brinquedo)o).cor == this.cor && (((Bola_Brinquedo)o).estado_Conservacao == null ? this.estado_Conservacao == null : ((Bola_Brinquedo)o).estado_Conservacao.equals(this.estado_Conservacao)) && (((Bola_Brinquedo)o).material_Feito == null ? this.material_Feito == null : ((Bola_Brinquedo)o).material_Feito.equals(this.material_Feito)) && (this.marca == null ? ((Bola_Brinquedo)o).marca == null : this.marca.equals(((Bola_Brinquedo)o).marca));  
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.marca);
        hash = 59 * hash + Objects.hashCode(this.estado_Conservacao);
        hash = 59 * hash + Objects.hashCode(this.material_Feito);
        hash = 59 * hash + Objects.hashCode(this.cor);
        return hash;
    }


}
