public class Main {
    public static void main(String[] args) {

        final User user = new User();
        final StupidBox stupidBox = new StupidBox();

        Thread userThread = new Thread(user, "IVAN");
        Thread boxThread = new Thread(stupidBox, "TIGER BOX");

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