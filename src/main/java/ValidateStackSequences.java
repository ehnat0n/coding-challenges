import java.util.Stack;

public class ValidateStackSequences {

    /*
    Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result
    of a sequence of push and pop operations on an initially empty stack, or false otherwise.

    Constraints:

    1 <= pushed.length <= 1000
    0 <= pushed[i] <= 1000
    All the elements of pushed are unique.
    popped.length == pushed.length
    popped is a permutation of pushed.
     */

    /*
    Add every single number to the stack, when we have a matching pop sequence -
    reduce stack and move right in popped at the same time.
    If we hit the end of pushed and stack is not reduced to zero - we have a "blocked" number in popped.
    Max runtime - 2 * n, using stack with max n elements.
    O(n) / O(n)
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popInd = 0;

        for(int num : pushed){
            stack.push(num);
            while(!stack.isEmpty() && stack.peek() == popped[popInd]){
                stack.pop();
                popInd++;
            }
        }
        return stack.isEmpty();
    }

    /*
    Same idea as solution2, but we use pushed as a stack. Since no new numbers are introduced - we can iterate over
    and push them left whenever there was a "popping sequence" - not going to overlap. Just storing them in the same
    array.
    Max runtime - 2 * n, no extra storage - we just do n write operations.
    O(n) / O(1)
     */
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        int stackInd = 0, popInd = 0;
        for (int num : pushed) {
            pushed[stackInd++] = num;
            while ((stackInd > 0) && (pushed[stackInd - 1] == popped[popInd])) {
                stackInd--;
                popInd++;
            }
        }
        return stackInd == 0;
    }
}
