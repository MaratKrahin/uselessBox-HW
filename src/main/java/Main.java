public class Main {
    public static void main(String[] args) {

        final ToggleSwitch gameStartToggle = new ToggleSwitch();
        final User user = new User(gameStartToggle);
        final StupidBox stupidBox = new StupidBox(gameStartToggle, user);

        Thread userThread = new Thread(user, "user");
        Thread boxThread = new Thread(stupidBox, "box");

        userThread.start();
        boxThread.start();

        try {
            userThread.join();
            boxThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("DON'T TOUCH THE BOX! GAME OVER!");
        }
    }
}