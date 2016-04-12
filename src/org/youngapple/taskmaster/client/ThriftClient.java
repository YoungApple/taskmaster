package org.youngapple.taskmaster.client;

import com.google.common.collect.Lists;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.youngapple.taskmaster.server.service.Query;
import org.youngapple.taskmaster.server.service.Task;
import org.youngapple.taskmaster.server.service.TaskMasterService;

/**
 */
public class ThriftClient {

  public static void main(String[] args) throws TException {
    //定义传输层协议 这里使用Socket
    TTransport transport = new TSocket("127.0.0.1", 9001);
    transport.open();
    //
    //定义传输层协议 这里使用Http
//      TTransport transport = new  THttpClient("127.0.0.1");


//    long start=System.currentTimeMillis();
    //定义编码解码协议  这里使用二进制
//      TProtocol protocol = new TBinaryProtocol(transport);
    //定义编码协议  这里使用json格式
//      TProtocol protocol = new TJSONProtocol(transport);
    //定义编码解码协议 这里使用压缩格式
    TProtocol protocol = new TBinaryProtocol(transport);
    //当使用服务端使用非阻塞服务时，客户端要设置protocol为frame


    TaskMasterService.Client client = new TaskMasterService.Client(protocol);
    Task task = new Task();
    task.setGroup("YSG");
    task.setPayload("DATA");
    client.createTasks(Lists.newArrayList(task, task.deepCopy(), task.deepCopy()));
    Query query = new Query();
    query.setGroup("YSG");
    System.out.println(client.query(query));
//    Parameters params = new Parameters();
////      params.setA(1);
////      params.setB(2);
//////    params.a = 1;
//////    params.b = 2;
//////    params.message = "client request .....";
////    int result1 = client.getIntegerSum(params);
////    double result2 = client.getDoubleSum(1.2, 2.4);
//    transport.close();
//    System.out.println(result1);
//    System.out.println(result2);
  }
}


