package printer;

import java.util.*;
import java.io.*;

public class HTMLPrinter implements Printer {
    /*
     * Ce champ contient le nom du fichier HTML dans lequel on souhaite
     * ecrire.
     */
    private PrintStream out;

    private static HashMap<Color, String> colors;

    static {
        colors = new HashMap<>();
        colors.put(Color.RED, "darkred");
        colors.put(Color.GREEN, "darkgreen");
        colors.put(Color.BROWN, "brown");
        colors.put(Color.BLUE, "darkblue");
        colors.put(Color.PURPLE, "purple");
        colors.put(Color.CYAN, "darkcyan");
    }

    private static String HTMLEscSeq(String s) {
        return "&" + s + ";";
    }

    /*
     * Cette methode permet de traduire une chaine de caracteres en HTML
     * en remplacant les caracteres speciaux HTML par leur code
     * correspondant en HTML.
     */
    private static final String escapeHTML(String s) {
        StringBuffer sb = new StringBuffer();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            String t;

            switch (c) {
            case '<':
                t = HTMLEscSeq("lt");
                break;
            case '>':
                t = HTMLEscSeq("gt");
                break;
            case '&':
                t = HTMLEscSeq("amp");
                break;
            case '"':
                t = HTMLEscSeq("quot");
                break;
                /*
                 * Be careful with this one (non-breaking white
                 * space).
                 */
            case ' ':
                t = HTMLEscSeq("nbsp");
                break;
            default:
                t = Character.toString(c);
            }
            sb.append(t);
        }
        return sb.toString();
    }

    /*
     * Le createur ouvre le fichier et met les balises initiales au
     * debut du fichier.
     */
    public HTMLPrinter(PrintStream out) {
        this.out = out;
        out.println("<!DOCTYPE html>");
        out.println("<html lang=en>");
        out.println("<head>");
        out.print("<meta charset=utf-8>");
        out.println("<title>JavaPP</title>");
        out.println("</head>");
        out.println("<body style=\"font-family: monospace; " +
                    "font-size: large\">");
    }

    /*
     * Cette fonction ecrit la chaine donnee en entree dans le fichier
     * file.
     */
    public void print(String s) {
        out.print(escapeHTML(s));
    }

    /*
     * Cette fonction ecrit en couleur la chaine donnee en entree dans
     * le fichier file.
     */
    public void print(String s, Color color) {
        out.print("<span style=\"color: " + colors.get(color) + "\">" +
                  escapeHTML(s) + "</span>");
    }

    /* Cette fonction permet d'aller a la ligne.  */
    public void newline() {
        out.println("<br>");
    }


    /* Cette fonction permet de mettre une espace.  */
    public void space() {
        out.print(escapeHTML(" "));
    }

    /*
     * Cette fonction doit etre appele pour finaliser l'ecriture dans le
     * fichier HTML. Elle met les balises de fin de fichiers et ferme le
     * fichier.
     */
    public void close() {
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
