package fr.uvsq21914172.pglp42.commands.operators;

import fr.uvsq21914172.pglp42.MoteurRpn;
import fr.uvsq21914172.pglp42.commands.Cancelable;
import fr.uvsq21914172.pglp42.commands.CommandRpn;

/**
 * Commande de l'addition.
 * 
 * @author Dalil
 *
 */
public class Add implements CommandRpn, Operator, Cancelable {

  private MoteurRpn moteurRpn;

  /**
   * Constructeur.
   * 
   * @param moteurRpn Moteur recevant la commande.
   */
  public Add(MoteurRpn moteurRpn) {
    this.moteurRpn = moteurRpn;
  }

  /**
   * Applique l'addition.
   */
  public void execute() {
    moteurRpn.addHistory(new Add(moteurRpn));
  }

  /**
   * Applique l'addition.
   */
  public void apply() {
    moteurRpn.applyOperator(this);
  }

  /**
   * Applique l'addition.
   */
  public double eval(double op1, double op2) {
    return op1 + op2;
  }

  /**
   * Affiche la commande.
   */
  public String display() {
    return "+";
  }

}
