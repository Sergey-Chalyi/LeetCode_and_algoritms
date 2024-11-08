class Solution(object):
    def longestCommonPrefix(self, strs: list) -> str:
        """
        :type strs: List[str]
        :rtype: str
        """
        final_prefix = ''
        max_possible_prefix = min(strs)
        
        for i in range(len(max_possible_prefix)):
            possible_prefix = max_possible_prefix[:(i + 1)]
            flag = True
            for word in strs:
                if word[:(i + 1)] != possible_prefix:
                    flag = False
                    break
            if not flag:
                break
            else:
                final_prefix = possible_prefix
        
        return final_prefix
            
            
print(Solution().longestCommonPrefix(["dog","racecar","car"]))            
