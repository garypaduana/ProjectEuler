import itertools

def fuzz(num, ran):
    cart = [[0 for x in range(ran * 2 + 1)] for x in range(len(num))]
 
    x1 = 0
    for x in range(-ran, ran + 1):
        y1 = 0
        for y in num:
            cart[y1][x1] = y + x
            y1 += 1
        x1 += 1
 
    for x in itertools.product(*cart):
        yield x

def nextPattern(pattern):
    new = []
    b = pattern[len(pattern)/2]
    new.append(b)
    [new.append(x+b) for x in pattern]
    return new
   
def S(x):
    sum = 0
    for ax in x:
        sum += ax
    return sum
           
def areDisjointed(a, b):
    s = set()
    [s.add(ax) for ax in a]
    [s.add(bx) for bx in b]
    return len(s) == len(a) + len(b)
 
def difference(a, b):
    c = []
    [c.append(ax) for ax in a]
    for bx in b:
        try:
            c.remove(bx)
        except ValueError:
            pass
    for i in range(1, len(c) + 1):
        for com in itertools.combinations(c, i):
            yield com

def areRulesTrue(a):
    for i in range(1, len(a) + 1):
        for b in itertools.combinations(a, i):
            cn = difference(a, b)
            for c in cn:
                sb = S(b)
                sc = S(c)
                if(sb == sc):
                    return False
                if(len(b) > len(c)):
                    if(sb <= sc):
                        return False
    return True
