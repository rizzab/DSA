class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> queue =new LinkedList<>();
        for(int i=deck.length-1;i>=0;i--){
            if(!queue.isEmpty()){
                queue.addFirst(queue.removeLast());
            }
            queue.addFirst(deck[i]);
        }
        int index=0;
        for(int n:queue){
            deck[index++]=n;
        }
        return deck;
    }
}