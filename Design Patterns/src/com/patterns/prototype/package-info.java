
package com.patterns.prototype;

/**
 * This pattern involves implementing a prototype interface which tells to
 * create a clone of the current object. This pattern is used when creation of
 * object directly is costly. For example, an object is to be created after a
 * costly database operation. We can cache the object, returns its clone on next
 * request and update the database as and when needed thus reducing database
 * calls.
 */