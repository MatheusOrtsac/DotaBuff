package steps;

import dotabuffprojeto.DriveFactory;
import dotabuffprojeto.DriverType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;


public class Hooks {
    public static Scenario currentScenario;
    @Before
    public void abriNavegador() {
        DriveFactory.getInstance().setDriver(DriverType.CHROME);

    }
    @After
    public void quitDrive() {
        DriveFactory.getInstance().quitDrive();
    }
    @BeforeStep
    public Scenario currentScenario(Scenario scenario){
        currentScenario = scenario;
        return scenario;
    }
}