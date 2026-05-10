class Solution {
    /*public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courseList = new ArrayList<>();
        for(int i = 0 ; i <numCourses ; i++){
            courseList.add(new ArrayList<>());
        }

        for(int[] arr : prerequisites){
            courseList.get(arr[1]).add(arr[0]);
        }

        int[] visited = new int[numCourses];
        int[] pathVisited = new int[numCourses];
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i = 0 ; i < numCourses; i++){
            if(visited[i] == 0 ){
                if(dfs(i, visited, pathVisited, courseList, stack)) return new int[]{};
            }
        }
        int[] result = new int[numCourses];
        int counter = 0;
        while(!stack.isEmpty()){
            result[counter++] = stack.pop();
        }
        return result;
    }

    private boolean dfs(int node, int[] visited, int[] pathVisited, List<List<Integer>> courseList, LinkedList<Integer> stack) {
        visited[node] = 1;
        pathVisited[node] = 1;

        List<Integer> neighbours = courseList.get(node);

        for(int neigh : neighbours){
            if(pathVisited[neigh] == 1) return true;
            if(visited[neigh] == 0) {
                if(dfs(neigh, visited, pathVisited, courseList, stack)) return true;
            }
        }
        stack.push(node);
        pathVisited[node] = 0;
        return false;
    }*/

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courseList = new ArrayList<>();
        for(int i = 0 ; i <numCourses ; i++){
            courseList.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for(int[] arr : prerequisites){
            courseList.get(arr[1]).add(arr[0]);
            inDegree[arr[0]] = inDegree[arr[0]] + 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i <numCourses; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        int[] result = new int[numCourses];
        int pointer = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            result[pointer++] = node;
            List<Integer> neighbours = courseList.get(node);
            for(int neigh : neighbours){
                inDegree[neigh]--;
                if(inDegree[neigh] == 0){
                    queue.offer(neigh);
                }
            }
        }
        if (pointer != numCourses) return new int[0];
        return result;
    }
}
