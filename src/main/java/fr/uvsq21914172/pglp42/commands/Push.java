package fr.uvsq21914172.pglp42.commands;

import fr.uvsq21914172.pglp42.ControleurRpn;
import fr.uvsq21914172.pglp42.MoteurRpn;

/**
 * Pousser.
 * 
 * @author Dalil
 *
 */
public class Push implements CommandRpn, Cancelable {

  MoteurRpn moteurRpn;
  ControleurRpn controleur;
  double memory;

  /**
   * Constructeur.
   * @param moteurRpn Moteur.
   * @param controleur Controleur.
   */
  public Push(MoteurRpn moteurRpn, ControleurRpn controleur) {
    this.moteurRpn = moteurRpn;
    this.controleur = controleur;
  }

  /**
   * Constructeur.
   * @param moteurRPN Moteur.
   * @param controleur Controleur.
   * @param memory Memoire.
   */
  private Push(MoteurRpn moteurRpn, ControleurRpn controleur, double memory) {
    this.moteurRpn = moteurRpn;
    this.controleur = controleur;
    this.memory = memory;
  }

  /**
   * Pile l'operande en memoire du controleur dans la pile du moteur.
   */
  public void execute() {
    moteurRpn.addHistory(new Push(moteurRpn, controleur, controleur.memory()));
  }

  /**
   * Applique la commandes au moment de l'execution du moteur.
   */
  public void apply() {
    moteurRpn.addOperande(memory);
  }

  /**
   * Representation de la commande lors de l'affichage de l'historique.
   */
  public String display() {
    return memory + "";
  }

}
