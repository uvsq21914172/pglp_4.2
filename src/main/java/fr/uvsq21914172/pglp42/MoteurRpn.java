package fr.uvsq21914172.pglp42;

import fr.uvsq21914172.pglp42.commands.Cancelable;
import fr.uvsq21914172.pglp42.commands.History;
import fr.uvsq21914172.pglp42.commands.Push;
import fr.uvsq21914172.pglp42.commands.Show;
import fr.uvsq21914172.pglp42.commands.operators.Add;
import fr.uvsq21914172.pglp42.commands.operators.Divide;
import fr.uvsq21914172.pglp42.commands.operators.Multiply;
import fr.uvsq21914172.pglp42.commands.operators.Operator;
import fr.uvsq21914172.pglp42.commands.operators.Substract;
import java.util.List;
import java.util.Stack;

/**
 * Interpreteur de commandes contenant l'etat de la calculatrice RPN.
 * 
 * @author Dalil
 *
 */
public class MoteurRpn extends Interpreteur {

  private Stack<Double> operandes = new Stack<Double>();
  private ControleurRpn controleur;

  /**
   * Constructeur.
   * 
   * @param controleur Controleur ayant invoqué le moteur.
   */
  public MoteurRpn(ControleurRpn controleur) {
    super();
    this.controleur = controleur;
    initRpn();
  }

  /**
   * Initialise les commandes du MoteurRPN.
   */
  protected void initRpn() {
    addCommands("Push", new Push(this, controleur));
    addCommands("Add", new Add(this));
    addCommands("Substract", new Substract(this));
    addCommands("Divide", new Divide(this));
    addCommands("Multiply", new Multiply(this));
    addCommands("Show", new Show(this, controleur));
    addCommands("History", new History(this, controleur));
  }

  /**
   * Ajoute une operande.
   * 
   * @param memory Operande a ajouter en memoire.
   */
  public void addOperande(double memory) {
    operandes.push(memory);
  }

  /**
   * Execute les commandes en historique.
   */
  public void execute() {
    operandes.clear();
    for (int i = 0; i < history.size(); i++) {
      history.get(i).apply();
    }
  }

  /**
   * Applique l'operateur.
   * 
   * @param op Operateur a appliquer sur les operandes en haut de la pile.
   */
  public void applyOperator(Operator op) {
    if (operandes.size() > 1) {
      double membre2 = operandes.pop();
      double membre1 = operandes.pop();
      operandes.push(op.eval(membre1, membre2));
    }
  }

  /**
   * Renvoie les operandes.
   * 
   * @return Retourne un tableau des operandes dans l'ordre d'insertion.
   */
  public Double[] getOperandes() {
    return operandes.toArray(new Double[operandes.size()]);
  }

  /**
   * Renvoie l'historique.
   * 
   * @return Retourne l'historique des commandes annulable
   */
  public List<Cancelable> getHistory() {
    return history;
  }

}
