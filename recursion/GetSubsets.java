import java.util.ArrayList;

public class GetSubsets {

    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<Integer>();

        for(int i = 0; i < args.length; i++)
            set.add(Integer.parseInt(args[i]));

        ArrayList<ArrayList<Integer>> powerset = getSubsets(set);

        System.out.println("Set: " + set);
        System.out.println("Subsets:");

        for(int i = 0; i < powerset.size(); i++)
            System.out.println(powerset.get(i));
    }

    /* Write a method to return all subsets of a set
     */
    public static ArrayList<ArrayList<Integer>> getSubsets(
        ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> powerset = new 
            ArrayList<ArrayList<Integer>>();
        getSubsets(set, subset, powerset, 0, set.size());
        return powerset;
    }

    public static void getSubsets(
        ArrayList<Integer> set, ArrayList<Integer> subset, 
        ArrayList<ArrayList<Integer>> powerset, int i, int rem) {
        if(rem == 0) {
            ArrayList<Integer> newset = new ArrayList<Integer>();
            newset.addAll(subset);
            powerset.add(newset);
            return;
        }

        subset.add(set.get(i));
        getSubsets(set, subset, powerset, i + 1, rem - 1);
        subset.remove(subset.size() - 1);
        getSubsets(set, subset, powerset, i + 1, rem - 1);
    }
}
