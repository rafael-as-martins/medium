package decorator;

import com.medium.EmailNotifier;
import com.medium.Notifier;
import com.medium.PhoneMessageDecorator;
import com.medium.SkypeMessageDecorator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NotifierTest {

    @Test
    public void notifyByEmail() {

        //Given
        Notifier notifier = new EmailNotifier();

        //When
        String notification = notifier.notifyWorkers();

        //Then
        assertThat(notification).isEqualTo("Sending EMAIL...");

    }

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
        double processedTime = ((PhoneMessageDecorator) notifier).getProcessedTime();

        //Then
        assertThat(processedTime).isEqualTo(predictedTime);
    }


    @Test
    public void notifyByPhoneMessage() {

        //When
        Notifier notifier = new PhoneMessageDecorator(new EmailNotifier());

        //Given
        String notification = notifier.notifyWorkers();

        //Then
        assertThat(notification).isEqualTo("Sending PHONE MESSAGE...");
    }

    @Test
    public void notifierExchangeFromDefaultToPhoneAndThenSkype() {

        Notifier notifier = new EmailNotifier();
        double estimatedTime = EmailNotifier.PROCESS_TIME;
        notifier.notifyWorkers();
        assertThat(notifier.getProcessTime()).isEqualTo(estimatedTime);

        notifier = new PhoneMessageDecorator(notifier);
        notifier.notifyWorkers();
        estimatedTime = EmailNotifier.PROCESS_TIME + PhoneMessageDecorator.PROCESS_TIME;
        assertThat(((PhoneMessageDecorator) notifier).getProcessedTime()).isEqualTo(estimatedTime);

        notifier = new SkypeMessageDecorator(notifier);
        notifier.notifyWorkers();
        estimatedTime = EmailNotifier.PROCESS_TIME + PhoneMessageDecorator.PROCESS_TIME + SkypeMessageDecorator.PROCESS_TIME;
        assertThat(((SkypeMessageDecorator) notifier).getProcessedTime()).isEqualTo(estimatedTime);

    }


}
