package lesson01;

/*
 * @Date 2015-4-3
 * 
 * @Author zhangzj@g-cloud.com.cn
 * 
 * @Copyright 2015 www.g-cloud.com.cn Inc. All rights reserved.
 * 
 * @Description 系统工具类
 */
public class SystemUtil {
	public static String run(String[] command) {
		Process proc = null;
		try {
			String commandString = "";
			for (String part : command) {
				commandString += part + " ";
			}
			// System.out.println(commandString);
			Runtime rt = Runtime.getRuntime();
			proc = rt.exec(command);
			StreamConsumer error = new StreamConsumer(proc.getErrorStream());
			StreamConsumer output = new StreamConsumer(proc.getInputStream());
			error.start();
			output.start();
			int returnValue = proc.waitFor();
			output.join();
			if (returnValue != 0) {
				// System.out.println("error");
				throw new Exception(error.getReturnValue());
			}
			return output.getReturnValue();
		} catch (Exception t) {
			// return "failed:"+t.getMessage();
		} finally {
			if (proc != null)
				proc.destroy();
		}
		return "";
	}
}
