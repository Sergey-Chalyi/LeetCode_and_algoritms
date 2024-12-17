def print_nums(num: int) -> None:
    if num < 0:
        print('all the nums have printed!')
    else:
        print(num)
        print_nums(num - 1)

def factorial(num: int):
    if num == 1:
        return 1
    else:
        return num * factorial(num - 1)


from typing import List

def get_array_sum_recursion(nums: List[int]) -> int:
    if len(nums) == 0:
        return 0
    else:
        return nums[0] + get_array_sum_recursion(nums[1:])


import math

def get_max_heigh(width: int, heigh: int) -> int:
    if math.modf(width / heigh)[0] == 0:
        return heigh
    else:
        return get_max_heigh(heigh, width - heigh * (width // heigh))

# print(get_max_heigh(400, 640))

def get_list_count(nums: List[int]) -> int:
    if len(nums) == 0:
        return 0
    else:
        return 1 + get_list_count(nums[1:])

# print(get_list_count([1,2,3,4]))

def get_max_num(nums:List[int]) -> int:
    if len(nums) == 1:
        return nums[0]
    elif len(nums) == 2:
        return nums[0] if nums[0] > nums[1] else nums[1]
    else:
        return nums[0] if nums[0] > get_max_num(nums[1:]) else get_max_num(nums[1:])

# print(get_max_num([1,2,32,4,5]))  

def binary_search_recursion(nums: List[int], el: int, low: int, high: int) -> int|None:
    if low <= high:
        mid = (low + high) // 2
        cur_el = nums[mid]
        
        if cur_el == el:
            return mid
        elif cur_el < el:
            return binary_search_recursion(nums, el, mid + 1, high)
        else:
            return binary_search_recursion(nums, el, low, mid - 1)
    else:
        return None

print(binary_search_recursion([1,2,3,4,5], 6, 0, 4))
