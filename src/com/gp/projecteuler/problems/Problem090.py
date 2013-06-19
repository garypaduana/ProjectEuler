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

def main():
    select_from_set = set()
    for i in range(0, 10):
        select_from_set.add(str(i))

    needed = set()
    [needed.add(x) for x in select_from_set]
    needed.remove('7')

    print select_from_set
        
    squares = [str(i**2).zfill(2) for i in range(1, 10)]
    print squares
    last_count = -1
    valid_sets = set()
    
    for die1 in itertools.combinations(select_from_set, 6):
        print die1
        die2_needed = set(needed)
        for num in die1:
            die2_needed.discard(num)

        #print "die1:", die1, "die2_needed:", die2_needed
        how_many = 6 - len(die2_needed)

        for die2_perm in itertools.combinations(select_from_set.difference(die2_needed), how_many):
            #print "die2_perm:", die2_perm
            m = makes_all_squares(set(die1), set(die2_perm).union(die2_needed), squares, False)
            
            if(m):
                valid_sets.add(frozenset({frozenset(die1), frozenset(set(die2_perm).union(die2_needed))}))
                if(last_count != len(valid_sets)):
                    print len(valid_sets), die1, set(die2_perm).union(die2_needed)
                    last_count = len(valid_sets)

def makes_all_squares(die1, die2, squares, swapped):
    #"die1:", die1, "die2:", die2, "squares:", squares, "swapped:", swapped
    found = True
    for square in squares:
        if not ((square[0] in die1 and square[1]  in die2) or
                (square[0]  in die2 and square[1]  in die1)):
            #print "cannot find:", square
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

























