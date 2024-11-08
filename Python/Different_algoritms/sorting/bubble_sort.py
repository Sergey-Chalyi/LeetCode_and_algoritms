my_list = [5, 1, 3, 4, 7, -1]

def list_sort(my_list: list) -> None:
    for iteration_number in range(len(my_list) - 1):
        for i in range(len(my_list) - iteration_number - 1):
            if my_list[i] > my_list[i + 1]:
                my_list[i], my_list[i + 1] = my_list[i + 1] , my_list[i] 

list_sort(my_list)
print(my_list)
    
