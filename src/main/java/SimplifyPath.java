import java.util.Stack;

public class SimplifyPath {

    /*
    Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style
    file system, convert it to the simplified canonical path.

    In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to
    the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'.
    For this problem, any other format of periods such as '...' are treated as file/directory names.

    The canonical path should have the following format:

        - The path starts with a single slash '/'.
        - Any two directories are separated by a single slash '/'.
        - The path does not end with a trailing '/'.
        - The path only contains the directories on the path from the root directory to the target file or
          directory (i.e., no period '.' or double period '..')

    Return the simplified canonical path.

    Constraints:

    1 <= path.length <= 3000
    path consists of English letters, digits, period '.', slash '/' or '_'.
    path is a valid absolute Unix path.
     */

    public String simplifyPath2(String path) {
        String[] dirs = path.split("/");
        StringBuilder sb = new StringBuilder();
        String dir;
        int skipCount = 0;
        for (int i = dirs.length - 1; i >= 0; i--) {
            dir = dirs[i];
            if (dir.equals(".") || dir.length() == 0) continue;
            if (dir.equals("..")) skipCount++;  //skip next dir + 1
            else if (skipCount > 0) skipCount--;  //skipping here
            else sb.insert(0, "/" + dir);  //append the dir with a leading slash to the front
        }
        if (sb.length() == 0) sb.append("/");
        return sb.toString();
    }

    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String dir : dirs) {
            if (dir.equals(".") || (dir.isEmpty())) continue;
            if (!stack.isEmpty() && dir.equals("..")) stack.pop();
            else if (!dir.equals("..")) stack.push(dir);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for (String dir : stack) {
            sb.append(dir);
            sb.append("/");
        }
        if (sb.length() > 1) sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
