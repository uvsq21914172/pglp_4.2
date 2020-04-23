package fr.uvsq21914172.pglp42.commands.operators;

import fr.uvsq21914172.pglp42.MoteurRpn;
import fr.uvsq21914172.pglp42.commands.Cancelable;
import fr.uvsq21914172.pglp42.commands.CommandRpn;

/**
 * Soustraction.
 * 
 * @author Dalil
 *
 */
public class Substract implements CommandRpn, Operator, Cancelable {

  private MoteurRpn moteurRpn;

  /**
   * Constructeur.
   * 
   * @param moteurRpn Moteur.
   */
  public Substract(MoteurRpn moteurRpn) {
    this.moteurRpn = moteurRpn;
  }

  /**
   * Execute.
   */
  public void execute() {
    moteurRpn.addHistory(new Substract(moteurRpn));
  }

  /**
   * Eval.
   */
  public double eval(double op1, double op2) {
    return op1 - op2;
  }

  /**
   * Apply.
   */
  public void apply() {
    moteurRpn.applyOperator(this);
  }

  /**
   * Affiche.
   */
  public String display() {
    return "-";
  }

}
