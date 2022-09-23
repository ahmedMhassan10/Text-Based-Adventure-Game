import java.util.Random;
import java.util.Scanner;

public class Build {
    public static int random_damage(int n) {
        Random r = new Random();
        return r.nextInt(n);
    }

    public static void build(Direction direction, Player player, Monster m1, Monster m2) throws InterruptedException {
        int time = 2000;

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("HP\t\t" + player.getHp() + "\n\n");
            if (direction == direction.South) {
                if (m1.isIs_defeted() && m2.isIs_defeted()) {
                    System.out.println("Congratulations you defeat the 2 monsters\n\nNow you can enter the town\n\n");
                    return;
                }
                System.out.println(
                        "You are at the gate of the town\n\nA guard is standing in front of you\n\nWhat will you do?\n\n");
                System.out.println("1-Talk to the guard.\n\n");
                System.out.println("2-Attack the guard.\n\n");
                System.out.println("3- Go to cross road.\n\nMake your choice: ");
                int input = scanner.nextInt();
                if (input == 1) {
                    System.out.println(
                            "Guard: Hell stranger. I have never seen your face.\n\nTo enter our town you must kill the monsters.\n\n");
                    Thread.sleep(time);
                    build(Direction.South, player, m1, m2);
                } else if (input == 2) {
                    System.out.println("Guard: Hey don`t be stubid!\n\nThe guard hit you\n\n");
                    System.out.println("You received 3 damage\n\n");
                    player.recive_damage(3);
                    if (player.isIs_defeted()) {
                        System.out.println("End\n\nYou loss the Game.\n\n");
                        return;
                    } else {
                        Thread.sleep(time);
                        build(Direction.South, player, m1, m2);
                    }
                } else if (input == 3) {
                    build(Direction.Cross, player, m1, m2);

                } else {
                    throw new Exception();
                }
            } else if (direction == Direction.North) {
                System.out.println("There is a river\n\nYou drink the water and rest\n\nYou resives 2 Hp.\n\n");
                player.setHp(player.getHp() + 2);
                Thread.sleep(time);
                build(Direction.Cross, player, m1, m2);
            } else if (direction == Direction.West) {
                if (m1.isIs_defeted()) {
                    System.out.println("Congratulations\n\n");
                    System.out.println("You defeated this monster\n\n");
                    Thread.sleep(time);
                    build(Direction.Cross, player, m1, m2);
                } else if (player.isIs_defeted()) {
                    System.out.println("End\n\nYou loss the Game.\n\n");
                    return;
                } else {
                    System.out.println("Monster Hp is: " + m1.getHp() + "\n\n");
                    System.out.println("1-Fight\n\n2-Run\n\nMake your choice :");
                    int input = scanner.nextInt();
                    try {
                        if (input == 1) {
                            int st = random_damage(m1.getMax_damage()), en = random_damage(player.getMax_damage());
                            m1.recive_damage(en);
                            player.recive_damage(st);
                            System.out.println(
                                    "You give the monster damage: " + en + "\n\nIts Hp is : " + m1.getHp() + "\n\n");
                            System.out.println(
                                    "You received damage: " + st + "\n\nIts Hp is : " + player.getHp() + "\n\n");
                            Thread.sleep(time);
                            build(Direction.West, player, m1, m2);
                        } else if (input == 2) {
                            build(Direction.Cross, player, m1, m2);

                        } else {
                            build(Direction.West, player, m1, m2);

                        }
                    } catch (Exception e) {
                        build(Direction.West, player, m1, m2);
                    }
                }
            } else if (direction == Direction.East) {
                if (m2.isIs_defeted()) {
                    System.out.println("Congratulations\n\n");
                    System.out.println("You defeated this monster\n\n");
                    Thread.sleep(time);
                    build(Direction.Cross, player, m1, m2);
                } else if (player.isIs_defeted()) {
                    System.out.println("End\n\nYou loss the Game.\n\n");
                    return;
                } else {
                    System.out.println("Monster Hp is: " + m2.getHp() + "\n\n");
                    System.out.println("1-Fight\n\n2-Run\n\nMake your choice :");
                    int input = scanner.nextInt();
                    try {
                        if (input == 1) {
                            int st = random_damage(m2.getMax_damage()), en = random_damage(player.getMax_damage());
                            m2.recive_damage(en);
                            player.recive_damage(st);
                            System.out.println(
                                    "You give the monster damage: " + en + "\n\nIts Hp is : " + m2.getHp() + "\n\n");
                            System.out.println(
                                    "You received damage: " + st + "\n\nIts Hp is : " + player.getHp() + "\n\n");
                            Thread.sleep(time);
                            build(Direction.East, player, m1, m2);
                        } else if (input == 2) {
                            build(Direction.Cross, player, m1, m2);

                        } else {
                            build(Direction.East, player, m1, m2);
                        }
                    } catch (Exception e) {
                        build(Direction.East, player, m1, m2);
                    }
                }
            } else if (direction == Direction.Cross) {
                System.out.println("You are at crossroad.\n\n\n");
                System.out.println("1-Go North\n\n2-Go South\n\n3-Go West\n\n4-Go East\n\nMake your choice :");
                int input = scanner.nextInt();
                try {
                    if (input == 1) {
                        build(Direction.North, player, m1, m2);
                    } else if (input == 2) {
                        build(Direction.South, player, m1, m2);
                    } else if (input == 3) {
                        build(Direction.West, player, m1, m2);
                    } else if (input == 4) {
                        build(Direction.East, player, m1, m2);
                    } else
                        throw new Exception();
                } catch (Exception e) {
                    build(Direction.Cross, player, m1, m2);
                }
            }
        } catch (Exception e) {
            build(Direction.South, player, m1, m2);
        }

    }
}