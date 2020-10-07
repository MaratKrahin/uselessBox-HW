public class User implements Runnable {

    private final ToggleSwitch toggleSwitch;

    public User(ToggleSwitch toggleSwitch) {
        this.toggleSwitch = toggleSwitch;
    }

    public synchronized void switchOn() {
        synchronized (toggleSwitch) {
            toggleSwitch.setCondition(true);
            System.out.println("Toggle ON, the box is OPEN");
            toggleSwitch.notify();
        }
    }

    public void run() {
        int iterCount = 3 + (int) (Math.random() * 10);
        for (int i = 0; i < iterCount; i++) {
            this.switchOn();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}