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

import datetime

def generatingFunction(n):
    return 1 - n + n**2 - n**3 + n**4 - n**5 + n**6 - n**7 + n**8 - n**9 + n**10

def OP(k, n, generatingFunction):
    """
        We shall define OP(k, n, generatingFunction) to be the nth
        term of the optimum polynomial generating function for the
        first k terms of a sequence produced by generatingFunction.
    """
    x = range(1, k + 1)
    fx = [generatingFunction(xi) for xi in x]
    
    sum = 0
    for i in range(len(x)):
        val = fx[i]
        for j in range(len(x)):
            if(i == j):continue
            val *= float(n - x[j]) / float(x[i] - x[j])
        sum += val
    return sum    
           
def main():
    start = datetime.datetime.now()
    sum = 0
    for x in range(1, 11):
        sum += OP(x, x+1, generatingFunction)
        
    print "Answer:", str(sum)
    print "Duration:", (datetime.datetime.now() - start)

if __name__ == "__main__":
    main()
