package fr.uvsq21914172.pglp42.commands;

import fr.uvsq21914172.pglp42.ControleurRpn;
import fr.uvsq21914172.pglp42.MoteurRpn;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Interface presentant la commande d'affichage de l'historique du moteur.
 * 
 * @author Dalil
 *
 */
public class History implements CommandRpn {

  private MoteurRpn moteurRpn;
  private ControleurRpn controleur;

  /**
   * Constructeur.
   * 
   * @param moteurRpn MoteurRPN recevant la commande.
   * @param controleur Controleur emmetant la commande.
   */
  public History(MoteurRpn moteurRpn, ControleurRpn controleur) {
    this.moteurRpn = moteurRpn;
    this.controleur = controleur;
  }

  /**
   * Affiche l'historique du moteur dans la sortie du controleur.
   */
  public void execute() {
    List<Cancelable> history = moteurRpn.getHistory();
    OutputStream os = controleur.output();
    PrintStream ps;
    try {
      ps = new PrintStream(os, true, "UTF-8");
      ps.println("History:");
      for (int i = 0; i < history.size(); i++) {
        ps.print(history.get(i).display() + " ");
      }
      ps.println("");
      ps.close();
    } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
