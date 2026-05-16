class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s:strs)
        {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i<str.length())
        {
            int j = str.indexOf("#", i);    //j = position of current #
            int len = Integer.parseInt(str.substring(i, j));  //get the length
            result.add(str.substring(j+1, j+1+len));  //extract the string
            i = j+1+len;    //pointer move to the next string
        }
        return result;
    }
}
