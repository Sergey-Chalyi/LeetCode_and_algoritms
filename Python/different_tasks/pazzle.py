import os
from typing import List


class PuzzleSolver:
    def __init__(self, file_path: str) -> None:
        self.file_path = file_path
        self.puzzle = []

    def load_puzzle(self) -> None:
        abs_path = os.path.join(os.path.dirname(__file__), self.file_path)
        with open(abs_path, 'r') as file:
            self.puzzle = [line.strip() for line in file if line.strip().isdigit()]

    def find_longest_sequence(self) -> str:
        max_sequence = ""

        for start_idx in range(len(self.puzzle)):
            used = set()
            current_sequence = self.puzzle[start_idx]
            used.add(start_idx)

            while True:
                found = False
                for i in range(len(self.puzzle)):
                    if i not in used and current_sequence[-2:] == self.puzzle[i][:2]:
                        current_sequence += self.puzzle[i][2:]
                        used.add(i)
                        found = True
                        break
                if not found:
                    break

            if len(current_sequence) > len(max_sequence):
                max_sequence = current_sequence
            # elif 

        return max_sequence


if __name__ == "__main__":
    print(len('861460567673324651908163749226502497863284759586758823141707942517'))
    # solver = PuzzleSolver("figures.txt")
    # solver.load_puzzle()
    # longest_sequence = solver.find_longest_sequence()
    # print("Longest sequence:", longest_sequence)

