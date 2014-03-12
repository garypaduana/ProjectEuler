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

import itertools
import math

def fuzz(num, ran):
    '''
        num is a list of numbers
        ran is a range to apply to each end on the natural number line
        
        fuzz finds all permutations of length len(num) with the addition
        of nearby numbers to produce a larger result with greater 'spread',
        hence 'fuzz'.  It's used to look for optimum sets when the
        near-optimum set has been calculated as a starting point.  Expand
        the ran value as necessary to find the optimum set.
    '''
    # creates array of array initialized to all 0 as place holder.
    # e.g. num = [1,2,3]; ran = 2
    # cart =    [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]]
    # filled = [[-1, 0, 1, 2, 3], [0, 1, 2, 3, 4], [1, 2, 3, 4, 5]]
    cart = [[0 for x in range(ran * 2 + 1)] for x in range(len(num))]
    
    x1 = 0
    for x in range(-ran, ran + 1):
        y1 = 0
        for y in num:
            cart[y1][x1] = y + x
            y1 += 1
        x1 += 1
    
    for x in itertools.product(*cart):
        yield x

def nextPattern(pattern):
    ''' Computes a near-optimal set for the next n given an optimal 
        set for the current n. See docs for S(x) for context.
    '''
    new = []
    b = pattern[len(pattern)/2]
    new.append(b)
    [new.append(x+b) for x in pattern]
    return new
   
def S(x):
    '''
        Let S(x) represent the sum of elements in set x of size n.
        If S(x) is minimised for a given n, we shall call it an
        optimum special sum set.
    '''
    sum = 0
    for ax in x:
        sum += ax
    return sum
           
def areDisjointed(a, b):
    '''
        Determines if a and b are disjointed sets of elements
    '''
    s = set()
    [s.add(ax) for ax in a]
    [s.add(bx) for bx in b]
    return len(s) == len(a) + len(b)
 
def difference(a, b):
    c = []
    [c.append(ax) for ax in a]
    for bx in b:
        try:
            c.remove(bx)
        except ValueError:
            pass
    for i in range(1, len(c) + 1):
        for com in itertools.combinations(c, i):
            yield com

def areRulesTrue(a):
    for i in range(1, len(a) + 1):
        for b in itertools.combinations(a, i):
            cn = difference(a, b)
            for c in cn:
                sb = S(b)
                sc = S(c)
                if(sb == sc):
                    return False
                if(len(b) > len(c)):
                    if(sb <= sc):
                        return False
    return True

# Sieve of Eratosthenes
# Code by David Eppstein, UC Irvine, 28 Feb 2002
# http://code.activestate.com/recipes/117119/

def gen_primes():
    """ Generate an infinite sequence of prime numbers.
    """
    # Maps composites to primes witnessing their compositeness.
    # This is memory efficient, as the sieve is not "run forward"
    # indefinitely, but only as long as required by the current
    # number being tested.
    #
    D = {}  

    # The running integer that's checked for primeness
    q = 2  

    while True:
        if q not in D:
            # q is a new prime.
            # Yield it and mark its first multiple that isn't
            # already marked in previous iterations
            # 
            yield q        
            D[q * q] = [q]
        else:
            # q is composite. D[q] is the list of primes that
            # divide it. Since we've reached q, we no longer
            # need it in the map, but we'll mark the next 
            # multiples of its witnesses to prepare for larger
            # numbers
            # 
            for p in D[q]:
                D.setdefault(p + q, []).append(p)
            del D[q]

        q += 1
        
def isPrime(num):
    for i in range(2, int(math.sqrt(num))):
        if num % i == 0:
            return False
    return True
