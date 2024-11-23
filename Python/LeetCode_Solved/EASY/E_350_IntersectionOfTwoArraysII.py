# Given two integer arrays nums1 and nums2, return an array of their intersection. 
# Each element in the result must appear as many times as it shows in both arrays 
# and you may return the result in any order.

from typing import Counter, List


class Solution:
    # my solution 
    def intersect2(self, nums1: List[int], nums2: List[int]) -> List[int]:
        final_array = []
        for num in set(nums1).intersection(set(nums2)):
            for _ in range(min(nums1.count(num), nums2.count(num))):
                final_array.append(num)
        return final_array
    
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        counter1 = Counter(nums1)
        counter2 = Counter(nums2)
        return list((counter1 & counter2).elements())


print(Solution().intersect([1,2,2,1], [2,2]))