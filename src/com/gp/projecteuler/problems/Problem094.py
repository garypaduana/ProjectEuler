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

    x_table = dict()
    x_table[1] = (5,5,6,16)
    x_table[2] = (65,65,66,196)
    x_table[3] = (901,901,902,2704)
    x_table[4] = (12545,12545,12546,37636)
    
    y_table = dict()
    y_table[1] = (16,17,17,50)
    y_table[2] = (240,241,241,722)
    y_table[3] = (3360,3361,3361,10082)
    y_table[4] = (46816,46817,46817,140450)

    case = 5
    while(x_table[len(x_table)][3] < 1000000000):
        x_table[case] = find_case(case, x_table, "x_table")
        case += 1

    case = 5
    while(y_table[len(y_table)][3] < 1000000000):
        y_table[case] = find_case(case, y_table, "y_table")
        case += 1

    for key in x_table.iterkeys():
        if(x_table[key][3] <= 1e9):
            perimeter_sum += x_table[key][3]

    for key in y_table.iterkeys():
        if(y_table[key][3] <= 1e9):
            perimeter_sum += y_table[key][3]

    print "Answer:", perimeter_sum
    print "Duration:", (datetime.datetime.now() - start)

def find_case(case, table, ab):
    n = 15 * table[case-1][0] - 15 * table[case-2][0] + table[case-3][0]
    if(ab == "x_table"):
        tup = (n, n+1, n+1, (3*n+2))
    elif(ab == "y_table"):
        tup = (n, n, n+1, (3*n+1))
    return tup   
    
def ranger(lower, upper):
    num = lower - 1
    while num < (upper - 1):
        num += 1
        yield num
    
    
if __name__ == "__main__":
    main()

