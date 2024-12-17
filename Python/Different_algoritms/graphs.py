from collections import deque

def find_saller(graph: dict) -> str:
    search_queue = deque(graph)
    cheacked_people = []
    while len(search_queue) > 0:
        person = search_queue.popleft()
        if person[-1] == '*':
            return person
        else:
            if person not in cheacked_people:
                search_queue += graph[person]
                cheacked_people.append(person)
            
    return None


people = {}
people['me'] = ['Bob', 'Alisa', 'Cler']
people['Bob'] = ['Peggi', 'Angela']
people['Alisa'] = ['Peggi']
people['Cler'] = ['Tom', 'Djonni']
people['Peggi'] = []
people['Angela'] = []
people['Tom'] = []
people['Djonni'] = []

print(find_saller(people))