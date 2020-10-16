public class StupidBox implements Runnable {

    private final ToggleSwitch toggleSwitch = new ToggleSwitch();

    public void checkToggleCondition() {
        if (ToggleSwitch.getCondition() == ToggleSwitch.ToggleCondition.ON) {
            System.out.println(getName() + " set Toggle OFF, the box is CLOSED");
            toggleSwitch.setCondition(ToggleSwitch.ToggleCondition.OFF);
        }
    }

    private String getName() {
        return Thread.currentThread().getName();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            checkToggleCondition();
        }
    }



}