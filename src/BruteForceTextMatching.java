import java.util.Scanner;

public class BruteForceTextMatching {
    private static int getPatternMatchIndex(String text, String pattern){
            for(int i = 0; i < text.length() - pattern.length() +1; i++){
                int j = i;
                boolean flag = false;
                for( j= 0; j < pattern.length(); j++){
                    if(text.charAt(i+j) != pattern.charAt(j)){
                        flag = true;
                        break;
                    }
                }

                if(!flag){
                    return i;
                }
            }

            return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = scanner.nextLine();

        System.out.print("Enter the pattern: ");
        String pattern = scanner.nextLine();

        if(pattern.length() > text.length()){
            System.out.println("No matching pattern found");
        }else{
            int idx = getPatternMatchIndex(text, pattern);
            if(idx == -1){
                System.out.println("No matching pattern found in the text");
            }else{
                System.out.println("The matching pattern fount at index " + idx);
            }
        }

    }
}
