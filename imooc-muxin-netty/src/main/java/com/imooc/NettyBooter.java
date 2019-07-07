package com.imooc;

import com.imooc.netty.WSServer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @description: 将netty放入springboot的监听事件中启动
 * @author: qml
 * @create: 2019-07-07 15:03
 */
@Component
public class NettyBooter implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(null==event.getApplicationContext().getParent()){
            WSServer.getInstance().start();
        }
    }
}
