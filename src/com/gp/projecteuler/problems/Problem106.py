import sys
import re
import itertools
sys.path.append('../')
import CommonPy

def main():
    lowest = 999999
    x = [3,5,6,7]
    if(areRulesTrue(x)):
        if(CommonPy.S(x) < lowest):
            print x
            lowest = CommonPy.S(x)

def areRulesTrue(a):
    everLasting = True
    for i in range(1, len(a) + 1):
        for b in itertools.combinations(a, i):
            cn = CommonPy.difference(a, b)

            print b, [x for x in cn]
            for c in cn:
                sb = CommonPy.S(b)
                sc = CommonPy.S(c)
                if(sb == sc):
                    everLasting = False
                #if(len(b) > len(c)):
                #    if(sb <= sc):
                #       everLasting = False
    return everLasting


if __name__ == '__main__':
    main()
