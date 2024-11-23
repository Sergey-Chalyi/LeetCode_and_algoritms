from pyparsing import nums


class Solution:
    def mySqrt(self, num: int) -> int:
        left, right = 0, num

        while left <= right:
            middle = left + ((left + right) // 2)
            if middle * middle < num:
                left = middle
            elif middle * middle > num:
                right = middle
            else:
                return middle
        return middle