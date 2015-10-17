/**
 * Bridge is used when we need to decouple an abstraction from its implementation 
 * so that the two can vary independently. This type of design pattern comes under 
 * structural pattern as this pattern decouples implementation class and abstract 
 * class by providing a bridge structure between them.
 * 
 * This pattern involves an interface which acts as a bridge which makes the 
 * functionality of concrete classes independent from interface implementer classes.
 * Both types of classes can be altered structurally without affecting each other.
 */
package com.patterns.bridge;
/**
 * We have a CookApi interface which is acting as a bridge implementer and concrete 
 * classes NonVegBurgerExtraCheese.java, VegBurgerExtraCheese.java implementing the CookApi
 * interface. Food is an abstract class and will use object of CookApi. BridgePatternDemo, 
 * our demo class will use Food class to make different burgers.
 * 
 */
