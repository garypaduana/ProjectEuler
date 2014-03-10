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
import itertools
import math

def main():
    """
        By using each of the digits from the set, {1, 2, 3, 4}, exactly once,
        and making use of the four arithmetic operations (+, , *, /) and
        brackets/parentheses, it is possible to form different positive
        integer targets.

        For example,

        8 = (4 * (1 + 3)) / 2
        14 = 4 * (3 + 1 / 2)
        19 = 4 * (2 + 3)  1
        36 = 3 * 4 * (2 + 1)

        Note that concatenations of the digits, like 12 + 34, are not allowed.

        Using the set, {1, 2, 3, 4}, it is possible to obtain thirty-one
        different target numbers of which 36 is the maximum, and each of
        the numbers 1 to 28 can be obtained before encountering the first
        non-expressible number.

        Find the set of four distinct digits, a < b < c < d, for which the
        longest set of consecutive positive integers, 1 to n, can be obtained,
        giving your answer as a string: abcd.
    """
    
    start = datetime.datetime.now()
    all_nums = [x for x in range(2, 10)]
    operators = ["+","-","*","/"]
    parentheses = [{0:"(", 1:")"},                  #   (x   x)  x   x
                   {0:"(", 2:")"},                  #   (x   x   x)  x
                   {1:"(", 2:")"},                  #    x  (x   x)  x
                   {1:"(", 3:")"},                  #    x  (x   x   x)
                   {2:"(", 3:")"},                  #    x   x  (x   x)
                   {0:"(", 1:")", 2:"(", 3:")"},    #   (x   x) (x   x)
                   {0:"((", 1:")", 2:")"},          #  ((x   x)  x)  x
                   {1:"((", 2:")", 3:")"},          #    x ((x   x)  x)
                   {0:"(", 1:"(", 2:"))"},          #   (x  (x   x)) x
                   {1:"(", 2:"(", 3:"))"},          #    x  (x  (x   x))
                   {-1:""}]                         #    x   x   x   x
    consecutive_set_results = dict()
    
    for parent_sequence in itertools.combinations(all_nums, 3):
        # begin with 1 because that resolution is assumed to be needed to
        # produce all results for all of the integers from 1 to n (about 40-70 probably)
        ps = [1]
        [ps.append(x) for x in parent_sequence]

        results = set()
        for num_sequence in itertools.permutations(ps, 4):
            for operator_sequence in itertools.product(operators, repeat=3):
                for paren in parentheses:
                    cpy = list(num_sequence)
                    for key in paren.keys():
                        if paren[key].find("(") > -1:
                            cpy[key] = paren[key] + str(cpy[key])
                        elif paren[key].find(")") > -1:
                            cpy[key] = str(cpy[key]) + paren[key]
                    
                    exp = str(cpy[0]) + operator_sequence[0] + \
                          str(cpy[1]) + operator_sequence[1] + \
                          str(cpy[2]) + operator_sequence[2] + \
                          str(cpy[3])
                    try:
                        result = eval(exp)
                    except ZeroDivisionError:
                        result = 0
                        
                    if math.floor(result) == result and result > 0:
                        results.add(result)

        consecutive = 1
        for x in range(1, len(results) + 1):
            if(x in results):
                consecutive += 1
            else:
                consecutive -= 1
                break
        consecutive_set_results[consecutive] = ps

    m = max(consecutive_set_results.iterkeys())
    s = consecutive_set_results[m]
    print "Answer:", ''.join([str(x) for x in s])
    print "Duration:", (datetime.datetime.now() - start)
      
if __name__ == "__main__":
    main()
