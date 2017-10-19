package org.free.jdk.deep.concurrent.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * TODO
 * @author dongdaiming
 * @date 2017年8月11日
 */
public class TestForkJoin {

	@Test
	public void testRecursiveTask() throws InterruptedException, ExecutionException {
		ForkJoinPool pool = new ForkJoinPool();
		Future<Integer> task = pool.submit(new SumTask(1, 100));
		System.out.println(task.get());
	}
	@Test
	public void testRecursiveAction() throws InterruptedException {
	    ForkJoinPool pool = new ForkJoinPool();
	    int cap = 1000 * 1;
	    DataList<String> datas = new DataList<>(cap);
	    init(datas, cap);
        long threshodDataSize = 1000;
        System.out.println("totalDataSize:" + datas.dataSize());
        long start = System.currentTimeMillis();
        pool.submit(new ListSplitAction<>(datas, threshodDataSize));
        
        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.MINUTES);
	}
	
	/**
     * @param datas
     */
	@Test
	public void testInit() {
	       int cap = 10000;
	        DataList<String> datas = new DataList<>(cap);
	        init(datas, cap);
	}
    private void init(DataList<String> datas, int cap) {
//        String s = "import com.antgroup.zmxy.openplatform.api.DefaultZhimaClient;\nimport com.antgroup.zmxy.openplatform.api.FileItem;\nimport com.antgroup.zmxy.openplatform.api.ZhimaApiException;\nimport com.antgroup.zmxy.openplatform.api.request.ZhimaDataBatchFeedbackRequest;\nimport com.antgroup.zmxy.openplatform.api.response.ZhimaDataBatchFeedbackResponse;\n\npublic class TestZhimaDataBatchFeedback {\n    //\u829D\u9EBB\u5F00\u653E\u5E73\u53F0\u5730\u5740\n    private String gatewayUrl     = \"https://zmopenapi.zmxy.com.cn/openapi.do\";\n    //\u5546\u6237\u5E94\u7528 Id\n    private String appId          = \"***\";\n    //\u5546\u6237 RSA \u79C1\u94A5\n    private String privateKey     = \"***\";\n    //\u829D\u9EBB RSA \u516C\u94A5\n    private String zhimaPublicKey = \"***\";\n\n    public void  testZhimaDataBatchFeedback() {\n        ZhimaDataBatchFeedbackRequest req = new ZhimaDataBatchFeedbackRequest();\n        req.setChannel(\"apppc\");\n        req.setPlatform(\"zmop\");\n        req.setFileType(\"json_data\");// \u5FC5\u8981\u53C2\u6570 \n        req.setFileCharset(\"UTF-8\");// \u5FC5\u8981\u53C2\u6570 \n        req.setRecords(\"100\");// \u5FC5\u8981\u53C2\u6570 \n        req.setColumns(\"user_name,user_credentials_type,user_credentials_no,order_no,biz_type,order_status,create_amt,pay_month,gmt_ovd_date,overdue_cnt,overdue_amt,gmt_pay,memo\");// \u5FC5\u8981\u53C2\u6570 \n        req.setPrimaryKeyColumns(\"order_no,pay_month\");// \u5FC5\u8981\u53C2\u6570 \n        req.setFileDescription(\"\u6587\u4EF6\u63CF\u8FF0\u4FE1\u606F\");// \n        req.setTypeId(\"1000033-xxxxx-test\u30011000033-xxxxx-order\");// \u5FC5\u8981\u53C2\u6570 \n        req.setBizExtParams(\"{\\\"extparam1\\\":\\\"value1\\\"}\");// \n        req.setFile(new FileItem(\"C:\\test_file\"));// \u5FC5\u8981\u53C2\u6570 \n        DefaultZhimaClient client = new DefaultZhimaClient(gatewayUrl, appId, privateKey, zhimaPublicKey);\n        try {\n            ZhimaDataBatchFeedbackResponse response =(ZhimaDataBatchFeedbackResponse)client.execute(req);\n            System.out.println(response.isSuccess());\n            System.out.println(response.getErrorCode());\n            System.out.println(response.getErrorMessage());\n        } catch (ZhimaApiException e) {\n            e.printStackTrace();\n        }\n    }\n\n    public static void main(String[] args) {\n        TestZhimaDataBatchFeedback result = new  TestZhimaDataBatchFeedback();\n        result.testZhimaDataBatchFeedback();\n    }\n}";
        String s = "string";
//        s = s.replaceAll("\\W", "");
//        System.out.println(s);
        for(int i = 0; i < cap; i++) {
//            datas.addData(s);
            datas.addData(s + i);
        }
    }
    @Test
	public void test2() {
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
    @Test
    public void test3() {
        System.out.println((1508391179386L - 1508391164361L) / 1000);
    }

}
