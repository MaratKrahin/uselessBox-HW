public class User implements Runnable {
    private final ToggleSwitch toggleSwitch = new ToggleSwitch();

    public void setToggleSwitch() {
        try {
            int waitTime = 2000;
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " set Toggle ON, the box is OPEN");
        toggleSwitch.setCondition(ToggleSwitch.ToggleCondition.ON);
    }

    private String getName() {
        return Thread.currentThread().getName();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            setToggleSwitch();
        }
    }


}