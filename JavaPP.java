import java.util.*;
import java.io.*;
import java_cup.runtime.Symbol;
import ASA.*;
import printer.*;
import parseur.*;

public class JavaPP {
    private Printer printer;
    private boolean color;
    private int depth;

    private JavaPP(Printer printer, boolean color) {
        this.printer = printer;
        this.color = color;
        depth = 0;
    }

    private void printVar(String name) {
        if (color)
            printer.print(name, Color.BROWN);
        else
            printer.print(name);
    }

    private void printDecl(Type t, String x, Expression e) {
        print(t);
        printer.space();
        printVar(x);
        if (e != null) {
            printer.space();
            printer.print("=");
            printer.space();
            print(e);
        }
    }

    private void print(DeclarationVariable var) {
        printDecl(var.getType(), var.getName(), var.getValue());
    }

    private void print(Instruction statement) {
        if (statement instanceof BlocInstructions)
            print((BlocInstructions) statement);
        if (statement instanceof Commentaire)
            print((Commentaire) statement);
        if (statement instanceof DeclarationVariable) {
            print((DeclarationVariable) statement);
            endStatement();
        }
        if (statement instanceof Expression) {
            print((Expression) statement);
            endStatement();
        }
        if (statement instanceof ForInstruction)
            print((ForInstruction) statement);
        if (statement instanceof IfInstruction)
            print((IfInstruction) statement);
        if (statement instanceof WhileInstruction)
            print((WhileInstruction) statement);
    }

    private void println(Instruction statement) {
        print(statement);
        printer.newline();
    }

    private void print(DeclarationChamp decl) {
        printQualifiers(decl.getQualifiers());
        printDecl(decl.getType(), decl.getName(),decl.getValue());
        endStatement();
    }

    private void print(CorpsClasse component) {
        if (component instanceof Commentaire) {
            print((Commentaire) component);
            printer.newline();
        } else {
            if (component instanceof BlocInstructions)
                print((BlocInstructions) component);
            if (component instanceof DeclarationChamp)
                print((DeclarationChamp) component);
            if (component instanceof DeclarationMethode)
                print((DeclarationMethode) component);
            blankLine();
        }
    }

    private void printQualifiers(List<String> keywords) {
        for (String keyword : keywords) {
            if (color)
                printer.print(keyword, Color.PURPLE);
            else
                printer.print(keyword);
            printer.space();
        }
    }

    private void print(Type t) {
        String name = t.getName();
        int dim = t.getDimension();

        if (color)
            printer.print(name, Color.GREEN);
        else
            printer.print(name);
        for (int i = 0; i < dim; i++)
            printer.print("[]");
    }

    private void print(Argument arg) {
        printDecl(arg.getType(), arg.getName(), null);
    }

    private void print(Programme prog) {
        printPackage(prog.getPack());
        printImports(prog.getImports());
        printComments(prog.getComments());
        print(prog.getDecl());
        printer.newline();
        printer.close();
    }

    private void print(Keyword keyword) {
        String k = keyword.toString();

        if (color)
            printer.print(k, Color.PURPLE);
        else
            printer.print(k);
    }

    private void printPackage(String name) {
        if (name != null) {
            print(Keyword.PACKAGE);
            printer.space();
            if (color)
                printer.print(name, Color.CYAN);
            else
                printer.print(name);
            endStatement();
            blankLine();
        }
    }

    private void printImports(List<String> imports) {
        for (String import_ : imports) {
            print(Keyword.IMPORT);
            printer.space();
            if (color)
                printer.print(import_, Color.CYAN);
            else
                printer.print(import_);
            endStatement();
            printer.newline();
        }
        if (!imports.isEmpty())
            printer.newline();
    }

    private void printComments(List<Commentaire> comments) {
        for (Commentaire comment : comments)
            println(comment);
    }

    private void print(Commentaire comment) {
        String commentStart = "/*";
        String commentEnd = "*/";
        String c = commentStart + comment.toString() + commentEnd;

        if (color)
            printer.print(c, Color.RED);
        else
            printer.print(c);
    }

    private void print(Expression expr) {
        String e = expr.toString();
        String ret = Keyword.RETURN + " ";

        if (e.startsWith(ret)) {
            print(Keyword.RETURN);
            printer.space();
            printer.print(e.substring(ret.length()));
        } else {
            printer.print(e);
        }
    }

    private void openBlock() {
        printer.print("{");
    }

    private void closeBlock() {
        printer.print("}");
    }

    private void print(IfInstruction instr) {
        BlocInstructions elseBlock = instr.getElseBlock();

        print(Keyword.IF);
        printer.space();
        printer.print("(" + instr.getCondition() + ")");
        printer.space();
        print(instr.getThenBlock());
        if (elseBlock != null) {
            printer.space();
            print(Keyword.ELSE);
            printer.space();
            print(elseBlock);
        }
    }

    private void print(WhileInstruction instr) {
        print(Keyword.WHILE);
        printer.space();
        printer.print("(" + instr.getCondition() + ")");
        printer.space();
        print(instr.getBody());
    }

    private void print(ForInstruction instr) {
        print(Keyword.FOR);
        printer.space();
        printer.print("(" + instr.getInit());
        endStatement();
        printer.space();
        print(instr.getCondition());
        endStatement();
        printer.space();
        printer.print(instr.getStep() + ")");
        printer.space();
        print(instr.getBody());
    }

    private void print(BlocInstructions b) {
        List<Instruction> l = b.getStatements();

        openBlock();
        depth++;
        if (l == null) {
            depth--;
        } else {
            printer.newline();
            for(Instruction i : l) {
                indent(depth);
                println(i);
            }
            indent(--depth);
        }
        closeBlock();
    }

    private void print(DeclarationMethode method) {
        List<Argument> args = method.getArgs();
        String name = method.getName();
        int argc = args.size();

        printQualifiers(method.getQualifiers());
        print(method.getReturnType());
        printer.space();
        if (color)
            printer.print(name, Color.BLUE);
        else
            printer.print(name);
        printer.print("(");
        for (int i = 0; i < argc; i++) {
            print(args.get(i));
            if (i + 1 < args.size()) {
                printer.print(",");
                printer.space();
            }
        }
        printer.print(")");
        printer.space();
        print(method.getBody());
    }

    private void blankLine() {
        printer.newline();
        printer.newline();
    }

    private void endStatement() {
        printer.print(";");
    }

    private void print(DeclarationClasseOuInterface class_) {
        List<String> interfaces = class_.getInterfaces();
        String parent = class_.getParent();

        printQualifiers(class_.getQualifiers());
        if (class_.isClass())
            print(Keyword.CLASS);
        else
            print(Keyword.INTERFACE);
        printer.space();
        print(new Type(class_.getName()));
        if (parent != null) {
            printer.space();
            print(Keyword.EXTENDS);
            printer.space();
            print(new Type(parent));
        }
        if (interfaces != null) {
            int n = interfaces.size();

            printer.space();
            print(Keyword.IMPLEMENTS);
            printer.space();
            for (int i = 0; i < n; i++) {
                print(new Type(interfaces.get(i)));
                if (i + 1 < interfaces.size()) {
                    printer.print(",");
                    printer.space();
                }
            }
        }
        printer.space();
        openBlock();
        blankLine();
        for (CorpsClasse member : class_.getBody()) {
            indent(++depth);
            print(member);
            depth--;
        }
        indent(depth);
        closeBlock();
    }

    private void indent(int depth) {
        int offset = depth << 2;

        for (int i = 0; i < offset; i++)
            printer.space();
    }

    public static void main(String[] args) {
        PrintStream out = System.out;
        String inFilename = null;
        String outFilename = null;
        boolean html = false;
        boolean color = false;

        for (int i = 0; i < args.length; i++)
            switch (args[i]) {
            case "-html":
                html = true;
                break;
            case "-color":
                color = true;
                break;
            case "-o":
                i++;
                if (i >= args.length) {
                    System.err.println("-o option needs an argument.");
                    System.exit(1);
                } else {
                    outFilename = args[i];
                }
                break;
            default:
                if (args[i].startsWith("-")) {
                    System.err.println("Invalid option " + args[i] + ".");
                    System.exit(1);
                } else {
                    inFilename = args[i];
                }
            }
        if (inFilename == null) {
            System.err.println("Please specify the file to format.");
            System.exit(1);
        }
        try {
            parseur.Scanner scanner;
            parser parser;
            Programme prog;
            Printer printer;

            if (outFilename != null)
                out = new PrintStream(outFilename);
            scanner = new parseur.Scanner(new FileReader(inFilename));
            parser = new parseur.parser(scanner);
            prog = (Programme) parser.parse().value;
            if (html)
                printer = new HTMLPrinter(out);
            else
                printer = new TerminalPrinter(out);
            (new JavaPP(printer, color)).print(prog);
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open file " + e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
