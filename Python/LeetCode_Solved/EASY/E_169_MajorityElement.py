# Given an array nums of size n, return the majority element.

# The majority element is the element that appears more than 
# ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

from typing import List
from collections import Counter

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        major_el = nums[0]
        major_el_count = nums.count(major_el)

        for el in set(nums):
            if nums.count(el) > major_el_count:
                major_el = el
                major_el_count = nums.count(el)

                if major_el_count > len(nums) / 2:
                    break

        return major_el 
    
    def majorityElement(self, nums: List[int]) -> int:
        elements = Counter(nums)
        for el in elements.keys():
            if elements[el] > len(nums) / 2:
                return el
