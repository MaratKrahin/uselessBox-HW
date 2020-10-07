public class ToggleSwitch {

    volatile private static boolean condition;

    public static boolean getCondition() {
        return condition;
    }

    public void setCondition(boolean condition){
        ToggleSwitch.condition = condition;
    }


}