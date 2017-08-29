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

## longest series
- **longest substring without repeating characters**: Use hashmap to map characters to their indices.

## palindrome series
- **longest palindromic substring**
    - Maximum common substring between reversed string (some tweak) - Dynamic programming
    - Dynamic programming: p(i,j) if string(i,j) is palindrome
    - Expand around center: be careful of even length palindrome
    - Manacher algorithm
- **shortest palindrome**
    - brutal force: reverse the string and compare the beginning and end
    - KMP: Construct s + # + inv(s), and construct the prefix = suffix array
    - two pointers algorithm: use the counting property.  

## strings
- **word ladder**: breadth first search, use string builder and hash set
- **word ladder II**: bfs, then dfs. Use map to track backwards path

## stair shape stack series
- **largest rectangle in histogram**: increasing stack to find border, ~~left and right sweep~~, left to right sweep is enough, when decrease, current bar is right border. Upside down with container with most waster.
- **maximal rectangle**: loop of largest rectangle in histogram
- **container with most water**: decreasing stack to find border, left sweep is enough
- **trapping rain water**: decreasing stack
- **trapping rain water II**: actually BFS. Use queue to maintain spots that need to be checked again. Only check spots where water level is reduced, and their neighbors.

## 1D dynamic programming
- **triangle**: DP backwards
- **maximum product subarray**: use maximum and minimum to keep track of results. Don't use positive and negative!
- **product of array except self**: two sweeps

## 2D dynamic programming
- **unique paths, unique paths II, minimum path sum, maximal square**: maintain 2D matrix
- **dungeon game**: 2D backwards

## arrays misc
- **set matrix zeros**: use first row and column to keep flags
- **search 2D matrix**: binary search
- **search 2D matrix II**: search by corner from top right to bottom left.
- **longest consecutive sequence**: use set to get union
- **majority element**: Moore's algorithm. Count up and down
- **majority element II**: Moore's algorithm variation. Notice how we have to add before substract

## bucket sort
- **sort colors, remove duplicates from sorted array**: bucket sort

## quick sort
- **sort list**: have to use list trick and maybe find middle?

## merge sort
- **merge sorted array**: merge from back to front

## backtracking
- **subsets, word search**: backtracking

# MISC
- Java `int` can not be null. `Integer` is nullable. `Collection` contains `objects`.
- Good practice to use generic forms?
    - `Set<T> foo = new HashSet<T>();`
    - `Map<Character, Integer> map = new HashMap<>();`
