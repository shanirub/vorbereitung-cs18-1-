public class Launcher {

    public static void main (String args[]) {
        View view = new View();

        Controller controller = new Controller();
        controller.initialise(view);

        view.initialise(controller);

    }
}
