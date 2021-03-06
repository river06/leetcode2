# leetcode note
----
## Series

#### `max sum series`
- **maximum subarray**: two pointers algorithm. Can be considered as 1D DP. There is a divide and conquer solution which is divided in three scenarios.
- **maximum subarray II**: Divide left and right. 2 X 1D DP
- **maximum subarray III**: 2D DP with optimization
- **maximum product subarray**: use maximum and minimum to keep track of results. 1D DP.

#### `num sum series`
- **two sum (number not sorted)**: hash map to store `<number, position>` pairs
- **two sum II (sorted)**: two pointers algorithm.
- **two sum IV**: hashset
- **three sum**: two pointers algorithm. Use one to sweep from start to end, the other to sweep backwards. Skip duplicates at (1) sum equals to target (2) the looping index
- **three sum closest**: basically two pointers algorithm
- **three sum smaller**: get the number of pairs by considering the right boundary (fixing the middle pointer)
- **four sum**: same two pointers algorithm as three sum. Skip duplicates at (1) sum equals to target (2) the two looping indices
- **four sum II**: hash map to store `<sum of elements in A, B; occurrences>` pairs
- **subarray sum equals k**: Hashmap from accumulative sum to occurrences. Calculate then put sum into hashmap.

#### `valid series`
- **valid number**

#### `best time to buy and sell stock series`
- **I and II**: sweep. Consider this as 1D DP.
- **III**: divide left and right, do DP twice
- **IV**: 2D dynamic programming

#### `intervals series`
- **merge interval**: In Java, use Collections.sort(), so that insert interval is unnecessary. We can add one by one.
- **insert interval**: The first interval should be found by comparing old interval's ends with new interval's start. Condition for inserting is newInterval.end < nextInterval.start

#### `longest series`
- **longest substring without repeating characters**: Use hashmap to map characters to their indices.

#### `palindrome series`
- **two pointers**
    - **shortest palindrome**
        - This is essentially to find longest palindrome from the start
        - `KMP`: Construct s + # + inv(s), and construct the prefix = suffix array
            - KMP is a string matching algorithm.
            - Lookup table is the longest prefix equals to suffix in the substring (0, i), i = 0 to string length.
            - Build the lookup table for the target string!
        - brutal force: reverse the string and compare the beginning and end
        - two pointers algorithm: use the counting property to find the length of the longest palindrome.
- **dynamic programming** - `DP(i,j)` if `string(i,j)` is palindrome or the length.
    - **longest palindromic substring**
        - `Manacher algorithm`
            - This needs inserting special character between original characters. It makes the algorithm much easier to understand. The special characters are also inserted in the edges. The length of half of the palindrome is the length of the original palindrome.
        - Expand around center: be careful of even length palindrome. Just call the expand function twice, it is much easier than inserting special character between original characters.
        - Dynamic programming:
        	- `dp(i,j)` if string(i,j) is palindrome. `dp(i,j)` depends on `dp(i+1, j-1)`, so fill up the matrix backwards in `i` direction and forwards in `j` direction.
        	- Or iterate over `j` at first. This way, the iteration can start from the beginning.
        	- Might also be iterated by the divide and conquer way.
    - **palindrome partitioning**: my solution is DP plus backtracking
    - **palindrome partitioning II**: my solution uses two DP, but they can be combined into one if the iteration sequence is the same.
    - **longest palindrome subsequence**: `DP(i,j)` stores the maximum length of palindromic substring
    - **count different palindromic subsequences**: can use 3D DP to solve the problem. The extra dimension stores the information about the boundary character.
- **misc**
    - **palindrome number**: invert half the number to avoid overflow
    - **valid palindrome**: just be careful of special cases
    - **palindrome linked list**: reverse linked list
    - **palindrome permutation**: count number algorithm
    - **palindrome permutation II**: should still use the old way of backtracking
    - **palindrome pairs**: special cases: empty string, palindrome itself, find whole reverted string.
    - **longest palindrome**: count
    - **largest palindrome product**: this is a math problem. For n digits, the product is at most `10^2n - 2*10^n + 1`, which means that the left part is at most `10^n - 3`. The product is at least `10^(2n-2)`, which means that the left part is at least `10^(n-1)`.
    - **find the closest palindrome**: a math problem. The trick is to zero out the right part of the original number. Add 1 to the middle number or subtract 1 from the zero-out number.
    - **palindromic substrings**: count the length of palindromic substrings

#### `stair shape stack series`
- **largest rectangle in histogram**: increasing stack to find border, ~~left and right sweep~~, left to right sweep is enough, when decrease, current bar is right border. Upside down with container with most waster.
- **maximal rectangle**: loop of largest rectangle in histogram
- **container with most water**: decreasing stack to find border, left sweep is enough
- **trapping rain water**: decreasing stack
- **trapping rain water II**: actually BFS. Use queue to maintain spots that need to be checked again. Only check spots where water level is reduced, and their neighbors.
- **sliding window maximum**: this problem uses `deque`, but the idea is the same: keep a decreasing sequence of indexes

#### `calculator series`
- **evaluate reverse polish notation**: stack
- **basic calculator**: solved with two stacks: one for operands one for numbers. Can be solved with just one stack. Use number to track current number. Use result to track current result. Use 1 and -1 trick to track sign. Use stack to track parenthesis. We push result = 0 and sign = 1 for multiple consecutive parenthesis.
- **basic calculator II**: one stack with pushing `1` trick. Be careful with negative number at the beginning. Open a new stack when seeing "+,-", not "x,/"!
- **expression add operators**: DFS.
	- Iterate over digits as a start to avoid +123 case
	- Imagine a stack and use +,- to handle 'stack'. We can actually use a stack to solve the problem. Should be easier to think.
	- Instead, keep track of summand and addand. Use '+' or '-' to partition the expression.
- **different ways to add parentheses**:
	- divide and conquer is one way
	- can aslo be solved by divide and conquer type DP

#### `loop series`
- **find the duplicate number**: duplicated number forms a loop. Use two pointers to find the entrance. Return index.

#### `marker series`
- **count primes**: find a prime, remove all of none primes from it.
- **find the celebrity**: use the already found markers to reduce the number of new calls

#### `minimum/maximum window series`
- **minimum window substring**: HashMap and two pointers. Two while loops: one to make solution valid/invalid, the other to make solution invalid/valid. Condition on **counter**.
- **minimum size subarray sum**
- **permutation in string**
- **Substring with Concatenation of All Words**

#### `parenthesis series`
- **valid parentheses**: stack or counter
- **valid parentheses string**: greedy algorithm. keep track of lower bound and upper bound of open parenthesis.
- **longest valid parentheses**:
    - dynamic programming: discuss when last one is ( or )
    - stack: keep track of last invalid position before the valid substrings
    - two points: number of left should be greater than number of right. Otherwise reset.
- **generate parentheses**:
	- recursive: backtracking, keep track of remaining open parentheses and close parentheses
	- iterative: (1) iterate over existing set (2) DP: Let `f(n)` be the set of valid parentheses with `n` pairs, `f(n) = (f(0))f(n-1), ..., (f(n-1))`
- **remove invalid parentheses**:
    - Remove any extra close parenthesis will make the string valid in terms of close parenthesis for strings with more close parentheses
    - Also need to revert the string or start from the end to remove extra open parentheses, consider `))()((`
    - DFS: (1) don't try to remove the close parenthesis that has been removed. (2) Don't remove consecutive close parentheses.
    - BFS: kind of brute force. Need to generate all possible combinations.
- **different ways to add parentheses**:
	- divide and conquer is one way
	- can aslo be solved by divide and conquer type DP

#### `schedule series`
- **task scheduler**: count idle time by filling up the gaps
- **rearrange string k distance apart**: can also use the same idea
- **meeting room II**: greedy algorithm to insert interval or see start and end as independent events.

#### `meeting point series`
- **walls and gates**: BFS from the position you want to reach
- **best meeting point**: median and note that vertical direction is independent of the horizontal direction

#### `permutation combination series`
- **permutations**: (1) recursive: backtracking algorithm (2) iteritative: given current set, insert next number into every possible positions
- **permutations II**: (1) recursive: backtracking algorithm. Skip if last same number has not been used. (2) iterative: given current set, insert next number into every possible positions if the number are not the same.
- **next permutation**: This is a math problem: (1) Find decreased number (2) find the number that is larger than the decreased number (3) swap them (4) reorder the remaining numbers in asending order
- **palindrome permutation**: count the number of letters
- **palindrome permutation II**: backtracking
- **permutation sequence**: this is a math problem. Calculate the number of permutations given the start index and use that to find the corresponding number
- **permutation in string**: seems to be a sliding window and hashmap problem
- **combinations**:
	- recursive: backtracking. Start from current number. 
	- recursive based on the condition that `C(n, k) = C(n-1, k) + C(n-1, k-1)`
	- DP: `DP(i, j)` stores the combinations from `i` to `j`.
	- iterative: add on to existing set one number by one number
- **combination sum**: (1) recusive: backtracking (2) DP (3) using the combination iteration idea?
- **combination sum II**: (1) backtracking (2) DP
- **combination sum III**: (1) backtracking
- **combination sum IV**: (1) backtracking (2) DP: `DP[i]` stores the number of combinations for `sum = i`
- **factor combinations**: (1) backtracking (2) ?
- **Letter Combinations of a Phone Number**: BFS

## Arrays
- **set matrix zeros**: use first row and column to keep flags
- **search 2D matrix**: binary search
- **search 2D matrix II**: search by corner from top right to bottom left.
- **longest consecutive sequence**: use set to get union
- **majority element**: Moore's algorithm. Count up and down
- **majority element II**: Moore's algorithm variation. Notice how we have to add before subtract
- **can place flowers**: pay attention to all cases
- **rotate array**: Using Cyclic Replacements

## Backtracking
#### `with memorization`
- **word break**: back tracking with memory
- **word break II**

#### `wit reset`
- **partition to k equal sum subsets**: reset the problem when one set is equal to target

#### `misc`
- **subsets, word search**: backtracking
- **permutations**, **permutations II**
- **factor combinations**: The next factor needs to be larger than previous factors
- **combination sum**, **combination sum II**, **combination sum III**
- **word pattern II**
- **sudoku solver**

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

## BFS
- **nested list weight sum**: Use iterative BFS. (Queue)
- **nested list weight sum II**: A good way to calculate weighted sum bottom up is to add weights in each level multiple times.
- **clone graph**: use a queue to clone BFS. Recursively clone DFS.
- **number of islands**: DFS can also be used to mask search result. If the original array can be modified, we can set the original array to be inverted value.

## Divide and conquer
- **count complete tree nodes**: count left and right. Perfect tree short cut

## Dynamic programming
#### `1D dynamic programming`
- **triangle**: DP backwards
- **maximum product subarray**: use maximum and minimum to keep track of results. Don't use positive and negative!
- **product of array except self**: two sweeps
- **house robber**, **house robber II**
- **valid parenthesis string**: Use two variables to track the min and max number of open parenthesis. Notice that the number of valid open parenthesis can not be less than zero.
- **student attendance record II**: augmented DP
- **With optimization**
    - **coin change**: `DP[i]` stores the value of minimum coins for amount `i`. Need to optimize over coins.
    - **longest increasing subsequence**: `DP[i]` stores the longest subsequence using `nums[i]`
    - **number of longest increasing subsequence**: Two DPs. One for the length the other for the count.
    - **perfect squares** `DP[i]` stores the number of squares for integer i
    - **word break**: optimization
    - **work break II**
    - **combination sum IV**
    - **freedom trail**: length varying DP problem

#### `2D dynamic programming`
- **unique paths, unique paths II, minimum path sum, maximal square**: maintain 2D matrix
- **Wildcard Matching**: 3 cases: character before `*` used 0, 1, multiple times
- **regular expressionexpression matching**: 3 cases: character before `*` used 0, 1, multiple times
- **is subsequence**: 2D DP. Two rows are sufficient. Actually two pointers algorithm is sufficient.
- **paint house**, **paint house II**: for paint house II, we can keep track of the two minimum previous costs.
- **minimum window subsequence**: DP does not give the direct solution. When getting the leftmost element, we can use DP to get the normal answer and then loop through the DP results.
- **backwards**
    - **dungeon game**: 2D backwards
    - **burst balloons**
- **With optimization**
    - **Split Array Largest Sum**: optimize over previous results
    - **partition equal subset sum**: knapsack problem. `DP[i][j]` represents if any subset of first `i` numbers can have sum equal to `j`.
    - **maximum vacation days**
    - **Maximum Sum of 3 Non-Overlapping Subarrays**: `DP[i][j]` represents the maximum sum of `i` non-overlapping subarrays among the first `j` sums. We need another array `ID[i][j]` to keep track of the starting index of the last sum of all the `i` sums with maximum sum among the first `j` sums.
- **divide and conquer**
    - For divide and conquer type problems, `DP[i][j]` represents the result for the divided problem with boundary `i` and `j`
    - **burst balloons**: `DP[i][j]` represents the maximum coins for balloons from `i` to `j`
    - **encode string with shortest length**: `DP[i][j]` stores the shortest encoded string from `i` to `j`

#### `ND dynamic programming`
- **burst balloons**: augment `DP[i][j]` with the number on the left and on the right
- **remove boxes**: augument `DP[i][j]` with the number of boxes with the same color as `box[i]` to the left/right

## Game Theory
#### `minimax`
- **can I win**: can be solved with negamax algorithm since this is zero sum game. Use hash map to remember result. Can reduce from O(n!) to O(2^n)

## Graph
#### `basics`
- **clone graph** (1) BFS use queue and HashMap (2) DFS use (stack) recursive and HashMap

#### `union find`
- **number of islands**, **number of islands II**
- **accounts merge**: HashMap to track email to name. This should contain all emails. Union Find to union all emails. Loop through the hashmap that contains all the emails and find the representing email.

## Hash

#### `hash set`
- **intersection of two arrays**: hash set

#### `hash map`
- **intersection of two arrays II**: hash map
- **isomorphic strings**: Use array of size 256 for character mapping! hash map or hash table
- **max points on a line**: gcd works great when calculating the slope
- **continuous subarray sum**: map from module of sum to index

## Linked List
#### `double linked list`
- **LRU cache**: Map from key to double linked list

#### `misc`
- **merge two sorted list**
- **merge k sorted list**: priority queue or heap
- **smallest range**: priority queue

## Math
#### `overflow`
- **Pow(x,n)**: x=0, x overflow, 1/x overflow, n min_val

#### `prime factors`
- **count primes**: find a prime, remove all of none primes from it.
- **ugly number**
- **ugly number II**: When facing with factors problems, can use multiple pointers to track factors.
- **super ugly number**: Remember that all pointers of primes after multiplication that equal to the minimum should move forward.

#### `misc`
- **sparse matrix multiplication**: row row multiplication

## Segment Tree
- **range query sum 1D mutable**

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
- **maximum swap**: we need to know the last occurance of every digits. Swap if larger digit exists later.

#### `quick sort`
- Quick sort does not need to keep track of the right indexes. In-line sort.
- **sort list**: have to use list trick and maybe find middle?

#### `quick select`
- **k closest points**

#### `merge sort`
- **sort list**: merge sort can also solve the problem
- **merge sorted array**: merge from back to front
- **count of smaller number after self**: merge sort can count the numbers to the right/left when merging

#### `misc`
- **largest number**: Just sort. Use a_b and b_a to decide which comes at first
- **wiggle sort**: sort pair by pair
- **wiggle sort II**: Quick select algorithm to find the `k`th largest element in array. Can be used to find median. Remember to use three way partition and index mapping.

## Stack
#### `stair shape series`

#### `misc`
- **longest increasing subsequence**, **Russian envelope**: although these are tagged as binary search, the key idea is to keep a "stack" of visited numbers


## Strings

#### `test of edge cases`
- **valid number**: + - e .
- **atoi**: + - invalid number overflow. Overflow can be solved by Integer.MAX_VALUE/10 and Integer.MAX_VALUE%10
- **validate IP address**

#### `misc`
- **word ladder**: breadth first search, use string builder and hash set
- **word ladder II**:
    - bfs, then dfs. Use map to track backwards path. We need DFS since BFS can not backtrack. It might be too expensive to store all the possible routes. For DFS, we need a map from words to its shortest distance to start. We need a map from words to previous words.
    - Actually, we do not need a map from words to distance. If we remove words from the dictionary when BFS, all the map from word to previous words will be on the shortest paths.
    - We can also BFS on the paths.
- **text justification**: special case: one word in a line
- **zigzag conversion**: math and be careful of edge cases.
- **shortest word distance**: two pointers
- **shortest word distance II**: HashMap and two pointers

## Tree

#### `traversal`
- **in-order**
    - **binary tree in-order traversal**:
        - Morris traversal in `O(1)` space.
        - Follow dot graph using stack: root not empty: push stack and go to left; root empty: pop stack and go to pop right
    - **binary search tree iterator**: in-order traversal using stack
    - **recover binary search tree**: In order traversal. Morris traversal algorithm
    - **kth smallest number in a BST**
    - **find mode in BST**
- **pre-order**
    - **binary tree pre-order traversal**: Stack: Push root, right child, left child
    - **same tree**, **symmetric tree**, **subtree of another tree**: pre-order traversal
    - **flatten binary tree to linked list**: not exactly pre-order traversal. Process left then right. Need to return the right most child of left and right sub trees.
    - **find duplicate subtrees**: same idea as serialize and de-serialize
- **post-order**
    - **binary tree post-order traversal**:
        - opposite of pre-order traversal when looking backwards, use stack. Use another stack to reverse result.
        - Follow dot graph using stack: root not null: push stack go to left; root null: (1) if stack top has right, go to that (2) pop stack, and pop all right branch
    - **construct string from binary tree**
- **level-order**
    - **binary tree level order traversal**: BFS using queue. Can use queue.size instead of two queues.
    - **binary tree level order traversal II**: BFS using queue.
    - **binary tree zig-zag level order traversal**: BFS using stack.
    - **populating next right pointers in each node II and II**: very special level order traversal. Need to keep track of this level's node, and next level's last visited node. This level can be visited by using this level's node's next.
    - **binary tree right side view**: level order traversal find the last node of every level
    - **find bottom left tree value**: level order
    - **find largest value in each tree row**: level order
    - **average of levels in binary tree**


#### `construct tree`
- **construct binary tree from preorder and inorder traversal**: pre-order starts with root
- **construct binary tree from postorder and inorder traversal**: post-order ends with root
- **convert sorted array to BST**: use middle element as root. Remember to use tree pointers instead of recursion.
- **serialization**
    - **serialize and deserialize binary tree**: pre-order or level order
    - **serialize and deserialize binary search tree**: find divider of left and right sub-trees first

#### `delete`
- **delete node in a BST**: Return the new root is convenient. Three cases: no child, one child, two children. Two children case can be solved by moving the value to the current root, and then do a deletion.  

#### `width`
- **maximum width of binary tree**: trick is to assign 2i and 2i+1 to children

#### `sum`
- **path sum**: pay attention to not leaf paths
- **path sum II**: not all functions of LinkedList is available in List. `new LinkedList<T>(oldList)` can be used to clone a list.
- **path sum III**: need to separate recursion with path finding logic
- **binary tree maximum path sum**: can use an array to return multiple values of the same type!
- **house robbery III**: return two values
- **most frequent subtree sum**: hash table
- **convert BST to greater tree**
- **binary tree tilt**
- **merge two binary trees**

#### `pass down`
- **validate binary search tree**: can pass down min and max. Don't have to return them. Also, be careful of minimum and maximum values of integer.
- **sum root to leaf numbers**: pass current number down
- **sum of left leaves**: sum!
- **binary tree right side view**: traverse right sub tree first and add any node whose level is larger than the maximum level so far

#### `misc`
- **unique binary search tree I**: permutation of left and right
- **unique binary search tree II**: `List<TreeNode>` can add `null`
- **lowest common ancestor of a binary search tree**: Use property of BST
- **lowest common ancestor of a binary tree**: return found element or common parent
- **maximum depth of binary tree**: DFS
- **minimum depth of binary tree**: DFS. Pay attention to not leaf path
- **balanced binary tree**: return -1 as not balanced
- **count complete tree nodes**: use left depth and right depth to shortcut some calculation
- **invert binary tree**: BFS can also work, I think
- **binary tree paths**: Three solutions: (1) Recursive and backtracking (2) BFS with helper queue to store the paths (3) DFS with helper stack to store the current paths.
- **diameter of binary tree**: use int[] to pass two values
- **trim a BST**

## Trie
- **trie service**
- **implement trie**
- **trie seralization**: n node tree seralization

## Two pointers
- **minimum size subarray sum**: two pointers
- **sum of square numbers**
- **validate palindrome**, **validate palindrome II**

----
# System Design

- **mini twitter**: Check if Hash map contains key before accessing the value
- **consistent hashing**: can call set on Integer
- **memcache**
- **mini cassandra**: TreeMap is implemented by Red-black tree (balanced BST). TreeSet is implemented by TreeMap.
- **tiny url**: unique ID
- **consistent hashing II**: TreeMap for the rescue
- **GFS client**

----
# MISC

- Java `int` can not be null. `Integer` is nullable. `Collection` contains `objects`.
- `gcd(a,b) {return b==0 ? a : gcd(b, a%b)}`
- Good practice to use generic forms?
    - `Set<T> foo = new HashSet<T>();`
    - `Map<Character, Integer> map = new HashMap<>();`
- `Arrays`
    - Convert array to list: `Arrays.asList(1,3,3)` or `Arrays.asList(new Integer[] {1, 2, 3})`
    - Sort an array of **Objects** in reverse order: `Arrays.sort(Integer[], Collections.reverseOrder())`
- `Comparator`
    - `Comparator<T> newComparator = new Comparator<T> { public int compare(T a, T b) { *** } };` uses anonymous class
    - A class should extend `Comparable<T>` interface to be comparable. implements `int compareTo(T object)`
- `StringBuilder`
    - `StringBuilder.length()`
    - `StringBuilder.setCharAt(int i, char c)`
- `Queue`
    - `Queue` supports `addAll(List list)`
- `Stack`
    - `peek(), pop()` throws `EmptyStackException` when used on an empty stack
- `PriorityQueue`
    - `PriorityQueue` can be constructed by `PriorityQueue(k, newComparator)` or just `PriorityQueue(newComparator)`
    - The size `k` in the constructor of priority queue does not limit the number of elements in the priority queue
    - Can call `queue.remove(element)` on a priority queue
- `Collections.reverse(someCollection)` reverses the collection. It does **NOT** return the collection
- int to char conversion does not work well with mod
