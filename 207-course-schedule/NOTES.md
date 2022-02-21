Init: Build adjacency list and indegree array. Add all indegree == 0 to a queue. Create counter which counts number of nodes w/ indegree 0.
while the q isn't empty:
every time we come across a node which has indegree of 0, increment counter
iterate through adjacency list and subtract from indegree array