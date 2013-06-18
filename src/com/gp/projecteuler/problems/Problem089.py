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

numerals = {"order":["M", "D", "C", "L", "X", "V", "I"],
    "M":1000, "D":500, "C":100, "L":50, "X":10, "V":5, "I":1}

replacements = {"order":["DCCCC","CCCC","LXXXX","XXXX","VIV","IIII"],
                "IIII":"IV",
                "VIV":"IX",
                "XXXX":"XL",
                "LXXXX":"XC",
                "CCCC":"CD",
                "DCCCC":"CM"}

def main():
    start = datetime.datetime.now()
    count = 0
    with open('./../../../../../resources/Problem089.txt', 'r') as f:
        text = f.read()
        for line in text.split('\n'):
            number = numberFromNumeral(line)
            minimal = minimalRomanNumeralForm(number)
            count += len(line) - len(minimal)
    print "Answer:", count
    print "Duration:", (datetime.datetime.now() - start)

def minimalRomanNumeralForm(number):
    """ Returns the Roman Numeral represenation of an integer
        in minimal form.
    """
    chars = []
    while(number > 0):
        for numeral in numerals["order"]:
            if(number >= numerals[numeral]):
                chars.append(numeral)
                number = number - numerals[numeral]
                break
    working = "".join(chars)
    for i in range(len(replacements)):
        for rep in replacements["order"]:
            working = working.replace(rep, replacements[rep])
    return working

def numberFromNumeral(numeral):
    """ Returns an integer corresponding to a Roman Numeral that
        may or may not be in minimal form.
    """
    sum = 0
    for i in range(len(replacements)):
        for rep in replacements["order"]:
            if(numeral.find(replacements[rep]) != -1):
                numeral = numeral.replace(replacements[rep], rep)
    
    for letter in numeral:
        sum += numerals[letter]

    return sum
        
if __name__ == "__main__":
    main()


