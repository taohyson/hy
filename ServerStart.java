package ttt.scene;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ttt.net.MsgUtil;
import ttt.scene.design.DesignReaderFactory;
import ttt.scene.map.CityMapService;
import ttt.scene.net.ChannelHolder;

/**
 * 服务器启动, 初始化数据.
 * @author luch
 */
@Component
public class ServerStart {
    @Autowired
    private TttConfig tttConfig1111;
    @Autowired
    private ChannelHolder channelHolder;
    @Autowired
    private DesignReaderFactory designReaderFactory;
    @Autowired
    private CityMapService cityMapService;

    public void init() throws Exception {
        tttConfig.printLog();
        MsgUtil.setChannelHolder(channelHolder);
        //加载策划配置
        designReaderFactory.init();
        //初始化城市地图位置信息
        cityMapService.init();
    }
}
