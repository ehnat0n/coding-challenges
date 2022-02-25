public class CompareVersionNumbers {

    /*
    Given two version numbers, version1 and version2, compare them.
    Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and
    may contain leading zeros. Every revision contains at least one character.
    Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision
    being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.

    To compare version numbers, compare their revisions in left-to-right order.
    Revisions are compared using their integer value ignoring any leading zeros.
    This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision
    at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their
    revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.

    Return the following:

    If version1 < version2, return -1.
    If version1 > version2, return 1.
    Otherwise, return 0.

    Constraints:

    1 <= version1.length, version2.length <= 500
    version1 and version2 only contain digits and '.'.
    version1 and version2 are valid version numbers.
    All the given revisions in version1 and version2 can be stored in a 32-bit integer.
     */
    public int compareVersion(String version1, String version2) {
        String[] revArr1 = version1.split("\\.");
        String[] revArr2 = version2.split("\\.");

        int len1 = revArr1.length;
        int len2 = revArr2.length;
        int maxLen = Math.max(len1, len2);

        for (int i = 0; i < maxLen; i++) {
            int rev1 = (i < len1) ? Integer.parseInt(revArr1[i]) : 0;
            int rev2 = (i < len2) ? Integer.parseInt(revArr2[i]) : 0;
            if (rev1 < rev2) return -1;
            else if (rev1 > rev2) return 1;
        }
        //all equal if you get to this point
        return 0;
    }
}
