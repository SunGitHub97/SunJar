import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.filldream.sun.utils.FileIOUtil;
import com.filldream.sun.utils.ListUtil;
import com.filldream.sun.utils.StringUtil;

public class test001 {
	public static void main(String[] args) {
		List<String> list = ListUtil.commaArrToList("1, ,");
		System.out.println("size:"+list.size());
		for(String s : list) {
			System.out.println(s);
		}
		
//		System.out.println(FileIOUtil.getFileNameNoSuffix("http:23.23.45.64:8899/bjdj/ondfs/sf/sjfks.jpg"));
	}
	
}
