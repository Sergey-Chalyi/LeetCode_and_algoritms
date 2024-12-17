from typing import List

def binary_search(nums: List[int], el: int) -> int | None:
    low = 0
    high = len(nums) - 1
    
    while low <= high:
        mid = (low + high) // 2
        cur_el = nums[mid]

        if cur_el < el:
            low = mid + 1
        elif cur_el > el:
            high = mid - 1
        else: 
            return mid
        
    return None

print(binary_search([1,2,3,4,5,6], 7))