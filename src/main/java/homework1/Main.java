package homework1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
        obstacles.add(new Wall(1));
        obstacles.add(new Wall(4));
        obstacles.add(new Treadmill(20));
        obstacles.add(new Treadmill(127));
        obstacles.add(new Treadmill(900));
        obstacles.add(new Wall(8));

        ArrayList<Runnable> participantsRun = new ArrayList<Runnable>();
        participantsRun.add(new Cat("Barsik", 100, 3));
        participantsRun.add(new Cat("Musya", 59, 5));
        participantsRun.add(new Human("Vitya", 1000, 5));
        participantsRun.add(new Human("Yura", 579, 7));
        participantsRun.add(new Robot("RG124", 1400, 20));
        participantsRun.add(new Robot("KL08-34", 967, 13));

        ArrayList<Jumpable> participantsJump = new ArrayList<Jumpable>();
        participantsJump.add(new Cat("Barsik", 100, 3));
        participantsJump.add(new Cat("Musya", 59, 5));
        participantsJump.add(new Human("Vitya", 1000, 5));
        participantsJump.add(new Human("Yura", 579, 7));
        participantsJump.add(new Robot("RG124", 1400, 20));
        participantsJump.add(new Robot("KL08-34", 967, 13));

        for (int i = 0; i < participantsJump.size(); i++) {
            for (int j = 0; j < obstacles.size(); j++) {
                if (obstacles.get(j).getClass() == Wall.class) {
                    if (!participantsJump.get(i).jump(obstacles.get(j).getLength())) {
                        break;
                    }
                }
                if (obstacles.get(j).getClass() == Treadmill.class) {
                    if (!participantsRun.get(i).run(obstacles.get(j).getLength())) {
                        break;
                    }
                }
            }
        }
    }
}