'''
Given a positive integer num, return true if num is a perfect square or false otherwise.

A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.

You must not use any built-in library function, such as sqrt.


Example 1:

Input: num = 16
Output: true
Explanation: We return true because 4 * 4 = 16 and 4 is an integer.

Example 2:

Input: num = 14
Output: false
Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.
'''

class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        low = 1
        high = num

        while low <= high:
            mid = (low + high) // 2
            multiplication = mid * mid
            if multiplication == num:
                return True
            elif multiplication > num:
                high = mid
            else:
                low = mid
        return False
    
    def isPerfectSquare2(self, num: int) -> bool:
        cur_nun = 1
        while True:
            mult = cur_nun ** 2 
            if mult == num:
                return True
            elif mult < num:
                cur_nun += 1
            else:
                return False

