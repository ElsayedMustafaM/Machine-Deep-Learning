#Breadth First Search
from collections import defaultdict
class graph:
    def __init__(self,graph):
        self.graph = graph

    def BFS(self,s):
            visited = [False]*len(self.graph)
            queue = []
            queue.append(s)
            visited[s] = True
            while queue:
                s = queue.pop(0)
                print(s)
                for i in self.graph[s]:
                    if visited[i] == False:
                        queue.append(i)
                        visited[i]= True



our_graph={0: [1, 2], 1: [0], 2: [0, 3, 6], 3: [2, 4, 5, 7], 4: [3], 5: [3, 6], 6: [2, 5, 8], 7: [3, 8], 8: [6, 7]}
g = graph(our_graph)
print("Breadth First Visiting Order ->")
g.BFS(0)
