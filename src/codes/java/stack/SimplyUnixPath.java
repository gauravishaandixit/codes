package codes.java.stack;

import java.util.Stack;

public class SimplyUnixPath {
    String simplifyPath(String path) {
        Stack<String> stack = new Stack();

        for(String cur: path.split("/")){

            if(cur.equals("..") && !stack.empty())
                stack.pop();
            else
            if(cur.length()>0 && !cur.equals(".") && !cur.equals(".."))
                stack.push(cur);
        }
        return "/"+String.join("/",stack);
    }

    public static void main(String[] a)
    {
        System.out.println(new SimplyUnixPath().simplifyPath("/home/"));
        System.out.println(new SimplyUnixPath().simplifyPath("/../home//abc/def/../."));
        System.out.println(new SimplyUnixPath().simplifyPath("/a//b////c/d//././/.."));
        System.out.println(new SimplyUnixPath().simplifyPath("/a/../../b/../c//.//"));
        System.out.println(new SimplyUnixPath().simplifyPath("/a/./b/../../c/"));
        System.out.println(new SimplyUnixPath().simplifyPath("/home//foo/"));
        System.out.println(new SimplyUnixPath().simplifyPath("/../"));
    }
}
