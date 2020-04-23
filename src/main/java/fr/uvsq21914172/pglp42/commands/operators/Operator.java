package fr.uvsq21914172.pglp42.commands.operators;

import fr.uvsq21914172.pglp42.commands.CommandRpn;

/**
 * Interface des operations.
 * 
 * @author Dalil
 *
 */
public interface Operator extends CommandRpn {
  /**
   * Evaluation.
   * 
   * @param op1 Op1.
   * @param op2 Op2.
   * @return resultat.
   */
  public double eval(double op1, double op2);
}
