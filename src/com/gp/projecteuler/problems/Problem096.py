'''
    Project Euler Solutions
    Copyright (C) 2012-2013, Gary Paduana, gary.paduana@gmail.com
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
'''

def main():
    # INCOMPLETE!!!
    
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

if __name__ == "__main__":
    main()
