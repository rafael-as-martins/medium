package decorator;

import com.medium.EmailNotifier;
import com.medium.Notifier;
import com.medium.PhoneMessageDecorator;
import com.medium.SkypeMessageDecorator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NotifierTest {


    @Test
    public void emailNotificationProcessedTime() {

        //Given
        Notifier notifier = new EmailNotifier();

        //When
        double processedTime = notifier.getProcessTime();

        //Then
        assertThat(processedTime).isEqualTo(3.3);
    }


    @Test
    public void phoneMessageProcessedTime() {

        //Given
        Notifier notifier = new PhoneMessageDecorator(new EmailNotifier());

        //When
        double predictedTime = EmailNotifier.PROCESS_TIME + PhoneMessageDecorator.PROCESS_TIME;
        notifier.notifyWorkers();
        double processedTime = notifier.getProcessedTime();

        //Then
        assertThat(processedTime).isEqualTo(predictedTime);
    }


    @Test
    public void notifierExchangeFromDefaultToPhoneAndThenSkype() {

        //Given
        Notifier notifier = new EmailNotifier();
        notifier = new PhoneMessageDecorator(notifier);
        notifier = new SkypeMessageDecorator(notifier);

        //When
        notifier.notifyWorkers();
        double estimatedTime = EmailNotifier.PROCESS_TIME + PhoneMessageDecorator.PROCESS_TIME + SkypeMessageDecorator.PROCESS_TIME;

        //Then
        assertThat(notifier.getProcessedTime()).isEqualTo(estimatedTime);

    }


}
