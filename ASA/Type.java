package ASA;

public class Type {
    private String name;

    /*
     * La dimension : 0 si ce n'est pas un tableau, 1 si c'est un
     * tableau de dimension 1, etc.  Par exemple pour int[][] le nom
     * sera int et la dimension sera 2
     */
    private int dimension;

    public Type(String name, int dimension) {
        this.name = name;
        this.dimension = dimension;
    }

    public Type(String name) {
        this.name = name;
        dimension = 0;
    }

    public String getName() {
        return name;
    }

    public int getDimension() {
        return dimension;
    }
}
