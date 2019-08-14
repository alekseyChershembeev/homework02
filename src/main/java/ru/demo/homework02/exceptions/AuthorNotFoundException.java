package ru.demo.homework02.exceptions;


/**
 * The type Author not found exception.
 */
public class AuthorNotFoundException extends RuntimeException {

	/**
	 * Instantiates a new Author not found exception.
	 *
	 * @param name the name
	 */
	public AuthorNotFoundException(String name) {
		super("Could not find author by name " + name);
	}
}
