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

def main():
    #letters = {}
    #for val in range(65, 91):
    #    letters[chr(val)] = val - 64

    #print letters
    words = set()
    with open('./../../../../../resources/problem098.txt', 'r') as f:
      text = f.read()
      for word in text.split(','):
          words.add(word.replace('\"', ''))

    for word in words:
        for x in itertools.permutations(word, len(word)):
            if(''.join(x) in words and ''.join(x) != word):
                print word, ''.join(x)

    print "done"
if __name__ == '__main__':
    main()
