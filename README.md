# leetcode note
- ideas

## num_sum series
- **two sum (number not sorted)**: hash map to register (number, target-number) pairs
- **two sum II (sorted)**: two pointers algorithm. 
- **three sum**: two pointers algorithm. Use one to sweep from start to end, the other to sweep backwards
- **three sum closest**: basically two pointers algorithm
- **four sum**: same two pointers algorithm as three sum. Remember to skip duplicate numbers

## best time to buy and sell stock series
- **I and II**: sweep. Consider this as 1D DP. 
- **III**: divide left and right, do DP twice
- **IV**: 2D dynamic programming

## intervals series
- **merge interval**: In Java, use Collections.sort(), so that insert interval is unnecessary
- **insert interval**: The first interval should be found by comparing ends with new interval.start 

## stair shape stack series
- **largest rectangle in histogram**: increasing stack to find border, left and right sweep
- **container with most water**: decreasing stack to find border, left sweep is enough

## 2D dynamic programming
- **unique paths, unique paths II, minimum path sum**: maintain 2D matrix
- **dungeon game**: 2D backwards

## arrays misc
- **set matrix zeros**: use first row and column to keep flags
- **search 2D matrix**: binary search
- **search 2D matrix II**: search by corner from top right to bottom left.

## bucket sort
- **sort colors, remove duplicates from sorted array**: bucket sort

## quick sort
- **sort list**: have to use list trick and maybe find middle?

## backtracking
- **subsets, word search**: backtracking