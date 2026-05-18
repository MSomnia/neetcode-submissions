class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // step 1: count the frequency
        Map<Integer, Integer> count = new HashMap<>();
        for(int n:nums)
        {
            if(count.containsKey(n))
            {
                count.put(n, count.get(n)+1);
            }
            else
            {
                count.put(n, 1);
            }
        }

        // step 2: sort by frequency
        // put all frequencies into a new list for sorting
        List<Integer> keys = new ArrayList<>(count.keySet());
        // using lambda to sort the list
        keys.sort( (a,b) -> count.get(b) - count.get(a));

        // step 3: get first k items
        int[] result = new int[k];
        for (int i=0; i<k; i++)
        {
            result[i] = keys.get(i);
        }

        return result;
    }
}
