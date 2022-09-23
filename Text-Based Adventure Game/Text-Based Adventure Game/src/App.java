
public class App {

    public static void main(String[] args) throws Exception {
        Monster monster1 = new Monster(3);
        Monster monster2 = new Monster(4);
        Player player = new Player(6);
        Build.build(Direction.South, player, monster1, monster2);
    }
}
