package academy.learnprogramming;

public class PC {
    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp() {
        getTheCase().pressPowerButton();
        drawLogo();
    }

    private void drawLogo() {
        //Fancy graphics
        getMonitor().drawPixelAt(1000, 800, "Yellow");
        // or monitor.drawPixelAt();
    }

    public Case getTheCase() {
        return theCase;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }
}
