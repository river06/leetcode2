# leetcode note
- ideas

## num sum series
- **two sum (number not sorted)**: hash map to store `<number, position>` pairs
- **two sum II (sorted)**: two pointers algorithm.
- **three sum**: two pointers algorithm. Use one to sweep from start to end, the other to sweep backwards
- **three sum closest**: basically two pointers algorithm
- **four sum**: same two pointers algorithm as three sum. Remember to skip duplicate numbers
- **four sum II**: hash map to store `<sum of elements in A, B; occurrences>` paris

## best time to buy and sell stock series
- **I and II**: sweep. Consider this as 1D DP.
- **III**: divide left and right, do DP twice
- **IV**: 2D dynamic programming

## intervals series
- **merge interval**: In Java, use Collections.sort(), so that insert interval is unnecessary. We can add one by one.
- **insert interval**: The first interval should be found by comparing old interval's ends with new interval's start

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

## stair shape stack series
- **largest rectangle in histogram**: increasing stack to find border, ~~left and right sweep~~, left to right sweep is enough, when decrease, current bar is right border. Upside down with container with most waster.
- **maximal rectangle**: loop of largest rectangle in histogram
- **container with most water**: decreasing stack to find border, left sweep is enough
- **trapping rain water**: decreasing stack
- **trapping rain water II**: actually BFS. Use queue to maintain spots that need to be checked again. Only check spots where water level is reduced, and their neighbors.

## calculator series
- **basic calculator**: solved with two stacks: one for operands one for numbers
- **basic calculator II**: one stack with pushing `1` trick. Be careful with negative number at the beginning.

## 1D dynamic programming
- **triangle**: DP backwards
- **maximum product subarray**: use maximum and minimum to keep track of results. Don't use positive and negative!
- **product of array except self**: two sweeps
- **coin change**: `DP[i]` stores the value of minimum coins for amount `i`. Need to optimize over coins.

## 2D dynamic programming
- **unique paths, unique paths II, minimum path sum, maximal square**: maintain 2D matrix
- **dungeon game**: 2D backwards
- **regular expression matching**: 3 cases: character before `*` used 0, 1, multiple times

## strings
- **word ladder**: breadth first search, use string builder and hash set
- **word ladder II**: bfs, then dfs. Use map to track backwards path

## arrays misc
- **set matrix zeros**: use first row and column to keep flags
- **search 2D matrix**: binary search
- **search 2D matrix II**: search by corner from top right to bottom left.
- **longest consecutive sequence**: use set to get union
- **majority element**: Moore's algorithm. Count up and down
- **majority element II**: Moore's algorithm variation. Notice how we have to add before substract

## sort
- **largest number**: Just sort. Use a_b and b_a to decide which comes at first

## insertion sort
- **insertion sort list**: Dummy head

## counting sort

## radix sort

## bucket sort
- **sort colors**: Since there are only three colors, move numbers to the sides - throw 0s to the left throw 2s to the right.
- **remove duplicates from sorted array**: bucket sort
- **maximum gap**: buckets are of length (max-min)/(n-1), and use pigeon hole
- **valid anagram**: alphabet buckets

## quick sort
- **sort list**: have to use list trick and maybe find middle?

## merge sort
- **sort list**: merge sort can also solve the problem
- **merge sorted array**: merge from back to front
- **count of smaller number after self**: merge sort can count the numbers to the right/left when merging

## backtracking
- **subsets, word search**: backtracking

# MISC
- Java `int` can not be null. `Integer` is nullable. `Collection` contains `objects`.
- Good practice to use generic forms?
    - `Set<T> foo = new HashSet<T>();`
    - `Map<Character, Integer> map = new HashMap<>();`
