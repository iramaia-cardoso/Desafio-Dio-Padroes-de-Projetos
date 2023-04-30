package one.digitalinnovation.gof;

import one.digitalinnovation.gof.facade.Facade;
import one.digitalinnovation.gof.singleton.SingletonEager;
import one.digitalinnovation.gof.singleton.SingletonLaze;
import one.digitalinnovation.gof.singleton.SingletonLazeHolder;
import one.digitalinnovation.gof.strategy.Comportamento;
import one.digitalinnovation.gof.strategy.ComportamentoAgressivo;
import one.digitalinnovation.gof.strategy.ComportamentoDefensivo;
import one.digitalinnovation.gof.strategy.ComportamentoNormal;
import one.digitalinnovation.gof.strategy.Robo;

public class Test {
    public static void main(String[] args) {
        // Testes do Design Pattern Singlet
        SingletonLaze lazy = SingletonLaze.getInstancia();
        System.out.println(lazy);
        lazy = SingletonLaze.getInstancia();
        System.out.println(lazy);

        SingletonEager eager = SingletonEager.getInstancia();
        System.out.println(eager);
        eager = SingletonEager.getInstancia();
        System.out.println(eager);

        SingletonLazeHolder lazeHolder = SingletonLazeHolder.getInstancia();
        System.out.println(lazeHolder);
        lazeHolder = SingletonLazeHolder.getInstancia();
        System.out.println(lazeHolder);

        // Testes Strategy
        Comportamento defensivo = new ComportamentoDefensivo();
        Comportamento normal = new ComportamentoNormal();
        Comportamento agressivo = new ComportamentoAgressivo();

        Robo robo = new Robo();
        robo.setComportamento(normal);
        robo.mover();
        robo.mover();
        robo.setComportamento(defensivo);
        robo.mover();
        robo.setComportamento(agressivo);
        robo.mover();
        robo.mover();
        robo.mover();

        // Testes Facade
        Facade facade = new Facade();
        facade.migrarCliente("Maia", "40285850");

    }

}
