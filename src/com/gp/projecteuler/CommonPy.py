import itertools
    
def fuzz(num, ran):
    '''
        num is a list of numbers
        ran is a range to apply to each end on the natural number line
        
        fuzz finds all permutations of length len(num) with the addition
        of nearby numbers to produce a larger result with greater 'spread',
        hence 'fuzz'.  It's used to look for optimum sets when the
        near-optimum set has been calculated as a starting point.  Expand
        the ran value as necessary to find the optimum set.
    '''
    # creates array of array initialized to all 0 as place holder.
    # e.g. num = [1,2,3]; ran = 2
    # cart =    [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]]
    # filled = [[-1, 0, 1, 2, 3], [0, 1, 2, 3, 4], [1, 2, 3, 4, 5]]
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
    ''' Computes a near-optimal set for the next n given an optimal 
        set for the current n. See docs for S(x) for context.
    '''
    new = []
    b = pattern[len(pattern)/2]
    new.append(b)
    [new.append(x+b) for x in pattern]
    return new
   
def S(x):
    '''
        Let S(x) represent the sum of elements in set x of size n.
        If S(x) is minimised for a given n, we shall call it an
        optimum special sum set.
    '''
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
