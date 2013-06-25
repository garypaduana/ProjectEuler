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
from decimal import *

def main():
    """
        It is easily proved that no equilateral triangle exists with
        integral length sides and integral area. However, the almost
        equilateral triangle 5-5-6 has an area of 12 square units.

        We shall define an almost equilateral triangle to be a
        triangle for which two sides are equal and the third differs
        by no more than one unit.

        Find the sum of the perimeters of all almost equilateral
        triangles with integral side lengths and area and whose
        perimeters do not exceed one billion (1,000,000,000).
    """
    start = datetime.datetime.now()
    sum = 0
    perimeter_sum = 0
    side = 1
    
    for i in ranger(2, 1000000):
        if(i % 10000000 == 0):
            print i, "Duration:", (datetime.datetime.now() - start)
        
        a = Decimal(i+1)
        b = Decimal(i)
        p = Decimal((a*2+b)/Decimal(2.))
        area1 = (p*(p-a)*(p-b)*(p-a))**(Decimal(1)/Decimal(2))
        
        a = i-1
        b = i
        p = (a*2+b)/2.
        area2 = (p*(p-a)*(p-b)*(p-a))**(1./2.)
        
        if area1 == int(area1) and area1 != 0.0:
            print (i+1),(i+1),i, area1
            perimeter_sum += (i + 1) + (i + 1) + i
        if area2 == int(area2) and area2 != 0.0:
            print (i-1),(i-1),i, area2
            perimeter_sum += (i - 1) + (i - 1) + i

    print perimeter_sum
    print "Duration:", (datetime.datetime.now() - start)

def ranger(lower, upper):
    num = lower - 1
    while num < (upper - 1):
        num += 1
        yield num
    
    
if __name__ == "__main__":
    main()

