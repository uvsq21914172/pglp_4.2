package fr.uvsq21914172.pglp42;

/**
 * Classe principale du calculateur.
 * 
 * @author Dalil
 */
public class CalculateurRpn {
  /**
   * Main.
   * 
   * @param args Arguments.
   */
  public static void main(String[] args) {

    SaisieRpn saisie = new SaisieRpn(System.in, System.out);
    while (saisie.isOn()) {
      saisie.listen();
    }
  }
}
