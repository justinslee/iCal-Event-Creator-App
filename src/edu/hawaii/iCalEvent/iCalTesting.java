package edu.hawaii.iCalEvent;

import static org.junit.Assert.*;

import org.junit.Test;
 
public class iCalTesting {
 
        // test createEvent for event 1 Succeeds correct data
 
        @Test public void createEvent1Test(){
 
                boolean ce = iCalEvent.createEvent("lunch", "nothing", "cafe", "VCR", "10", "10", "20130102", "110000", "20130102", "120000");
 
                assertTrue(ce);
 
        }
 

 
        // test createEvent for event 2 fails invalid geo
 
        @Test public void createEvent2Test(){
 
                boolean ce = iCalEvent.createEvent("exam", "ics314", "POST318", "none", "400", "200", "20120502", "043000", "20120502", "630000");
 
                assertTrue(ce);
 
        }
 

 
        // test createEvent for event 3 fails time reversed
 
        @Test public void createEvent3Test(){
 
                boolean ce = iCalEvent.createEvent("work", "day shift", "office", "none", "-30", "150", "20120603", "083000", "20120603", "013000");
 
                assertTrue(ce);
 
        }
 
        
 
} 
