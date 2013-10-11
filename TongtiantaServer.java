package ttt.scene;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

/** @author luch */
public class TongtiantaServer {
    private static final Logger log = LoggerFactory.getLogger(TongtiantaServer.class);

    public static void main(String[] args) throws Exception {
        log.info("服务器开始启动...");
        final GenericXmlApplicationContext application = new
                GenericXmlApplicationContext("classpath*:/application.xml");

        application.getBean(ServerStart.class).init();
        final ServerStop stop = application.getBean(ServerStop.class);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                stop.destroy();
                application.close();
            }
        });

        TttServerBootstrap b = application.getBean(TttServerBootstrap
                .class);
        b.run();
        log.debug("启动完毕!");
    }
}
