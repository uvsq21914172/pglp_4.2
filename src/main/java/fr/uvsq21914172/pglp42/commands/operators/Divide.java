package fr.uvsq21914172.pglp42.commands.operators;

import fr.uvsq21914172.pglp42.MoteurRpn;
import fr.uvsq21914172.pglp42.commands.Cancelable;
import fr.uvsq21914172.pglp42.commands.CommandRpn;

/**
 * Commande de division.
 * 
 * @author Dalil
 *
 */
public class Divide implements CommandRpn, Operator, Cancelable {

  private MoteurRpn moteurRpn;

  /**
   * Constructeur.
   * 
   * @param moteurRpn Moteur recevant la commande.
   */
  public Divide(MoteurRpn moteurRpn) {
    this.moteurRpn = moteurRpn;
  }

  /**
   * Execute la division.
   */
  public void execute() {
    moteurRpn.addHistory(new Divide(moteurRpn));
  }

  /**
   * Execute la division.
   */
  public void apply() {
    moteurRpn.applyOperator(this);
  }

  /**
   * Applique la division.
   */
  public double eval(double op1, double op2) {
    return op1 / op2;
  }

  /**
   * Affiche la commande.
   */
  public String display() {
    return "/";
  }

}
