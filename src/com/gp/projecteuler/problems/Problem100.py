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
        print n, d
