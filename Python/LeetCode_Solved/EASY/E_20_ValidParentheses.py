class Solution:
    def isValid(self, brackets_string: str) -> bool:
        if len(brackets_string) % 2 != 0 or len(brackets_string) == 0:
            return False
        if not self.isCorrectBranchesCount(brackets_string):
            return False

        brackets_list = []
        for i in range(len(brackets_string)):
            current_bracket = brackets_string[i]
            if self.isOpenBracket(current_bracket):
                brackets_list.append(current_bracket)
            else:
                if len(brackets_list) == 0:
                    return False
                previous_bracket = brackets_list[-1]
                if self.isClosedBracked(previous_bracket, current_bracket):
                    brackets_list.pop()
                else:
                    return False
        
        return len(brackets_list) == 0

    def isCorrectBranchesCount(self, brackets_string: str) -> bool:
        if brackets_string.count('(') != brackets_string.count(')'):
            return False
        if brackets_string.count('{') != brackets_string.count('}'):
            return False
        if brackets_string.count('[') != brackets_string.count(']'):
            return False
        return True

    def isOpenBracket(self, bracket: str) -> bool:
        return bracket in ['(', '{', '[']

    def isClosedBracked(self, previous_bracket: str, current_bracket: str) -> bool:
        breckets = {
            '{' : '}',
            '[' : ']',
            '(' : ')',
        }
        return breckets[previous_bracket] == current_bracket

print(Solution().isValid('(){}}{'))