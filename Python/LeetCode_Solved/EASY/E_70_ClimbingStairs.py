import math


class Solution:
    def climbStairs(self, steps_count: int) -> int:
        if steps_count == 0:
            return 0
        elif steps_count == 1:
            return 1
        elif steps_count == 2:
            return 2
        
        count_of_variation = 1 # when we do all 1 steps

        if steps_count % 2 == 0:
            count_of_variation += 1 # when we do all 2 steps
            count_of_1 = 2
        else:
            count_of_1 = 2
        
        count_of_2 = (steps_count - count_of_1) // 2 
        
        while count_of_2 >= 1:
            count_of_variation += self.get_variation_count(count_of_2, count_of_1)
            count_of_1 += 2
            count_of_2 -= 1
        
        
        return int(count_of_variation)

    
    def get_variation_count(self, count_of_2: int, count_of_1: int) -> int:
        return math.factorial(count_of_2 + count_of_1)/((math.factorial(count_of_2) * math.factorial(count_of_1)))
        
            
        