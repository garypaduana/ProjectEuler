import sys
import re
sys.path.append('../')
import CommonPy

def main():
    sum = 0
    with open ('../../../../../resources/Problem105.txt') as f:
        data = f.readlines()
        for line in data:
            match = re.match('(.+)\n?', line)
            nums = []
            [nums.append(int(x)) for x in match.groups()[0].split(',')]
            
            if(CommonPy.areRulesTrue(nums)):
                sum += CommonPy.S(nums)
    print sum

if __name__ == '__main__':
    main()
