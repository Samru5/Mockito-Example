package com.capgemini.demo.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.demo.MathApplication;
import com.capgemini.demo.exception.InvalidInputException;
import com.capgemini.demo.service.CalculatorService;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTest {

@Mock
private CalculatorService service;	

@InjectMocks
MathApplication application=new MathApplication(service);

@Before
public void setUp()
{
	MockitoAnnotations.initMocks(this);
}

@Test
public void testPerformAdditionWithTwoPositiveIntegers()
{
	when(service.addition(5, 4)).thenReturn(9);
	assertEquals(9,application.performAddition(5, 4));
}

@Test
public void testPerformAdditionWithFirstPositiveIntegerAndSecondNegativeInteger()
{
	when(service.addition(6, -3)).thenReturn(3);
	assertEquals(3,application.performAddition(6, -3));
}

@Test
public void testPerformAdditionWithTwoNegativeIntegers()
{
	when(service.addition(-5, -5)).thenReturn(-10);
	assertEquals(-10,application.performAddition(-5, -5));
}
@Test
public void testPerformAdditionWithFirstNegativeIntegerAndSecondPositiveInteger()
{
	when(service.addition(6, -3)).thenReturn(3);
	assertEquals(3,application.performAddition(6, -3));
}

@Test
public void testFindFactorialWithPositiveInteger() throws InvalidInputException {
when(service.factorial(4)).thenReturn(24L);
assertEquals(24, application.findFactorial(4));
}

@Test(expected=InvalidInputException.class)
public void testFindFactorialOfNegativeNumber() throws InvalidInputException
{
	doThrow(new InvalidInputException("Can't find factorial of negative number")).when(service).factorial(-5);
			application.findFactorial(-5);
}

@Test
public void testPerformSubtractionOfTwoPositiveIntegers()
{
	when(service.subtraction(12, 4)).thenReturn(8);
	assertEquals(8,application.performSubtraction(12, 4));
}

public void testPerformSubtractionOfFirstPositiveAndSecondNegativeIntegers()
{
	when(service.subtraction(12, -8)).thenReturn(20);
	assertEquals(20,application.performSubtraction(12, -8));
}

public void testPerformSubtractionOfFirstNegativeAndSecondPositiveIntegers()
{
	when(service.subtraction(-8,4)).thenReturn(-12);
	assertEquals(-12,application.performSubtraction(-8,4));
}
public void testPerformSubtractionOfBothNegativeIntegers()
{
	when(service.subtraction(-8,-8)).thenReturn(0);
	assertEquals(0,application.performSubtraction(-8,-8));
}
@Test
public void testPerformMultiplication()
{
	when(service.multiplication(6, 4)).thenReturn(24);
	assertEquals(24,application.performMultiplication(6,4));
}
@Test
public void testPerformDivision()
{
	when(service.multiplication(6, 3)).thenReturn(2);
	assertEquals(2,application.performMultiplication(6,3));
}

@Test(expected = ArithmeticException.class)
public void testPerformDivisionWithDivisorZero() {
doThrow(new ArithmeticException("/ by zero")).when(service).division(7, 0);
application.performDivision(7, 0); 
}

@Test
public void testPerformSquareOfPositiveInteger()
{
	when(service.square(5)).thenReturn(25L);
	assertEquals(25,application.findSquare(5));
}

@Test
public void testPerformSquareOfNegativeInteger()
{
	when(service.square(-3)).thenReturn(9L);
	assertEquals(9,application.findSquare(-3));
}
}
