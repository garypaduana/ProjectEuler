findDivisorCount = {num ->
    divisorCount = 0
    for(long i = 1; i < (long)Math.sqrt(num) + 1; i++){
        if(num % i == 0){
            divisorCount += 2
        }
    }
    return divisorCount
}

start = System.nanoTime()
num = count = 0

while(true){
    count++
    num += count
     
    if(findDivisorCount(num) > 500)
        break
}
print "$num, ${(System.nanoTime() - start) / 1e6}ms"
