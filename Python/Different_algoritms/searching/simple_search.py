from typing import List

def simple_search(nums: List[int], el: int) -> int|None:
    """Returns index of the needed element"""
    for i in range(len(nums)):
        cur_el = nums[i]
        if cur_el == el:
            return i
        
    return None

print(simple_search([1,2,3,4,5,6], 2))