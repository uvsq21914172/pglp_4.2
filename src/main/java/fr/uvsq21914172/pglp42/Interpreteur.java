package fr.uvsq21914172.pglp42;

import fr.uvsq21914172.pglp42.commands.Cancelable;
import fr.uvsq21914172.pglp42.commands.CommandRpn;
import fr.uvsq21914172.pglp42.commands.Quit;
import fr.uvsq21914172.pglp42.commands.Undo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe Receiver de base des commandes.
 * 
 * @author Dalil
 *
 */
public class Interpreteur {

  protected Map<String, CommandRpn> commands = new HashMap<String, CommandRpn>();
  protected List<Cancelable> history = new ArrayList<Cancelable>();
  protected boolean state = true;

  /**
   * Constructeur par défaut.
   */
  public Interpreteur() {
    init();
  }

  /**
   * Ajoute une commande.
   * 
   * @param commandName Nom de la commande ajoute dans l'interpreteur.
   * @param command Commande ajoute dans l'interpreteur.
   */
  protected void addCommands(String commandName, CommandRpn command) {
    commands.put(commandName, command);
  }

  /**
   * Initialise les commandes de l'interpreteur.
   */
  protected void init() {
    addCommands("Undo", new Undo(this));
    addCommands("Quit", new Quit(this));
  }

  /**
   * Execute la commande.
   * 
   * @param commandName Nom de la commande a executer.
   */
  public void executeCommand(String commandName) {
    if (commands.containsKey(commandName)) {
      commands.get(commandName).execute();
    }
  }

  /**
   * Est il allumé.
   * 
   * @return Retourne l'etat de l'interpreteur.
   */
  public boolean isOn() {
    return state;
  }

  /**
   * Annule la derniere commande Cancelable en memoire.
   */
  public void undo() {
    if (history.size() > 0) {
      history.remove(history.size() - 1);
    }
  }

  /**
   * Ajoute une commande a l'historique.
   * 
   * @param command Commande annulable a ajouter dans l'historique.
   */
  public void addHistory(Cancelable command) {
    history.add(command);
  }

  /**
   * Passe l'etat de l'interpreteur a faux.
   */
  public void turnOff() {
    state = false;
  }

}
