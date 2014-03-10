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
    f = open('../../../../../resources/base_exp.txt', 'r')
    
    max = 0
    max_index = 0
    index = 1
    for line in f:
        if len(line) == 0:
            continue
        pieces = line.split(',')
        val = math.log10(float(pieces[0])) * float(pieces[1])
        if(val > max):
            max = val
            max_index = index
        index += 1
    
    print "Answer:",  max_index
    print "Duration:", (datetime.datetime.now() - start)

if __name__ == "__main__":
    main()
        
