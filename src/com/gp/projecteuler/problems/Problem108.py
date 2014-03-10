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
import math

def main():
    start = datetime.datetime.now()
    
    max = 0
    i = 1
    while True:
        i = pows(i)
        th = len(divisors(i*i))
        if(th > max):
            max = th
            print i, max  
    
    print "Answer:", "NOT YET SOLVED!"
    print "Duration:", (datetime.datetime.now() - start)  

def pows(last):
    return last * 2

def divisors(num):
    divs = []
    divs.append(num)
    for i in range(1, (num / 2) + 1):
        if(num % i == 0):
            divs.append(i)
    return sorted(divs)

if __name__ == '__main__':
    main()
