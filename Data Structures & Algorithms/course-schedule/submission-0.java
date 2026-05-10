class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courseList = new ArrayList<>();
        for(int i = 0 ; i <numCourses ; i++){
            courseList.add(new ArrayList<>());
        }

        for(int[] arr : prerequisites){
            courseList.get(arr[1]).add(arr[0]);
        }

        int[] visited = new int[numCourses];
        int[] pathVisited = new int[numCourses];

        for(int i = 0 ; i < numCourses; i++){
            if(visited[i] == 0 ){
                if(dfs(i, visited, pathVisited, courseList)) return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, int[] visited, int[] pathVisited, List<List<Integer>> courseList) {
        visited[node] = 1;
        pathVisited[node] = 1;

        List<Integer> neighbours = courseList.get(node);

        for(int neigh : neighbours){
            if(pathVisited[neigh] == 1) return true;
            if(visited[neigh] == 0) {
                if(dfs(neigh, visited, pathVisited, courseList)) return true;
            }
        }
        pathVisited[node] = 0;
        return false;
    }
}
