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
- **find right interval**
- **arranging coins**: overflow
- **heaters**
- **find k closest element**

#### `search of answer`
- **median of two sorted array**: binary search of `k` in the `k`th element
- **kth smallest element in a sorted matrix**: binary search of guessed number and find its position in matrix
- **kth smallest number in multiplication table**: basically kthe smallest element in a sorted matrix. Guess the answer and binary search for it.
- **split array largest sum**: search of largest sum since it is bounded
- **smallest good base**: search of the power of the base-converted number. There is a formula for finding based given the base-converted number

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

## Tree

#### `traversal`
- **in-order**
    - **binary tree in-order traversal**: Morris traversal in `O(1)` space
    - **binary search tree iterator**: in-order traversal using stack
    - **recover binary search tree**: In order traversal. Morris traversal algorithm
    - **kth smallest number in a BST**
    - **find mode in BST**
- **pre-order**
    - **binary tree pre-order traversal**: should be able to use stack. Push root, right child, left child
    - **same tree**, **symmetric tree**, **subtree of another tree**: pre-order traversal
    - **flatten binary tree to linked list**: not exactly pre-order traversal. Process left then right. Need to return the right most child of left and right sub trees.
- **post-order**
    - **binary tree post-order traversal**: opposite of binary tree pre-order traversal. Use two stacks. Dot graph when only one stack allowed.
    - **construct string from binary tree**
- **level-order**
    - **binary tree level order traversal**: BFS using queue. Can use queue.size instead of two queues.
    - **binary tree level order traversal II**: BFS using queue.
    - **binary tree zig-zag level order traversal**: BFS using stack.
    - **populating next right pointers in each node II and II**: very special level order traversal. Need to keep track of this level's node, and next level's last visited node. This level can be visited by using this level's node's next.
    - **binary tree right side view**: level order traversal find the last node of every level
    - **find bottom left tree value**: level order
    - **find largest value in each tree row**: level order


#### `construct tree`
- **construct binary tree from preorder and inorder traversal**: pre-order starts with root
- **construct binary tree from postorder and inorder traversal**: post-order ends with root
- **convert sorted array to BST**: use middle element as root. Remember to use tree pointers instead of recursion.

#### `delete`
- **delete node in a BST**: Return the new root is convenient. Three cases: no child, one child, two children. Two children case can be solved by moving the value to the current root, and then do a deletion.  

#### `DFS`
- **MISC**
    - **maximum depth of binary tree**: DFS
    - **minimum depth of binary tree**: DFS. Pay attention to not leaf path
    - **balanced binary tree**: return -1 as not balanced
    - **count complete tree nodes**: use left depth and right depth to shortcut some calculation
    - **invert binary tree**: BFS can also work, I think
    - **binary tree path**: string builder
    - **diameter of binary tree**: use int[] to pass two values
- **sum**
    - **path sum**: pay attention to not leaf paths
    - **path sum II**: not all functions of LinkedList is available in List. new LinkedList<T>(oldList) can be used to clone a list.
    - **path sum III**: need to separate recursion with path finding logic
    - **binary tree maximum path sum**: can use an array to return multiple values of the same type!
    - **house robbery III**: return two values
    - **most frequent subtree sum**: hash table
    - **convert BST to greater tree**
    - **binary tree tilt**
    - **merge two binary trees**
- **pass down**
    - **validate binary search tree**: can pass down min and max. Don't have to return them. Also, be careful of minimum and maximum values of integer.
    - **sum root to leaf numbers**: pass current number down
    - **sum of left leaves**: sum!
    - **binary tree right side view**: traverse right sub tree first and add any node whose level is larger than the maximum level so far

#### `misc`
- **unique binary search tree I**: permutation of left and right
- **unique binary search tree II**: `List<TreeNode>` can add `null`
- **lowest common ancestor of a binary search tree**: Use property of BST
- **lowest common ancestor of a binary tree**: return found element or common parent

## Two pointers
- **minimum size subarray sum**: two pointers







---
# MISC

- Java `int` can not be null. `Integer` is nullable. `Collection` contains `objects`.
- Good practice to use generic forms?
    - `Set<T> foo = new HashSet<T>();`
    - `Map<Character, Integer> map = new HashMap<>();`
