public class StupidBox implements Runnable {

    private final ToggleSwitch myToggleSwitch;
    final User user;

    public StupidBox(ToggleSwitch toggleSwitch, User user) {
        this.myToggleSwitch = toggleSwitch;
        this.user = user;
    }

    public void switchOff() {
        synchronized (myToggleSwitch) {
            try {
                while (!ToggleSwitch.getCondition()) {
                    myToggleSwitch.wait();
                }
                myToggleSwitch.setCondition(false);
                System.out.println("Toggle OFF, the box is CLOSED");

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            this.switchOff();
        }

    }


}