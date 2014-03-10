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

import math
from decimal import *

def ran(start, end):
    start -= 1
    while start < end:
        start += 1
        yield start

for n in ran(1070379110497, 1070379110498):
    d = (Decimal('0.5')*Decimal(n)*Decimal(n) - Decimal('0.5') * Decimal(n) + Decimal('0.25')).sqrt() + Decimal('0.5')
    
    #b = math.sqrt(0.5*n**2-0.5*n + 0.25) + 0.5
    if(d == d // Decimal('1.0')):
        print n, '---  Answer:', d
