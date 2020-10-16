public class ToggleSwitch {

    private static volatile ToggleCondition condition = ToggleCondition.OFF;

    public static ToggleCondition getCondition() {
        return condition;
    }

    public void setCondition(ToggleCondition condition) {
        ToggleSwitch.condition = condition;
    }

    static public enum ToggleCondition {
        ON, OFF
    }


}