'''
    Project Euler Solutions
    Copyright (C) 2012-2013, Gary Paduana, gary.paduana@gmail.com
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
'''

import copy
import csv
import datetime
import os

def createGraph(grid):
    graph = {}
    for row in range(0, len(grid)):
        graph[row] = Node(row)
    
    for row in range(0, len(grid)):
        for column in range(0, len(grid)):
            if(grid[row][column] > 0):              
                graph[row].connections.append(graph[column].index)
    return graph

def connected(graph, current, visitedNodes):
    if(graph[current].visited == False):
        visitedNodes.append(current)
        graph[current].visited = True
    for node in graph[current].connections:
        if(graph[node].visited == False):
            visitedNodes.append(node)
            graph[node].visited = True
            connected(graph, node, visitedNodes)
    return visitedNodes
    
class Node:    
    def __init__(self, index):
        self.index = index
        self.connections = []
        self.visited = False
    def __str__(self):
        return 'index: ' + str(self.index) + ', connections: ' + str(self.connections)
    def __repr__(self):
        return 'index: ' + str(self.index) + ', connections: ' + str(self.connections)
    
def main():
    print os.getcwd()
    start = datetime.datetime.now()
    grid = []
    with open ('../../../../../resources/network.txt', 'rb') as f:
        data = csv.reader(f, delimiter=',', quotechar='\'')
        for row in data:
            row = [x.replace('-','0') for x in row]
            row = [int(x) for x in row]
            grid.append(row)
            
    weights = {}
    for row in range(0, len(grid)):
        for column in range(0, len(grid[0])):
            if(grid[row][column] not in weights):
                weights[grid[row][column]] = []
            weights[grid[row][column]].append((row, column))
            
    savings = 0
    sortedKeys = sorted(weights, reverse=True)
    temp = copy.deepcopy(grid)
    for i in range(0, len(sortedKeys)):
        for pair in weights[sortedKeys[i]]:
            temp[pair[0]][pair[1]] = 0
            temp[pair[1]][pair[0]] = 0
            graph = createGraph(temp)
            
            if(len(connected(graph, 0, [])) == len(temp)):
                savings += sortedKeys[i]
                grid[pair[0]][pair[1]] = 0
                grid[pair[1]][pair[0]] = 0
            else:
                temp[pair[0]][pair[1]] = grid[pair[0]][pair[1]]
                temp[pair[1]][pair[0]] = grid[pair[1]][pair[0]]

    print "Answer:", savings / 2
    print "Duration:", (datetime.datetime.now() - start)
    
if __name__ == '__main__':
    main()

        
