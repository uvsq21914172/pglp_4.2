package fr.uvsq21914172.pglp42;

import java.io.OutputStream;

/**
 * Controleur test.
 * 
 * @author Dalil
 *
 */
public class TestControleurRpn implements ControleurRpn {

  private double memory;
  private OutputStream output;
  private MoteurRpn moteur;

  /**
   * Constructeur.
   * 
   * @param output Sortie du Controleur.
   */
  public TestControleurRpn(OutputStream output) {
    this.output = output;
    moteur = new MoteurRpn(this);
  }

  /**
   * Pousse une operande.
   * 
   * @param operande Operande a piler dans le MoteurRPN.
   */
  public void push(double operande) {
    memory = operande;
    moteur.executeCommand("Push");
  }

  /**
   * Affiche l'etat de la pile du MoteurRPN.
   */
  public void show() {
    moteur.executeCommand("Show");
  }

  /**
   * Affiche l'historique du MoteurRPN.
   */
  public void history() {
    moteur.executeCommand("History");
  }

  /**
   * Applique l'addition au MoteurRPN.
   */
  public void add() {
    moteur.executeCommand("Add");
  }

  /**
   * Applique la division au MoteurRPN.
   */
  public void divide() {
    moteur.executeCommand("Divide");
  }

  /**
   * Applique la soustraction au MoteurRPN.
   */
  public void substract() {
    moteur.executeCommand("Substract");
  }

  /**
   * Applique la multiplication au MoteurRPN.
   */
  public void multiply() {
    moteur.executeCommand("Multiply");
  }

  /**
   * Annule la derniere action annulable du MoteurRPN.
   */
  public void undo() {
    moteur.executeCommand("Undo");
  }

  /**
   * Ferme le MoteurRPN.
   */
  public void quit() {
    moteur.executeCommand("Quit");
  }

  /**
   * Memoire.
   * 
   * @return Retourne l'operande en memoire dans le Controleur.
   */
  public double memory() {
    // TODO Auto-generated method stub
    return memory;
  }

  /**
   * Sortie.
   * 
   * @return Retourne la sortie du controleur.
   */
  public OutputStream output() {
    // TODO Auto-generated method stub
    return output;
  }

}
