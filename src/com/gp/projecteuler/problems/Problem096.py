def main():
    board = []
    board.append(map(int, "003020600"))
    board.append(map(int, "900305001"))
    board.append(map(int, "001806400"))
    board.append(map(int, "008102900"))
    board.append(map(int, "700000008"))
    board.append(map(int, "006708200"))
    board.append(map(int, "002609500"))
    board.append(map(int, "800203009"))
    board.append(map(int, "005010300"))

def check(board):
    tot = 0
    blocks = [[0,3,0,3],
    for x in range(0, 3):
        for y in range(0, 3):
            tot += board[x][y]
    if board[

if __name__ == "__main__":
    main()
