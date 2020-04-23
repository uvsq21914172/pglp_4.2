package fr.uvsq21914172.pglp42.commands;

/**
 * Interface representant les commandes enregistré en historique.
 * 
 * @author Dalil
 *
 */
public interface Cancelable extends CommandRpn {
  /**
   * Methode a appliquer quand le moteur relis l'historique.
   */
  public void apply();

  /**
   * Affiche.
   * 
   * @return Représentation de la commande lors de l'affichage de l'historique.
   */
  public String display();
}
