from typing import List

class Solution:
    def minimum_sum_subarray(self, nums: List[int], l: int, r: int) -> int:
        min_sum = None
        is_min_changed = False

        for subarray_len in range(l, r + 1):
            start_point = 0
            finish_point = subarray_len

            while finish_point <= len(nums):
                cur_sum = sum(nums[start_point : finish_point])

                if cur_sum > 0:
                    if is_min_changed:
                        if min_sum > cur_sum:
                            min_sum = cur_sum
                    else:    
                        is_min_changed = True
                        min_sum = cur_sum

                start_point += 1
                finish_point += 1

        if is_min_changed:
            return min_sum
        else:
            return -1
        

print(Solution().minimumSumSubarray([3, -2, 1, 4], 2, 3))

        