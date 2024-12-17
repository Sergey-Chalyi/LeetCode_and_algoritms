from typing import List

def get_min_index(array: List[int]) -> int:
    min_el = array[0]
    min_el_index = 0
    for i in range(len(array)):
        cur_el = array[i]
        if cur_el < min_el:
            min_el = cur_el
            min_el_index = i
    return min_el_index

def selection_sort(array: List[int]) -> List[int]:
    sorted_final_array = []
    for i in range(len(array)):
        sorted_final_array.append(array.pop(get_min_index(array)))
    return sorted_final_array

print(selection_sort([12,2,3,4,5, 0]))
