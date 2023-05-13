import java.io.*;
import java.util.*;

class Solution {

    int pepoleUnderMeIncMe(String manager, HashMap<String, ArrayList<String>> directReportie, TreeMap<String, Integer>ans){
        if(directReportie.containsKey(manager) == false){
            ans.put(manager, 0);
            return 1;
        }
        int cnt =0;
        for(String emp : directReportie.get(manager)){
            cnt += pepoleUnderMeIncMe(emp, directReportie, ans);
        }

        ans.put(manager, cnt);
        return cnt+1;
    }

    public void EmpUnderManager(Map<String, String> emp)
    {
        HashMap<String, ArrayList<String>> directReportie = new HashMap<>();
        String ceo = "";// if manager is the employee
        for(String e : emp.keySet()){
            String manager = emp.get(e);
            if(manager.equals(e)){// if manager is same employee then he is emoloyee
                ceo = manager;
                continue;
            }else{// else take the employee list if present and and the employee and pust into hashmap again
                ArrayList<String> listOfEmployees = directReportie.getOrDefault(manager, new ArrayList<>());
                listOfEmployees.add(e);
                directReportie.put(manager, listOfEmployees);
            }
        }

        // after that this is to print no of employees has manager with them
        TreeMap<String, Integer>ans = new TreeMap<>();
        pepoleUnderMeIncMe(ceo, directReportie, ans);

        for(String e : ans.keySet()){
            System.out.println(e+" "+ans.get(e));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Map<String,String> emp = new HashMap<String, String>();
        for(int i=0;i<n;++i){
            emp.put(sc.next(),sc.next());
        }
        Solution Obj = new Solution();
        Obj.EmpUnderManager(emp);
    }
}