package academy.learnprogramming;

import javax.management.monitor.Monitor;

public class PC {
    private Case theCase;
    private theMonitor monitors;
    private Motherboard motherboard;

    public PC(Case theCase, theMonitor monitors, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitors = monitors;
        this.motherboard = motherboard;
    }

    public void powerUp() {
        getTheCase().pressPowerButton();
        drawLogo();
    }

    public void drawLogo() {
        //Fancy graphics
        getMonitor().drawPixelAt(1000, 800, "Yellow");
        // or monitor.drawPixelAt();
    }

    public Case getTheCase() {
        return theCase;
    }

    public theMonitor getMonitor() {
        return monitors;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }
}
