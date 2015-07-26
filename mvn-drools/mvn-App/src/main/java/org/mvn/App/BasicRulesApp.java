/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mvn.App;

import java.util.ArrayList;
import org.drools.core.event.DebugRuleRuntimeEventListener;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 *
 * @author Lenovo
 */
public class BasicRulesApp {

    public static final void main(String[] args) {
        // KieServices is the factory for all KIE services 
        KieServices ks = KieServices.Factory.get();

        // From the kie services, a container is created from the classpath
        KieContainer kc = ks.getKieClasspathContainer();

        // From the container, a session is created based on  
        // its definition and configuration in the META-INF/kmodule.xml file 
        KieSession ksession = kc.newKieSession("BasicRuleKS");

        // Once the session is created, the application can interact with it
        // In this case it is setting a global as defined in the 
        // org/drools/examples/helloworld/HelloWorld.drl file
//        ksession.setGlobal("list",
//                new ArrayList<Object>());

        // The application can also setup listeners
        ksession.addEventListener(new DebugAgendaEventListener());
        ksession.addEventListener(new DebugRuleRuntimeEventListener());

        // To setup a file based audit logger, uncomment the next line 
        // KieRuntimeLogger logger = ks.getLoggers().newFileLogger( ksession, "./helloworld" );
        // To setup a ThreadedFileLogger, so that the audit view reflects events whilst debugging,
        // uncomment the next line
        // KieRuntimeLogger logger = ks.getLoggers().newThreadedFileLogger( ksession, "./helloworld", 1000 );
        // The application can insert facts into the session
        Account account = new Account();
        account.setBalance(50);

        ksession.insert(account);

        // and fire the rules
        ksession.fireAllRules();

        // Remove comment if using logging
        // logger.close();
        // and then dispose the session
        ksession.dispose();
    }

}
