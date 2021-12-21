package academy.learnprogramming;

public class Lights {
    private Switch lightSwitch;
    private boolean working;

    public Lights(Switch lightSwitch, boolean working) {
        this.lightSwitch = lightSwitch;
        this.working = working;
    }

    public Switch getLightSwitch() {
        return lightSwitch;
    }

    public boolean isWorking(Switch lightSwitch) {
        if (lightSwitch.isStatus()) {
            return working = true;
        } else {
            return working;
        }
    }

    public void turnOnLights(boolean working) {
        if (lightSwitch.isStatus()) {
            System.out.println("Lights are turned on");
            System.out.println("The lights are working");
        }
    }
}
