package fr.uvsq21914172.pglp42.commands;

import fr.uvsq21914172.pglp42.Interpreteur;

/**
 * Commande quitter.
 * 
 * @author Dalil
 *
 */
public class Quit implements CommandRpn {

  private Interpreteur interpreteur;

  /**
   * Constructeur.
   * 
   * @param interpreteur Interpreteur recevant la commande.
   */
  public Quit(Interpreteur interpreteur) {
    this.interpreteur = interpreteur;
  }

  /**
   * Ferme l'interpreteur.
   */
  public void execute() {
    interpreteur.turnOff();
  }

}
