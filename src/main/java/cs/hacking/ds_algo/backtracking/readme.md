# Backtracking

Build candidates incrementally, when candidates can not satisfied solution, abandon it.

Keywords: *tracking* *back*

## @Wiki

1. search depth-first order from root to last node. based on valid candidate
   enum all next level node, and check them is a candidate too
2. if node and backtracked candidates can not be valid solution, abandon it
   or search next
3. abandon means cut a sub search tree, which reduce time
4. total cost: sum of checking each node

## Check NQueens

```
1. from left to right, let col = 0

   1
   ?
   ?
   ?

2. now we check each row in col = 1, is any one unsafe, like

   1 x
   ? x
   ?
   ?

   abandon it [row, col] = 0

3. if we find one candidate works, like

   1 x
   ? x
   ? 1
   ?

   we search forward to next col recursively, that is

   1 x x -> 1 x x -> 1 x x x -> 1 x x -> x x -> ...
   ? x x    ? x 1    ? x 1 x    ? x x    1 x
   ? 1 x    ? x      ? x ? x    ? x x    x x
   ? ? x    ? 1      ? 1 ? x    ? 1 x    x 1

4. so what's backtracking?
```