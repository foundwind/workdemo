package leecode;

import java.util.HashMap;
import java.util.Map;

public class Demo391 {

    public static void main(String[] args) {
        int[] liebiao = {
                0, 1, 2, 4, 6, 8, 10, 12, 14, 16, 18, 21, 24, 27, 30, 34, 38, 42, 46, 49, 52, 55, 58, 61, 64, 67, 70, 73, 76, 79, 82, 86, 90, 94, 98, 102, 106, 110, 114, 119, 124, 129, 134, 139, 144, 149, 154, 160, 166, 172, 178, 182, 186, 190, 194, 198, 202, 206, 210, 214, 218, 222, 226, 230, 234, 238, 242, 246, 250, 254, 258, 262, 266, 270, 274, 278, 282, 286, 290, 295, 300, 305, 310, 315, 320, 325, 330, 335, 340, 345, 350, 355, 360, 365, 370, 376, 382, 388, 394, 400, 406, 412, 418, 424, 430, 436, 442, 448, 454, 460, 466, 473, 480, 487, 494, 501, 508, 515, 522, 529, 536, 543, 550, 555, 560, 565, 570, 575, 580, 585, 590, 595, 600, 605, 610, 615, 620, 625, 630, 635, 640, 645, 650, 655, 660, 666, 674, 680, 686, 692, 698, 703, 708, 713, 718, 723, 728, 733, 738, 743, 748, 753, 758, 763, 768, 773, 778, 783, 788, 793, 798, 803, 808, 813, 818, 823, 828, 833, 838, 843, 848, 853, 858, 863, 868, 873, 878, 883, 888, 893, 898, 904, 910, 916, 922, 928, 934, 940, 946, 952
        };

    }

    public boolean isRectangleCover(int[][] rectangles) {
        Map<Point, Integer> map = new HashMap<>();
        int lxM = rectangles[0][0];
        int lyM = rectangles[0][1];
        int rxM = rectangles[0][2];
        int ryM = rectangles[0][3];
        int area = 0;
        for (int i = 0; i < rectangles.length; i++) {
            int lx = rectangles[i][0];
            int ly = rectangles[i][1];
            int rx = rectangles[i][2];
            int ry = rectangles[i][3];
            area += (rx - lx) * (ry - ly);
            lxM = Math.min(lxM, lx);
            lyM = Math.min(lyM, ly);
            rxM = Math.max(rxM, rx);
            ryM = Math.max(ryM, ry);

            Point point1 = new Point(lx, ly);
            Point point2 = new Point(rx, ry);
            Point point3 = new Point(lx, ry);
            Point point4 = new Point(rx, ly);
            map.put(point1, map.getOrDefault(point1, 0) + 1);
            map.put(point2, map.getOrDefault(point2, 0) + 1);
            map.put(point3, map.getOrDefault(point3, 0) + 1);
            map.put(point4, map.getOrDefault(point4, 0) + 1);
        }
        Point point1 = new Point(lxM, lyM);
        Point point2 = new Point(rxM, ryM);
        Point point3 = new Point(lxM, ryM);
        Point point4 = new Point(rxM, lyM);
        if (area != (rxM - lxM) * (ryM - lyM)
                || map.getOrDefault(point1, 0) != 1
                || map.getOrDefault(point2, 0) != 1
                || map.getOrDefault(point3, 0) != 1
                || map.getOrDefault(point4, 0) != 1
        ) return false;
        map.remove(point1);
        map.remove(point2);
        map.remove(point3);
        map.remove(point4);

        for (Integer value : map.values()) {
            if (value != 2 || value != 4)
                return false;
        }
        return true;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return x + y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point point2 = (Point) obj;
            return this.x == point2.x && this.y == point2.y;
        }
        return false;
    }
}


