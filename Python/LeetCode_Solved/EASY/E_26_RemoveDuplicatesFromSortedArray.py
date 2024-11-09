from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        unique_nums_count = self.replace_unique_nums_to_start(nums)
        self.replace_ununique_nums_to_symbol(nums, unique_nums_count, '_')
        return unique_nums_count
    

    def replace_unique_nums_to_start(self, nums: List[int]) -> int:
        unique_nums_count = len(set(nums))
        unique_nums_index = 0

        for index in range(unique_nums_count):
            nums[index] = nums[unique_nums_index]
            for i in range(unique_nums_index + 1, len(nums)):
                if nums[i] != nums[index]:
                    unique_nums_index = i
                    break
        
        return unique_nums_count


    def replace_ununique_nums_to_symbol(self, nums: List[int], unique_nums_count: int, symbol: str) -> None:
        for i in range(unique_nums_count, len(nums)):
            nums[i] = symbol
        # print(nums)

print(Solution().removeDuplicates([1,1,2]))
print(Solution().removeDuplicates([0,0,1,1,1,2,2,3,3,4]))
