/*

/**
 * 
 * @author Abner Farias
 
 A classe Comida contém as informações mínimas para uma refeição. Não possui muitos atributos
 "nomeComida" recebe o nome da cdomida, que é de certa forma desnecessário, diferente das "calorias", que 
 definirão quanto o animal vai engordar. MesesProdução indica quanto tempo esta ração/comida foi produzida ou encontra-se morte,
 sendo este atributo útil para verificar a "qualidade" da comida, que impacta na saúde do animal

Além dos velhos conhecidos getters e setters, tempos o método "verificar_Qualidade(int)", retornando se a comida ainda´e comestível ou não.

 
 */
package Comida;


public interface Comida {
  public boolean Verificar_Qualidade(Comida comida);
}
