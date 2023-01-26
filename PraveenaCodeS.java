import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.lang.*;

class PraveenaCodeS{
    public static void main(String args[]) throws IOException{  
        if (System.getProperty("ONLINE_JUDGE") == null) {
            // Redirecting the I/O to external files
            // as ONLINE_JUDGE constant is not defined which
            // means
            // the code is not running on an online judge
            PrintStream ps= new PrintStream(new File("output.txt"));
            InputStream is= new FileInputStream("input.txt");
            System.setIn(is);
            System.setOut(ps);
        }
        Scanner scan = new Scanner(System.in);
        //For reading string from input file
        //String myLine = scan.nextLine();
        //scan.nextLine();
        //To take int array as input
        String[] members=new String[3];
        members[0]="id42";
        members[1]="id158";
        members[2]="id23";
        String[][] events=new String[6][3];
        //1st row.
        events[0][0]="MESSAGE";
        events[0][1]="0";
        events[0][2]="ALL id158 id42";
        //2nd row.
        events[1][0]="OFFLINE";
        events[1][1]="1";
        events[1][2]="id158";
        //3rd row.
        events[2][0]="MESSAGE";
        events[2][1]="2";
        events[2][2]="id158 id158";

        events[3][0]="OFFLINE";
        events[3][1]="3";
        events[3][2]="id23";

        events[4][0]="MESSAGE";
        events[4][1]="60";
        events[4][2]="HERE id158 id42 id23";

        events[5][0]="MESSAGE";
        events[5][1]="61";
        events[5][2]="HERE";
        /*int[] nums=new int[4];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scan.nextInt();
        }*/
        String[] sol=solution(members, events);
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
        /*for (Integer integer : sol) {
            System.out.println(integer);
        }*/
        //System.out.println(sol);
        scan.close();
    }  

    public static String[] solution(String[] members,String[][] events){
        HashMap<String,Integer> activeMember=new HashMap<>();
        HashMap<String,Integer> lastActive=new HashMap<>();
        for (int i = 0; i < members.length; i++) {
            activeMember.put(members[i],0);
        }
        for (int i = 0; i < events.length; i++) {
            String[] string=events[i];
            String isMessage=string[0];
            String timeStamp=string[1];
            String membersName=string[2];
            String[] allMember=membersName.split(" ");
            if(isMessage.equals("MESSAGE")){
                boolean allPresent=false;
                boolean allHere=false;
                Set<String> set=new HashSet<>();
                for (int j = 0; j < allMember.length; j++) {
                    String memberName=allMember[j];
                    if(memberName.equals("ALL")){
                        for (Map.Entry<String,Integer> hEntry : activeMember.entrySet()) {
                            int value=hEntry.getValue();
                            String key=hEntry.getKey();
                            activeMember.put(key,value+1);
                            allPresent=true;
                        }
                    }
                    else if(memberName.equals("HERE")){
                        if(lastActive.containsKey(memberName)){
                            int value=lastActive.get(memberName);
                            int currentTimeStamp=Integer.parseInt(timeStamp);
                            if(currentTimeStamp-value>=60){
                                activeMember.put(memberName,activeMember.getOrDefault(memberName,0)+1);
                                set.add(memberName);
                            }
                        }else{
                                activeMember.put(memberName,activeMember.getOrDefault(memberName,0)+1);
                                set.add(memberName);
                        }
                    }
                    else{
                        if(allPresent==false){
                            if(!set.contains(memberName)){
                                activeMember.put(memberName,activeMember.getOrDefault(memberName,0)+1);
                                //lastActive.put(memberName,lastActive.getOrDefault(memberName, 0)+1);
                                set.add(memberName);
                            }
                        }
                    }
                }
            }else{
                for (int j = 0; j < allMember.length; j++) {
                    String s=allMember[j];
                    int currentTime=Integer.parseInt(timeStamp);
                    lastActive.put(s, currentTime);
                }
            }
        }
        List<String> solution=new ArrayList<>();
        for (Map.Entry<String,Integer> hEntry : activeMember.entrySet()) {
            String key=hEntry.getKey();
            int value=hEntry.getValue();
            StringBuilder sb=new StringBuilder();
            sb.append(key);
            sb.append("=");
            sb.append(String.valueOf(value));
            solution.add(sb.toString());
        }
        Collections.sort(solution);
        String[] sol=new String[solution.size()];
        for (int i = 0; i < solution.size(); i++) {
            sol[i]=solution.get(i);
        }
        return sol;
    }
}  