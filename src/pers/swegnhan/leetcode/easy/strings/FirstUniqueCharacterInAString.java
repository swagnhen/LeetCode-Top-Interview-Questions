package pers.swegnhan.leetcode.easy.strings;

class CharUnit{
    public int index;
    public int num;
}

public class FirstUniqueCharacterInAString {

    public static int firstUniqChar(String s) {
        CharUnit[] a = new CharUnit[256];
        for(int i = 0; i < 256; i++) {
            a[i] = new CharUnit();
            a[i].num = 0;
        }
        for(int i = 0; i < s.length(); i++){
            if(a[s.charAt(i)].num == 0)
                a[s.charAt(i)].index = i;
            a[s.charAt(i)].num++;
        }
        int min = s.length();
        for(int i = 0; i < 256; i++) {
            if(a[i].num == 1)
                min = Math.min(min, a[i].index);
        }
        if(min != s.length())
            return min;
        return -1;
    }

    public static void main(String[] args){
        System.out.println(firstUniqChar("abb"));
    }

}
