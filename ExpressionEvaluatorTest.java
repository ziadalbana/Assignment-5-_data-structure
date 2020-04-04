/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;

import eg.edu.alexu.csd.datastructure.stack.cs.ExpressionEvaluator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alex
 */
public class ExpressionEvaluatorTest {
    ExpressionEvaluator practise=new ExpressionEvaluator();
    

    /**
     * Test of infixToPostfix method, of class ExpressionEvaluator.
     */
    @Test
    public void testInfixToPostfix1() {
        String expected = "a b c - d + / e a - * c * ";
        String actual = practise.infixToPostfix("(a / (b - c + d)) * (e - a) * c ");
        assertEquals(expected, actual);
    } 
     /**
     * Test of infixToPostfix method, of class ExpressionEvaluator.
     */
    @Test
    public void testInfixToPostfix2() {
        String expected = "a b / c - d e * + a c * - ";
        String actual = practise.infixToPostfix("a / b - c + d * e - a * c");
        assertEquals(expected, actual);
    } 
     /**
     * Test of evaluate method, of class ExpressionEvaluator.
     */
    @Test
    public void testInfixToPostfix3() {
        String expected = "1 2 + 7 * ";
        String actual = practise.infixToPostfix("(1 + 2) * 7");
        assertEquals(expected, actual);
    }
      /**
     * Test of infixToPostfix method, of class ExpressionEvaluator.
     */
     @Test
    public void testInfixToPostfix4() {
        String expected = "4 8 + 6 5 - * 3 2 - 2 2 + * / ";
        String actual = practise.infixToPostfix("( 4 + 8 ) *(  6 - 5 ) / ( (3 - 2 )  *(  2 + 2 ) )");
        assertEquals(expected, actual);
    }
      /**
     * Test of infixToPostfix method, of class ExpressionEvaluator.
     */
    @Test
    public void testInfixToPostfix5() {
        String expected = "300 23 + 43 21 - * 84 7 + / ";
        String actual = practise.infixToPostfix("( 300 + 23 ) * ( 43 - 21 ) / ( 84 + 7 ) ");
        assertEquals(expected, actual);
    }
     /**
     * Test of infixToPostfix method, of class ExpressionEvaluator.
     */
    @Test
    public void testInfixToPostfix6() {
        String expected = "3 4 5 * 6 / + ";
        String actual = practise.infixToPostfix("3+4*5/6");
        assertEquals(expected, actual);
    }
    /**
     * Test of evaluate method, of class ExpressionEvaluator.
     */
    @Test
    public void testEvaluate1() {
        int expected =78;
        int actual = practise.evaluate("( 300 + 23 ) * ( 43 - 21 ) / ( 84 + 7 )");
        assertEquals(expected,actual);
    }/**
     * Test of evaluate method, of class ExpressionEvaluator.
     */
    @Test
    public void testEvaluate2() {
        int expected =3;
        int actual = practise.evaluate("(4+8)*(6-5)/((3-2)*(2+2))");
        assertEquals(expected,actual);
    }
    /**
     * Test of evaluate method, of class ExpressionEvaluator.
     */
    @Test
    public void testEvaluate3() {
        int expected =6;
        int actual = practise.evaluate("3+4*5/6");
        assertEquals(expected,actual);
    }

    
    
}
