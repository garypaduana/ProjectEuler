start = System.nanoTime()
num = 600851475143L
primes = new HashSet<Long>()

whileLoop:
while(!isPrime(num)){
    for(long i = 2; i < (long)Math.sqrt(num); i++){
        if(num % i == 0 && isPrime(i)){
            num = (long) (num / i)
            continue whileLoop
        }
    }
}

println "Answer: ${num}, time: ${(System.nanoTime() - start) / 1e6}ms"

boolean isPrime(long num){
    if(primes.contains(num)){
        return true
    }
    
    for(long i = 2; i < (long)Math.sqrt(num); i++){
        if(num % i == 0){
            return false
        }
    }
    
    primes.add(num)
    return true
}
