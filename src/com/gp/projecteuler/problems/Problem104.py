import string
import math
from decimal import *

phi = (Decimal(1) + Decimal.sqrt(Decimal(5))) / Decimal(2)
fibs = ['1','1']

def isPandigital(num):
    num = str(num)
    if(len(num) != 9):
        return False
    
    for x in range(1,10):
        if(string.count(num, str(x)) != 1):
            return False
    return True  

def fastfib(n):
    return round(phi ** n / Decimal.sqrt(Decimal(5)),0)

def fibDigitCount(n):
    return n * math.log(phi, 10) - math.log(5, 10)/2 

def fibFirstDigits(n, numDigits):
    return str(round(10**(math.modf(fibDigitCount(n))[0]), 8) * 10**numDigits)[0:9]

def fibLastDigits(fibs, numDigits):
    x = str((int(fibs[0]) + int(fibs[1])) % 10**numDigits)
    fibs.append(x)
    fibs[0:-2] = []
    return x
    
def main():
    conditionMet = False
    count = 2
    while(not conditionMet):
        count += 1
        if(isPandigital(fibLastDigits(fibs, 9))):
            if(isPandigital(fibFirstDigits(count, 9))):
                print "Answer: " + str(count)
                conditionMet = True
        
        
if __name__ == '__main__':
    main()


