package org.youngapple.taskmaster.server;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.*;
import org.youngapple.taskmaster.server.persistence.memory.TaskMasterMemoryDao;
import org.youngapple.taskmaster.server.service.TaskMasterService;
import org.youngapple.taskmaster.server.service.impl.TaskMasterServiceImpl;

import java.net.InetSocketAddress;

/**
 *
 */
public class ThriftServer {

  private static final int PORT = 9001;
  private static final String ADDRESS = "127.0.0.1";

  private final TaskMasterService.Iface taskMasterService;

  @Inject
  public ThriftServer(TaskMasterService.Iface taskMasterService) {
    this.taskMasterService = taskMasterService;
  }

  public void nonBlockService(){
    TProcessor processor = new TaskMasterService.Processor<>(taskMasterService);
    /** 非阻塞IO */
    try {
      TNonblockingServerSocket tSocketTranport = new TNonblockingServerSocket(
          new InetSocketAddress(ADDRESS, PORT));

      TNonblockingServer.Args targs = new TNonblockingServer.Args(
          tSocketTranport);

      targs.processor(processor);
      targs.protocolFactory(new TCompactProtocol.Factory());
      targs.transportFactory(new TFramedTransport.Factory());

      TServer server = new TNonblockingServer(targs);
      System.out.println("server begin ......................");
      server.serve();
      System.out.println("---------------------------------------");

    } catch (TTransportException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  public void service() {
    TaskMasterService.Processor processor = new TaskMasterService.Processor<>(taskMasterService);

    try {
      // 定义通信协议 这里服务端使用Socket
      TServerTransport serverTransport = new TServerSocket(new InetSocketAddress(ADDRESS, PORT));
      // 单线程阻塞io
      TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
      System.out.println("Simple server begin ......................");
      server.serve();
      System.out.println("OUT...");
    } catch (Exception ex) {
    }
  }

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new ServerModule());
    ThriftServer thriftServer = injector.getInstance(ThriftServer.class);
    thriftServer.service();

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      System.out.println("System exit... @YSG ...");
    }));
  }
}
