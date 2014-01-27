public class Paths {

    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("You need to enter X and Y coordinates.");
            System.exit(1);
        }

        long x = Long.parseLong(args[0]);
        long y = Long.parseLong(args[1]);

        System.out.println("Number of ways from (0, 0) to (" + x + ", " + y +
            "): " + numPaths1(x, y));
        System.out.println("Number of ways from (0, 0) to (" + x + ", " + y +
            "): " + numPaths2(x, y));
    }

    /* Imagine a robot sitting on the upper left corner of an X by Y grid. The
     * robot can only move in two directions: right and down. How many
     * possible paths are there for the robot to go from (0,0) to (X, Y)?
     */
    public static long numPaths1(long x, long y) {
        if(x < 0 || y < 0)
            return 0;

        if(x == 0 || y == 0)
            return 1;

        return numPaths1(x-1, y) + numPaths1(x, y-1);
    }

    // Solution using combinatorics
    public static long numPaths2(long x, long y) {
        return fact(x + y) / (fact(x) * fact(y));
    }

    public static long fact(long n) {
        long r = 1;

        while(n > 1) {
            r *= n;
            n--;
        }

        return r;
    }

    /* Imagine certain spots are "off limits", such that the robot cannot
     * step on them. Design an algorithm to find a path for the robot from 
     * the top left to the bottom right.
     */
     public static boolean getPath(int x, int y, LinkedList<Point> path) {
        Point p = new Point(x, y);
        path.add(p);

        if(x == 0 && y == 0)
            return true;

        boolean success = false;

        if(x >= 1 && isFree(x-1, y))
            success = getPath(x-1, y, path);

        if(!success && y >= 1 && isFree(x, y-1))
            success = getPath(x, y-1);

        if(!success)
            path.remove(p);

        return success;
     }

     // Using dynamic programming to improve performance
     public static boolean getPath2(int x, int y, LinkedList<Point> path, 
        HashMap<Point, Boolean> cache) {
        Point p = new Point(x, y);

        if(cache.containsKey(p))
            return cache.get(p);

        path.add(p);

        if(x == 0 && y == 0)
            return true;

        boolean success = false;

        if(x >= 1 && isFree(x - 1, y))
            success = getPath2(x - 1, y, path, cache);

        if(!success && y >= 1 && isFree(x, y - 1))
            success = getPath2(x, y - 1, path, cache);

        if(!success)
            path.remove(p);

        cache.put(p, success);
        return success;
    }
}
