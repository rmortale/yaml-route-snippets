import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.ibm.mq.jakarta.jms.MQXAConnectionFactory;
import com.ibm.msg.client.jakarta.wmq.WMQConstants;

import io.quarkiverse.messaginghub.pooled.jms.PooledJmsWrapper;
import io.smallrye.common.annotation.Identifier;
import jakarta.inject.Singleton;
import jakarta.inject.Named;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;
import jakarta.transaction.TransactionManager;

public class IbmMqXa extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("ibmmq:queue:DEV.QUEUE.1")
                .transacted()
                .log("Received message from IBM MQ: ${body}")
                .throwException(new IllegalArgumentException("Simulated processing error")) ;
    }

    @Singleton
    JtaTransactionManager manager(TransactionManager transactionManager) {
        return new JtaTransactionManager(transactionManager);
    }

    @Named("ibmConnectionFactory")
    public ConnectionFactory createXAConnectionFactory(PooledJmsWrapper wrapper) {
        MQXAConnectionFactory mq = new MQXAConnectionFactory();
        try {
            mq.setHostName("localhost");
            mq.setPort(1414);
            mq.setChannel("DEV.APP.SVRCONN");
            mq.setQueueManager("QM1");
            mq.setTransportType(WMQConstants.WMQ_CM_CLIENT);
            mq.setStringProperty(WMQConstants.USERID, "app");
            mq.setStringProperty(WMQConstants.PASSWORD, "passw0rd");
        } catch (JMSException e) {
            throw new RuntimeException("Unable to create IBM MQ Connection Factory", e);
        }
        return wrapper.wrapConnectionFactory(mq);
    }

    @Named("ibmmq")
    JmsComponent ibmmq(@Named("ibmConnectionFactory") ConnectionFactory cf, JtaTransactionManager tm) {
        JmsComponent ibmmq = new JmsComponent();
        ibmmq.setConnectionFactory(cf);
        ibmmq.setTransactionManager(tm);
        return ibmmq;
    }
}
