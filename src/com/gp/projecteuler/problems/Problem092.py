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

def main():
    count = 0
    lookup = dict()
    for i in range(1, 10000000):
        #print i, lookup
        this_lookup = []
        
        nex = next_num(i)
        this_lookup.append(nex)
        
        while(nex != 89 and nex != 1):
            if(nex in lookup.keys()):
                nex = lookup[nex]
                break
            nex = next_num(nex)
            this_lookup.append(nex)
            
        if(nex == 89):
            count += 1
            for n in this_lookup:
                lookup[n] = 89
        else:
            for n in this_lookup:
                lookup[n] = 1
            
    print count

def next_num(num):
    sum = 0
    for x in str(num):
        sum += int(x)**2
    return sum

if __name__ == "__main__":
    main()
