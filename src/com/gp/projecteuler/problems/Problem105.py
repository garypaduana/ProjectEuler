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
import sys
import re
sys.path.append('../')
import CommonPy

def main():
    start = datetime.datetime.now()
    sum = 0
    with open ('../../../../../resources/Problem105.txt') as f:
        data = f.readlines()
        for line in data:
            match = re.match('(.+)\n?', line)
            nums = []
            [nums.append(int(x)) for x in match.groups()[0].split(',')]
            
            if(CommonPy.areRulesTrue(nums)):
                sum += CommonPy.S(nums)
    print "Answer:", sum
    print "Duration:", (datetime.datetime.now() - start)

if __name__ == '__main__':
    main()
