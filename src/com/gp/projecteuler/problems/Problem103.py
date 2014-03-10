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
import sys

sys.path.append('../')
 
def main():
    start = datetime.datetime.now()
    nMap = {1:[1],
            2:[1,2],
            3:[2,3,4],
            4:[3,5,6,7],
            5:[6,9,11,12,13],
            6:[11,18,19,20,22,25]}
 
    pp = CommonPy.nextPattern(nMap[6])
    
    lowest = 999999
    for x in CommonPy.fuzz(pp, 1):
        if(CommonPy.areRulesTrue(x)):
            if(CommonPy.S(x) < lowest):
                print "Tuple: " + str(x)
                print "Answer: " + ''.join([str(y) for y in x])
                print "Duration:", (datetime.datetime.now() - start)
                lowest = CommonPy.S(x)
  
if __name__ == "__main__":
    main()
