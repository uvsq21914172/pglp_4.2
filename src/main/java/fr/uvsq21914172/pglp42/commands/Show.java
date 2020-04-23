package fr.uvsq21914172.pglp42.commands;

import fr.uvsq21914172.pglp42.ControleurRpn;
import fr.uvsq21914172.pglp42.MoteurRpn;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * Montre.
 * 
 * @author Dalil
 *
 */
public class Show implements CommandRpn {

  private ControleurRpn controleur;
  private MoteurRpn moteurRpn;

  /**
   * Constructeur.
   * 
   * @param moteurRpn Moteur.
   * @param controleur Controleur.
   */
  public Show(MoteurRpn moteurRpn, ControleurRpn controleur) {
    this.moteurRpn = moteurRpn;
    this.controleur = controleur;
  }

  /**
   * Execute.
   */
  public void execute() {
    OutputStream os = controleur.output();
    PrintStream ps;
    try {
      ps = new PrintStream(os, true, "UTF-8");
      moteurRpn.execute();
      Double[] operandes = moteurRpn.getOperandes();
      ps.println("Stack:");
      for (int i = 0; i < operandes.length; i++) {
        ps.print(operandes[i] + " ");
      }
      ps.println("");
      ps.close();
    } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
