# Runtime: 124 ms, faster than 50.07% of Python3 online submissions for Snakes and Ladders.
# Memory Usage: 14.3 MB, less than 82.74% of Python3 online submissions for Snakes and Ladders.
class java00002.m01.Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:

        l = len(board)
        def next(square: int) -> (int, int):
            row, col = (square - 1) // l, (square - 1) % l
            if row % 2 == 1:
                col = l - 1 - col
            if row > l - 1 :
                return -1, -1
            return l - 1 - row, col


        seam = set()
        q = deque([(1, 0)])

        while q:
            square, steps = q.popleft()
            for i in range(1, 6 + 1):
                next_square = square + i

                position_x, position_y = next(next_square)

                if position_x != -1 and board[position_x][position_y] != -1 :
                    next_square = board[position_x][position_y]

                if next_square == l * l:
                    return steps + 1

                if next_square not in seam:
                    seam.add(next_square)
                    q.append((next_square, steps + 1))

        return -1