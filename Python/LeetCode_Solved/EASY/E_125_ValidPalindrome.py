import re


class Solution:
    def isPalindrome(self, string: str) -> bool:
        only_letters_string = re.sub(r'[^a-zA-Z0-9]+', '', string)
        only_letters_string = only_letters_string.lower()
        return only_letters_string == only_letters_string[::-1]

print(Solution().isPalindrome('0P'))
    
