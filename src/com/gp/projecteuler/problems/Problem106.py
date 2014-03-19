'''
    Project Euler Solutions
    Copyright (C) 2012-2014, Gary Paduana, gary.paduana@gmail.com
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

import sys
sys.path.append('../')
import CommonPy
import datetime
import itertools

class Pair:    
    def __init__(self, b, c):
        self.b = b
        self.c = c
    def __str__(self):
        return str(self.__dict__)
    def __eq__(self, other): 
        return (self.b == other.b and self.c == other.c) or \
               (self.b == other.c and self.c == other.b)
    def __hash__(self):
        return hash(self.b) ^ hash(self.c)   
    
def main():
    start = datetime.datetime.now()    
    x = [1,2,3,4,5,6,7,8,9,10,11,12]
    checkNeededCount = checkFirstRuleCount(x)
    print "Answer:", str(checkNeededCount)
    print "Duration:", (datetime.datetime.now() - start)

def checkFirstRuleCount(a):
    '''
        returns the count of how many times rule 1 *needs* to be checked
        for a given set of n strictly increasing numbers, assuming rule 2
        has already been satisfied.  See the problem for details.
    '''
    checkCount = 0
    pairs = set()
    for i in range(1, len(a) + 1):
        for b in itertools.combinations(a, i):
            cn = CommonPy.difference(a, b)
            for c in cn:
                pairs.add(Pair(b, c))
    print 'total pairs:', len(pairs)
    for pair in pairs:      
        # Conditions for which an equality check is not required:
        if(len(pair.b) != len(pair.c)):
            continue
        if(len(pair.b) == 1 or len(pair.c) == 1):
            continue
        if(areAllLower(pair.b, pair.c)):
            continue
        checkCount += 1           
    return checkCount

def areAllLower(b, c):
    '''
        returns true if all elements of 'b' are less than all
        elements of 'c' when sorted and compared using equal indexes.
    '''
    bs = sorted(b)
    cs = sorted(c)
    bLowerCount = 0
    for i in range(0, len(b)):
        if(bs[i] < cs[i]):
            bLowerCount += 1
    return bLowerCount == len(bs)

if __name__ == '__main__':
    main()
