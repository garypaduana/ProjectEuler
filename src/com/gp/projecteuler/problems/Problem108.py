import math

def main():
    max = 0
    i = 1
    while True:
        i = pows(i)
        th = len(divisors(i*i))
        if(th > max):
            max = th
            print i, max    

def pows(last):
    return last * 2

def divisors(num):
    divs = []
    divs.append(num)
    for i in range(1, (num / 2) + 1):
        if(num % i == 0):
            divs.append(i)
    return sorted(divs)

if __name__ == '__main__':
    main()
