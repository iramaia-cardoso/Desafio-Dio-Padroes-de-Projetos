package one.digitalinnovation.gof.singleton;

/**
 * Singleton "preguiçoso"
 */
public class SingletonLaze {
    private static SingletonLaze instancia;

    private SingletonLaze() {
        super();
    }

    public static SingletonLaze getInstancia() {
        if (instancia == null) {
            instancia = new SingletonLaze();
        }
        return instancia;
    }
}
