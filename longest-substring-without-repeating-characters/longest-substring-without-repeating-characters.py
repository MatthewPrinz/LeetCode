class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        char_to_index = {}
        max_len = 0
        for i, char in enumerate(s):
            if char not in char_to_index.keys():
                char_to_index[char] = i
                max_len = len(char_to_index) if len(char_to_index) > max_len else max_len
            else:
                new_char_to_index = {}
                for k, v in char_to_index.items():
                    if v >= char_to_index[char]:
                        new_char_to_index[k] = v
                new_char_to_index[char] = i
                char_to_index = new_char_to_index
        return max_len
            