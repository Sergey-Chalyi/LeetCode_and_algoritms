from typing import List

def quick_sort(nums: List[int]) -> List[int]:
    if len(nums) <= 1:
        return nums
    else:
        pivot_el = nums[0]
        larger_els = [el for el in nums[1:] if el >= pivot_el]
        smaller_els = [el for el in nums[1:] if el < pivot_el]

        return quick_sort(smaller_els) + [pivot_el] + quick_sort(larger_els)


import random, time

def quick_sort2(nums: List[int]) -> List[int]:
    if len(nums) <= 1:
        return nums
    else:
        pivot_el = random.choice(nums)
        larger_els = [el for el in nums[1:] if el >= pivot_el]
        smaller_els = [el for el in nums[1:] if el < pivot_el]

        return quick_sort(smaller_els) + [pivot_el] + quick_sort(larger_els)

start_time = time.time()
print(quick_sort2([3,6,1,78,2,2]))
print('total time =', time.time() - start_time)