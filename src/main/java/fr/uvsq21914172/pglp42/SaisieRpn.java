package fr.uvsq21914172.pglp42;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

/**
 * Controleur.
 * 
 * @author Dalil
 *
 */
public class SaisieRpn implements ControleurRpn {
  private double memory;
  private OutputStream output;
  private Scanner scanner;
  private MoteurRpn moteur;

  /**
   * Construction.
   * 
   * @param input InputStream servant d'entrée au controleur.
   * @param output InputStream servant de sortie au controleur.
   */
  public SaisieRpn(InputStream input, OutputStream output) {
    scanner = new Scanner(input, "UTF-8");
    this.output = output;
    moteur = new MoteurRpn(this);
  }

  /**
   * Attend la prochaine entrée de l'utilisateur, puis la traite.
   */
  public void listen() {
    String next;
    String tmp;
    while (isOn() && scanner.hasNextLine()) {
      next = scanner.next();
      if (next.matches("^-?\\d+(\\.\\d+)?$")) {
        memory = Double.parseDouble(next);
        moteur.executeCommand("Push");
      } else {
        if (next.matches("^Push$")) {
          if ((tmp = scanner.next()).matches("^-?\\d+(\\.\\d+)?$")) {
            memory = Double.parseDouble(tmp);
          } else {
            memory = 0;
          }
        }
        moteur.executeCommand(next);
      }
    }
  }

  /**
   * Est il allume.
   * 
   * @return Retourne l'etat de la calculatriceRPN.
   */
  public boolean isOn() {
    return moteur.isOn();
  }

  /**
   * Memoire.
   * 
   * @return Retourne l'opérande stocke en memoire.
   */
  public double memory() {
    return memory;
  }

  /**
   * Sortie.
   * 
   * @return Retourne la sortie du Controleur.
   */
  public OutputStream output() {
    return output;
  }

}
