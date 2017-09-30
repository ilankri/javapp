package printer;

import java.util.*;

public class TerminalPrinter implements Printer {
    private java.io.PrintStream out;

    private static HashMap<Color, String> colors;

    static {
        colors = new HashMap<>();
        colors.put(Color.RED, "\033[31m");
        colors.put(Color.GREEN, "\033[32m");
        colors.put(Color.BROWN, "\033[33m");
        colors.put(Color.BLUE, "\033[34m");
        colors.put(Color.PURPLE, "\033[35m");
        colors.put(Color.CYAN, "\033[36m");
        colors.put(null, "\033[0m");
    }

    public TerminalPrinter(java.io.PrintStream out) {
        this.out = out;
    }

    /*
     * Cette methode ne fait qu'afficher la chaine donnee en entree dans
     * le terminal.
     */
    public void print(String s) {
        out.print(s);
    }

    /*
     * Cette methode affiche la chaine donnee en entree dans le terminal
     * de la couleur donnee.
     */
    public void print(String s, Color color) {
        out.print(colors.get(color));
        print(s);
        out.print(colors.get(null));
    }

    /* Cette methode permet d'aller a la ligne.  */
    public void newline() {
        out.println();
    }

    /* Cette methode insere une espace.  */
    public void space() {
        out.print(" ");
    }

    public void close() {}
}
