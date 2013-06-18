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

    print select_from_set
        
    squares = [i**2 for i in range(1, 10)]
    print squares

    valid_sets = set()
    
    for perm in itertools.permutations(select_from_set, 6):
        if('6' in perm and '9' not in perm):
            perm = perm + tuple('9')
        elif('9' in perm and '6' not in perm):
            perm = perm + tuple('6')
         
        # for this permutation, find minimum matching set
        other = set()
        for square in squares:
            found = True
            
            s = str(square)
            if(square < 10):
                s = "0" + str(square)
                
            if(s[0] in perm):
                other.add(s[1])
            elif(s[1] in perm):
                other.add(s[0])
            else:
                found = False
                break

        if(len(other) > 6 or found == False):
            continue

        # minimum set found, if 2nd die has fewer than 6 sides
        # determined already, find all permutations to fill
        # in the gaps.  These are rather meaningless and just filler.

        difference = select_from_set.difference(other)

        for diff_perm in itertools.permutations(difference, (6 - len(other))):
            other_modified = set()
            [other_modified.add(o) for o in other]
                        
            for additional_num in diff_perm:
                other_modified.add(additional_num)
                
            #print "die 1:", perm, "die 2:", other_modified
            valid_sets.add(frozenset({frozenset(perm), frozenset(other_modified)}))
    print len(valid_sets)

    for s in valid_sets:
        print s
    
if __name__ == "__main__":
    main()
