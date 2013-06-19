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

import itertools
import datetime
import math

def main():
    start = datetime.datetime.now()
    
    right_triangles = set()
    upper = 51
    for x1 in range(0, upper):
        for y1 in range(0, upper):
            for x2 in range(0, upper):
                for y2 in range(0, upper):
                    if(is_right_triangle(x1,y1,x2,y2)):
                        right_triangles.add(frozenset({(x1,y1),(x2,y2)}))

    print "Answer:", len(right_triangles)
    print "Duration:", (datetime.datetime.now() - start)
    
def is_right_triangle(x1, y1, x2, y2):
    if((x1 == x2 and y1 == y2) or
       (x1 == 0 and y1 == 0) or
       (x2 == 0 and y2 == 0)):
        return False
    
    distances = []
    distances.append((x1**2+y1**2)**(1./2.))
    distances.append((x2**2+y2**2)**(1./2.))
    distances.append(((x1-x2)**2+(y1-y2)**2)**(1./2.))
        
    hyp = max(distances)
    distances.remove(hyp)

    difference = hyp**2 - (distances[0]**2 + distances[1]**2)
    if(math.fabs(difference) <= 0.0000001):
        return True

if __name__ == "__main__":
    main()
