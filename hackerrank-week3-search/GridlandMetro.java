import java.util.*;

public class GridlandMetro {
    public static void main(String[] args) {
        //don t forget when you copy to hackerran you need to change it to long m and n !!!!!!!!
        Scanner scanner = new Scanner(System.in);
        long n=scanner.nextInt();
        long m = scanner.nextInt();
        long k = scanner.nextInt();

        HashMap<Long, List<ArrayList<Long>>> map = new HashMap<>();

        long total = n * m;
        for(int p=0; p<k; p++) {
            long r = scanner.nextInt();
            long c1 = scanner.nextInt();
            long c2 = scanner.nextInt();
            boolean isTrue = false;
            //if it contains the key and c2 is not before the c1 and c1 is not after c2
            //then we can check if new c2 is bigger than old c2 we are changing the c2
            //same is for c1 if it is smaller than old c1 new c1 is c1
            //else it is not bettwen any interval we just add to do list of intervals which is at line 25
            //if r is contains a key than we don't need to go along
            //we are just changing isTrue to true
            //if it doesn't contain the key then it will proceed the line 48 because isTrue is false ->!isTrue = True
            if(map.containsKey(r)) {
                List<ArrayList<Long>> list = map.get(r);
                for (int i = 0; i < list.size(); i++) {
                    //one of the c1 and c2 is out of the array
                    if (!(c2 < list.get(i).get(0) || c1 > list.get(i).get(1))) {
                        if (c2 > list.get(i).get(1)) {
                            list.get(i).set(1, c2);
                        }
                        if (c1 < list.get(i).get(0)) {
                            list.get(i).set(0, c1);
                        }
                    } else {
                        ArrayList<Long> list2 = new ArrayList<>();
                        list2.add(c1);
                        list2.add(c2);
                        list.add(list2);
                        break;
                    }
                }
                isTrue = true;
            }
            if(!isTrue) {
                ArrayList<Long> arrList = new ArrayList<>();
                arrList.add(c1);
                arrList.add(c2);
                List<ArrayList<Long>> listOfList = new ArrayList<>();
                listOfList.add(arrList);
                map.put(r, listOfList);
            }
        }
        // System.out.println(map.get(1));
        for(long key : map.keySet()) {
            List<ArrayList<Long>> list = map.get(key);
            for(List<Long> ls : list) {
                total -= (long)ls.get(1) - (long)ls.get(0) + 1;
            }
        }

        System.out.println(total);
        scanner.close();
    }


    private static int[] getElements(String elements, int size) {

        String[] elementsArray = elements.trim().split(" ");

        if (elementsArray.length != size)
            throw new IllegalArgumentException("Number of elements in the list does not match the size provided");

        int[] numbers = new int[size];
        int index = 0;

        // extract integers
        for (String ele : elementsArray) {
            numbers[index++] = Integer.parseInt(ele);
        }
        return numbers;
    }

    static int gridlandMetro(int n, int m, int k, int[][] track) {
        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
        int total = n * m;
        for(int[] position : track) {
            int r = position[0];
            int c1 = position[1];
            int c2 = position[2];

            if(map.get(r) == null) {
                List<List<Integer>> list = new ArrayList<>();
                List<Integer> l1 = new ArrayList<>();
                l1.add(c1);
                l1.add(c2);
                list.add(l1);
                map.put(r, list);
            } else {
                List<List<Integer>> list = map.get(r);

                boolean isTrue = true;
                for (int i=0; i<list.size(); i++) {

                    if (c1 <= list.get(i).get(0) && c2 >= list.get(i).get(0) && isTrue) {
                        list.get(i).set(0, c1);
                        isTrue = false;

                    }

                    if(c2 >= list.get(i).get(1) && c1 <= list.get(i).get(1) && isTrue) {
                        list.get(i).set(1, c2);
                        isTrue = false;
                    }
                    if(c1 >= list.get(i).get(0) && c1 <= list.get(i).get(1) && c2 >=list.get(i).get(0) && c2 <= list.get(i).get(1) && isTrue) {
                        isTrue = false;
                    }
                }
                System.out.println(list);
                if(isTrue) {
                    List<Integer> l1 = new ArrayList<>();
                    l1.add(c1);
                    l1.add(c2);
                    list.add(l1);
                    map.put(r, list);
                }

            }
        }
       // System.out.println(map.get(1));
        for(int key : map.keySet()) {
            List<List<Integer>> list = map.get(key);
            for(List<Integer> ls : list) {
                total -= ls.get(1) - ls.get(0) + 1;
            }
        }

        return total;
    }


}
