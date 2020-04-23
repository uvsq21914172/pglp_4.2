package fr.uvsq21914172.pglp42;

import java.io.OutputStream;

/**
 * Cette interface représente les controleurs qui enverront les commandes au moteur RPN.
 * 
 * @author Dalil
 */
public interface ControleurRpn {
  /**
   * Memoire.
   * 
   * @return Retourne l'operande en memoire dans le controleur.
   */
  public double memory();

  /**
   * Sortie.
   * 
   * @return Retourne la sortie du controleur.
   */
  public OutputStream output();
}
