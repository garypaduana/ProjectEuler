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

def main():
    """
        A number chain is created by continuously adding the
        square of the digits in a number to form a new number
        until it has been seen before.

        For example,

        44 -> 32 -> 13 -> 10 -> 1 -> 1
        85 -> 89 -> 145 -> 42 -> 20 -> 4 -> 16 -> 37 -> 58 -> 89

        Therefore any chain that arrives at 1 or 89 will become
        stuck in an endless loop. What is most amazing is that
        EVERY starting number will eventually arrive at 1 or 89.

        How many starting numbers below ten million will arrive at 89?
    """
    start = datetime.datetime.now()
    count = 0
    # create a lookup array of size 567.  9,999,999 run through
    # the algorithm will produce the largest first round product,
    # and it is no more than 9^2 * 7 = 567
    # store either 0, 1, or 89 in each position.
    lookup = [0 for x in range(0, 9**2*7 + 1)]
    for i in range(1, 10000000):
        nex = next_num(i)
        this_lookup = nex

        # if we already have an answer to this chain, jump to it
        if lookup[nex] != 0:
            nex = lookup[nex]
               
        while(nex != 89 and nex != 1):
            if lookup[nex] != 0:
                nex = lookup[nex]
                break
            nex = next_num(nex)

        lookup[this_lookup] = nex
        if(nex == 89):
            count += 1
    print "Answer:", count
    print "Duration:", (datetime.datetime.now() - start)

def next_num(num):
    sum = 0
    while(num > 0):
        sum += (num % 10)*(num % 10)
        num = num // 10
    return sum
    
if __name__ == "__main__":
    main()
