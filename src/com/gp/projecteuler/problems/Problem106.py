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

import CommonPy
import datetime
import itertools
import re
import sys
sys.path.append('../')

def main():
    # INCOMPLETE!!
    
    lowest = 999999
    x = [3,5,6,7]
    if(areRulesTrue(x)):
        if(CommonPy.S(x) < lowest):
            print x
            lowest = CommonPy.S(x)
    
    print "Answer:", 'NOT YET SOLVED'
    print "Duration:", (datetime.datetime.now() - start)

def areRulesTrue(a):
    everLasting = True
    for i in range(1, len(a) + 1):
        for b in itertools.combinations(a, i):
            cn = CommonPy.difference(a, b)

            print b, [x for x in cn]
            for c in cn:
                sb = CommonPy.S(b)
                sc = CommonPy.S(c)
                if(sb == sc):
                    everLasting = False
                #if(len(b) > len(c)):
                #    if(sb <= sc):
                #       everLasting = False
    return everLasting

if __name__ == '__main__':
    main()
