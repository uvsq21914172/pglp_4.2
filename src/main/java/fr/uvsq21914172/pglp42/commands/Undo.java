package fr.uvsq21914172.pglp42.commands;

import fr.uvsq21914172.pglp42.Interpreteur;

/**
 * Commande annulant la derniere commande annulable.
 * 
 * @author Dalil
 *
 */
public class Undo implements CommandRpn {

  private Interpreteur interpreteur;

  /**
   * Constructeur.
   * 
   * @param interpreteur Interpreteur recevant la commande.
   */
  public Undo(Interpreteur interpreteur) {
    this.interpreteur = interpreteur;
  }

  /**
   * Annulant la derniere commande annulable.
   */
  public void execute() {
    interpreteur.undo();
  }
}
