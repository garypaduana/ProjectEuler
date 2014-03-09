import math

f = open('c:/users/gpaduana/documents/python/base_exp.txt', 'r')

max = 0
max_index = 0
index = 1
for line in f:
    if len(line) == 0:
        continue
    pieces = line.split(',')
    val = math.log10(float(pieces[0])) * float(pieces[1])
    if(val > max):
        max = val
        max_index = index
    index += 1

print max, max_index
        
