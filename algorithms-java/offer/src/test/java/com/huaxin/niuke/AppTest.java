/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

package com.huaxin.niuke;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import javax.sql.rowset.Predicate;
import java.util.HashMap;
import java.util.function.Consumer;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return
                new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
