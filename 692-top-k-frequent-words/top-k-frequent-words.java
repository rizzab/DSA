class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Min-heap: If frequency equal, use lexicographical reverse order
        Queue<String> q = new PriorityQueue<>((w1, w2) -> 
            map.get(w1).equals(map.get(w2)) 
                ? w2.compareTo(w1) 
                : map.get(w1) - map.get(w2)
        );

        for (String word : map.keySet()) {
            q.add(word);
            if (q.size() > k) {
                q.poll(); // remove least frequent or lexicographically larger
            }
        }

        List<String> result = new ArrayList<>();
        while (!q.isEmpty()) {
            result.add(q.poll());
        }

        // Reverse to get most frequent first
        Collections.reverse(result);
        return result;
    }
}
