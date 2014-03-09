import sys
import itertools
sys.path.append('../')
import CommonPy
 
def main():
    nMap = {1:[1],
            2:[1,2],
            3:[2,3,4],
            4:[3,5,6,7],
            5:[6,9,11,12,13],
            6:[11,18,19,20,22,25]}
 
    pp = CommonPy.nextPattern(nMap[6])
    
    lowest = 999999
    for x in CommonPy.fuzz(pp, 1):
        if(CommonPy.areRulesTrue(x)):
            if(CommonPy.S(x) < lowest):
                print x
                lowest = CommonPy.S(x)
  
if __name__ == "__main__":
    main()
