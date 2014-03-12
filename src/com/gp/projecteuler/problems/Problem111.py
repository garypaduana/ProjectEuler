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

import CommonPy
import datetime
import sys
sys.path.append('../')

def main():
    start = datetime.datetime.now()
    
    for i in range(int(1e9), int(1e9+100000)):
        if(CommonPy.isPrime(i)):
            print i
    
    
    print "Answer:", "NOT YET SOLVED!"
    print "Duration:", (datetime.datetime.now() - start)

def M(n, d):
    ''' represents the maximum number of repeated digits for an 
        n-digit prime where d is the repeated digit
        So M(4, 1) = 3 is the maximum number of repeated digits 
        for a 4-digit prime where one is the repeated digit
    '''
    pass

def N(n, d):
    ''' represents the number of such primes 
        there are N(4, 1) = 9 such primes
    '''
    pass

def S(n, d):
    ''' represents the sum of these primes
        the sum of these primes is S(4, 1) = 22275
    '''
    pass
    
if __name__ == '__main__':
    main()