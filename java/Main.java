
public class Main {

    static String password = "pulvert05";

    public static void main(String[] args) {
        Model model = new Model(password);
        View view = new View();
        Controller controller = new Controller(model, view);
    }
}
