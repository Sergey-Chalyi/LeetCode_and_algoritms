from typing import List


class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        for i in range(len(nums) + 1):
            if i not in nums:
                return i
    
    def missingNumber(self, nums: List[int]) -> int:
        full_set = {i for i in range(len(nums) + 1)} 
        return (full_set - set(nums)).pop()
    
    def missingNumber(self, nums: List[int]) -> int:
        return sum([i for i in range(len(nums) + 1)]) - sum(nums)

print(Solution().missingNumber([0, 1, 3]))