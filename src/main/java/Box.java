import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Box {
    private double width;
    private double height;
    private double depth;

    Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    double getWidth() {
        return this.width;
    }

    @Override
    public String toString() {
        return "Box." + width;
    }
}


class Main5 {
    static List<Box> boxes = new ArrayList<>(
        List.of(
                new Box(11, 20, 30),
                new Box(30, 1, 4),
                new Box(31, 60, 80),
                new Box(9, 35, 16),
                new Box(70, 80, 11)
        )
    );
    static List<Box> largeBoxes = new ArrayList<>();

    public static void filterBoxes(List<Box> boxes) {
        Iterator<Box> iterator = boxes.iterator();
        while(iterator.hasNext()) {
            Box box = iterator.next();
            if (box.getWidth() > (double) 30) {
                iterator.remove();
                largeBoxes.add(box);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(boxes);               // [Box.11.0, Box.30.0, Box.31.0, Box.9.0, Box.70.0]
        System.out.println(largeBoxes);          // []
        filterBoxes(boxes);
        System.out.println(boxes);               // [Box.11.0, Box.30.0, Box.9.0]
        System.out.println(largeBoxes);          // [Box.31.0, Box.70.0]
    }
}
