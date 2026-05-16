class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        //通过字母频率看窗口
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        //统计初始窗口每个字母频率
        for (int i=0; i < s1.length(); i++)
        {
            count1[s1.charAt(i) -  'a']++;
            count2[s2.charAt(i) - 'a']++;

        }

        if(Arrays.equals(count1, count2)) return true;

        //sliding window
        //从s1长度的位置（窗口右边的新字符）开始，一直到s2末尾
        for (int i = s1.length(); i < s2.length(); i++)
        {
            //右边进：窗口右边加入一个新字符
            count2[s2.charAt(i) - 'a']++;
            //左边出：窗口左边移出一个新字符
            count2[s2.charAt(i - s1.length()) - 'a']--;

            //每次滑动后检查
            if (Arrays.equals(count1, count2)) return true;

        }
        return false;
    }
}
