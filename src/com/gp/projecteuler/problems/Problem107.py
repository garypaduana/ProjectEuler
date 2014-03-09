import copy
import csv
 
#http://www.python.org/doc/essays/graphs/
 
def connected(grid):
    graph = {}
   
    for row in range(0, len(grid)):
        conns = []
        for col in range(0, len(grid)):
            if(grid[row][col] > 0):
                conns.append(col)
        graph[row] = conns
  
    paths = findAllPaths(graph, 0, len(grid))
    graph = {'A': ['B', 'C'],
             'B': ['C', 'D'],
             'C': ['D'],
             'D': ['C'],
             'E': ['F'],
             'F': ['C']}
 
    print findAllPaths(graph, 'A', 'D')
    for p in paths:
        if(len(p) == len(grid)):
            return True
    return False
 
 
   
    
class Node:
    index = 0
    connections = []
    visited = False
 
    def __init__(self, index):
        self.index = index
    def __str__(self):
        return str(index) + ', ' + str(connections)
    def __repr__(self):
        return str(self.index) + ', ' + str(self.connections)  
 
def findAllPaths(graph, start, end, path=[]):
    path = path + [start]
    if start == end:
        return [path]
    if not graph.has_key(start):
        return []
    paths = []
    for node in graph[start]:
        if node not in path:
            newpaths = findAllPaths(graph, node, end, path)
            for newpath in newpaths:
                paths.append(newpath)
    return paths
   
def main():
    grid = []
    with open ('./../../../../../resources/network.txt', 'rb') as f:
        data = csv.reader(f, delimiter=',', quotechar='\'')
        for row in data:
            row = [x.replace('-','0') for x in row]
            row = [int(x) for x in row]
            grid.append(row)
           
    grid = [[0,16,12,21,0,0,0],
            [16,0,0,17,20,0,0],
            [12,0,0,28,0,31,0],
            [21,17,28,0,18,19,23],
            [0,20,0,18,0,0,11],
            [0,0,31,19,0,0,27],
            [0,0,0,23,11,27,0]]
   
    weights = {}
    for row in range(0, len(grid)):
        for column in range(0, len(grid[0])):
            if(grid[row][column] not in weights):
                weights[grid[row][column]] = []
            weights[grid[row][column]].append((row, column))
           
    savings = 0
    sortedKeys = sorted(weights, reverse=True)
    for i in range(0, len(sortedKeys)):
        for pair in weights[sortedKeys[i]]:
            temp = copy.deepcopy(grid)
            temp[pair[0]][pair[1]] = 0
            temp[pair[1]][pair[0]] = 0
            if(connected(temp)):
                savings += sortedKeys[i]
                grid = copy.deepcopy(temp)
    print savings / 2
   
if __name__ == '__main__':
    main()
