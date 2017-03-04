# leetcode2
- ideas

## num_sum series
- two sum (number not sorted): hash map to register (number, target-number) pairs
- two sum II (sorted): two pointers algorithm. 
- three sum: two pointers algorithm. Use one to sweep from start to end, the other to sweep backwards
- three sum closest: basically two pointers algorithm
- four sum: same two pointers algorithm as three sum. Remember to skip duplicate numbers

## best time to buy and sell stock series
- I and II: sweep. Consider this as 1D DP. 
- III: divide left and right, do DP twice
- IV: 2D dynamic programming

## merge intervals