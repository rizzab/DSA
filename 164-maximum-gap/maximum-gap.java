class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2)
            return 0;
        int n = nums.length;
        int max = nums[0], min= nums[0];
        for(int i  : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int bucketSize = (max - min)/(n - 1);
        if(bucketSize == 0)
            bucketSize++;
        int totalBuckets = ((max - min)/bucketSize) + 1;
        int[] minBucket = new int[totalBuckets];
        int[] maxBucket = new int[totalBuckets];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        for(int i = 0 ; i < n ; i++) {
            int index = (nums[i] - min)/bucketSize;
            minBucket[index] = Math.min(minBucket[index], nums[i]);
            maxBucket[index] = Math.max(maxBucket[index], nums[i]);
        }
        int prevMax = maxBucket[0], result = 0;
        for(int i = 1; i < totalBuckets; i++) {
            if(minBucket[i] == Integer.MAX_VALUE)
                continue;
            result = Math.max(result, minBucket[i] - prevMax);
            prevMax = maxBucket[i];
        }
        return result;
    }
}