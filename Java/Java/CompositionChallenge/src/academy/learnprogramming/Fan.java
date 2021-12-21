package academy.learnprogramming;

public class Fan {
    private Switch aSwitch;
    private boolean working;

    public Fan(Switch aSwitch, boolean working) {
        this.aSwitch = aSwitch;
        this.working = working;
    }

    public Switch getaSwitch() {
        return aSwitch;
    }

    public boolean isWorking(Switch aSwitch) {
        this.aSwitch = aSwitch;
        if (aSwitch.isStatus()) {
            return working = true;
        } else {
            return working;
        }
    }

    public void turnOnFan(boolean working) {
        if (aSwitch.isStatus()) {
            System.out.println("Fan is turned on");
            System.out.println("Fan is working");
        }
    }
}
