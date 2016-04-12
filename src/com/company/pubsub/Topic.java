package com.company.pubsub;

import java.security.acl.Acl;

/**
 */
public interface Topic {
    String getName();
    Acl getPublisherAcl();
    Acl getSubscriberAcl();
    Strategy getStrategy();

    enum Strategy {
        DEFAULT,
        ALL
    }
}
