import java.util.*;

class Solution {
    private int[][] directions = {
        {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
        {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
    };

    public int maxMoves(int kx, int ky, int[][] positions) {
        List<int[]> allPositions = new ArrayList<>();
        allPositions.add(new int[]{kx, ky});
        for (int[] pos : positions) {
            allPositions.add(new int[]{pos[0], pos[1]});
        }
        int N = positions.length;
        int[][] minMoves = new int[allPositions.size()][N];
        
        for (int i = 0; i < allPositions.size(); i++) {
            int[] start = allPositions.get(i);
            int startX = start[0], startY = start[1];
            int[][] dist = new int[50][50];
            for (int x = 0; x < 50; x++) {
                Arrays.fill(dist[x], Integer.MAX_VALUE);
            }
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{startX, startY});
            dist[startX][startY] = 0;
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int x = current[0], y = current[1];
                for (int[] dir : directions) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx < 0 || nx >= 50 || ny < 0 || ny >= 50) continue;
                    if (dist[nx][ny] == Integer.MAX_VALUE) {
                        dist[nx][ny] = dist[x][y] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            for (int j = 0; j < N; j++) {
                int px = positions[j][0], py = positions[j][1];
                minMoves[i][j] = dist[px][py];
            }
        }

        int[][][] memo = new int[allPositions.size()][1 << N][2];
        for (int i = 0; i < allPositions.size(); i++) {
            for (int mask = 0; mask < (1 << N); mask++) {
                Arrays.fill(memo[i][mask], -1);
            }
        }

        return dfs(allPositions, minMoves, 0, (1 << N) - 1, true, memo);
    }

    private int dfs(List<int[]> allPositions, int[][] minMoves, int posIndex, int mask, boolean isAliceTurn, int[][][] memo) {
        if (mask == 0) return 0;
        int index = isAliceTurn ? 1 : 0;
        if (memo[posIndex][mask][index] != -1) {
            return memo[posIndex][mask][index];
        }
        int result = isAliceTurn ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for (int j = 0; j < minMoves[posIndex].length; j++) {
            if ((mask & (1 << j)) == 0) continue;
            int moves = minMoves[posIndex][j];
            int nextMask = mask ^ (1 << j);
            int nextPosIndex = j + 1; // pawns are at indices 1 to N
            int nextResult = dfs(allPositions, minMoves, nextPosIndex, nextMask, !isAliceTurn, memo);
            int total = moves + nextResult;
            if (isAliceTurn) {
                if (total > result) result = total;
            } else {
                if (total < result) result = total;
            }
        }
        memo[posIndex][mask][index] = result;
        return result;
    }
}