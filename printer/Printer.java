package printer;

import java.util.*;

public interface Printer {
    public void print(String s);

    public void print(String s, Color color);

    public void newline();

    public void space();

    public void close();
}
