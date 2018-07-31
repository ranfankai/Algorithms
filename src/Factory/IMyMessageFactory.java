package Factory;

/**
 * Created by haha on 2018/7/19.
 */
interface IMyMessageFactory {

    public IMyMessage createMessage(String messageType);
}
