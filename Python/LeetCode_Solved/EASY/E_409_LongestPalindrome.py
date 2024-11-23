class Solution:
    def longestPalindrome(self, string: str) -> int:
        dict_with_chars = {}
        for char in string:
            if char not in dict_with_chars:
                dict_with_chars[char] = 1
            else:
                dict_with_chars[char] += 1
        
        final_palindrome_len = 0
        temp_list = []
        for char in dict_with_chars:
            char_count = dict_with_chars[char]
            if char_count % 2 == 0:
                final_palindrome_len += char_count
            else:
                temp_list.append(char_count)

        if len(temp_list) > 0:
            for count in temp_list:
                if count // 2 > 0:
                    final_palindrome_len += (count // 2) * 2
            final_palindrome_len += 1
        
        return final_palindrome_len
