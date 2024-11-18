from pickle import LONG_BINGET
from typing import List
from pyparsing import nums


class Solution:
    def merge(self, nums1: List[int], n1_count: int, nums2: List[int], n2_count: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        if n1_count == 0:
            if n2_count == 0:
                return
            else:
                for i in range(len(nums1)):
                    nums1[i] = nums2[i]
                return
        elif n2_count == 0:
            return
        
        longer_array = nums1 if n1_count > n2_count else nums2
        nums1_index = 0
        for i in range(len(longer_array)):
            element = longer_array[i]
            # if element == nums1[nums1_index]:
            #     nums1_index += 1
            #     continue            
            nums1_index = self.modify_array(nums1, nums1_index, element)

    
    def modify_array(self, array_to_modify: List[int], index: int, number_to_add: int) -> int:
        if array_to_modify[index] >= number_to_add:
            for i in range(len(array_to_modify) - 1, index, -1):
                array_to_modify[i], array_to_modify[i - 1] = array_to_modify[i - 1], array_to_modify[i]
            array_to_modify[index] = number_to_add
            return index + 1
        elif array_to_modify[index] < number_to_add:      
            for i in range(len(array_to_modify) - 1, index + 1, -1):
                array_to_modify[i], array_to_modify[i - 1] = array_to_modify[i - 1], array_to_modify[i]
            array_to_modify[index + 1] = number_to_add
            return index + 1

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        last_index = len(nums1) - 1

        while m > 0 and n > 0:
            if nums1[m - 1] > nums2[n - 1]:
                nums1[last_index] = nums1[m - 1]
                m -= 1
            else:
                nums1[last_index] = nums2[n - 1]
                n -= 1
            last_index -= 1
        
        while n > 0:
            nums1[last_index] = nums2[n - 1]
            n -= 1
            last_index -= 1



nums1 = [1,2,3,0,0,0]
m = 3
nums2 = [2,5,6]
n = 3
Solution().merge(nums1, m, nums2, n)
print(nums1)