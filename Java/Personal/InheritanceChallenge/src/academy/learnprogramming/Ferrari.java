package academy.learnprogramming;

public class Ferrari extends Car{
    private int driftSpeed;
    private String turboMode;

    public Ferrari(String fuel, String size, String color, int doors, int wheels, boolean isManual, String handSteering, int gears, int speed, int driftSpeed, String turboMode) {
        super(fuel, size, color, doors, wheels, isManual, handSteering, gears, speed);
        this.driftSpeed = driftSpeed;
        this.turboMode = turboMode;
    }

    public String getHandSteering() {
        return super.getHandSteering();
    }

    @Override
    public int getGears() {
        return super.getGears();
    }

    @Override
    public int getSpeed() {
        return super.getSpeed();
    }

    @Override
    public void handSteering() {
        super.handSteering();
    }

    @Override
    public void theGears() {
        super.theGears();
    }

    @Override
    public void carSpeed() {
        super.carSpeed();

    }

    public void drift(int driftSpeed) {
        System.out.println("The car is drifting at " + driftSpeed + " mph");
    }

    public void turbo(String turboMode) {
        switch (turboMode) {
            case "On":
                System.out.println("Turbo mode is on");
                break;

            case "Off":
                System.out.println("Turbo mode is off");
                break;

            default:
                break;
        }
    }
}
