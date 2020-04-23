package fr.uvsq21914172.pglp42.commands.operators;

import fr.uvsq21914172.pglp42.MoteurRpn;
import fr.uvsq21914172.pglp42.commands.Cancelable;
import fr.uvsq21914172.pglp42.commands.CommandRpn;

/**
 * Multiply.
 * 
 * @author Dalil
 *
 */
public class Multiply implements CommandRpn, Operator, Cancelable {

  private MoteurRpn moteurRpn;

  /**
   * Constructeur.
   * 
   * @param moteurRpn Moteur.
   */
  public Multiply(MoteurRpn moteurRpn) {
    this.moteurRpn = moteurRpn;
  }

  /**
   * Multiply.
   */
  public void execute() {
    moteurRpn.addHistory(new Multiply(moteurRpn));
  }

  /**
   * Multiply.
   */
  public void apply() {
    moteurRpn.applyOperator(this);
  }

  /**
   * Multiply.
   */
  public double eval(double op1, double op2) {
    return op1 * op2;
  }

  /**
   * Affiche.
   */
  public String display() {
    return "*";
  }

}
