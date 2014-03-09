import itertools


def main():
    #letters = {}
    #for val in range(65, 91):
    #    letters[chr(val)] = val - 64

    #print letters
    words = set()
    with open('./../../../../../resources/problem098.txt', 'r') as f:
      text = f.read()
      for word in text.split(','):
          words.add(word.replace('\"', ''))

    for word in words:
        for x in itertools.permutations(word, len(word)):
            if(''.join(x) in words and ''.join(x) != word):
                print word, ''.join(x)

    print "done"
if __name__ == '__main__':
    main()
