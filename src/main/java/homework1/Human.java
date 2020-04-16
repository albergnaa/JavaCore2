package homework1;

public class Human implements Runnable, Jumpable {

    private String name;
    private int maxDistance;
    private int maxHigh;

    public Human(String name, int maxDistance, int maxHigh) {
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxHigh = maxHigh;
    }

    public boolean jump(int high) {
        boolean check = false;
        if (high <= maxHigh) {
            check = true;
            System.out.println(name + " jumps successfully");
        } else {
            check = false;
            System.out.println(name + " can't jump");
        }
        return check;
    }

    public boolean run(int distance) {
        boolean check = false;
        if (distance <= maxDistance) {
            check = true;
            System.out.println(name + " runs successfully");
        } else {
            check = false;
            System.out.println(name + " can't run");
        }
        return check;
    }
}
