# leetcode note
----
## Series
#### `num sum series`
- **two sum (number not sorted)**: hash map to store `<number, position>` pairs
- **two sum II (sorted)**: two pointers algorithm.
- **three sum**: two pointers algorithm. Use one to sweep from start to end, the other to sweep backwards
- **three sum closest**: basically two pointers algorithm
- **four sum**: same two pointers algorithm as three sum. Remember to skip duplicate numbers
- **four sum II**: hash map to store `<sum of elements in A, B; occurrences>` paris

#### `best time to buy and sell stock series`
- **I and II**: sweep. Consider this as 1D DP.
- **III**: divide left and right, do DP twice
- **IV**: 2D dynamic programming

#### `intervals series`
- **merge interval**: In Java, use Collections.sort(), so that insert interval is unnecessary. We can add one by one.
- **insert interval**: The first interval should be found by comparing old interval's ends with new interval's start

#### `longest series`
- **longest substring without repeating characters**: Use hashmap to map characters to their indices.

#### `palindrome series`
- **longest palindromic substring**
    - Maximum common substring between reversed string (some tweak) - Dynamic programming
    - Dynamic programming: p(i,j) if string(i,j) is palindrome
    - Expand around center: be careful of even length palindrome
    - Manacher algorithm
- **shortest palindrome**
    - brutal force: reverse the string and compare the beginning and end
    - KMP: Construct s + # + inv(s), and construct the prefix = suffix array
    - two pointers algorithm: use the counting property.  

#### `stair shape stack series`
- **largest rectangle in histogram**: increasing stack to find border, ~~left and right sweep~~, left to right sweep is enough, when decrease, current bar is right border. Upside down with container with most waster.
- **maximal rectangle**: loop of largest rectangle in histogram
- **container with most water**: decreasing stack to find border, left sweep is enough
- **trapping rain water**: decreasing stack
- **trapping rain water II**: actually BFS. Use queue to maintain spots that need to be checked again. Only check spots where water level is reduced, and their neighbors.

#### `calculator series`
- **basic calculator**: solved with two stacks: one for operands one for numbers
- **basic calculator II**: one stack with pushing `1` trick. Be careful with negative number at the beginning.

#### `loop series`
- **find the duplicate number**: duplicated number forms a loop. Use two pointers to find the entrance. Return index.


## Arrays
- **set matrix zeros**: use first row and column to keep flags
- **search 2D matrix**: binary search
- **search 2D matrix II**: search by corner from top right to bottom left.
- **longest consecutive sequence**: use set to get union
- **majority element**: Moore's algorithm. Count up and down
- **majority element II**: Moore's algorithm variation. Notice how we have to add before subtract

## Backtracking
- **subsets, word search**: backtracking

## Binary search

#### `Bit shift`
- **divide two integers**: bit shift
- **pow(x,n)**

#### `three pointers`
- **search in rotated sorted array**: use three pointers
- **Search in Rotated Sorted Array II**: skip duplicated boundary
- **Find Minimum in Rotated Sorted Array**
- **Find Minimum in Rotated Sorted Array II**
- **search for a range**
- **search insertion position**
- **sqrt(x)**
- **valid perfect square**: basically sqrt
- **Search a 2D Matrix**: I think converting 2D matrix to 1D by index mapping is better than searching rows and columns separately. At least code can be easier.
- **Find Peak Element**: compare mid with mid-1 and mid+1
- **h-index II**
- **first bad version**
- **guess number higher or lower**: be careful of overflow!

#### `search of answer`
- **median of two sorted array**: binary search of `k` in the `k`th element
- **kth smallest element in a sorted matrix**: binary search of guessed number and find its position in matrix
- **split array largest sum**: search of largest sum since it is bounded

#### `search of sum`
- **max sum of rectangle no larger than k**: basically brute force version of 1D max sum of sub array no larger than `k`. Do a binary search to find any value > sum - k among previous sums.

## Binary search tree
- **count complete tree nodes**
- **kth smallest element in a BST**: in order traversal

## Divide and conquer
- **count complete tree nodes**: count left and right. Perfect tree short cut

## Dynamic programming
#### `1D dynamic programming`
- **triangle**: DP backwards
- **maximum product subarray**: use maximum and minimum to keep track of results. Don't use positive and negative!
- **product of array except self**: two sweeps
- **With optimization**
    - **coin change**: `DP[i]` stores the value of minimum coins for amount `i`. Need to optimize over coins.
    - **longest increasing subsequence**: `DP[i]` stores the longest subsequence using `nums[i]`

#### `2D dynamic programming`
- **unique paths, unique paths II, minimum path sum, maximal square**: maintain 2D matrix
- **dungeon game**: 2D backwards
- **regular expression matching**: 3 cases: character before `*` used 0, 1, multiple times
- **is subsequence**: 2D DP. Two rows are sufficient. Actually two pointers algorithm is sufficient.
- **With optimization**
    - **Split Array Largest Sum**: optimize over previous results

## Hash

#### `hash set`
- **intersection of two arrays**: hash set

#### `hash map`
- **intersection of two arrays II**: hash map

## Sort

#### `insertion sort`
- **insertion sort list**: Dummy head

#### `counting sort`

#### `radix sort`

#### `bucket sort`
- **sort colors**: Since there are only three colors, move numbers to the sides - throw 0s to the left throw 2s to the right.
- **remove duplicates from sorted array**: bucket sort
- **maximum gap**: buckets are of length (max-min)/(n-1), and use pigeon hole
- **valid anagram**: alphabet buckets

#### `quick sort`
- **sort list**: have to use list trick and maybe find middle?

#### `merge sort`
- **sort list**: merge sort can also solve the problem
- **merge sorted array**: merge from back to front
- **count of smaller number after self**: merge sort can count the numbers to the right/left when merging

#### `misc`
- **largest number**: Just sort. Use a_b and b_a to decide which comes at first
- **wiggle sort**: sort pair by pair
- **wiggle sort II**: Quick select algorithm to find the `k`th largest element in array. Can be used to find median. Remember to use three way partition and index mapping.

## Stack
- **stair shape series**
- **longest increasing subsequence**, **Russian envelope**: although these are tagged as binary search, the key idea is to keep a "stack" of visited numbers

## Strings
- **word ladder**: breadth first search, use string builder and hash set
- **word ladder II**: bfs, then dfs. Use map to track backwards path

## Two pointers
- **minimum size subarray sum**: two pointers







---
# MISC

- Java `int` can not be null. `Integer` is nullable. `Collection` contains `objects`.
- Good practice to use generic forms?
    - `Set<T> foo = new HashSet<T>();`
    - `Map<Character, Integer> map = new HashMap<>();`
