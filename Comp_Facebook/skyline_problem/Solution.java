import java.util.*;
class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        // construct intervals
        int idx = 0;
        Segment[] segments = new Segment[buildings.length*2];
        for (int[] interval: buildings) {
            segments[idx] = new Segment(interval[0], interval[2], true);
            segments[idx+1] = new Segment(interval[1], interval[2], false);
            idx += 2;
        }
        Arrays.sort(segments);

        SortedMap<Integer, Integer> height2Freq = new TreeMap<Integer, Integer>();
        height2Freq.put(0, 1);

        // loop through segments
        List<int[]> ret = new ArrayList<int[]>();
        for (Segment segment: segments) {
            int maxHeight = height2Freq.lastKey();
            if (segment.isStart) {
                height2Freq.put(segment.height, height2Freq.getOrDefault(segment.height, 0) + 1);
                if (segment.height > maxHeight) {
                    ret.add(new int[] {segment.x, segment.height});
                }
            } else {
                int freq = height2Freq.get(segment.height) - 1;
                if (freq == 0) {
                    height2Freq.remove(segment.height);
                } else {
                    height2Freq.put(segment.height, freq);
                }

                if (segment.height == maxHeight && freq == 0) {
                    ret.add(new int[] {segment.x, height2Freq.lastKey()});
                }
            }
        }
        return ret;
    }

    private class Segment implements Comparable<Segment> {
        int x;
        int height;
        boolean isStart;
        Segment (int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }

        public int compareTo(Segment s) {
            if (this.x != s.x) {
                return this.x - s.x;
            } else if (this.isStart != s.isStart) {
                return this.isStart ? -1 : 1;
            } else {
                return this.isStart ? s.height - this.height : this.height - s.height;
            }
        }
    }
}
