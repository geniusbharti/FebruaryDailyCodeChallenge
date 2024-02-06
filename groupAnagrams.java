class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //edge case
        if(strs == null || strs.length == 0) return new ArrayList<>();

        //main logic
        Map<String, List<String>> mpp =new HashMap<>();
        for(int i=0; i<strs.length; i++){
            int[] ch = new int[26];
            for(char c: strs[i].toCharArray()) ch[c-'a']++;
            String key = Arrays.toString(ch);
            if(!mpp.containsKey(key)) mpp.put(key, new ArrayList<>());
            mpp.get(key).add(strs[i]);
        }
        return new ArrayList<>(mpp.values());
    }
}
