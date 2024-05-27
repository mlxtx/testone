public class RemoveConsecutiveChars {

    public static String removeConsecutive(String str) {
        StringBuilder sb = new StringBuilder(str);
        boolean hasChanged;

        do {
            hasChanged = false;
            int count = 1;
            for (int i = 1; i < sb.length(); i++) {
                if (sb.charAt(i) == sb.charAt(i - 1)) {
                    count++;
                    if (count >= 3) {
                        sb.delete(i - count + 1, i + 1);
                        hasChanged = true;
                        break;
                    }
                } else {
                    count = 1;
                }
            }
        } while (hasChanged);

        return sb.toString();
    }
    public static String removeConsecutive1(String str) {
        StringBuilder sb = new StringBuilder(str);
        boolean hasChanged;

        do {
            hasChanged = false;
            int count = 1;
            int start = 0;
            for (int i = 1; i <= sb.length(); i++) {
                if (i < sb.length() && sb.charAt(i) == sb.charAt(i - 1)) {
                    count++;
                } else {
                    if (count >= 3) {
                        sb.delete(start, start + count);
                        hasChanged = true;
                        break;
                    }
                    start = i;
                    count = 1;
                }
            }
        } while (hasChanged);

        return sb.toString();
    }
    public static void main(String[] args) {
        String input = "aabbbbbbcdd";
        String result = removeConsecutive(input);
        System.out.println("结果: " + result); // 输出结果:cdd

        String s = removeConsecutive1(input);
        System.out.println(s);

    }
}