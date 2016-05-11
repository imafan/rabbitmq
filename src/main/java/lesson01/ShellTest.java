package lesson01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by imafan on 2016-05-05.
 */
public class ShellTest {


    public static void main(String[] args) throws Exception{


        Map<String, Object> data = new HashMap<String,Object>();
        Process proc = null;
        String[] command = {"sh","storageInfo.sh"};
        String commandString = "";
        for (String part : command) {
            commandString += part + " ";
        }

//        String res = SystemUtil.run(command);
//        System.out.println("res:" + res);
        /*Runtime rt = Runtime.getRuntime();
        proc = rt.exec(commandString);
        BufferedReader br = null;
        try{
            br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String str = "";
            while((str = br.readLine()) != null){
                System.out.println(str);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            br.close();
        }*/

        String tempStest = "res:.rgw.buckets 38469709 149826\n" +
                "total used 759835908\n" +
                "total avail 2107607916\n" +
                "total space 2867443824";

        String[] lines = tempStest.split("\n");
        if (lines != null && lines.length > 0) {
            String[] tempArray = null;
            for(String line : lines){
                    tempArray = line.split(" ");
                    if("total".equalsIgnoreCase(tempArray[0])){
                        data.put(tempArray[1],tempArray[2]);
                    }else{
                        data.put(tempArray[0],tempArray[2]);
                    }
            }
        }

        System.out.println("data:" +  data.toString());
    }


}
