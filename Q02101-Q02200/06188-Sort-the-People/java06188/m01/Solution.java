package java06188.m01;

/**
 * @Description:
 * @Author: alton_z
 * @Create Date Time: 2022-09-25 14:10
 * @Update Date Time: 2022-09-25 14:10
 * @Updated-By: alton_z
 * @Update-Location:
 */
class Solution {

    class Pair implements Comparable<Pair>
    {
        public String name;
        int age;
        public Pair(String name, int age) //constructor
        {
            this.name = name;
            this.age = age;
        }
        public int compareTo(Pair other) //making it only compare a2 values
        {
            return other.age - this.age;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {

        Pair[] help = new Pair[names.length];

        for (int i = 0; i < names.length; i++) {
            help[i] = new Pair(names[i], heights[i]);
        }

        Arrays.sort(help);

        String[] res = new String[names.length];
        for(int i = 0; i < names.length; i++) {
            res[i] = help[i].name;
        }

        return res;
    }
}

