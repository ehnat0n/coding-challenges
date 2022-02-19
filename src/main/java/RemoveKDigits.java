public class RemoveKDigits {

    /*
    Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer
    after removing k digits from num.

    Constraints:

    1 <= k <= num.length <= 10^5
    num consists of only digits.
    num does not have any leading zeros except for the zero itself.
     */
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (len == k) return "0"; //trivial case - removing all digits

        //optimization to get rid of zeros on the left if we can - those are free removals
        int cur = 0;
        int zero = num.indexOf('0');
        while ((zero != -1) && (zero <= (cur + k))) { //found zero before we reached k elements or right after
            k -= zero - cur; //reduce k since all those going to be removed
            cur = zero + 1; //jump past first zero
            while (cur < len && num.charAt(cur) == '0') cur++; //keep moving pointer if there are more zeros after - those are leading zeros in new number
            if (cur + k >= len) return "0"; //more zeroes than numbers to remove - can get rid of all numbers
            zero = num.indexOf('0', cur); //looking for next zero
        }

        //below code can be stand-alone solution if we deal with leading zeros at the end
        StringBuilder sb = new StringBuilder();
        char c;
        //looking for peaks
        while (cur < len) {
            c = num.charAt(cur);
            while ((!sb.isEmpty()) && (k > 0) && (sb.charAt(sb.length() - 1) > c)) {
                k--;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c);
            cur++;
        }

        //should be all non-descending order - removing tail
        while ((!sb.isEmpty() && (k > 0))) {
            k--;
            sb.deleteCharAt(sb.length() - 1);
        }
        //should not be empty because of zero optimization on top where we check if k > tail
        return sb.toString();
    }
}
