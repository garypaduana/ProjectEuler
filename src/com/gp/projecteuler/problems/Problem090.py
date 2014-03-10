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

import itertools
import datetime

def main():   
    start = datetime.datetime.now()
    select_from_set = set()
    for i in range(0, 10):
        select_from_set.add(str(i))
        
    squares = [str(i**2).zfill(2) for i in range(1, 10)]
    valid_sets = set()
    
    for die1 in itertools.combinations(select_from_set, 6):
        for die2 in itertools.combinations(select_from_set, 6):
            m = makes_all_squares(set(die1), set(die2), squares, False)
            
            if(m):
                valid_sets.add(frozenset({frozenset(die1), frozenset(set(die2))}))
                    
    print "Answer:", len(valid_sets)
    print "Duration:", (datetime.datetime.now() - start)

def makes_all_squares(die1, die2, squares, swapped):
    found = True
    for square in squares:
        if not ((square[0] in die1 and square[1]  in die2) or
                (square[0] in die2 and square[1]  in die1)):
            found = False

        if not found and not swapped:
            if '6' in die1:
                die1.add('9')
            if '9' in die1:
                die1.add('6')
            if '6' in die2:
                die2.add('9')
            if '9' in die2:
                die2.add('6')
            return makes_all_squares(die1, die2, squares, True)
    return found

if __name__ == "__main__":
    main()

























