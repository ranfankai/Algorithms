package Factory;

/**
 * Created by haha on 2018/7/19.
 */
import java.util.Map;

/**
 * 工厂方法模式_产品接口
 *
 * @author popkidorc
 *
 */
public interface IMyMessage {

    public Map<String, Object> getMessageParam();

    public void setMessageParam(Map<String, Object> messageParam);

    public void sendMesage() throws Exception;// 发送通知/消息

}
