/*
  A interface Pessoa, além de implementar a interface "Movimento" (Uma pessoa se movimenta", ela é implementada por
  Dono (Todo dono é uma pessoa). Só possui o método "Adicionar_Profissão".
 */
package Dono;
import Dono.Movimento;




/**
 *
 * @author ABGerson
 */
public interface Pessoa extends Movimento{
   // public void Mover();
    public void Adicionar_Profissao(String ob);
    
}
