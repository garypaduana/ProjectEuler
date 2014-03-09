def generatingFunction(n):
    return 1 - n + n**2 - n**3 + n**4 - n**5 + n**6 - n**7 + n**8 - n**9 + n**10

def OP(k, n, generatingFunction):
    """
        We shall define OP(k, n, generatingFunction) to be the nth
        term of the optimum polynomial generating function for the
        first k terms of a sequence produced by generatingFunction.
    """
    x = range(1, k + 1)
    fx = [generatingFunction(xi) for xi in x]
    
    sum = 0
    for i in range(len(x)):
        val = fx[i]
        for j in range(len(x)):
            if(i == j):continue
            val *= float(n - x[j]) / float(x[i] - x[j])
        sum += val
    return sum    
           
def main():
    sum = 0
    for x in range(1, 11):
        sum += OP(x, x+1, generatingFunction)
    print 'Answer: ' + str(sum)

if __name__ == "__main__":
    main()
