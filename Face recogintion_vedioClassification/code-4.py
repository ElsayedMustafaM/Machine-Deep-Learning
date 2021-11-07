from collections import defaultdict

class graph:
    def __init__(self):
        self.graph = defaultdict(list)  # generate empty dictionary each value represent list

    def addEdge(self , u , v):
             self.graph[u].append(v)

    def DFS (self,s):
            visited = [False]*len(self.graph)
            stack = []
            stack.append(s)
            visited[s] = True
            while stack:
                s = stack.pop()
                print(s)
                for i in self.graph[s]:
                    if visited[i] == False:
                        stack.append(i)
                        visited[i]= True



g = graph()
g.addEdge(0,1)
g.addEdge(0,2)
g.addEdge(0,3)
g.addEdge(1,4)
g.addEdge(2,3)
g.addEdge(3,4)
g.addEdge(3,5)
g.addEdge(4,0)
g.addEdge(5,2)
print("Depth First Visiting Order ->")
g.DFS(0)