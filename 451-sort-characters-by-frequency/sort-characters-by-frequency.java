class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> charcount=new HashMap<>();
        for (char c:s.toCharArray()){
            charcount.put(c,charcount.getOrDefault(c,0)+1);
        }
        List<List<Character>> buckets=new ArrayList<>();
        for(int i=0;i<=s.length();i++){
            buckets.add(new ArrayList<>());
        }
        for(Map.Entry<Character,Integer> entry: charcount.entrySet()){
            char c =entry.getKey();
            int freq=entry.getValue();
            buckets.get(freq).add(c);
        }
        StringBuilder result = new StringBuilder();
        for(int freq = s.length();freq>0;freq--){
            for(char c:buckets.get(freq)){
                for(int i=0;i<freq;i++){
                    result.append(c);
                }
            }
        }
        return result.toString();
        
    }
}