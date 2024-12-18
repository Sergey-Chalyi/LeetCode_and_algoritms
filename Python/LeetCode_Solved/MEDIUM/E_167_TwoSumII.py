# Given a 1-indexed array of integers numbers that is already sorted 
# in non-decreasing order, find two numbers such that they add up
# to a specific target number. Let these two numbers be 
# numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

# Return the indices of the two numbers, index1 and index2,
#  added by one as an integer array [index1, index2] of length 2.

# The tests are generated such that there is exactly one 
# solution. You may not use the same element twice.

# Your solution must use only constant extra space.

from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        first_pointer = 0
        last_pointer = len(nums) - 1
        while True:
            cur_sum = nums[first_pointer] + nums[last_pointer]

            if cur_sum == target:
                return [first_pointer + 1, last_pointer + 1]
            elif cur_sum < target:
                first_pointer += 1
            else:
                last_pointer -= 1
    
    def twoSum2(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums) - 1):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i + 1, j + 1]




