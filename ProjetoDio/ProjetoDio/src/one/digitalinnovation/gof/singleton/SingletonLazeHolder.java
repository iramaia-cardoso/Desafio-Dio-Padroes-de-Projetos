package one.digitalinnovation.gof.singleton;

/**
 * "Lazy Holder-encapisula a instancia"
 */
public class SingletonLazeHolder {
    private static class InstanciaHolder {
        public static SingletonLazeHolder instancia = new SingletonLazeHolder();
    }

    private SingletonLazeHolder() {
        super();
    }

    public static SingletonLazeHolder getInstancia() {
        return InstanciaHolder.instancia;
    }

}
