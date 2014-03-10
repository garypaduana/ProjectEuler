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
    start = datetime.datetime.now()

    x = 1
    for p in range(7830457):
        x *= 2
        x %= 10**10

    x *= 28433
    x += 1

    print "Answer:", str(x)[-10:]
    print "Duration:", (datetime.datetime.now() - start)

if __name__ == "__main__":
    main()
